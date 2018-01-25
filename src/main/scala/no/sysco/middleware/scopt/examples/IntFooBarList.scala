//package no.sysco.middleware.scopt.examples
//
//import scopt._
//
//import scala.io.StdIn
//
//case class Config(foo: Int = -1, bar: Seq[Int] = List())
//
//object Sample1 extends App {
//
//  val parser = new OptionParser[Config]("ScoptTest") {
//    head("ScoptTest", "1.0")
//
//    opt[Int]('f', "format")
//      .action((x, config) => config.copy(foo = x))
//      .text("foo is an integer")
//      .required()
//    opt[Seq[Int]]('b', "bar")
//      .action((x, config) => config.copy(bar = x))
//      .text("bar is a list")
//      .required()
//
//    help("help").abbr("h").text("Show usage")
//
////    override def errorOnUnknownArgument = false
////    override def terminate(exitState: Either[String, Unit]): Unit = ()
//  }
//
//
//  while (true) {
//    val command = StdIn.readLine()
//    parser.parse(command.split(" "), Config()) match {
//      case Some(config) => println(s"\nyou provided config foo ${config.foo} and bar ${config.bar}\n")
//      case None => println("usage ScoptTest -b badgeId")
//    }
//  }
//
//
//}
