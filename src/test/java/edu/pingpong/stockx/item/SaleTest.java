package edu.pingpong.stockx.item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SaleTest {

    Offer sale = null;

    @Before
    public void setupSale() {
        this.sale = new Sale("13", 550);
    }

    @Test
    public void constructorTest() {
        assertNotNull(sale);
    }

    @Test
    public void sizeAndValueTest() {
        assertEquals("13", sale.size());
        assertEquals(550, sale.value());
    }
}
