package A4.G2.model;

import A4.G2.model.artwork.Art;
import A4.G2.model.sale.Sale;
import A4.G2.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private List<Art> arts = new ArrayList<>();
    private List<Sale> artsForSale = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private String termsAndConditions="";

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

    public void addUser(User newUser) { users.add(newUser); }

    public User loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    return u;
                }
            }
        }
        return null;
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

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }
}
