package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */

trait ErrorXMLParser extends XMLParser {
  override def thisParser = "error"
}
