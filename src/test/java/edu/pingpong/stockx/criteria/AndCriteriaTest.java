package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
