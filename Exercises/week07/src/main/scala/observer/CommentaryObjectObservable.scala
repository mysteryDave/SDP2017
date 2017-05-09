package observer

import scala.collection.mutable.ListBuffer
/**
  * Created by dtucke03 on 08/05/2017.
  */
class CommentaryObjectObservable(val title: String) extends Commentary {

  var commentaryObj = new CommentaryObject(new ListBuffer[Observer], title)
  var sLatestUpdate: String = ""

  def setDesc(sNewDesc: String): Unit = sLatestUpdate = sNewDesc

  def notifyObservers(): Unit = commentaryObj.notifyObservers(sLatestUpdate)
}