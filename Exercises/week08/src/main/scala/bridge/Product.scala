package bridge

trait Product { //alternatively productName parameter to Product constructor.
  def productName: String

  def produce: Unit = println("Producing " + productName)
}