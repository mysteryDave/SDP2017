package bridge

// TODO

case class Motoren(product: Product, s: String) extends Car(product, s) {
  override def assemble: Unit =

  override def produceProduct: Unit = product.produce

  override def printDetails: Unit = ???
}
