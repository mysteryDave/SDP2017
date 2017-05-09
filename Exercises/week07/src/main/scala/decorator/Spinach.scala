package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = pizza.getDesc + ", Spinach (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice: Double = pizza.getPrice + 7.92
}
