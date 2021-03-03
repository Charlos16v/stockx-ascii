package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxTest {


    Item sneaker = null;
    Criteria size = null;
    Criteria bids = null;
    Criteria max = null;

    @Before
    public void setupMax() {
        this.sneaker = new Sneaker("Test", "Test");
        this.size = new Size("9.5");
        this.bids = new Bids();
        this.max = new Max(size, bids);

        sneaker.add(new Sale("6", 200));
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
        List<Offer> lista = this.max.checkCriteria(sneaker);
        System.out.println(lista);
        //assertEquals(888, max.checkCriteria(sneaker).get(0).value());
        //assertEquals("9.5", max.checkCriteria(sneaker).get(0).size());
    }
    @Test
    public void checkCriteria_max_size_bid_Test() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("13", 550));
        sneaker.add(new Bid("4.5", 480));
        sneaker.add(new Bid("13", 900));
        sneaker.add(new Bid("6", 472));
        sneaker.add(new Ask("15", 288));
        sneaker.add(new Ask("13", 333));
        sneaker.add(new Ask("14", 1000));
        sneaker.add(new Ask("13", 341));

        Criteria size = new Size("13");
        Criteria bids = new Bids();
        Criteria max = new Max(size, bids);

        List<Offer> filteredSize = max.checkCriteria(sneaker);
        assertTrue(filteredSize.stream().allMatch(o -> o.size().equals("13")));
        assertTrue(filteredSize.stream().allMatch(o -> o instanceof Bid));
        assertEquals(900, filteredSize.get(0).value());
    }

    @Test
    public void checkCriteria_no_max_test() {

        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria size = new Size("13");
        Criteria bids = new Bids();
        Criteria max = new Max(size, bids);

        List<Offer> filteredSize = max.checkCriteria(sneaker);
        assertTrue(filteredSize.isEmpty());
    }
}
