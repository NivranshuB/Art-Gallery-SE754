package A4.G2.model.sale;

import A4.G2.model.artwork.Art;

public class BuyNow extends Sale {

    public BuyNow(int saleID, double startingPrice, Art artPiece) {
        super(saleID, startingPrice, artPiece);
    }

    @Override
    public String getSaleType() {
        return "Buy Now";
    }

    public double getGst() {
        return this.getPrice() * 0.15;
    }
}
