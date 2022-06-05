package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.service.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VirtualGalleryController {
    @Autowired
    Gallery service;

    @RequestMapping(value="/virtual-gallery", method = RequestMethod.GET)
    public ModelAndView showArts(ModelMap model){
        service.addArt(new Painting(null, "Art 1", "", null, ""));
        service.addArt(new Print(null, "Art 2", "", null, ""));
        service.addArt(new Sculpture(null, "Art 3", "", null, ""));
        List<Art> arts = service.getArtList();
        ModelAndView map = new ModelAndView("/virtual-gallery");
        map.addObject("lists", arts);
        return map;
    }
}
