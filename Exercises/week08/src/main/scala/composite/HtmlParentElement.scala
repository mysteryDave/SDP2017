package composite

case class HtmlParentElement(s: String) extends HtmlTag(s) {

  var childTags: List[HtmlTag] = List.empty[HtmlTag]

  //Tree parsing
  override def generateHtml: Unit = {
    println(sStartTag)
    for(child: HtmlTag <- childTags) child.generateHtml
    println(sEndTag)
  }

  override def addChildTag(htmlTag: HtmlTag): Unit = childTags = childTags :+ htmlTag

  override def removeChildTag(htmlTag: HtmlTag): Unit = childTags = childTags.filter(_ != htmlTag)

  override def getChildren: List[HtmlTag] = childTags

}
