package abstractfactory

/**
  * Created by DT on 10/05/2017.
  *
  * London Parser Factory will only produce London client style XML parsers
  */

object LondonParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): LondonXMLParser = parserType match {
    case "LondonERROR" => new LondonERRORParser
    case "LondonFEEDBACK" => new LondonFEEDBACKParser
    case "LondonORDER" => new LondonORDERParser
    case "LondonRESPONSE" => new LondonRESPONSEParser
  }
}
