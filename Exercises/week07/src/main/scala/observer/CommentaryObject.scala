package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {
  def subscribeObserver(observer: Observer) = subscribers.append(observer)

  def unSubscribeObserver(observer: Observer) = {
    val nRemoveSubscriber = subscribers.indexOf(observer)
    subscribers.remove(nRemoveSubscriber)
  }

  def notifyObservers(sUpdateMsg: String) = for(aSubscriber <- subscribers) aSubscriber.notify(subjectDetails + ":" + sUpdateMsg)

  def subjectDetails: String = title
}
