package A4.G2.model;

import A4.G2.model.artwork.Art;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private List<Art> arts = new ArrayList<>();
    private Art[] onSales;

    public Gallery() {
        String termsAndConditions = "";
    }

    public void addArt(Art art) {
        arts.add(art);
    }
    public List<Art> getArtList() {
        return arts;
    }



}
