package products

/**
  * Created by dtucke03 on 05/05/2017.
  */
class Creator {
  def factory(sProdName: String): Product = new ConcreteProduct(sProdName)
  def factory(sProdName: String, dProdPrice: Double): Product = new ConcreteProduct(sProdName, dProdPrice)
}

class ConcreteCreator extends Creator {
  override def factory(sProdName: String): ConcreteProduct = new ConcreteProduct(sProdName)
  override def factory(sProdName: String, dProdPrice: Double): ConcreteProduct = new ConcreteProduct(sProdName, dProdPrice)
}
