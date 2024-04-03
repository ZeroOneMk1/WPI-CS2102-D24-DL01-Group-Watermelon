/**
 * This class represents a rover that can travel on a planet.
 * It has a name, wheels, a battery, and a distance to travel.
 * It can also recharge its battery and travel further.
 * @author Azura Simsek
 */
public class Rover implements Vehicle {
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
     * Returns a string representation of the Rover object.
     *
     * @return a string representation of the Rover object
     */
    public String toString() {
        String out = "Rover: " + name;
        return out;
    }

    
    /**
     * This method checks if two Rover objects are equal.
     * Two Rovers are considered equal if their name, wheels, battery, and distance to travel are equal.
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (o instanceof Rover) {
            Rover other = (Rover) o;
            return this.name.equals(other.name) && this.wheels.equals(other.wheels) && this.battery.equals(other.battery) && Math.abs(this.metersToDestination - other.metersToDestination) < 0.01;
        } else {
            return false;
        }
    }

    /**
     * Returns the name of the rover.
     * @return the name of the rover
     */
    public String name(){
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
            return this.name();
        }else if(distanceOther > distanceSelf){
            return otherRover.name();
        }else{
            return "%s&%s".formatted(this.name(), otherRover.name());
        }
    }

    /**
     * Travels the rover for the given time.
     * @param time the time to travel
     */
    public void travelFor(double time){
        this.metersToDestination = time * this.wheels.getSpeed();
        this.battery.setAmpsLeft(this.battery.getAmpsLeft() - time * this.wheels.getTotalCurrentDraw());
        if(this.battery.getAmpsLeft() < 0) {
            this.metersToDestination = this.metersToDestination - time * this.wheels.getMetersPerAmp() - this.battery.getAmpsLeft() * time;
            this.battery.setAmpsLeft(0);
        }else{
            this.metersToDestination = this.metersToDestination - time * this.wheels.getMetersPerAmp();
        }

    }

    /**
     * Returns whether the rover can reach its destination with its current battery.
     * @return whether the rover can reach its destination with its current battery
     */
    public boolean canReachDest(){
        return progressUntilRecharge()==1?true:false;
    }

    @Override
    public double distancePossible() {
        return this.getDistanceUntilRecharge();
    }
}