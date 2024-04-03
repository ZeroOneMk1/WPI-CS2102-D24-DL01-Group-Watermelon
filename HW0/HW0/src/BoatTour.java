public class BoatTour {
    public BoatTour(){

    }
    public double expenses(int numAdults, int numKids){
        return 470 + numAdults*5 + numKids*3;
    }
    public double revenue(int numAdults, int numKids){
        return 65*numAdults + 40*numKids;
    }
    public double profit(int numAdults, int numKids){
        return revenue(numAdults, numKids) - expenses(numAdults, numKids);
    }
}
