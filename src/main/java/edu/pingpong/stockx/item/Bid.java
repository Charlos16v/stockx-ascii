package edu.pingpong.stockx.item;

public class Bid implements Offer {


    private final String size;
    private final Integer bid;

    public Bid(String size, Integer bid) {
        this.size = size;
        this.bid = bid;
    }

    public String size() {
        return this.size;
    }

    public int value() {
        return this.bid;
    }

    @Override
    public int compareTo(Offer offer) {
        return this.bid.compareTo(offer.value());
    }

    @Override
    public String toString() {
        return "Size: " + size() + '\n' +
                "Bid: " + value() + '\n' + '\n';
    }

}
