import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class that provides a template for processing temperature and humidity data streams.
 * It implements the TempHumid interface, defining the core steps for data intake, cleaning, parsing,
 * sorting, and querying maximum temperature and minimum humidity values.
 *
 * Subclasses should implement any date-specific logic within these methods.
 */
public abstract class TempHumidTemplate implements TempHumid {


    List<Double> intakeData;
    List<Double> parsedTemps;
    List<Double> parsedHums;

    public TempHumidTemplate(){
        this.intakeData = new ArrayList<Double>(List.of());
        this.parsedTemps = new ArrayList<Double>(List.of());
        this.parsedHums = new ArrayList<Double>(List.of());
    }
    /**
     * @param data date is in yyyymmdd.0 format, temperature is in F, humidity is in % (0.0-100.0)
     *             invariants:
     *             - always starts with a valid date
     *             - following a date is 0 or more pairs of temperature and humidity values OR a single error value -999
     *             - A data input list may contain multiple dates, the dates may appear in any order
     *             - intakeData may be called multiple times with data from other sensors for the same date
     */
    @Override
    public void intakeData(List<Double> data) {
        this.intakeData = data;
    }

    /**
     * Removes invalid sensor data (-999 values) from the stored intake data.
     */
    @Override
    public void clean() {
        List<Double> temp = new ArrayList<Double>(List.of());
        for(Double element:this.intakeData){
            if(element >=-998){
                temp.add(element);
            }
        }
        this.intakeData = temp;
    }

    /**
     * Parses the intake data into separate lists for temperatures and humidity values,
     * preparing it for efficient querying.
     *
     * Removes the parsed data from the intake list to avoid redundant processing.
     */
    @Override
    public void parse() {
        boolean addingHumidity = false;
        for(Double element:this.intakeData){
            if(element >= 1000){
                continue;
            }
            if(!addingHumidity){
                this.parsedTemps.add(element);
            }else{
                this.parsedHums.add(element);
            }
            addingHumidity = !addingHumidity;
        }
    }

    /**
     * Sorts the parsed temperature and humidity lists for faster query performance.
     */
    @Override
    public void sort() {
        this.parsedTemps.sort(Double::compareTo);
        this.parsedHums.sort(Double::compareTo);
    }

    /**
     * Returns the highest temperature value found in the parsed data.
     *
     * @return The maximum temperature, or -999.0 if no valid temperature data is available.
     */
    @Override
    public double maxTemperature() {
        if(this.parsedTemps.isEmpty()){
            return -999.0;
        }
        return this.parsedTemps.get(this.parsedTemps.size()-1);
    }

    /**
     * Returns the lowest humidity value found in the parsed data.
     *
     * @return The minimum humidity, or -999.0 if no valid humidity data is available.
     */
    @Override
    public double minHumidity() {
        if(this.parsedHums.isEmpty()){
            return -999.0;
        }
        return this.parsedHums.get(0);
    }
}
