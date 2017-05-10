package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */

object NYCParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): NYCXMLParser = parserType match {
    case "NYCERROR" => new NYCERRORParser
    case "NYCFEEDBACK" => new NYCFEEDBACKParser
    case "NYCORDER" => new NYCORDERParser
    case "NYCRESPONSE" => new NYCRESPONSEParser
  }
}
