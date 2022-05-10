package A4.G2.model.sale;

import A4.G2.model.artwork.Art;
import A4.G2.model.users.User;

public class Auction extends  Sale {

    private User bidPerson;
    private int numBids;
    private double reservePrice;
    private int timeRemaining;
    private double currentBid;

    public Auction(int saleID, double startingPrice, Art artPiece, double reservePrice, int timeRemain) {
        super(saleID, startingPrice, artPiece);
        this.reservePrice = reservePrice;
        this.timeRemaining = timeRemain;
    }

    public double getReservePrice() {
        return this.reservePrice;
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public double getCurrentBid() {
        return this.currentBid;
    }
}
