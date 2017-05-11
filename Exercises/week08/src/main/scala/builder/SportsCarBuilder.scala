package builder

// TODO

object SportsCarBuilder extends CarBuilder {

  var car = new Car("SPORTS")

  val dSportSize: Array[Double] = {192.3, 76.2, 60., 112.9, 65.3}

  override def buildBodyStyle: Unit = bodyDesc(dSportSize, sSportDims)

  override def buildPower: Unit = ???

  override def buildEngine: Unit = ???

  override def buildBreaks: Unit = ???

  override def buildSeats: Unit = ???

  override def buildWindows: Unit = ???

  override def buildFuelType: Unit = ???

  override def getCar: Car = ???
}
