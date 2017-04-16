/**
  * Created by Den on 17/04/2017.
  */
trait BatteryPoweredSensor extends Sensor {

  def getBatteryPercentage: Double
}
