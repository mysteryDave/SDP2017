/**
  * Created by David Tucker on 19/04/2017.
  */
case class Person(sFirst: String, sLast: String) {

}

object Person {
  def apply(sFullName: String): Person = {
    val sParts: Array[String] = sFullName.split(" ")
    val sNewFirst = for(sName <- 0 until (sParts.length - 1)) yield sParts(sName) + " "
    sParts.length match {
      case 0 => Person("","")
      case 1 => Person("",sFullName)
      case 2 => Person(sParts(0), sParts(1))
      case _ => Person(sFullName.dropRight(sParts(sParts.length - 1).length + 1), sParts(sParts.length - 1))
    }
  }
}
