package A4.G2.controller;

import A4.G2.service.Gallery;
import A4.G2.model.users.User;
import A4.G2.service.account.ILoginDetailsManager;
import A4.G2.service.account.LoginDetailsManager;
import A4.G2.service.dao.IUserDaoService;
import A4.G2.service.dao.UserDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("loggedInUser")
public class LoginPageController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

		Gallery gallery = new Gallery();
		User user1 = new User("user1", "Password123", "user1@gmail.com", "4737054",
				"7 Parkers Ave, Mexico", new Date(1990, 6, 3));
		gallery.addUser(user1);

		ILoginDetailsManager loginDetailsManager = new LoginDetailsManager(gallery);

		User loginUser = loginDetailsManager.loginUser(name, password);

		if (loginUser == null) {
			model.put("errorMessage", "Invalid Credentials: Username or Password incorrect");
			return "login";
		}

		model.put("loggedInUser", loginUser);

		return "home";
	}
}
