package observer

import scala.collection.mutable.ListBuffer
/**
  * Created by dtucke03 on 08/05/2017.
  */
class CommentaryObjectObservable(override var subscribers: ListBuffer[Observer], override val title: String) extends CommentaryObject(subscribers, title) with Commentary {

  var sLatestUpdate: String = ""

  def setDesc(sNewDesc: String): Unit = sLatestUpdate = sNewDesc

  def notifyObservers() = for(aSubscriber <- subscribers) aSubscriber.update(subjectDetails + ":" + sLatestUpdate)
}