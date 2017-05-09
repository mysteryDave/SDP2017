package observer

import scala.collection.mutable.ListBuffer
/**
  * Created by dtucke03 on 08/05/2017.
  */
class CommentaryObjectObservable(subscribers: ListBuffer[Observer], title: String) extends CommentaryObject(subscribers, title) with Commentary {

  def this(title: String) = {
    this(new ListBuffer[Observer], title)
  }

  def setDesc(sNewDesc: String) = {
    sSubjectDetail = sNewDesc
    notifyObservers()
  }

}