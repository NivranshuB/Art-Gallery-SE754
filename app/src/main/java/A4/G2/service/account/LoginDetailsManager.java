package A4.G2.service.account;

import A4.G2.model.users.User;
import A4.G2.service.account.ILoginDetailsManager;
import A4.G2.service.dao.UserDaoService;

public class LoginDetailsManager implements ILoginDetailsManager {

    UserDaoService userDaoService;

    public LoginDetailsManager(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @Override
    public boolean changeUsername(User user, String newUsername) throws UsernameTakenException {
        if (userDaoService.checkIfUsernameTaken(newUsername)) {
            throw new UsernameTakenException("'" + newUsername + "' already taken as a username");
        }
        user.setUsername(newUsername);
        return true;
    }
}
