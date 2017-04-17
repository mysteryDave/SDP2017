import java.util.Calendar

import scala.collection.mutable.ListBuffer

/**
  * Created by David Tucker on 17/04/2017.
  */
class SecurityControlUnit(sensors: ListBuffer[Sensor], alarms: ListBuffer[Alarm]) extends ControlUnit(sensors: ListBuffer[Sensor], alarms: ListBuffer[Alarm]) {
  def timecheck() : Boolean = {
    val timeNow = Calendar.getInstance()
    val nHour = timeNow.get(Calendar.HOUR_OF_DAY)
    nHour >= 22 || nHour < 6
  }

  override def pollSensors() {
    if (timecheck()) super.pollSensors()
  }

}
