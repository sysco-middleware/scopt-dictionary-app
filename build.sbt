name := "scopt-dictionary-app"

version := "0.1"

scalaVersion := "2.12.4"

val scoptVer = "3.7.0"

libraryDependencies ++= Seq(
  "com.github.scopt" %% "scopt" % scoptVer,
  // Config file parser
  "com.github.pureconfig" %% "pureconfig" % "0.8.0",
)