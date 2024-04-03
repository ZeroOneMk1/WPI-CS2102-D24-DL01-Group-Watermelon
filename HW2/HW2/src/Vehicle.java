public interface Vehicle {
    public void travelFor(double time);
    public double progressUntilRecharge();
    public double distancePossible();
    public boolean canReachDest();
    public String name();
    public boolean equals(Object o);
}
