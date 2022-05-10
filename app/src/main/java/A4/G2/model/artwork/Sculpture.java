package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Sculpture extends Art {
    private Artist artist;
    private String title;

    public Sculpture(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
        this.title = title;
    }

    public Artist getSculptureArtist() {
        return this.artist;
    }

    public String getSculptureTitle() {
        return this.title;
    }
}
