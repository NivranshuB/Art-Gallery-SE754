package A4.G2.model.sale;

import A4.G2.model.users.User;

public class Auction extends  Sale {

    private User bidPerson;
    private int numBids;
    public Auction(int saleID, double startingPrice, double reservePrice, int timeRemain) {
        super(saleID, startingPrice);
    }
}
