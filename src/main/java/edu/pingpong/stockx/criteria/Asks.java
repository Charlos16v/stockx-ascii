package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class Asks implements Criteria {

    public Asks() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        return sneaker.offers().stream().filter(offer -> offer instanceof Ask)
                .collect(Collectors.toList());
    }
}
