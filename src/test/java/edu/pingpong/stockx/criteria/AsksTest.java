package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AsksTest {

    Criteria asks = null;
    Item sneaker = null;

    @Before
    public void setupAsks() {
        this.asks = new Asks();
        this.sneaker = new Sneaker("Test", "Test");
        this.sneaker.add(new Ask("13", 330));
        this.sneaker.add(new Bid("13", 222));
    }

    // Testeo que lo que hay en la lista en la posicion 0, es un Ask con value 330, y no el Bid 222
    @Test
    public void checkCriteriaTest() {
        assertEquals(330, asks.checkCriteria(sneaker).get(0).value());
    }


}
