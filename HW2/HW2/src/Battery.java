/**
 * This class represents a battery.
 * 
 * @author Azura Simsek
 */
public class Battery {

    /**
     * The capacity of the battery, in ampere-seconds.
     */
    public double capacity;

    /**
     * The amount of charge remaining in the battery, in ampere-seconds.
     */
    public double amountLeft;

    /**
     * Creates a new Battery with the specified capacity and amount left.
     * 
     * @param capacity The capacity of the battery, in ampere-seconds.
     * @param amountLeft The amount of charge remaining in the battery, in ampere-seconds.
     */
    public Battery(double capacity, double amountLeft) {
        this.capacity = capacity;
        this.amountLeft = amountLeft;
    }

    /**
     * Returns true if the specified object is equal to this Battery object.
     *
     * Two Batteries are considered equal if and only if they have the same capacity and the same amount of charge remaining.
     *
     * @param o the object to compare to this Battery
     * @return true if the specified object is equal to this Battery, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Battery)) {
            return false;
        }
        Battery battery = (Battery) o;
        return Double.compare(battery.capacity, capacity) == 0 && Double.compare(battery.amountLeft, amountLeft) == 0;
    }


    /**
     * Returns the amount of charge remaining in the battery, in ampere-seconds.
     * 
     * @return The amount of charge remaining in the battery, in ampere-seconds.
     */
    public double getAmpsLeft() {
        return amountLeft;
    }

    /**
     * Returns the capacity of the battery, in ampere-seconds.
     * 
     * @return The capacity of the battery, in ampere-seconds.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Sets the amount of charge remaining in the battery, in ampere-seconds.
     * 
     * @param ampsLeft The amount of charge remaining in the battery, in ampere-seconds.
     */
    public void setAmpsLeft(double ampsLeft) {
        this.amountLeft = ampsLeft;
    }

}