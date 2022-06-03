package A4.G2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedInUser")
public class SignupPageController {

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String showSignupPage(ModelMap model){
        System.out.println("Sending signup page!");
        return "signup";
    }
}
