import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {

    Rover r1 = new Rover("discovery",
            new Wheels(4, 1, .25),
            new Battery(100, 10), 20);

    Rover r2 = new Rover("curiosity",
            new Wheels(4, 1, .25),
            new Battery(20, 20), 20);
    Rover r3 = new Rover("My Fridge",
            new Wheels(1, 0.000000001, 1000000000),
            new Battery(2000, 2000), 2000);


    @Test
    public void timeUntilRecharge(){
        assertEquals(0.5, r1.progressUntilRecharge(), 0.01);
    }

    @Test
    public void canReachTest1(){
        assertFalse(r1.canReachDest());
    }

    @Test
    public void testCanReachDestinationTrue(){
        assertTrue(r2.canReachDest());
    }

    @Test
    public void testWhoGoesFurther(){
        assertEquals("discovery", r1.whoGoesFurther(r2));
    }

    @Test
    public void testWhoGoesFurtherTwo(){
        assertEquals("curiosity", r3.whoGoesFurther(r2));
    }

    @Test
    public void testWhoGoesFurtherTres(){
        assertEquals("My Fridge&My Fridge", r3.whoGoesFurther(r3));
    }

    @Test
    public void testTravelFor(){
        r1.travelFor(10000);
        assertEquals(0.0, r1.battery.amountLeft, 0.01);
    }
}
