package A4.G2.controller;

import A4.G2.service.Gallery;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.model.users.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@Controller
@SessionAttributes("name")
public class AddArtController {

    @Autowired
    Gallery gallery;

    @RequestMapping(value = "/add-art", method = RequestMethod.GET)
    public String showAddArtPage(ModelMap model) {
        return "add-art";
    }

    @RequestMapping(value = "/add-art", method = RequestMethod.POST)
    public String showSuccessAddArtPage(
            ModelMap model,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String dimensions,
            @RequestParam String artType,
            @RequestParam String artistName,
            @RequestParam String fileOfImage
    ) throws IOException {

        Image image;
        image = ImageIO.read(new File("src/main/images/"+fileOfImage));

        Artist artist = new Artist();
        artist.setArtistName(artistName);

        switch (artType) {
            case "0" -> {
                Painting painting = new Painting(artist, title, description, image, dimensions);
                gallery.addArt(painting);
            }
            case "1" -> {
                Print print = new Print(artist, title, description, image, dimensions);
                gallery.addArt(print);
            }
            case "2" -> {
                Sculpture sculpture = new Sculpture(artist, title, description, image, dimensions);
                gallery.addArt(sculpture);
            }
        }

        String message =  String.format("Art titled: \"%s\" successfully added", title);
        model.put("message", message);

        System.out.println(gallery.getArtList());
        return "add-art";
    }

}
