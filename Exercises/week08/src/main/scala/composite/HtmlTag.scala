package composite

abstract class HtmlTag(tagName: String) {
  var sStartTag: String = tagName
  var sEndTag: String = tagName

  def getTagName: String = tagName

  def setStartTag(tag: String): Unit = sStartTag = tag

  def setEndTag(tag: String): Unit = sEndTag = tag

  def setTagBody(tagBody: String): Unit = throw new UnsupportedOperationException(this + " TAG CANNOT HAVE BODY")

  def addChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException(this + " TAG CANNOT HAVE CHILDREN")

  def removeChildTag(htmlTag: HtmlTag): Unit = throw new UnsupportedOperationException(this + "TAG CANNOT HAVE CHILDREN")

  def getChildren: List[HtmlTag] = throw new UnsupportedOperationException(this + "TAG CANNOT HAVE CHILDREN")

  def generateHtml
}