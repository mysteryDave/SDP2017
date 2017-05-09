package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = pizza.getDesc + ", Cheese (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice: Double = pizza.getPrice + 20.72
}
