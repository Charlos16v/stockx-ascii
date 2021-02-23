package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;

import java.util.List;
import java.util.stream.Collectors;

public class Sales implements Criteria {
    public Sales() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        return sneaker.offers().stream().filter(offer -> offer instanceof Sale)
                .collect(Collectors.toList());
    }
}
