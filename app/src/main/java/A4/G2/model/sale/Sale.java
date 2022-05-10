package A4.G2.model.sale;

public abstract class Sale {
    private int saleID;
    private double price;
    public Sale(int saleID, double startingPrice) {
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
