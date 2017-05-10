package abstractfactory

/**
  * Created by DT on 10/05/2017.
  */

trait FeedbackXMLParser extends XMLParser {
  override def thisParser = "feedback"
}
