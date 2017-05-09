package decorator

import java.text.DecimalFormat

/**
  * Created by David Tucker on 09/05/2017.
  */
abstract class PizzaDecorator(basePizza: Pizza) extends Pizza {
  override val priceFormat: DecimalFormat = new DecimalFormat("#.##")

  override def getDesc: String = basePizza.getDesc

  override def getPrice: Double = basePizza.getPrice
}
