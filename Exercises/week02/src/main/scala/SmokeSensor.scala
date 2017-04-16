import scala.util.Random

class SmokeSensor extends BatteryPoweredSensor {
  var dBatteryPercentage = -1.0
  var sLocation: String = null
  var sSensorType:String = null

  override def isTriggered: Boolean = {
    dBatteryPercentage = dBatteryPercentage - 20
    Random.nextInt(100) < 10
  }

  override def getLocation: String = sLocation

  override def getSensorType: String = sSensorType

  override def getBatteryPercentage: Double = dBatteryPercentage
}
