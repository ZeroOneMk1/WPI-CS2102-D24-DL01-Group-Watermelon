import java.util.ArrayList;
import java.util.List;
/**
 * A class that represents a competition between multiple vehicles.
 * 
 * @author Azura Simsek
 */
public class Competition {
    /**
     * A list of vehicles participating in the competition.
     */
    private List<Vehicle> vehicles;

    /**
     * Creates a new competition with the given list of vehicles.
     * 
     * @param vehicles the list of vehicles participating in the competition
     */
    public Competition(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Checks if two competitions are equal.
     * 
     * Two competitions are equal if they have the same list of vehicles.
     * 
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Competition)) {
            return false;
        }
        Competition other = (Competition) o;
        return vehicles.equals(other.vehicles);
    }

    /**
     * Returns the name of the vehicle that travelled the furthest.
     * 
     * If multiple vehicles travelled the same distance, returns the name of the first one.
     * If no vehicles travelled, returns "No Competitors".
     * 
     * @return the name of the vehicle that travelled the furthest
     */
    public String whoGoesFurthest() {
        String out = "No Competitors";

        if (vehicles.size() > 0) {
            double furthestDistance = 0.0;
            List<String> furthestVehicles = new ArrayList<>();

            for (Vehicle vehicle : vehicles) {
                double currentDistance = vehicle.distancePossible();
                if (currentDistance > furthestDistance) {
                    furthestDistance = currentDistance;
                    furthestVehicles.clear();
                    furthestVehicles.add(vehicle.name());
                } else if (currentDistance == furthestDistance) {
                    furthestVehicles.add(vehicle.name());
                }
            }

            out = furthestVehicles.get(0);
        }

        return out;
    }

    /**
     * Travels all vehicles for the given time.
     * 
     * @param time the time to travel
     */
    public void travelFor(double time) {
        for (Vehicle vehicle : vehicles) {
            vehicle.travelFor(time);
        }
    }

    /**
     * Returns the closest progress until recharge of all vehicles.
     * 
     * @return the closest progress until recharge
     */
    public double closestProgressUntilRecharge() {
        int numElements = vehicles.size();
        double[] progresses = new double[numElements];
        for (int i = 0; i < numElements; i++) {
            progresses[i] = vehicles.get(i).progressUntilRecharge();
        }
        double max = progresses[0];
        for (int i = 1; i < numElements; i++) {
            if (progresses[i] > max) {
                max = progresses[i];
            }
        }
        return max;
    }

    /**
     * Returns a list of the names of all vehicles that reached their destination.
     * 
     * @return a list of the names of all vehicles that reached their destination
     */
    public List<String> allWhoReachDest() {
        List<String> out = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.canReachDest()) {
                out.add(v.name());
            }
        }
        return out;
    }
}