package decorator

/**
  * Created by David Tucker on 09/05/2017.
  */
class FetaCheese(pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc = pizza.getDesc + ", Feta Cheese (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice = pizza.getPrice + 24.99
}
