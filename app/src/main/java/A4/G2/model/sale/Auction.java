package A4.G2.model.sale;

import A4.G2.model.artwork.Art;
import A4.G2.model.users.User;
import A4.G2.service.payment.NoPaymentDetailsException;

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

    public int getTotalBids() {
        return this.numBids;
    }

    public User getCurrentBidder() {
        return this.bidPerson;
    }

    public void placeBid(User user, int price) throws NoPaymentDetailsException {
        if (user.getPaymentDetails() == null) {
            throw new NoPaymentDetailsException("User has no payment details.");
        }
    @Override
    public String getSaleType() {
        return "Auction";
    }
}
