package bridge

case class GearLocking(s: String) extends Product {
// TODO

  override def productName: String = s

  override def produce: Unit = ???
}
