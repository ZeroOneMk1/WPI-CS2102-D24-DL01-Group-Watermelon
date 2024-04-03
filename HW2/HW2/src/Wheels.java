/**
 * A class that represents the number of wheels, their speed, and the current draw per wheel.
 * 
 * @author Azura Simsek
 */
public class Wheels implements MovementImplement {
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
     * Checks if two Wheels objects are equal.
     * 
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheels)) {
            return false;
        }
        Wheels other = (Wheels) o;
        return amount == other.amount && speed == other.speed && currentDrawPerWheel == other.currentDrawPerWheel;
    }

    /**
     * Calculates and returns the meters per ampere of the wheels.
     * 
     * @return The meters per ampere of the wheels.
     */
    public double getMetersPerAmp() {
        return this.speed / (this.currentDrawPerWheel * this.amount);
    }

    public double getTotalCurrentDraw() {
        return this.currentDrawPerWheel * this.amount;
    }

    public double getSpeed() {
        return this.speed;
    }
}