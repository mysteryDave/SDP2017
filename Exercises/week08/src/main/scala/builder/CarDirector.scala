package builder

// TODO

case class CarDirector(carBuilder: CarBuilder) {
  def build {
    /*Assumes the director knows that every car must have these parts
     * could be encapsulated further into carBuilder and leave director to call carBuilder.buildCar
     */
    carBuilder.buildBodyStyle
    carBuilder.buildPower
    carBuilder.buildEngine
    carBuilder.buildBreaks
    carBuilder.buildSeats
    carBuilder.buildWindows
    carBuilder.buildFuelType
  }

}
