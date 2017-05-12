package composite

case class HtmlElement(s: String) extends HtmlTag(s) {
  var sTagBody: String = ""

  override def generateHtml(): Unit = println(sStartTag + sTagBody + sEndTag)

  override def setTagBody(tagBody: String): Unit = sTagBody = tagBody
}
