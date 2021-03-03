package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AndCriteriaTest {


    Item sneaker = null;
    Criteria size = null;
    Criteria sales = null;
    Criteria andCriteria = null;

    @Before
    public void setupAndCriteria() {
        this.sneaker = new Sneaker("Test", "Test");
        this.size = new Size("9.5");
        this.sales = new Sales();
        this.andCriteria = new AndCriteria(size, sales);

        sneaker.add(new Sale("6", 200));
        sneaker.add(new Sale("9.5", 888));
        sneaker.add(new Sale("9.5", 777));
        sneaker.add(new Sale("10", 69));
    }

    @Test
    public void checkCriteriaTest() {
        assertEquals(888, andCriteria.checkCriteria(sneaker).get(0).value());
        assertEquals("9.5", andCriteria.checkCriteria(sneaker).get(0).size());

        assertEquals(777, andCriteria.checkCriteria(sneaker).get(1).value());
        assertEquals("9.5", andCriteria.checkCriteria(sneaker).get(1).size());
    }

    @Test
    public void andSizeBidCriteriaTest() {

        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("9.5", 550));
        sneaker.add(new Bid("4.5", 480));
        sneaker.add(new Bid("9.5", 900));
        sneaker.add(new Bid("6", 472));
        sneaker.add(new Ask("15", 288));
        sneaker.add(new Ask("13", 333));
        sneaker.add(new Ask("9.5", 1000));
        sneaker.add(new Ask("13", 341));
        assertEquals(8, sneaker.offers().size());

        Criteria size = new Size("9.5");
        Criteria bids = new Bids();

        assertEquals(4, bids.checkCriteria(sneaker).size());
        assertEquals(3, size.checkCriteria(sneaker).size());

        Criteria andSizeBids = new AndCriteria(size, bids);
        assertEquals(2, andSizeBids.checkCriteria(sneaker).size());

        assertTrue(andSizeBids.checkCriteria(sneaker).stream().allMatch(o -> o.size().equals("9.5")));
        assertTrue(andSizeBids.checkCriteria(sneaker).stream().allMatch(o -> o instanceof Bid));


        // Changing filter position
        Criteria andBidsSize = new AndCriteria(bids, size);
        assertEquals(2, andBidsSize.checkCriteria(sneaker).size());
    }
}
