package abstractfactory

trait XMLParser {

  def thisClient: String
  def thisParser: String

  def thisCapParser: String = thisParser.charAt(0).toString.toUpperCase + {
    for {
      charIndex <- thisParser.indices
      if charIndex > 0
    } yield thisParser(charIndex).toString
  }

  def parse = thisClient + " Parsing " + thisParser + " XML...\n" + thisClient + thisCapParser + " XML Message"

}
