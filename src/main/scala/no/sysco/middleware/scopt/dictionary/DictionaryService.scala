package no.sysco.middleware.scopt.dictionary

import scala.io.Source

class DictionaryService(config: Config) {
  import no.sysco.middleware.scopt.dictionary.Commands._

  def build(command: Command) : Unit = {

    command.action.get() match {
      case STORAGE => println(config.dictionary.storage)
      case SHOW => show()
    }

  }

  private def show() : Unit = {
    for (line <- Source.fromFile(config.dictionary.storage).getLines) {
      println(line)
    }
  }
}
