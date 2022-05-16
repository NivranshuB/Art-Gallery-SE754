package A4.G2.model.users;

public class ShippingDetails {

    private String address;
    private String preferences;

    public ShippingDetails(String shippingAddress, String shippingPreferences) {
        this.address = shippingAddress;
        this.preferences = shippingPreferences;
    }

    public String getAddress() {
        return address;
    }

    public String getPreferences() {
        return preferences;
    }
}
