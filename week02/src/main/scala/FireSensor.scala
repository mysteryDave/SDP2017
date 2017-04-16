import scala.util.Random

class FireSensor extends Sensor {
  override def isTriggered: Boolean = (Random.nextInt(100) < 5)

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = -1
}
