
package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class AndCriteria implements Criteria {

    private Criteria criteria = null;
    private Criteria otherCriteria = null;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<Offer> checkCriteria(Item sneaker) {

        List<Offer> criteria = this.criteria.checkCriteria(sneaker);
        List<Offer> otherCriteria = this.otherCriteria.checkCriteria(sneaker);

        /*criteria.retainAll(otherCriteria);
        return criteria;*/
        return criteria.stream()
                .distinct()
                .filter(otherCriteria::contains)
                .collect(Collectors.toList());

    }
}
