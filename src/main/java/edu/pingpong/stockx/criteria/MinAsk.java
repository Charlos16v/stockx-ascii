package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Ask;
import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinAsk implements Criteria {

    public MinAsk() {
    }

    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        Comparator<Offer> comparator = Comparator.comparing(Offer::value);

        List<Offer> lista = sneaker.offers().stream()
                .filter(offer -> offer instanceof Ask)
                .min(comparator)
                .stream().collect(Collectors.toList());
        return lista;


    }
}
