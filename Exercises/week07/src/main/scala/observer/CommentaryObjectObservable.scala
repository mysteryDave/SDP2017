package observer

import scala.collection.mutable.ListBuffer
/**
  * Created by dtucke03 on 08/05/2017.
  */
class CommentaryObjectObservable(override var subscribers: ListBuffer[Observer]) extends CommentaryObject(subscribers, title) with Commentary { {

  var currentUpdate: String = ""

  def setDesc(sNewDesc: String): Unit = currentUpdate = sNewDesc

  def notifyObservers() = for(aSubscriber <- subscribers) aSubscriber.update(subjectDetails + ":" + currentUpdate)
}