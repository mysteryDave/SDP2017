package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */

trait OrderXMLParser extends XMLParser {
  override def thisParser = "order"
}
