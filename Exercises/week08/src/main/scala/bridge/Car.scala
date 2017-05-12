package bridge

class Car(product: Product, carType: String) {

  //This code is common to all existing cars... can be overridden with car specific code in sublasses (if needed)
  def assemble: Unit = println("Assembling " + product.productName + " for " + carType)

  //productName and any other calls to product will run the code specific to the product passed
  def produceProduct: Unit = {
    product.produce
    println("Modifying product " + product.productName + " according to " + carType)
  }

  def printDetails: Unit = println("Car: " + carType + ", Product: " + product.productName)
}
