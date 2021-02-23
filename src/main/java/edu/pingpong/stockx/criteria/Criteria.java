package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;

public interface Criteria {

    List<Offer> checkCriteria(Item item);
}
