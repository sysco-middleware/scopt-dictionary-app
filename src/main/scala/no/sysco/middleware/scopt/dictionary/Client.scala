package no.sysco.middleware.scopt.dictionary

import java.util.Optional



object Client {

  val parser = new scopt.OptionParser[ParserConfig]("dictionary") {
    head("dictionary", "1.0")

    cmd("storage")
      .action((_,config) => config.copy())
      .text(s"will show current timestamp")

    help("help").abbr("h").text("Show usage")
    // TODO: only for test
    override def terminate(exitState: Either[String, Unit]): Unit = ()
  }

}

case class ParserConfig(filePath: Optional[String] = Optional.empty())
