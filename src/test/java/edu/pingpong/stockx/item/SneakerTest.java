package edu.pingpong.stockx.item;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SneakerTest {

    Item sneaker = null;

    @Before
    public void setupSneaker() {
        this.sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
    }

    @Test
    public void constructorTest() {
        assertNotNull(sneaker);
    }

    @Test
    public void offersTest() {
        System.out.println(sneaker.offers());
    }
}
