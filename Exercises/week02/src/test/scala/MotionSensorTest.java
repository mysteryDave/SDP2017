import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by David Tucker on 17/04/2017.
 */
public class MotionSensorTest {
    
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
    
}
