import java.util.List;

public class TempHumidRTP extends TempHumidTemplate{
    @Override
    public void intakeData(List<Double> data) {
        super.intakeData(data);
        super.clean();
        super.parse();
        super.sort();
    }
}
