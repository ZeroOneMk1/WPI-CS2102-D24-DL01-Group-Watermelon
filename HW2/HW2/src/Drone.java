import java.util.List;

/**
 * An object that represents a Drone.
 * 
 * @author Azura Simsek
 */
public class Drone implements Vehicle {

    /**
     * The unique ID number of the drone.
     */
    public int idNumber;

    /**
     * The list of propellers that power the drone.
     */
    public List<Propeller> propellers;

    /**
     * The battery that powers the drone.
     */
    public Battery battery;

    /**
     * The list of checkpoints that the drone must reach.
     */
    public List<Double> checkPoints;

    /**
     * Creates a new drone with the specified ID number, propellers, battery, and checkpoints.
     *
     * @param idNumber    the ID number of the drone
     * @param propellers  the list of propellers
     * @param battery     the battery
     * @param checkPoints the list of checkpoints
     */
    public Drone(int idNumber, List<Propeller> propellers, Battery battery, List<Double> checkPoints) {
        this.idNumber = idNumber;
        this.propellers = propellers;
        this.battery = battery;
        this.checkPoints = checkPoints;
    }

    /**
     * Returns a string representation of the drone, containing its ID number.
     *
     * @return the string representation of the drone
     */
    public String toString() {
        return "Drone: " + idNumber;
    }

    /**
     * Checks if the list of checkpoints of this drone and the specified list are equal.
     * Two lists are considered equal if they have the same number of elements and each element at the same index is equal.
     *
     * @param otherCheckPoints the list of checkpoints to compare with
     * @return true if the checkpoints are equal, false otherwise
     */
    public boolean checkPointsEqual(List<Double> otherCheckPoints) {
        double thissum = 0;
        double othersum = 0;
        for (Double checkPoint : this.checkPoints) {
            thissum += checkPoint;
        }
        for (Double checkPoint : otherCheckPoints) {
            othersum += checkPoint;
        }
        return thissum == othersum;
    }

    /**
     * Checks if this drone is equal to the specified object.
     * Two drones are considered equal if they have the same ID number, propellers, battery, and checkpoints.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Drone) {
            Drone other = (Drone) o;
            return this.idNumber == other.idNumber &&
                    this.propellers.equals(other.propellers) &&
                    this.battery.equals(other.battery) &&
                    this.checkPointsEqual(other.checkPoints);
        } else {
            return false;
        }
    }

    /**
     * Calculates the total distance that the drone can travel for each ampere of battery power.
     * This is the sum of the distances traveled by each propeller.
     *
     * @return the total distance traveled for each ampere of battery power
     */
    public double getMetersPerAmp() {
        double out = 0;
        for (Propeller propeller : this.propellers) {
            out += propeller.getMetersPerAmp();
        }
        return out;
    }

    /**
     * Calculates the distance that the drone can travel until the battery needs to be recharged.
     * This is the product of the total distance traveled for each ampere of battery power and the number of amperes left in the battery.
     *
     * @return the distance that the drone can travel until the battery needs to be recharged
     */
    public double getDistanceUntilRecharge() {
        return this.getMetersPerAmp() * this.battery.getAmpsLeft();
    }

    /**
     * Moves the drone for a specified time, using the battery power.
     * The distance traveled is calculated based on the total distance traveled for each ampere of battery power and the time passed.
     * If the battery power is negative, the distance traveled is added to the list of checkpoints as a negative value.
     * The battery power is then set to zero.
     *
     * @param time the time to move the drone for
     */
    @Override
    public void travelFor(double time) {
        this.battery.setAmpsLeft(this.battery.getAmpsLeft() - time * this.getMetersPerAmp());
        if (this.battery.getAmpsLeft() < 0) {
            // this.checkPoints.add(-this.battery.getAmpsLeft() * this.getMetersPerAmp());
            this.battery.setAmpsLeft(0);
        }
    }

    /**
     * Calculates the progress of the drone towards reaching its destination.
     * This is the ratio of the distance traveled until recharging to the total distance to the destination.
     * If the ratio is greater than one, it is set to one. If it is less than zero, it is set to zero.
     *
     * @return the progress of the drone towards reaching its destination
     */
    @Override
    public double progressUntilRecharge() {
        final double factor = this.getDistanceUntilRecharge() / this.getMetersToDestination();

        if (factor > 1) {
            return 1;
        } else if (factor < 0) {
            return 0;
        } else {
            return factor;
        }
    }

    /**
     * Calculates the total distance to the destination from the current position of the drone.
     * This is the sum of all the distances between each checkpoint.
     *
     * @return the total distance to the destination
     */
    public double getMetersToDestination() {
        double out = 0;
        for (Double checkPoint : this.checkPoints) {
            out += checkPoint;
        }
        return out;
    }

    /**
     * Checks if the drone has reached its destination or not.
     * This is determined by comparing the progress towards recharging to one.
     *
     * @return true if the drone has reached its destination, false otherwise
     */
    @Override
    public boolean canReachDest() {
        return progressUntilRecharge() == 1? true : false;
    }

    /**
     * Returns a string representation of the drone, containing its ID number.
     *
     * @return the string representation of the drone
     */
    @Override
    public String name() {
        String out = "drone#%d".formatted(this.idNumber);
        return out;
    }

    /**
     * Calculates the maximum distance that the drone can travel.
     * This is the distance that the drone can travel until the battery needs to be recharged.
     *
     * @return the maximum distance that the drone can travel
     */
    public double distancePossible() {
        return this.getDistanceUntilRecharge();
    }
}