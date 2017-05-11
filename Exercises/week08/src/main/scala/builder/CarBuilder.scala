package builder

trait CarBuilder {

  /*Standard body dimensions used by most cars
  **Individual builder subclass can override with different specifics or not use if needed.
  **Other pattern better here? - if other subclasses don't use may be better to encapsulate elsewhere? Decorator?
  */
  val sDimensions: Array[String] = Array(
    "overall length", "overall width", "overall height",
    "wheel base",     "front track",   "rear track",
    "curb to curb turning circle")

  /*Standard body description used by most cars [All inches apart from last, feet]
  **Individual builder subclass can override with different specifics or not use if needed.
  **Other pattern better here? - if other subclasses don't use may be better to encapsulate elsewhere? Decorator?
  */
  def bodyDesc(dims: Array[Double], dimDescs: Array[String] = sDimensions) = {
    var sBody: String = " External dimensions: "
    val sMoreBody = for (nDim <- 0 until (dims.length - 2) by 2) yield {
      dimDescs(nDim) + " (inches): " + dims(nDim) + ",\n" + dimDescs(nDim + 1) + " (inches): " + dims(nDim + 1) + ", "
    }
    sBody = sBody + sMoreBody.mkString.dropRight(2) + " and " + dimDescs(dims.length-1) + " (feet): " + dims(dims.length-1)

    sBody
  }

  def powerDesc(nHP: Integer, nHPRPM: Integer, nTorque: Integer, nTorqueRPM: Integer) =  f"$nHP hp @ $nHPRPM%,n rpm; $nTorque ft lb of torque @ $nTorqueRPM%,n rpm"

  //Assumption: different cars may be not all have all components. Director may not know components.
  //Individual builder subclass can override with different specifics if needed.
  def buildCar: Unit = {
    buildBodyStyle
    buildPower
    buildEngine
    buildBreaks
    buildSeats
    buildWindows
    buildFuelType
  }

  def buildBodyStyle

  def buildPower

  def buildEngine

  def buildBreaks

  def buildSeats

  def buildWindows

  def buildFuelType

  def getCar: Car
}