package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SalesTest {

    Criteria sales = null;
    Item sneaker = null;

    @Before
    public void setupSales() {
        this.sales = new Sales();
        this.sneaker = new Sneaker("Test", "Test");
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Ask("10", 888));
        sneaker.add(new Sale("10", 69));
    }

    @Test
    public void checkCriteriaTest() {
        assertEquals(69, sales.checkCriteria(sneaker).get(0).value());
    }


}
