package builder

// TODO

object SportsCarBuilder extends CarBuilder {

  var car = new Car("SPORTS")

  val dSportSize: Array[Double] = Array(192.3, 75.5, 54.2, 112.3, 63.7, 64.1, 37.7)

  override def buildBodyStyle: Unit = car.setBodyStyle(bodyDesc(dSportSize))

  override def buildPower: Unit = car.setPower(powerDesc(323, 6800, 278, 4800))

  override def buildEngine: Unit = car.setEngine("3.6L V 6 DOHC and variable valve timing")

  override def buildBreaks: Unit = car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution.\nStability control")

  override def buildSeats: Unit = car.setSeats("Driver sports front seat with one power adjustments manual height,\nfront passenger seat sports front seat with one power adjustments")

  override def buildWindows: Unit = car.setWindows("Front windows with one-touch on two windows")

  override def buildFuelType: Unit = car.setFuelType("Petrol 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range")

  override def getCar: Car = this.car //this override is the same in every case, move to parent class?
}
