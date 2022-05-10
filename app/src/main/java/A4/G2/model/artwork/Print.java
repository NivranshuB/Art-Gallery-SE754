package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Print extends Art {
    private Artist artist;
    private String title;

    public Print(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
        this.title = title;
    }

    public Artist getPrintArtist() {
        return this.artist;
    }

    public String getPrintTitle() {
        return this.title;
    }
}
