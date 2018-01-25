package no.sysco.middleware.scopt.dictionary

import scala.io.StdIn

object Boot extends App {

  val appConfig: Config = Config.load()
  val dictionaryService: DictionaryService = new DictionaryService(appConfig)
//  val client = new Client(dictionaryService)

  while (true) {
    val command = StdIn.readLine()
    Client.parser.parse(command.split(" "), ParserConfig()) match {
      case Some(c) => dictionaryService.build(c)
      case None => println("Bad Request")
    }
  }

}
