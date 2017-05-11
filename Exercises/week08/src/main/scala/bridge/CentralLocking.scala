package bridge

case class CentralLocking(s: String) extends Product {
// TODO
  override def productName: String = s

  override def produce: Unit = ???
}
