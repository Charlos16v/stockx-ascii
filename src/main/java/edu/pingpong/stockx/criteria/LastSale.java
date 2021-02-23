package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;

import java.util.List;
import java.util.stream.Collectors;

public class LastSale implements Criteria {

    public LastSale() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        List<Offer> sales = sneaker.offers().stream().filter(offer -> offer instanceof Sale)
                .collect(Collectors.toList());

        return sales.stream()
                .reduce((first, second) -> second)
                .stream().collect(Collectors.toList());

    }
}
