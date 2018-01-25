//package no.sysco.middleware.scopt.examples
//
//import java.util.Calendar
//
//object TimerApp extends App {
//  case class Config(time: Long = -1)
//
//
//  val parser = new scopt.OptionParser[Config]("timer") {
//
//    head("TimerApp", "1.0")
//
//    cmd("show")
//      .action((_,config) => config.copy(time = Calendar.getInstance().getTimeInMillis))
//      .text(s"will show current timestamp")
//      .children(
//        opt[Long]("time")
//          .abbr("t")
//          .text("sill show custom timestamp")
//          .action((timestamp, config) => config.copy(time = timestamp))
//      )
//
//    help("help").abbr("h").text("Show usage")
//  }
//
//  parser.parse(args, Config()) match {
//    case Some(config) => println(s"\ntime is ${config.time}\n")
//
//    case None => println(s"\nBad args\n")
//  }
//}
