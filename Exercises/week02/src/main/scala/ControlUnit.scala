import scala.collection.mutable.ListBuffer

class ControlUnit(sensors: ListBuffer[Sensor],alarms: ListBuffer[Alarm]) {
  def pollSensors() {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
        for (alarm <- alarms) println(alarm.alarmAction)
        println()
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

object ControlUnit
