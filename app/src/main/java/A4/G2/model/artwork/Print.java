package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Print extends Art {
    private Artist artist;
    private String title;
    private String description;
    private Image image;

    public Print(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
        this.title = title;
        this.description = description;
        this.image = photo;
    }

    public Artist getPrintArtist() {
        return this.artist;
    }

    public String getPrintTitle() {
        return this.title;
    }

    public String getPrintDescription() {
        return this.description;
    }

    public Image getPrintImage() {
        return this.image;
    }
}
