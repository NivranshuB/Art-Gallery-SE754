package A4.G2.model.artwork;

import A4.G2.model.users.Artist;
import A4.G2.model.sale.Sale;

import java.awt.*;

public abstract class Art {
    private Artist artist;
    private String title;
    private String description;
    private Image image;
    private String dimensions;
    private Sale sale;

    public Art(Artist artist, String title, String description, Image image, String dimensions) {
        this.artist = artist;
        this.title = title;
        this.description = description;
        this.image = image;
        this.dimensions = dimensions;
        boolean onSale = false;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Image getImage() {
        return this.image;
    }

    public String getDimensions() {
        return this.dimensions;
    }
}
