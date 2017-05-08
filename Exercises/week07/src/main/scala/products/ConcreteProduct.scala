package products

/**
  * Created by dtucke03 on 05/05/2017.
  */
class ConcreteProduct(val sName: String, val dPrice: Double = 149.99) extends Product {
  val sDescription = "A " + sName + "."
}
