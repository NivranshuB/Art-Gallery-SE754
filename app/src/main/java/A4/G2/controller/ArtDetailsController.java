package A4.G2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtDetailsController {
	@RequestMapping(value="/art-details", method = RequestMethod.GET)
	public String showArtDetailsPage(ModelMap model) {return "art-details";}
}
