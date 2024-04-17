import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

/**
 * An interface for a greenhouse which has a collection of Temperature & Humidity sensors
 * as well as an internal clock to prevent data tampering
 */
public interface IGreenHouse {

    /**
     * Intakes data into the greenhouse system
     * @param data in the [yyyymmdd.0, temp, humid, temp2, humid2, -999.0, ...] format
     */
    public void intakeData(List<Double> data);

    /**
     * get the maximum temperature for a particular date (in degrees F)
     * @param forDate the date in yyyymmdd.0 format
     * @return the Optional.of(answer) if it exists or Optional.empty() if it does not
     */
    public Optional<Double> maxTemperature(double forDate);

    /**
     * get the maximum temperature for the current date on the greenhouse clock
     * @return the Optional.of(answer) if there is any data for the current data or Optional.empty() otherwise
     */
    public Optional<Double> maxTemperature();


    /**
     * get the minimum humidity value for a particular date (in % as 0.0 ~ 100.0)
     * @param forDate the date in yyyymmdd.0 format
     * @return the Optional.of(answer) if it exists or Optional.empty() if it does not
     */
    public Optional<Double> minHumidity(double forDate);
    /**
     * get the minimum humidity for the current date on the greenhouse clock
     * @return the Optional.of(answer) if there is any data for the current data or Optional.empty() otherwise
     */
    public Optional<Double> minHumidity();

    /**
     * Changes the current strategy for storing THDateComparable objects
     * @param strategy
     */
    public void setStrategy(IGHStrategy strategy);

    // Utilities to help you

    /**
     * Converts a gregorian calendar object into a double yyyymmdd.0 representation
     * @param gc
     * @return
     */
    public default double convertDate(GregorianCalendar gc){
        double year = gc.get(Calendar.YEAR);
        double month = gc.get(Calendar.MONTH) + 1; //Gregorian Calendar Months are 0-11 :(
        double day = gc.get(Calendar.DAY_OF_MONTH);
        return  day +
                (month * 100.0) +
                (year * 100.0 * 100.0);
    }

    /**
     * Converts a date double into a mutable gregorian calendar object
     * @param d in yyyymmdd.0 format
     * @return the gregorian calendar for that date (at midnight)
     */
    public default GregorianCalendar convertDate(double d){
        String dateStr = String.format("%.0f", d);

        int year = Integer.parseInt(dateStr.substring(0, 4));
        // Subtract 1 from month because GregorianCalendar months are 0-based
        int month = Integer.parseInt(dateStr.substring(4, 6)) - 1;
        int day = Integer.parseInt(dateStr.substring(6, 8));

        return new GregorianCalendar(year, month, day);
    }

    /**
     * Assume a sensor value is a date if it is greater jan 01, 1970
     * @param sensorDatum the datum which may be a date, temperature, humidity, or error
     * @return true if it is a yyyymmdd.0 formatted date
     */
    public default boolean isDate(double sensorDatum){
        return sensorDatum <= 99999999.0 && sensorDatum > 19700101.0;
    }
}
