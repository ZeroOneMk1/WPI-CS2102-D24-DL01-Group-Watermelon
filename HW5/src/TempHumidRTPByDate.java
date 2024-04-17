import java.util.LinkedList;
import java.util.List;
public class TempHumidRTPByDate extends TempHumidRTP{
    protected double date;
    public TempHumidRTPByDate(double date) {
        super();
        this.date = date;
    }

    @Override
    public void clean(){
        List<Double> forDate = new LinkedList<Double>();
        boolean collecting = false;
        for(double d : this.data){
            if(this.isDate(d) && d == this.date){
                collecting = true;
            }
            else if(this.isDate(d)){
                collecting = false;
            }
            else if(collecting){
                forDate.add(d);
            }
        }
        this.data = forDate;
        super.clean();
    }
}
