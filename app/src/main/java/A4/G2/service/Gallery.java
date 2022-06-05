package A4.G2.service;

import A4.G2.model.artwork.Art;
import A4.G2.model.artwork.Painting;
import A4.G2.model.artwork.Print;
import A4.G2.model.artwork.Sculpture;
import A4.G2.model.sale.Sale;
import A4.G2.model.users.Artist;
import A4.G2.model.users.User;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Gallery {
    private final List<Art> arts = new ArrayList<>();
    private final List<Sale> artsForSale = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private String termsAndConditions = "";

    private Boolean isInitiated = false;

    public Gallery() {

    }

    public void addArt(Art art) {
        arts.add(art);
    }

    public void removeArt(Art art) {
        arts.remove(art);
    }

    public List<Art> getArtList() {
        return arts;
    }

    public void addArtForSale(Sale sale) {
        artsForSale.add(sale);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void removeArtForSale(Sale sale) {
        artsForSale.remove(sale);
    }

    public List<Sale> getArtSalesList() {
        return artsForSale;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public List<User> getUserList() {
        return users;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }


    public void initiate() throws IOException {
        if (!this.isInitiated) {
            Artist artist = new Artist();
            artist.setArtistName("Frank");
            Image image = ImageIO.read(new File("src/main/images/testImage.png"));
            Painting initialArt = new Painting(artist, "Title", "Description", image, "2x1m");
            initialArt.setId("1");
            addArt(initialArt);

            addArt(new Painting(artist, "Art 1", "", null, ""));
            addArt(new Print(artist, "Art 2", "", null, ""));
            addArt(new Sculpture(artist, "Art 3", "", null, ""));

            //Initialisation for login and signup testing
            User user1 = new User("user1", "Password123", "user1@gmail.com", "4737054",
                    "7 Parkers Ave, Mexico", new Date(1990, 6, 3));
            addUser(user1);
            setTermsAndConditions("I agree to abide by the rules of copyright and not sell duplicate prints" +
                    " of arts listed on this application");

            this.isInitiated = true;
        }

    }
}
