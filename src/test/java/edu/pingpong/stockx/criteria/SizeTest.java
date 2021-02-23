package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Sale;
import edu.pingpong.stockx.item.Sneaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SizeTest {


    Item sneaker = null;
    Criteria size = null;

    @Before
    public void setupSales() {

        this.sneaker = new Sneaker("Test", "Test");
        sneaker.add(new Sale("10", 888));
        sneaker.add(new Sale("10", 69));
        sneaker.add(new Sale("9.5", 200));

        this.size = new Size("9.5");
    }

    @Test
    public void checkCriteriaTest() {
        assertEquals("9.5", size.checkCriteria(sneaker).get(0).size());
    }
}
