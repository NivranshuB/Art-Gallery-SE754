package A4.G2.model.sale;

import A4.G2.model.artwork.Art;
import A4.G2.model.users.User;
import A4.G2.service.payment.NoPaymentDetailsException;
import A4.G2.service.payment.UnregisteredUserPurchaseException;

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

    public void buyArtPiece(User user) throws NoPaymentDetailsException, UnregisteredUserPurchaseException {
        if (user == null) {
            throw new UnregisteredUserPurchaseException("User is not registered.");
        }
        if (user.getPaymentDetails() == null) {
            throw new NoPaymentDetailsException("User has no payment details.");
        }
    }
}
