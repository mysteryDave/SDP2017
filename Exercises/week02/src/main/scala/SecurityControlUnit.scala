import java.util.Calendar

import scala.collection.mutable.ListBuffer

/**
  * Created by David Tucker on 17/04/2017.
  */
class SecurityControlUnit(sensors: ListBuffer[Sensor]) extends ControlUnit(sensors: ListBuffer[Sensor]) {
  def timecheck() : Boolean = {
    val timeNow = Calendar.getInstance()
    val nHour = timeNow.get(Calendar.HOUR_OF_DAY)
    nHour >= 22 || nHour < 6
  }

  override def pollSensors() {
    if (timecheck) super.pollSensors()
    else pollHazardSensors()
  }

  def pollHazardSensors() {
    for (sensor <- sensors) {
      if (!sensor.isSecuritySensor) {
        if (sensor.isTriggered) {
          System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
        }
        else {
          System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
        }
      }
    }
  }
}
