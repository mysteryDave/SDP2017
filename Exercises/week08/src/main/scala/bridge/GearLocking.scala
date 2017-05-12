package bridge

case class GearLocking(s: String) extends Product {
  def productName: String = s
}
