package A4.G2.model;

import A4.G2.model.artwork.Art;
import A4.G2.model.sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private List<Art> arts = new ArrayList<>();
    private List<Sale> artsForSale = new ArrayList<>();

    public Gallery() {
        String termsAndConditions = "";
    }

    public void addArt(Art art) {
        arts.add(art);
    }
    public List<Art> getArtList() {
        return arts;
    }

    public void addArtForSale(Sale sale) {
        artsForSale.add(sale);
    }
    public List<Sale> getArtSalesList() {
        return artsForSale;
    }


}
