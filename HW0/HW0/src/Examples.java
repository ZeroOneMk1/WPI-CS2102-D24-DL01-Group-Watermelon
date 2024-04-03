import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void testDoublingNumbers(){
        assertEquals(4, 2*2);
    }

    @Test
    public void testBoatTourExpenses1Adult1Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(478, bt.expenses(1, 1), 0.01);
    }
    @Test
    public void testBoatTourExpenses100Adults0Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(970, bt.expenses(100, 0), 0.01);
    }
    @Test
    public void testBoatTourRevenue1Adult1Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(105, bt.revenue(1, 1), 0.01);
    }
    @Test
    public void testBoatTourRevenue100Adults0Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(6500, bt.revenue(100, 0), 0.01);
    }
    @Test
    public void testBoatTourProfit1Adult1Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(-373, bt.profit(1, 1), 0.01);
    }
    @Test
    public void testBoatTourProfit100Adults0Kid(){
        BoatTour bt = new BoatTour();
        assertEquals(5530, bt.profit(100, 0), 0.01);
    }

    // House Calculator Tests

    @Test
    public void testHouseCalculatorZeroZero(){
        HouseCalculator hc = new HouseCalculator();
        assertEquals(2000, hc.totalCost(0, 0), 0.01);
    }

    @Test
    public void testHouseCalculatorThousandHundred(){
        HouseCalculator hc = new HouseCalculator();
        assertEquals(4350, hc.totalCost(1000, 100), 0.01);
    }

    @Test
    public void testHouseCalculator500_000__10_000(){
        HouseCalculator hc = new HouseCalculator();
        assertEquals(1237000, hc.totalCost(500000, 10000), 0.01);
    }
}
