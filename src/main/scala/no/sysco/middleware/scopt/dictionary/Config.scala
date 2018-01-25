package no.sysco.middleware.scopt.dictionary

import pureconfig.loadConfig

case class Config(dictionary: Dictionary)

object Config {

  def load() =
    loadConfig[Config] match {
      case Right(config) => config
      case Left(error) =>
        throw new RuntimeException("Cannot read config file, errors:\n" + error.toList.mkString("\n"))
    }

}

private[dictionary] case class Dictionary(storage: String)

