/**
 * This class represents a mobile vehicle that can travel forever and never runs out of fuel.
 * It is a legendary vehicle that is only driven by the pope.
 * 
 * @author Azura Simsek
 */
public class PopeMobile implements Vehicle {

    /**
     * The name of the vehicle.
     */
    private String name;

    /**
     * Creates a new PopeMobile with the given name.
     *
     * @param name The name of the vehicle.
     */
    public PopeMobile(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    public String toString() {
        String out = "PopeMobile: " + name;
        return out;
    }

    /**
     * Checks if two PopeMobile objects are equal.
     *
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PopeMobile)) {
            return false;
        }
        PopeMobile that = (PopeMobile) o;
        return name.equals(that.name);
    }

    /**
     * Travels for a given amount of time. This method does nothing, as the PopeMobile is a legendary vehicle that never runs out of fuel.
     *
     * @param time The amount of time to travel. This parameter is ignored, as the PopeMobile is a legendary vehicle that never runs out of fuel.
     */
    @Override
    public void travelFor(double time) {

    }

    /**
     * Returns 1.0, as the PopeMobile is a legendary vehicle that never runs out of fuel.
     *
     * @return 1.0, as the PopeMobile is a legendary vehicle that never runs out of fuel.
     */
    @Override
    public double progressUntilRecharge() {
        return 1.0;
    }

    /**
     * Returns Double.MAX_VALUE, as the PopeMobile is a legendary vehicle that can travel an infinite distance.
     *
     * @return Double.MAX_VALUE, as the PopeMobile is a legendary vehicle that can travel an infinite distance.
     */
    @Override
    public double distancePossible() {
        return Double.MAX_VALUE;
    }

    /**
     * Returns true, as the PopeMobile is a legendary vehicle that can reach any destination.
     *
     * @return true, as the PopeMobile is a legendary vehicle that can reach any destination.
     */
    @Override
    public boolean canReachDest() {
        return true;
    }

    /**
     * Returns the name of the vehicle.
     *
     * @return The name of the vehicle.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * The Pope Waves.
     * 
     * @param name The name of the vehicle.
     */
    public void wave(String name) {
        System.out.println(name + " is waving");
    }

}