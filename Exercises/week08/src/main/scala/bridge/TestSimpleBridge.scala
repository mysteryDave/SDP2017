package bridge

/**
  * Created by DT on 11/05/2017.
  */
object TestSimpleBridge {

  def main(args: Array[String]) {
    val product: Product = CentralLocking("Central Locking System")
    val product2: Product = GearLocking("Gear Locking System")
    var car: Car = new Car(product, "BigWheel xz model")

    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = new Car(product2, "BigWheel xz model")
    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = new Car(product, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = new Car(product2, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
  }
}
