package no.sysco.middleware.scopt.dictionary

import scala.io.StdIn
import no.sysco.middleware.scopt.dictionary.Commands

object Boot extends App {


  val appConfig: Config = Config.load()
  val dictionaryService: DictionaryService = new DictionaryService(appConfig)
//  val client = new Client(dictionaryService)

  while (true) {
    val command = StdIn.readLine()
    Commands.parser.parse(command.split(" "), Command()) match {
      case Some(c) => dictionaryService.build(c)
      case None => println("Bad Request")
    }
  }

}
