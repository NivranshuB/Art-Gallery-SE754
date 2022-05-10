package A4.G2.model.sale;

public abstract class Sale {
    private int saleID;

    public Sale(int saleID, double startingPrice) {
        this.saleID = saleID;
    }

    public int getSaleId() {
        return this.saleID;
    }
}
