package A4.G2.controller;

import A4.G2.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("loggedInUser")
public class ManageAccountController {

    @RequestMapping(value="/manage-account", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model){
        return "manage-account";
    }

    /**
     * Test endpoint to fake a user log in. Used for UI testing of the ManageAccount feature
     */
    @RequestMapping(value="/manage-account/testing", method = RequestMethod.GET)
    public String testManageAccountPage(ModelMap model) {
        User user1 = new User("user1", "Password123", "user1@gmail.com", "4737054",
                "7 Parkers Ave, Mexico", new Date(1990, 6, 3));
        model.put("loggedInUser", user1);
        return "manage-account";
    }
}
