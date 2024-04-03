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