package observer

/**
  * Created by DT on 08/05/2017.
  */
class SMSUsersObserver(s: Subject, msg: String) extends SMSUsers(s: Subject, msg: String) {
  override def toString() = "SMS subscriber " + msg

  def update(desc: String): Unit = println("desc")

}