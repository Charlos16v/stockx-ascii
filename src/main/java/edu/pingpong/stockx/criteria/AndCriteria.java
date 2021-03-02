
package edu.pingpong.stockx.criteria;

import edu.pingpong.stockx.item.Item;
import edu.pingpong.stockx.item.Offer;

import java.util.List;

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

        otherCriteria.retainAll(criteria);
        return otherCriteria;

        /*return criteria.stream()
                .distinct()
                .filter(otherCriteria::contains)
                .collect(Collectors.toList());*/

    }
}
