package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BidsTests {

    Criteria bids = null;
    Item sneaker = null;

    @Before
    public void setupBids() {
        this.bids = new Bids();
        this.sneaker = new Sneaker("Test", "Test");
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Ask("10", 888));
    }

    @Test
    public void checkCriteriaTest() {
        assertEquals(200, bids.checkCriteria(sneaker).get(0).value());
    }


}
