import java.util.ArrayList;
import java.util.List;

public class TempHumidRTPByDate extends TempHumidRTP{
    double day;
    public TempHumidRTPByDate(double day){
        super();
        this.day = day;
    }

    @Override
    public void intakeData(List<Double> data) {
        List<Double> newData = new ArrayList<>(List.of());
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
