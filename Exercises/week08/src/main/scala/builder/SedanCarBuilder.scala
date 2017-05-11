package builder

//TODO

object SedanCarBuilder extends CarBuilder {

  var car = new Car("SEDAN")

  val dSedanSize: Array[Double] = Array(202.9, 76.2, 60.7, 112.9, 65.3,  65.5, 39.5)

  override def buildBodyStyle: Unit = car.setBodyStyle(bodyDesc(dSedanSize))

  override def buildPower: Unit = car.setPower(powerDesc(285, 6500, 253, 4000))

  override def buildEngine: Unit = car.setEngine("3.5L Duramax V 6 DOHC")

  override def buildBreaks: Unit = car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution")

  override def buildSeats: Unit = car.setSeats("Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats")

  override def buildWindows: Unit = car.setWindows("Laminated side windows.Fixed rear window with defroster")

  override def buildFuelType: Unit = car.setFuelType("Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range")

  override def getCar: Car = this.car //this override is the same in every case, move to parent class?
}
