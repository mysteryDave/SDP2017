import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by David Tucker on 17/04/2017.
 */
public class MotionSensorTest {
    
  @Test
  public void testThatIsTriggeredReturnsFalse() {
    MotionSensor sensor = new MotionSensor();
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    MotionSensor sensor = new MotionSensor();
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    MotionSensor sensor = new MotionSensor();
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }
    
}
