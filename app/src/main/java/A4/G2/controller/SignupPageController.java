package A4.G2.controller;

import A4.G2.model.Gallery;
import A4.G2.model.users.User;
import A4.G2.service.account.ILoginDetailsManager;
import A4.G2.service.account.LoginDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes({"loggedInUser", "termsAndConditions"})
public class SignupPageController {

    Gallery gallery;

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model){
        if (gallery == null) {
            gallery = new Gallery();
            User user1 = new User("user1", "Password123", "user1@gmail.com", "4737054",
                    "7 Parkers Ave, Mexico", new Date(1990, 6, 3));
            gallery.addUser(user1);
            gallery.setTermsAndConditions("I agree to abide by the rules of copyright and not sell duplicate prints" +
                    " of arts listed on this application");
        }
        model.put("termsAndConditions", gallery.getTermsAndConditions());
        return "signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password,
                                  @RequestParam String retypedPassword,
                                  @RequestParam(defaultValue = "false") boolean checkbox){

        ILoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

        if (!name.matches(".*\\w.*")) {
            model.put("errorMessage", "Invalid Credentials: Username must contain at least one character");
            return "signup";
        } else if (loginDetailsManager.checkUsernameTaken(name)) {
            model.put("errorMessage", "Invalid Credentials: Username taken");
            return "signup";
        }

        int passwordSecure = loginDetailsManager.checkPasswordSecure(password, retypedPassword);

        if (passwordSecure == -1) {
            model.put("errorMessage", "Invalid Credentials: Password is less that 6 chars");
            return "signup";
        } else if (passwordSecure == -2) {
            model.put("errorMessage", "Invalid Credentials: Password must contain at least one capital letter");
            return "signup";
        } else if (passwordSecure == -3) {
            model.put("errorMessage", "Invalid Credentials: Password must contain at least one digit");
            return "signup";
        }

        if (passwordSecure == 0) {
            model.put("errorMessage", "Invalid Credentials: Retyped password does not match");
            return "signup";
        }

        if (!checkbox) {
            model.put("errorMessage", "Invalid Credentials: You must accept terms and conditions to create an account");
            return "signup";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }
}
