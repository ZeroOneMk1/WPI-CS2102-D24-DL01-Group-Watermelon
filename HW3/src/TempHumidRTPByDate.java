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
     * Overrides the parent class's intakeData method to filter data for the designated date.
     * It extracts only the relevant temperature and humidity values for the target date and
     * then calls the parent class's intakeData method for real-time processing.
     *
     * @param data A list of doubles containing temperature and humidity data in the format
     *             specified by the TempHumid interface.
     */
    @Override
    public void intakeData(List<Double> data) {
        List<Double> newData = new ArrayList<Double>(List.of());
        int i = 0;
        while(data.get(i) != this.day){
            i++;
            if(i >= data.size()){
                return;
            }
        }
        i++;
        if(i >= data.size()){
            return;
        }
        while(data.get(i) < 1000){
            newData.add(data.get(i));
            i++;
            if(i >= data.size()){
                break;
            }
        }
        super.intakeData(newData);
    }
}
