public class HouseCalculator {

    public double totalCost(double initial, double downpayment){
        double principle =  initial - downpayment;
        return 2000 + initial + principle * .05 * 30;
    }
}
