import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Examples {

    Rover r1 = new Rover("discovery",
            new Wheels(4, 1, .25),
            new Battery(100, 10), 20);

    Rover r2 = new Rover("curiosity",
            new Wheels(4, 1, .25),
            new Battery(20, 20), 20);

    Competition comp = new Competition(List.of(r1, r2));

    

    Rover r3 = new Rover("My Fridge",
            new Wheels(1, 0.000000001, 1000000000),
            new Battery(2000, 2000), 2000);

//    @Test
//    public void testTravelFor(){
//        r1.travelFor(10000);
//        assertEquals(0.0, r1.battery.amountLeft, 0.01);
//    }

    @Test
    public void testTravelForAllfor5Seconds(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 0);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 15), 0);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        comp.travelFor(5);
        assertTrue(AFTERcomp.equals(comp));
    }

    @Test
    public void testNoneWhoReachDest(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 200);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 15), 200);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        List<String> empty = new ArrayList<String>();
        assertEquals(empty, AFTERcomp.allWhoReachDest());
    }

    @Test
    public void testAllWhoReachDest(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 15), 2);

        Drone drone = new Drone(
            1,
            new ArrayList<Propeller>(List.of(new Propeller(100, 100))),
            new Battery(1000, 1000),
            new ArrayList<Double>()
        );

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2, drone));
        List<String> full = new ArrayList<String>();
        full.add("discovery");
        full.add("curiosity");
        full.add("drone#1");
        assertEquals(full, AFTERcomp.allWhoReachDest());
    }

    @Test
    public void testClosestProgressUntilRecharge1(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 0), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 0), 2);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        assertEquals(0, AFTERcomp.closestProgressUntilRecharge(), 0.01);
    }

    @Test
    public void testClosestProgressUntilRecharge2(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 20), 20);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        assertEquals(1.0, AFTERcomp.closestProgressUntilRecharge(), 0.01);
    }

    @Test
    public void testWhoGoesFurthestNone(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 20), 20);

        Competition AFTERcomp = new Competition(List.of());
        assertEquals("No Competitors", AFTERcomp.whoGoesFurthest());
    }

    @Test
    public void testWhoGoesFurthestOne(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(1, 1), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(20, 20), 20);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        assertEquals("curiosity", AFTERcomp.whoGoesFurthest());
    }

    @Test
    public void testWhoGoesFurthestTie(){

        Rover AFTERr1 = new Rover("discovery",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 2);

        Rover AFTERr2 = new Rover("curiosity",
                new Wheels(4, 1, .25),
                new Battery(100, 5), 2);

        Competition AFTERcomp = new Competition(List.of(AFTERr1, AFTERr2));
        assertEquals("discovery", AFTERcomp.whoGoesFurthest());
    }

    Drone d1 = new Drone(1,
            List.of(new Propeller(100, 100)),
            new Battery(1000, 1000),
            List.of(100.0, 200.0, 300.0));

    Drone d2 = new Drone(2,
            List.of(new Propeller(100, 100)),
            new Battery(1000, 1000),
            List.of(100.0, 200.0, 300.0));

    @Test
    public void testDronesEquals() {
        assertFalse(d1.equals(d2));
    }

    @Test
    public void testCheckPointsEqual() {
        List<Double> cp1 = List.of(100.0, 200.0, 300.0);
        List<Double> cp2 = List.of(100.0, 200.0, 300.0);
        assertTrue(d1.checkPointsEqual(cp1));
        assertTrue(d1.checkPointsEqual(cp2));
    }

    @Test
    public void testEqualsFalse() {
        Drone d3 = new Drone(3,
                List.of(new Propeller(100, 100)),
                new Battery(1000, 1000),
                List.of(100.0, 200.0, 300.0));
        assertFalse(d1.equals(d3));
    }

    @Test
    public void testGetMetersPerAmp() {
        double expected = 2.0;
        double actual = d1.getMetersPerAmp();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetDistanceUntilRecharge() {
        double expected = 2000.0;
        double actual = d1.getDistanceUntilRecharge();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testTravelFor() {
        double time = 10000.0;
        d1.travelFor(time);
        double expected = 0.0;
        double actual = d1.battery.getAmpsLeft();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testProgressUntilRecharge() {
        double expected = 1.0;
        double actual = d1.progressUntilRecharge();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetMetersToDestination() {
        double expected = 600.0;
        double actual = d1.getMetersToDestination();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testCanReachDest() {
        boolean expected = true;
        boolean actual = d1.canReachDest();
        assertEquals(expected, actual);
    }

    @Test
    public void testName() {
        String expected = "drone#1";
        String actual = d1.name();
        assertEquals(expected, actual);
    }

    @Test
    public void testDistancePossible() {
        double expected = 2000.0;
        double actual = d1.distancePossible();
        assertEquals(expected, actual, 0.0);
    }

    Propeller p1 = new Propeller(100, 100);
    Propeller p2 = new Propeller(100, 100);

    @Test
    public void testPropellersEquals() {
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testGetMetersPerAmpProp() {
        double expected = 2.0;
        double actual = p1.getMetersPerAmp();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetTotalCurrentDrawProp() {
        double expected = 1.5 * 100;
        double actual = p1.getTotalCurrentDraw();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testGetSpeedProp() {
        double expected = 300.0;
        double actual = p1.getSpeed();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testEqualsFalseProp() {
        Propeller p3 = new Propeller(200, 100);
        assertFalse(p1.equals(p3));
    }

    @Test
    public void testToStringPope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        String expected = "PopeMobile: popeMobile";
        String actual = pm.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testEqualsPope() {
        PopeMobile pm1 = new PopeMobile("popeMobile");
        PopeMobile pm2 = new PopeMobile("popeMobile");
        assertTrue(pm1.equals(pm2));
    }

    @Test
    public void testEqualsFalsePope() {
        PopeMobile pm1 = new PopeMobile("popeMobile");
        PopeMobile pm2 = new PopeMobile("popeMobile2");
        assertFalse(pm1.equals(pm2));
    }

    @Test
    public void testTravelForPope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        pm.travelFor(10000);
        assertEquals(1.0, pm.progressUntilRecharge(), 0.01);
    }

    @Test
    public void testProgressUntilRechargePope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        assertEquals(1.0, pm.progressUntilRecharge(), 0.01);
    }

    @Test
    public void testDistancePossiblePope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        assertEquals(Double.MAX_VALUE, pm.distancePossible(), 0.01);
    }

    @Test
    public void testCanReachDestPope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        assertTrue(pm.canReachDest());
    }

    @Test
    public void testNamePope() {
        PopeMobile pm = new PopeMobile("popeMobile");
        assertEquals("popeMobile", pm.name());
    }

}
