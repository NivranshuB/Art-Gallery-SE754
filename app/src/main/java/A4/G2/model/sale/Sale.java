package A4.G2.model.sale;

import A4.G2.model.artwork.Art;

public abstract class Sale {
    private int saleID;
    private double price;
    public Sale(int saleID, double startingPrice, Art artPiece) {
        this.saleID = saleID;
        this.price = startingPrice;
    }

    public int getSaleId() {
        return this.saleID;
    }

    public double getPrice() {
        return this.price;
    }
}
