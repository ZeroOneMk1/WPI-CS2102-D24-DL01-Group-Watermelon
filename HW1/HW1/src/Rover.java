/**
 * This class represents a rover that can travel on a planet.
 * It has a name, wheels, a battery, and a distance to travel.
 * It can also recharge its battery and travel further.
 * @author Azura Simsek
 */
public class Rover {
    /**
     * The name of the rover.
     */
    public String name;
    /**
     * The wheels of the rover.
     */
    public Wheels wheels;
    /**
     * The battery of the rover.
     */
    public Battery battery;
    /**
     * The distance the rover needs to travel.
     */
    public double metersToDestination;

    /**
     * Creates a new rover with the given name, wheels, battery, and distance to travel.
     * @param name the name of the rover
     * @param wheels the wheels of the rover
     * @param battery the battery of the rover
     * @param metersToDestination the distance the rover needs to travel
     */
    public Rover(String name, Wheels wheels, Battery battery, double metersToDestination) {
        this.name = name;
        this.wheels = wheels;
        this.battery = battery;
        if(metersToDestination <= 0){
            this.metersToDestination = 0.0000000000001; // SMALL POSITIVE NUMBER
        }else{
            this.metersToDestination = metersToDestination;
        }
    }

    /**
     * Returns the name of the rover.
     * @return the name of the rover
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the distance the rover can travel until it needs to recharge its battery.
     * @return the distance the rover can travel until it needs to recharge its battery
     */
    private double getDistanceUntilRecharge(){
        return this.wheels.getMetersPerAmp() * this.battery.getAmpsLeft();
    }

    /**
     * Returns the maximum distance the rover can travel with its current battery.
     * @return the maximum distance the rover can travel with its current battery
     */
    private double getDistanceIfFull(){
        return this.wheels.getMetersPerAmp() * this.battery.getCapacity();
    }

    /**
     * Returns the progress of the rover until it needs to recharge its battery.
     * @return the progress of the rover until it needs to recharge its battery
     */
    public double progressUntilRecharge(){
        final double factor = this.getDistanceUntilRecharge()/this.metersToDestination;

        if(factor > 1){
            return 1;
        }else if(factor < 0){
            return 0;
        }else{
            return factor;
        }
    }

    /**
     * Returns which rover goes further based on its current distance and the distance of the other rover.
     * @param otherRover the other rover
     * @return the name of the rover that goes further
     */
    public String whoGoesFurther(Rover otherRover){
        double distanceSelf = this.getDistanceIfFull();
        double distanceOther = otherRover.getDistanceIfFull();

        if(distanceOther < distanceSelf){
            return this.getName();
        }else if(distanceOther > distanceSelf){
            return otherRover.getName();
        }else{
            return "%s&%s".formatted(this.getName(), otherRover.getName());
        }
    }

    /**
     * Travels the rover for the given distance.
     * @param distance the distance to travel
     */
    public void travelFor(double distance){
        this.metersToDestination = distance;
        if(!this.canReachDest()){
            this.metersToDestination -= this.getDistanceUntilRecharge();
            this.battery.setAmpsLeft(0);
        }else{
            this.metersToDestination = 0;
            this.battery.setAmpsLeft(this.battery.getAmpsLeft() - distance / this.wheels.getMetersPerAmp());
        }
    }

    /**
     * Returns whether the rover can reach its destination with its current battery.
     * @return whether the rover can reach its destination with its current battery
     */
    public boolean canReachDest(){
        return progressUntilRecharge()==1?true:false;
    }
}