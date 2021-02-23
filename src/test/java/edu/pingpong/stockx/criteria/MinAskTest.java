package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MinAskTest {

    Criteria asks = null;
    Item sneaker = null;
    Criteria minAsk = null;

    @Before
    public void setupBids() {
        this.asks = new Asks();
        this.sneaker = new Sneaker("Test", "Test");
        this.sneaker.add(new Ask("6", 600));
        this.sneaker.add(new Ask("9.5", 333));
        this.sneaker.add(new Ask("9.5", 340));
        this.sneaker.add(new Ask("13", 330));

        this.minAsk = new MinAsk();
    }

    @Test
    public void checkCriteriaTest() {
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        assertEquals(330, minimum.get(0).value());
    }
}