package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LastSaleTest {
    Criteria sales = null;
    Item sneaker = null;
    Criteria lastSale = null;

    @Before
    public void setupBids() {
        this.sales = new Sales();
        this.sneaker = new Sneaker("Test", "Test");
        sneaker.add(new Sale("6", 200));
        sneaker.add(new Sale("9.5", 479));
        sneaker.add(new Sale("13", 338));
        sneaker.add(new Sale("9.5", 480));

        this.lastSale = new LastSale();
    }

    @Test
    public void checkCriteriaTest() {
        List<Offer> maximum = lastSale.checkCriteria(sneaker);
        assertEquals(480, maximum.get(0).value());

    }
}
