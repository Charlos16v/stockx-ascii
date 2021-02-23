package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MaxBidTest {

    Criteria bids = null;
    Item sneaker = null;
    Criteria maxBid = null;

    @Before
    public void setupBids() {
        this.bids = new Bids();
        this.sneaker = new Sneaker("Test", "Test");
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));

        this.maxBid = new MaxBid();
    }

    @Test
    public void checkCriteriaTest() {
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        assertEquals(480, maximum.get(0).value());

    }
}