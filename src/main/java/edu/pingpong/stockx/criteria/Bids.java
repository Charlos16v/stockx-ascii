package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class Bids implements Criteria {

    public Bids() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        return sneaker.offers().stream().filter(offer -> offer instanceof Bid)
                .collect(Collectors.toList());
    }
}
