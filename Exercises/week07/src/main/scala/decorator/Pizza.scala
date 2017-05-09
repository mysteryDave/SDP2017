package decorator

import java.text.DecimalFormat

trait Pizza {
  val priceFormat: DecimalFormat = new DecimalFormat("#")

  def getDesc: String

  def getPrice: Double
}
