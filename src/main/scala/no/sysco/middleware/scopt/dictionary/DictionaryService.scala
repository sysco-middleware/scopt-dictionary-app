package no.sysco.middleware.scopt.dictionary

import scala.io.Source

class DictionaryService(config: Config) {
  import no.sysco.middleware.scopt.dictionary.Commands._

  def build(command: Command) : Unit = {
    command.action match {
      case Some(STORAGE) => println(config.dictionary.storage)
      case Some(SHOW) => show(command)
    }
  }

  private def show(command: Command) : Unit = {
    val source = Source.fromFile(config.dictionary.storage)
    command.options match {
      case None => for (line <- source.getLines) println(line)
      case Some(ORDER_ASC) => source.getLines.toList.sortWith(_ < _).foreach(el => println(el))
      case Some(ORDER_DESC) => source.getLines.toList.sortWith(_ > _).foreach(el => println(el))
    }
  }

}
