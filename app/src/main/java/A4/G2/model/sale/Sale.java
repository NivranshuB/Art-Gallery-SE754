package A4.G2.model.sale;

import A4.G2.model.artwork.Art;

public abstract class Sale {
    private int saleID;
    private double price;
    private double deliveryCost;
    private String deliveryTime;
    Art artPiece;

    public Sale(int saleID, double startingPrice, Art artPiece) {
        this.saleID = saleID;
        this.price = startingPrice;
        this.artPiece = artPiece;
    }

    public int getSaleId() {
        return this.saleID;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDeliveryCost() {
        return this.deliveryCost;
    }

    public String getDeliveryTime() {
        return this.deliveryTime;
    }
}
