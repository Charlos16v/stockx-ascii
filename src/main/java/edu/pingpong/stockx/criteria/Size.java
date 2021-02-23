package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;
import edu.pingpong.stockx.item.Sale;

import java.util.List;
import java.util.stream.Collectors;

public class Size implements Criteria {

    private String size = "";

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {
        List<Offer> sales = sneaker.offers().stream().filter(offer -> offer instanceof Sale)
                .collect(Collectors.toList());

        return sales.stream().filter(s -> s.size().equals(this.size))
                .collect(Collectors.toList());
    }
}
