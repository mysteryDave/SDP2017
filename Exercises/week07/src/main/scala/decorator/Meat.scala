package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = pizza.getDesc + ", Meat (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice: Double = pizza.getPrice + 14.25
}
