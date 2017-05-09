package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = pizza.getDesc + ", Green Olives (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice: Double = pizza.getPrice + 5.47
}
