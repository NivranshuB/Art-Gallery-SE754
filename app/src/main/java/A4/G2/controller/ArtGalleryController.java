package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.service.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
@SessionAttributes("name")
public class ArtGalleryController {

    @Autowired
    Gallery gallery;
    ModelAndView map = new ModelAndView("/art-gallery");

    @RequestMapping(value = "/art-gallery", method = RequestMethod.GET)
    public ModelAndView showAddArtPage(ModelMap model) throws IOException {
        //add an artwork to gallery
        gallery.initiate();

        List<Art> artList = gallery.getArtList();
        map.addObject("list", artList);
        return map;
    }

}