import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

public class GreenHouse implements IGreenHouse {
    public GreenHouse(GregorianCalendar cal){

    }
    @Override
    public void intakeData(List<Double> data) {

    }

    @Override
    public Optional<Double> maxTemperature(double forDate) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> maxTemperature() {
        return Optional.empty();
    }

    @Override
    public Optional<Double> minHumidity(double forDate) {
        return Optional.empty();
    }

    @Override
    public Optional<Double> minHumidity() {
        return Optional.empty();
    }

    @Override
    public void setStrategy(IGHStrategy strategy) {

    }
}
