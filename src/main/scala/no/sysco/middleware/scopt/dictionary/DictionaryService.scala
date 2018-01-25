package no.sysco.middleware.scopt.dictionary


class DictionaryService(config: Config) {
  def build(parserConfig: ParserConfig) : Unit = {
    println(config.dictionary.storage)
  }
}
