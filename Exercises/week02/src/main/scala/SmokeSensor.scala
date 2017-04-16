import scala.util.Random

class SmokeSensor extends Sensor {
  var dBatteryPercentage = -1.0

  override def isTriggered: Boolean = {
    dBatteryPercentage = dBatteryPercentage - 20
    Random.nextInt(100) < 10
  }

  override def getLocation: String = null

  override def getSensorType: String = null

  override def getBatteryPercentage: Double = dBatteryPercentage
}
