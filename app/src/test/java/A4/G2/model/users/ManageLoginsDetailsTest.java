package A4.G2.model.users;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

/**
 * USER STORY: Manage login details
 *
 * As a user, I would like to be able to change my login details such as my username and password, so that my account is
 * more secure and memorable.
 *
 * ACs
 * - A logged in user should be able to click on their profile to reach an ‘edit profile’ section
 * - In the ‘edit profile’ section the user should be able to directly edit their username
 * - In the ‘edit profile’ section the user should be able to also change their password by entering their new password
 *   and confirming it by entering it again (as is the convention)
 * - If the user’s new password entries don’t match then notify the user to try again
 * - If the user’s new password is not secure enough, then notify the user to try again
 * - If the user’s new password is sufficiently secure and the two entries match, change this particular account’s
 *   password
 */
public class ManageLoginsDetailsTest {

    @Test
    public void testUserChangesUsernameToUniqueUsername() {
        UserDaoService userDaoService = Mockito.mock(UserDaoService);
        Mockito.when(userDaoService.checkIfUsernameTaken()).thenReturn(false);

        LoginDetailsManager loginDetailsManager = new LoginDetailsManager(userDaoService);

        User user = Mockito.spy(new User("jeff", "qwerty30", "jeff.com", "123456",
                "jeff house"));

        loginDetailsManager.changeUsername(user, "Geoff");

        Mockito.verify(user, times(1)).setUsername("Geoff");
    }
}
