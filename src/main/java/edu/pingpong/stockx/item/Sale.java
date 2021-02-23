package edu.pingpong.stockx.item;

public class Sale implements Offer {


    private String size = "";
    private Integer price = 0;

    public Sale(String size, Integer price) {
        this.size = size;
        this.price = price;
    }

    public String size() {
        return this.size;
    }

    public int value() {
        return this.price;
    }

    @Override
    public int compareTo(Offer offer) {
        return this.price.compareTo(offer.value());
    }

    @Override
    public String toString() {
        return "Size: " + size() + '\n' +
                "Price: " + value() + '\n' + '\n';
    }

}
