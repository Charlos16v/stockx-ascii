package edu.pingpong.stockx.item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AskTest {

    Offer ask = null;

    @Before
    public void setupAsk() {
        this.ask = new Ask("13", 288);
    }

    @Test
    public void constructorTest() {
        assertNotNull(ask);
    }

    @Test
    public void sizeAndValueTest() {
        assertEquals("13", ask.size());
        assertEquals(288, ask.value());
    }
}