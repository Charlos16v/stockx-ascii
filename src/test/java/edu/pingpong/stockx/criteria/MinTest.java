package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTest {

    Item sneaker = null;
    Criteria size = null;
    Criteria asks = null;
    Criteria min = null;

    @Before
    public void setupMin() {
        this.sneaker = new Sneaker("Test", "Test");
        this.size = new Size("9.5");
        this.asks = new Asks();
        this.min = new Min(size, asks);

        sneaker.add(new Ask("9.5", 400));
        sneaker.add(new Ask("9.5", 600));
        sneaker.add(new Ask("6", 200));
        sneaker.add(new Ask("6", 200));
        sneaker.add(new Sale("9.5", 777));
        sneaker.add(new Sale("10", 69));
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 888));
        sneaker.add(new Bid("10", 69));
        sneaker.add(new Bid("9.5", 888));
        sneaker.add(new Bid("9.5", 888));
    }

    @Test
    public void checkCriteriaTest() {
        assertEquals(400, min.checkCriteria(sneaker).get(0).value());
        assertEquals("9.5", min.checkCriteria(sneaker).get(0).size());
    }

}
