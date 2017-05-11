package bridge

case class CentralLocking(s: String) extends Product {
  def productName: String = s
}
