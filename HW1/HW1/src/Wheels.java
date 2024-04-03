/**
 * A class that represents the number of wheels, their speed, and the current draw per wheel.
 * 
 * @author Azura Simsek
 */
public class Wheels {
    /**
     * The number of wheels.
     */
    public int amount;
    /**
     * The speed of the wheels.
     */
    public double speed;
    /**
     * The current draw per wheel.
     */
    public double currentDrawPerWheel;

    /**
     * Constructs a new Wheels object with the specified number of wheels, speed, and current draw per wheel.
     * 
     * @param amount The number of wheels.
     * @param speed The speed of the wheels in meters-per-second.
     * @param currentDrawPerWheel The current draw per wheel in amperes-per-second.
     */
    public Wheels(int amount, double speed, double currentDrawPerWheel) {
        this.amount = amount;
        this.speed = speed;
        this.currentDrawPerWheel = currentDrawPerWheel;
    }

    /**
     * Calculates and returns the meters per ampere of the wheels.
     * 
     * @return The meters per ampere of the wheels.
     */
    public double getMetersPerAmp() {
        return this.speed / (this.currentDrawPerWheel * this.amount);
    }
}