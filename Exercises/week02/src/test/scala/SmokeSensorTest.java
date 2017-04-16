import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    SmokeSensor sensor = new SmokeSensor();
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    SmokeSensor sensor = new SmokeSensor();
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    SmokeSensor sensor = new SmokeSensor();
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    SmokeSensor sensor = new SmokeSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatAlarmRaisedPercentageIsTen() {
    int nNumberOfTests = 10000;
    int nTriggered = 0;
    SmokeSensor sensor = new SmokeSensor();
    for (int nTest = 1; nTest<=nNumberOfTests; nTest++) {
      if(sensor.isTriggered()) nTriggered++;
    }
    double dAlarmRaisedPercent = 100.0 * (double)nTriggered / (double)nNumberOfTests;
    assertEquals(10.0, dAlarmRaisedPercent, 0.5);
  }

  @Test
  public void testBatteryDrainIsTenPercent() {
    SmokeSensor sensor = new SmokeSensor();
    double dBatteryLevel = sensor.getBatteryPercentage();
    sensor.isTriggered();
    double dNewBatteryLevel = sensor.getBatteryPercentage();
    assertEquals(dBatteryLevel - 20, dNewBatteryLevel, 0.01);
  }

}
