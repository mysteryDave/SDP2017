package decorator

class SimplyVegPizza extends Pizza {
  def getDesc: String = "SimplyVegPizza (" + priceFormat.format(getPrice) + ")"

  def getPrice: Double = 230
}
