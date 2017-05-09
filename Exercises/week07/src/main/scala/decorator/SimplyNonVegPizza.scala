package decorator

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = "SimplyNonVegPizza (" + priceFormat.format(getPrice) + ")"

  def getPrice: Double = 350
}
