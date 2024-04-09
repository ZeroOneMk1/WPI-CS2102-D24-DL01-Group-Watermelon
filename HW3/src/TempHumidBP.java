/**
 * A concrete implementation of the TempHumidTemplate that processes temperature and humidity data
 * in a Batch Processing (BP) approach. It defers cleaning, parsing, and sorting of data until
 * query methods like `maxTemperature` or `minHumidity` are called.
 *
 * This class is suitable for scenarios where data is accumulated over time and queries are
 * performed less frequently. It avoids upfront processing costs, potentially saving resources
 * if not all queries will be used.
 */
public class TempHumidBP extends TempHumidTemplate{

    /**
     * Overrides the parent class's maxTemperature method to perform necessary processing steps
     * (cleaning, parsing, sorting) before returning the maximum temperature value.
     *
     * @return The highest temperature found in the processed data, or -999.0 if no valid data is available.
     */
    @Override
    public double maxTemperature() {
        super.clean();
        super.parse();
        super.sort();
        return super.maxTemperature();
    }

    /**
     * Overrides the parent class's minHumidity method to perform necessary processing steps
     * (cleaning, parsing, sorting) before returning the minimum humidity value.
     *
     * @return The lowest humidity found in the processed data, or -999.0 if no valid data is available.
     */
    @Override
    public double minHumidity() {
        super.clean();
        super.parse();
        super.sort();
        return super.minHumidity();
    }
}
