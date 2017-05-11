package builder

trait CarBuilder {

  //Standard body dimensions used by most cars
  val sDimensions: Array[String] = {
    "overall length", "overall width", "overall height",
    "wheel base",     "front track",   "rear track",
    "curb to curb turning circle"}

  //Standard body description used by most cars [All inches apart from last, feet]
  def bodyDesc(dims: Array[Double], dimDescs: Array[String]) = " External dimensions:" + {
    for (nDim <- 1 until dims.length - 1) <- dimDescs(nDim) + " (inches): " + dims(nDim) + "," + {
      if (nDim % 2 == 0) "\n"
      else " "
    }
  } + {
    dimDescs(dims.length-2) + " (inches): " + dims(dims.length-2) + "and" +
    dimDescs(dims.length-1) + " (feet): " + dims(dims.length-1)
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