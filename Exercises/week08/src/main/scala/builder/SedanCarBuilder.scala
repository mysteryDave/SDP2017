package builder

//TODO

object SedanCarBuilder extends CarBuilder {

  var car = new Car("SEDAN")

  val dSedanSize: Array[Double] = {202.9, 76.2, 60.7}

  override def buildBodyStyle: Unit = car.setBodyStyle(bodyDesc(dSedanSize,sDimensions))

  override def buildPower: Unit = ???

  override def buildEngine: Unit = ???

  override def buildBreaks: Unit = ???

  override def buildSeats: Unit = ???

  override def buildWindows: Unit = ???

  override def buildFuelType: Unit = ???

  override def getCar: Car = ???
}
