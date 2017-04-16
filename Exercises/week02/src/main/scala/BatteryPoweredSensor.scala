/**
  * Created by David Tucker on 17/04/2017.
  */
trait BatteryPoweredSensor extends Sensor {
  override val isSecuritySensor: Boolean = false

  def getBatteryPercentage: Double
}
