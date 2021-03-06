import scala.util.Random

/**
  * Created by David Tucker on 17/04/2017.
  */
class MotionSensor extends Sensor {
  override val isSecuritySensor: Boolean = true

  var sLocation: String = null
  var sSensorType: String = null

  override def isTriggered: Boolean = Random.nextInt(100) < 20

  override def getLocation: String = sLocation

  override def getSensorType: String = sSensorType
}
