package A4.G2.controller;

import A4.G2.model.users.User;
import A4.G2.service.Gallery;
import A4.G2.service.account.LoginDetailsManager;
import A4.G2.service.account.UsernameTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.Date;

@Controller
@SessionAttributes("loggedInUser")
public class ManageAccountController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value="/manage-account", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model){
        return "manage-account";
    }

    @RequestMapping(value="/manage-account/username", method = RequestMethod.POST)
    public String changeAccountUsername(ModelMap model, @RequestParam String newUsername) throws IOException {
        gallery.initiate();
        LoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        if (!newUsername.matches(".*\\w.*")) {
            model.put("usernameErrorMessage", "Invalid username: Username must contain at least one char");
            return "manage-account";
        } else if (loginDetailsManager.checkUsernameTaken(newUsername)) {
            model.put("usernameErrorMessage", "Invalid username: Username is already taken");
            return "manage-account";
        }

        return "manage-account";
    }

    /**
     * Test endpoint to fake a user log in. Used for UI testing of the ManageAccount feature
     */
    @RequestMapping(value="/manage-account/testing", method = RequestMethod.GET)
    public String testManageAccountPage(ModelMap model) throws IOException {
        gallery.initiate();
        LoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        User user1 = loginDetailsManager.loginUser("user1", "Password123");
                model.put("loggedInUser", user1);
        return "manage-account";
    }
}
