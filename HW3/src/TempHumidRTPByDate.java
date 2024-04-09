import java.util.ArrayList;
import java.util.List;

/**
 * A specialized subclass of TempHumidRTP that processes temperature and humidity data for a specific date.
 * It filters incoming data to only retain values for the designated date before passing it to
 * the parent class for real-time processing.
 *
 * This class is useful for isolating and analyzing data for a particular date, without the need to
 * handle multiple dates within the same object.
 */
public class TempHumidRTPByDate extends TempHumidRTP{
    double day;
    /**
     * Initializes a new instance of TempHumidRTPByDate for the specified date.
     *
     * @param day The date (in yyyymmdd.0 format) for which data should be processed.
     */
    public TempHumidRTPByDate(double day){
        super();
        this.day = day;
    }

    /**
     * Overrides the parent class's clean method to filter data for the designated date.
     * This filtering occurs during the real-time processing pipeline, ensuring that only
     * relevant temperature and humidity values for the target date are parsed and sorted.
     *
     * It removes any invalid sensor data (-999 values) and values for other dates, leaving
     * only the data for the specific date specified in the `this.day` field.
     */
    @Override
    public void clean() {
        List<Double> newData = new ArrayList<Double>(List.of());
        int i = 0;
        while(this.intakeData.get(i) != this.day){
            i++;
            if(i >= this.intakeData.size()){
                return;
            }
        }
        i++;
        if(i >= this.intakeData.size()){
            return;
        }
        while(this.intakeData.get(i) < 1000){
            newData.add(this.intakeData.get(i));
            i++;
            if(i >= this.intakeData.size()){
                break;
            }
        }
        this.intakeData = newData;
        super.clean();
    }
}
