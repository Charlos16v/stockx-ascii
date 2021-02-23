package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Bid;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxBid implements Criteria {

    public MaxBid() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Comparator<Offer> comparator = Comparator.comparing(Offer::value);

        return sneaker.offers().stream()
                .filter(offer -> offer instanceof Bid)
                .max(comparator)
                .stream().collect(Collectors.toList());

    }
}
