import java.util.List;

/**
 * A concrete implementation of the TempHumidTemplate that processes temperature and humidity data
 * immediately upon intake. It follows a Real-Time Processing (RTP) approach, executing all
 * processing steps (cleaning, parsing, sorting) within the `intakeData` method.
 *
 * This class is suitable for scenarios where immediate query responses are required, as data
 * is always kept in a parsed and sorted state for efficient retrieval.
 */
public class TempHumidRTP extends TempHumidTemplate{
    /**
     * Overrides the parent class's intakeData method to perform immediate processing of the data.
     * Steps include storing the data, cleaning invalid values, parsing it into separate temperature
     * and humidity lists, and sorting those lists for efficient querying.
     *
     * @param data A list of doubles containing temperature and humidity data in the format
     *             specified by the TempHumid interface.
     */
    @Override
    public void intakeData(List<Double> data) {
        super.intakeData(data);
        clean();
        super.parse();
        super.sort();
    }
    /**
     * Removes invalid sensor data (-999 values) from the stored intake data.
     */
    @Override
    public void clean() {
        super.clean();
    }
}
