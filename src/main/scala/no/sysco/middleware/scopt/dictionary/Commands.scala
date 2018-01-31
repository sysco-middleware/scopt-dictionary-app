package no.sysco.middleware.scopt.dictionary

import java.util.Optional



object Commands {
  final val STORAGE = s"STORAGE"
  final val SHOW = s"SHOW"
  final val ADD = s"ADD"

  val parser = new scopt.OptionParser[Command]("dictionary") {
    head("dictionary", "1.0")

    cmd("storage")
      .action((_,c) => c.copy(action = Optional.of(STORAGE)))
      .text(s"print current dictionary file")

    cmd("show")
        .action((_,c) => c.copy(action = Optional.of(SHOW)))
        .text(s"show all words in dictionary")

//    cmd("add")
//      .action((_,c) => c.copy(action = Optional.of(ADD)))
//      .text(s"add new word:translation to dictionary")
//      .children(
//        opt[String]("key")
//
//      )

    help("help").abbr("h").text("Show usage")
    // TODO: only for test
    override def terminate(exitState: Either[String, Unit]): Unit = ()
  }

}

case class Command(action: Optional[String] = Optional.empty(), options: Optional[Seq[String]]= Optional.empty())
