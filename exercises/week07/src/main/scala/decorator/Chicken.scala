package decorator

/**
  * Created by David Tucker on 09/05/2017.
  */
class Chicken(pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc = pizza.getDesc + ", Chicken (" + priceFormat.format(getPrice - pizza.getPrice) + ")"

  override def getPrice = pizza.getPrice + 12.47
}
