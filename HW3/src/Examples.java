import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Examples {

        List<Double> testData = List.of(20240401.0, 75.0, 10.0, 76.0, 11.0, 77.0, 9.0, 65.0, 12.0, -999.0, 75.0, 10.0,
                                                  20240402.0, 75.0, 10.0, 76.0, 11.0, 78.0, 15.0, 65.0, 12.0, -999.0, 75.0, 10.0);
    @Test
    public void testTests(){
        assertEquals(1, 1);
        assertFalse(false);
        assertTrue(true);
    }

    @Test
    public void testMaxTemp1(){
        TempHumid thd = new TempHumidBP();
        thd.intakeData(testData);
        assertEquals(78.0, thd.maxTemperature(), 0.01);
    }

    @Test
    public void testMaxTemp2(){
        TempHumid thd = new TempHumidRTP();
        thd.intakeData(testData);
        assertEquals(78.0, thd.maxTemperature(), 0.01);
    }

    @Test
    public void testTime1(){
        TempHumid thdBP = new TempHumidBP();
        TempHumid thdRTP = new TempHumidRTP();
        long time1 = System.nanoTime();
        thdBP.intakeData(testData);
        long time2 = System.nanoTime();
        long bpIntake = time2-time1;

        long time3 = System.nanoTime();
        thdRTP.intakeData(testData);
        long time4 = System.nanoTime();
        long rtpIntake = time4 - time3;

        assertTrue(bpIntake < rtpIntake);
    }

    @Test
    public void testMinHumid1(){
        TempHumid thd = new TempHumidBP();
        thd.intakeData(testData);
        assertEquals(9.0, thd.minHumidity(), 0.01);
    }

    @Test
    public void testMinHumid2(){
        TempHumid thd = new TempHumidRTP();
        thd.intakeData(testData);
        assertEquals(9.0, thd.minHumidity(), 0.01);
    }

    @Test
    public void testMaxTemp3(){
        TempHumid thd = new TempHumidRTPByDate(20240401.0);
        thd.intakeData(testData);
        assertEquals(77.0, thd.maxTemperature(), 0.01);
    }

    @Test
    public void testMaxTemp4(){
        TempHumid thd = new TempHumidRTPByDate(20240402.0);
        thd.intakeData(testData);
        assertEquals(78.0, thd.maxTemperature(), 0.01);
    }
}
