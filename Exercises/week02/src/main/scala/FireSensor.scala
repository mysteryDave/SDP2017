import scala.util.Random

class FireSensor extends BatteryPoweredSensor {
  var dBatteryPercentage = -1.0
  var sLocation: String = null
  var sSensorType:String = null

  override def isTriggered: Boolean = {
    dBatteryPercentage = dBatteryPercentage - 10
    Random.nextInt(100) < 5
  }

  override def getLocation: String = sLocation

  override def getSensorType: String = sSensorType

  override def getBatteryPercentage: Double = dBatteryPercentage
}
