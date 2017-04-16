import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    FireSensor sensor = new FireSensor();
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor();
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor();
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatAlarmRaisedPercentageIsFive() {
    int nNumberOfTests = 10000;
    int nTriggered = 0;
    FireSensor sensor = new FireSensor();
    for (int nTest = 1; nTest<=nNumberOfTests; nTest++) {
      if(sensor.isTriggered()) nTriggered++;
    }
    double dAlarmRaisedPercent = 100.0 * (double)nTriggered / (double)nNumberOfTests;
    assertEquals(5.0, dAlarmRaisedPercent, 0.5);
  }

  @Test
  public void testBatteryDrainIsTenPercent() {
    FireSensor sensor = new FireSensor();
    double dBatteryLevel = sensor.getBatteryPercentage();
    sensor.isTriggered();
    double dNewBatteryLevel = sensor.getBatteryPercentage();
    assertEquals(dBatteryLevel - 10, dNewBatteryLevel, 0.01);
  }
}
