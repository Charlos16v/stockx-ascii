package edu.pingpong.stockx.item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BidTest {

    Offer bid = null;

    @Before
    public void setupBid() {
        this.bid = new Bid("13", 550);
    }

    @Test
    public void constructorTest() {
        assertNotNull(bid);
    }

    @Test
    public void sizeAndValueTest() {
        assertEquals("13", bid.size());
        assertEquals(550, bid.value());
    }
}
