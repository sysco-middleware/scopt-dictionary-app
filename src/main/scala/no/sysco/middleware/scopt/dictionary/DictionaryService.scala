package no.sysco.middleware.scopt.dictionary

import java.io.File

import scala.io.Source

class DictionaryService(config: Config) {
  import no.sysco.middleware.scopt.dictionary.Commands._

  final val dictionaryFile = new File(config.dictionary.storage)

  def build(command: Command) : Unit = {
    command.action match {
      case None => println(s"\nNONE NOTHING")
      case Some(ADD) => add(command)
      case Some(STORAGE) => println(config.dictionary.storage)
      case Some(SHOW) => show(command)
      case _ => println(s"\n_ NOTHING")
    }
  }

  private def show(command: Command) : Unit = {
    val source = Source.fromFile(config.dictionary.storage)
    command.options match {
      case None => for (line <- source.getLines) println(line)
      case Some(ORDER_ASC) => source.getLines.toList.sortWith(_ < _).foreach(el => println(el))
      case Some(ORDER_DESC) => source.getLines.toList.sortWith(_ > _).foreach(el => println(el))
      case _ => println(s"\n_ NOTHING")
    }
  }

  private def add(commands: Command) : Unit = {
    val valuesMap = commands.values
    valuesMap match {
      case Some(value) =>
        printToFile(dictionaryFile){
          p => for ((k,v)<- value) p.append(s"\n$k:$v")
        }
      case None => ()
    }
  }

  // https://stackoverflow.com/a/4608061/6769651
  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }

}
