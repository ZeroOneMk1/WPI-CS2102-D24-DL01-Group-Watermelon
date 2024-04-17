import java.util.LinkedList;
import java.util.List;

public abstract class TempHumidTemplate implements TempHumid {
    public List<Double> data;
    public List<Double> temperatures;
    public List<Double> humidities;

    public TempHumidTemplate(){
        this.data = new LinkedList<>();
        this.temperatures = new LinkedList<>();
        this.humidities = new LinkedList<>();
    }
    @Override
    public void intakeData(List<Double> data) {
        this.data.addAll(data);
    }

    public void processData(){
        this.clean();
        this.parse();
        this.sort();
    }

    @Override
    public void clean() {
        this.data.removeIf((d) -> this.isDate(d));
        this.data.removeIf((d) -> d == -999.0);
    }

    @Override
    public void parse() {
        for(int i = 0; i < this.data.size(); i += 2){
            temperatures.add(this.data.get(i));
            humidities.add(this.data.get(i+1));
        }
        this.data.clear();
    }

    @Override
    public void sort() {
        this.temperatures.sort(Double::compareTo);
        this.humidities.sort(Double::compareTo);
    }


    @Override
    public double maxTemperature() {
        return temperatures.isEmpty() ? -999.0 : temperatures.get(temperatures.size() - 1);
    }

    @Override
    public double minHumidity() {
        return humidities.isEmpty() ? -999.0 : this.humidities.get(0);
    }
}
