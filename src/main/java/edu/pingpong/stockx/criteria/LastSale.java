package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class LastSale implements Criteria {

    public LastSale() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Criteria sales = new Sales();
        List<Offer> salesList = sales.checkCriteria(sneaker);

        return salesList.stream()
                .reduce((first, second) -> second)
                .stream().collect(Collectors.toList());

    }
}
