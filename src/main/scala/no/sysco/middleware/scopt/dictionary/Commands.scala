package no.sysco.middleware.scopt.dictionary

import java.util.Optional


/**
  * Commands: CRUD
  * C - add
  * R - show
  * U - update
  * D - delete
  */
object Commands {
  final val STORAGE : String = s"storage"

  final val ADD : String = s"add"
  final val SHOW : String= s"show"
  final val UPDATE : String= s"update"
  final val DELETE : String= s"delete"

  final val ORDER_ASC : String = s"asc"
  final val ORDER_DESC : String= s"desc"


  val parser = new scopt.OptionParser[Command]("dictionary") {
    head("dictionary", "1.0")
    cmd(STORAGE)
      .action((_,c) => c.copy(action = Option.apply(STORAGE)))
      .text(s"print current dictionary file")

    cmd(ADD)
      .action((_,c)=> c.copy(action = Option.apply(ADD)))
      .text(s"add key:value pair")
      .children(
        opt[Map[String,String]]("words")
          .valueName("k1=v1,k2=v2...")
          .action( (x, c) => c.copy(values = Option.apply(x)) )
          .text("other arguments")
      )


    cmd(SHOW)
      .action((_,c) => c.copy(action = Option.apply(SHOW)))
      .text(s"show all words")
        .children(
          // flags
          opt[Unit]("ascending")
            .abbr("asc")
            .action((_,c)=> c.copy(action = Option.apply(SHOW), options = Option.apply(ORDER_ASC)))
            .text(s"ASC order"),
          opt[Unit]("descending")
            .abbr("desc")
            .action((_,c)=> c.copy(action = Option.apply(SHOW), options = Option.apply(ORDER_DESC)))
            .text(s"DESC order")
        )


    cmd(UPDATE)
      .action((_,c) => c.copy(action = Option.apply(UPDATE)))
      .text(s"replace key:value entry")
    cmd(DELETE)
      .action((_,c) => c.copy(action = Option.apply(DELETE)))
      .text(s"delete key:value entry")

    help("help").abbr("h").text("Show usage")
    // TODO: only for test
    override def terminate(exitState: Either[String, Unit]): Unit = ()
  }

}

case class Command(action: Option[String] = Option.empty, options: Option[String]= Option.empty, values: Option[Map[String, String]] = Option.empty)
