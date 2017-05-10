package abstractfactory

object ParserFactoryProducer {
  //Factory factory (factory producer)

  def getFactory(s: String): AbstractParserFactory = s match {
    case "NYCFactory" => NYCParserFactory
    case "LondonFactory" => LondonParserFactory
  }

}
