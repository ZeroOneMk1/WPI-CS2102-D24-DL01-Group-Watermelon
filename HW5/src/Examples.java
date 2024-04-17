import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class Examples {

    List<Double> testData = List.of(20240401.0,75.0,10.0,76.0,11.0,77.0,9.0,65.0,12.0,-999.0, 75.0,10.0,
            20240402.0 ,75.0,10.0,76.0,11.0,78.0,15.0,65.0,12.0,-999.0,75.0,10.0,
            20240403.0 ,75.0,9.0,76.0,11.0,79.0,15.0,65.0,12.0,-999.0,75.0,10.0,
            20240404.0 ,75.0,8.0,76.0,11.0,80.0,15.0,65.0,12.0,-999.0,75.0,10.0,
            20240405.0 ,75.0,7.0,76.0,11.0,81.0,15.0,65.0,12.0,-999.0,75.0,10.0,
            20240406.0 ,75.0,6.0,76.0,11.0,82.0,15.0,65.0,12.0,-999.0,75.0,10.0);

    @Test
    public void typicalGreenHouse(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 1));
        gh.intakeData(testData);
        assertEquals(Optional.of(80.0), gh.maxTemperature(20240404.0));
    }
    @Test
    public void ignoreDataForDateGreenHouse(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 7));
        gh.intakeData(testData);
        assertEquals(Optional.empty(), gh.maxTemperature(20240404));
    }
    @Test
    public void encapsulateGCTestGreenHouse(){
        GregorianCalendar gc = new GregorianCalendar(2024, Calendar.APRIL, 6);
        GreenHouse gh = new GreenHouse(gc);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        gh.intakeData(testData);
        assertEquals(Optional.of(82.0), gh.maxTemperature(20240406));
    }

    @Test
    public void typicalGreenHouse2(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 1));
        gh.intakeData(testData);
        assertEquals(Optional.of(8.0), gh.minHumidity(20240404.0));
    }
    @Test
    public void ignoreDataForDateGreenHouse2(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 7));
        gh.intakeData(testData);
        assertEquals(Optional.empty(), gh.minHumidity(20240404));
    }
    @Test
    public void encapsulateGCTestGreenHouse2(){
        GregorianCalendar gc = new GregorianCalendar(2024, Calendar.APRIL, 6);
        GreenHouse gh = new GreenHouse(gc);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        gh.intakeData(testData);
        assertEquals(Optional.of(6.0), gh.minHumidity(20240406));
    }

    @Test
    public void typicalGreenHouseNoDate(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 1));
        gh.intakeData(testData);
        assertEquals(Optional.of(82.0), gh.maxTemperature());
    }
    @Test
    public void ignoreDataForDateGreenHouseNoDate(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 7));
        gh.intakeData(testData);
        assertEquals(Optional.empty(), gh.maxTemperature());
    }

    @Test
    public void typicalGreenHouseNoDate2(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 1));
        gh.intakeData(testData);
        assertEquals(Optional.of(6.0), gh.minHumidity());
    }
    @Test
    public void ignoreDataForDateGreenHouseNoDate2(){
        GreenHouse gh = new GreenHouse(new GregorianCalendar(2024, Calendar.APRIL, 7));
        gh.intakeData(testData);
        assertEquals(Optional.empty(), gh.minHumidity());
    }

    @Test
    public void encapsulateGCTestGreenHouse3(){
        GregorianCalendar gc = new GregorianCalendar(2024, Calendar.APRIL, 6);
        GreenHouse gh = new GreenHouse(gc);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        gh.intakeData(testData);
        assertEquals(Optional.empty(), gh.maxTemperature(20240403));
    }
}
