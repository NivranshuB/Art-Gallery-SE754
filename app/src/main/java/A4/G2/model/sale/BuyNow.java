package A4.G2.model.sale;

import A4.G2.model.artwork.Art;

public class BuyNow extends Sale {

    public BuyNow(int saleID, double startingPrice, Art artPiece) {
        super(saleID, startingPrice, artPiece);
    }

    public double getGst() {
        return this.getPrice() * 0.15;
    }

    public String getSaleType(){
        return "Buy Now";
    }
}
