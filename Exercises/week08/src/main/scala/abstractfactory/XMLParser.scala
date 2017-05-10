package abstractfactory

trait XMLParser {

  def thisClient: String
  def thisParser: String

  def thisCapParser: String = {
    val upperParser = thisParser(0).toUpper + thisParser.drop(1)
    upperParser.mkString
  }

  def parse = thisClient + " Parsing " + thisParser + " XML...\n" + thisClient + " " + thisCapParser + " XML Message"

}
