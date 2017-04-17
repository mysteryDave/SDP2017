import java.io.IOException
import java.util.Scanner

import scala.collection.mutable.ListBuffer

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {

    val sensors = new ListBuffer[Sensor]()
    sensors += new FireSensor()
    sensors += new SmokeSensor()

    val securitySensors = new ListBuffer[Sensor]()
    securitySensors += new MotionSensor()

    val hazardAlarms = new ListBuffer[Alarm]()
    hazardAlarms += new AlertFireAlarm
    hazardAlarms += new AlertOwnerAlarm
    hazardAlarms += new AudibleAlarm

    val securityAlarms = new ListBuffer[Alarm]()
    securityAlarms += new AlertPoliceAlarm
    securityAlarms += new AlertOwnerAlarm

    val controlUnit: ControlUnit = new ControlUnit(sensors, hazardAlarms)
    val securityControlUnit: SecurityControlUnit = new SecurityControlUnit(securitySensors, securityAlarms)

    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""
    while (input != EXIT) {
      println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
      input = scanner.nextLine
      if (input == POLL) {
        controlUnit.pollSensors()
        securityControlUnit.pollSensors()
      }
    }
  }
}
