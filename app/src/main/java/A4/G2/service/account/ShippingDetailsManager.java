package A4.G2.service.account;

import A4.G2.model.users.User;

public class ShippingDetailsManager implements IShippingDetailsManager {

    @Override
    public String getShippingAddress(User user) {
        return user.getShippingDetails().getAddress();
    }
}
