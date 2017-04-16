trait Sensor {
  val isSecuritySensor: Boolean

  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String
}
