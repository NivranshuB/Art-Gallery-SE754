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

    @Override
    public boolean changePassword(User user, String oldPassword, String newPassword, String newPasswordRetyped) throws WeakPasswordException {
        if (!newPassword.matches(".*\\d.*")) {
            throw new WeakPasswordException("Weak password: no digits in password");
        } else if (!newPassword.chars().anyMatch(Character::isUpperCase)) {
            throw new WeakPasswordException("Weak password: no capital letters in password");
        }
        user.setPassword(newPassword);
        return true;
    }
}
