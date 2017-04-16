import scala.util.Random

class FireSensor extends Sensor {
  var dBatteryPercentage = -1.0

  override def isTriggered: Boolean = {
    dBatteryPercentage = dBatteryPercentage - 10
    Random.nextInt(100) < 5
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = dBatteryPercentage
}
