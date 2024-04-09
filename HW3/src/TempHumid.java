import java.util.List;

/** An Abstract Temperature-Humidity class using the
 *  Template Method Pattern
 *  for processing temperature-humidity combo sensor data streams:
 *  E.g. 20240401.0 72.0 10.0 73.0 11.0
 *    would be a stream for the date April 1st, 2024 with temperatures 72F and 73F and humidity %s 10% and 11%
 */
public interface TempHumid {


    /**
     * A Helper method for determining if a datum is a date or a sensor value
     * @param d a double in either yyyymmdd form OR a temp/humid value
     * @return true if the double is in yyyymmdd form.
     */
    public default boolean isDate(double d){
        return d >= 19700101 && d <= 99991231;
    }

    /**
     * Loads a stream of temperature humidity data into memory (stores it in a field)
     * @param data
     *   date is in yyyymmdd.0 format, temperature is in F, humidity is in % (0.0-100.0)
     *   invariants:
     *   - always starts with a valid date
     *   - following a date is 0 or more pairs of temperature and humidity values OR a single error value -999
     *   - A data input list may contain multiple dates, the dates may appear in any order
     *   - intakeData may be called multiple times with data from other sensors for the same date
     */
    public abstract void intakeData(List<Double> data);

    /**
     * Removes invalid sensor data (-999s) as well as data not pertaining to this objects date from the
     */
    public abstract void clean();

    /**
     * transforms the data from the intake form (List of doubles) into a form convenient for output queries
     * Removes data from the intake form to avoid redundantly parsing it
     */
    public abstract void parse();

    /**
     * Mutates the parsed form to make queries fast by sorting the
     * temperature and humidity values
     */
    public abstract void sort();

    /**
     * @return the biggest temperature for this date
     */
    public abstract double maxTemperature();

    /**
     * @return the smallest temperature for this date
     */
    public abstract double minHumidity();
}
