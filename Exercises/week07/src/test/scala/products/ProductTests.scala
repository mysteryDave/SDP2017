package products

/**
  * Created by dtucke03 on 05/05/2017.
  */
class ProductTests extends org.scalatest.FunSpec {
  describe("A product") {
    it("costs 149.99") {
      val anExampleProduct = new ConcreteProduct("Example")
      println(anExampleProduct)
      assert(149.99 == anExampleProduct.dPrice, 0.01)
    }
    it("has a description") {
      val aDescriptProduct = new ConcreteProduct("Description")
      println(aDescriptProduct.sDescription)
      assert("A Description.".equals(aDescriptProduct.sDescription))
    }
    it("can be given another price") {
      val aCheaperProduct = new ConcreteProduct("Value Item", 9.99)
      println(aCheaperProduct.dPrice)
      assert(aCheaperProduct.dPrice == 9.99, 0.01)
    }
  }
}