package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {

  var sSubjectDetail: String = title

  override def subscribeObserver(observer: Observer) = subscribers = subscribers :+ observer

  override def unSubscribeObserver(observer: Observer) = {
    val nRemoveSubscriber = subscribers.indexOf(observer)
    println("UNSUBSCRIBING " + (nRemoveSubscriber + 1) + " '" + subscribers(nRemoveSubscriber) + "' = '" + observer + "'")
    subscribers.remove(nRemoveSubscriber)
  }

  override def notifyObservers(): Unit = {
    for(updateSubscriber <- subscribers) {
      updateSubscriber.update(title + ":" + subjectDetails)
    }
  }

  override def subjectDetails: String = sSubjectDetail

}
