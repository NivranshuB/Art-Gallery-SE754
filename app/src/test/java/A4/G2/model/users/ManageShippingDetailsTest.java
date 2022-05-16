package A4.G2.model.users;

import A4.G2.service.account.ShippingDetailsManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

/**
 * USER STORY: Manage shipping details
 *
 * As a user, I would like to be able to add my shipping address to my account so that I can avoid filling it out every
 * time I make a purchase.
 *
 * ACs
 * - A logged in user should be able to click on their profile to reach an ‘edit profile’ section which contains their
 *   default shipping address and delivery preferences
 * - The user should be able to make changes to their address and preferences
 * - When the user has finished making their changes to the shipping details they should be able to save these new
 *   details on their profile
 */
public class ManageShippingDetailsTest {

    @Test
    public void testRetrievalOfShippingAddress() {
        User user;
        ShippingDetailsManager shippingDetailsManager;
        ShippingDetails shippingDetails;

        shippingDetailsManager = new ShippingDetailsManager();

        user = Mockito.mock(User.class);
        shippingDetails = Mockito.mock(ShippingDetails.class);

        Mockito.when(shippingDetails.getAddress()).thenReturn("4 Jersey Shore, New Orleans");
        Mockito.when(shippingDetails.getPreferences()).thenReturn("Delivery after 5pm");

        Mockito.when(user.getShippingDetails()).thenReturn(shippingDetails);

        assertEquals("4 Jersey Shore, New Orleans", shippingDetailsManager.getShippingAddress(user));

        Mockito.verify(user, times(1)).getShippingDetails();
        Mockito.verify(shippingDetails, times(1)).getAddress();
    }

    @Test
    public void testRetrievalOfShippingPreferences() {
        User user;
        ShippingDetailsManager shippingDetailsManager;
        ShippingDetails shippingDetails;

        shippingDetailsManager = new ShippingDetailsManager();

        user = Mockito.mock(User.class);
        shippingDetails = Mockito.mock(ShippingDetails.class);

        Mockito.when(shippingDetails.getAddress()).thenReturn("4 Jersey Shore, New Orleans");
        Mockito.when(shippingDetails.getPreferences()).thenReturn("Delivery after 5pm");

        Mockito.when(user.getShippingDetails()).thenReturn(shippingDetails);

        assertEquals("Delivery after 5pm", shippingDetailsManager.getShippingPreferences(user));

        Mockito.verify(user, times(1)).getShippingDetails();
        Mockito.verify(shippingDetails, times(1)).getPreferences();
    }
}
