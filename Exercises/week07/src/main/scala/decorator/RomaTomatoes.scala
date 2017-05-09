package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = pizza.getDesc + ", Roma Tomatoes (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice: Double = pizza.getPrice + 5.20
}
