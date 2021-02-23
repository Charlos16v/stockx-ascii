package edu.pingpong.stockx.item;

public class Ask implements Offer {


    private final String size;
    private final Integer ask;

    public Ask(String size, Integer ask) {
        this.size = size;
        this.ask = ask;
    }

    public String size() {
        return this.size;
    }

    public int value() {
        return this.ask;
    }

    @Override
    public int compareTo(Offer offer) {
        return this.ask.compareTo(offer.value());
    }

    @Override
    public String toString() {
        return "Size: " + size() + '\n' +
                "Ask: " + value() + '\n' + '\n';
    }
}
