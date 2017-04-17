import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by David Tucker on 17/04/2017.
 */
public class AlarmTest {

    @Test
    public void testThatFireBrigadeCalled() {
        AlertFireAlarm alarm = new AlertFireAlarm();
        String sAlarmed = alarm.alarmAction();
        assertEquals("Called Fire Brigade", sAlarmed);
    }

    @Test
    public void testThatPoliceCalled() {
        AlertPoliceAlarm alarm = new AlertPoliceAlarm();
        String sAlarmed = alarm.alarmAction();
        assertEquals("Called Police", sAlarmed);
    }

    @Test
    public void testThatOwnerCalled() {
        AlertOwnerAlarm alarm = new AlertOwnerAlarm();
        String sAlarmed = alarm.alarmAction();
        assertEquals("Called Property Owner", sAlarmed);
    }

    @Test
    public void testAudibleAlarm() {
        AudibleAlarm alarm = new AudibleAlarm();
        String sAlarmed = alarm.alarmAction();
        assertEquals("Sounding alarm siren. Wee Wah Wee Wah Wee Wah!", sAlarmed);
    }

}


