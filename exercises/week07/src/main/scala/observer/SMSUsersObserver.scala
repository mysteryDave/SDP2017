package observer

/**
  * Created by David Tucker on 09/05/2017.
  */
class SMSUsersObserver(a: Subject, b: String) extends SMSUsers(a, b) {
  //Anything needed here?
  println(b + ": Created.")

}
