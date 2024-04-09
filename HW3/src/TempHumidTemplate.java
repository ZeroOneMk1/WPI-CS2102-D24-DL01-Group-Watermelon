import java.util.ArrayList;
import java.util.List;

public abstract class TempHumidTemplate implements TempHumid{

    List<Double> intakeData;
    List<Double> parsedTemps;
    List<Double> parsedHums;

    public TempHumidTemplate(){
        this.intakeData = new ArrayList<>(List.of());
        this.parsedTemps = new ArrayList<>(List.of());
        this.parsedHums = new ArrayList<>(List.of());
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
     *
     */
    @Override
    public void clean() {
        List<Double> temp = new ArrayList<>(List.of());
        for(Double element:this.intakeData){
            if(element >=-998){
                temp.add(element);
            }
        }
        this.intakeData = temp;
    }

    /**
     *
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
        }
    }

    /**
     *
     */
    @Override
    public void sort() {
        this.parsedTemps.sort(Double::compareTo);
        this.parsedHums.sort(Double::compareTo);
    }

    /**
     * @return
     */
    @Override
    public double maxTemperature() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public double minHumidity() {
        return 0;
    }
}
