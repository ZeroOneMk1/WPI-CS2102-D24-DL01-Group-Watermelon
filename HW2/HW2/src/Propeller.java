/**
 * A propeller used on Drones for locomotion.
 * 
 * @author Azura Simsek
 */
public class Propeller implements MovementImplement {
    public int size;
    public double boost;

    /**
     * Creates a new Propeller with the specified size and boost.
     * 
     * @param size the diameter of the propeller in meters
     * @param boost the boost of the propeller, measured in meters per second
     */
    public Propeller(int size, double boost) {
        this.size = size;
        this.boost = boost;
    }

    /**
     * Checks if the specified object is equal to this Propeller.
     * 
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Propeller)) {
            return false;
        }
        Propeller other = (Propeller) o;
        return this.size == other.size && this.boost == other.boost;
    }

    /**
     * Calculates the efficiency of the propeller, measured in meters per ampere.
     * 
     * @return the efficiency of the propeller
     */
    @Override
    public double getMetersPerAmp() {
        return this.getSpeed() / this.getTotalCurrentDraw();
    }

    /**
     * Calculates the total current draw of the propeller, which is the sum of the current draw of each of its blades.
     * 
     * @return the total current draw of the propeller
     */
    @Override
    public double getTotalCurrentDraw() {
        return 1.5 * this.size;
    }

    /**
     * Calculates the speed of the propeller, which is the sum of its diameter (in meters) and its boost.
     * 
     * @return the speed of the propeller
     */
    @Override
    public double getSpeed() {
        return (2 * this.size) + this.boost;
    }

}