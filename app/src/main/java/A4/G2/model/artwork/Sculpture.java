package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Sculpture extends Art {
    private Artist artist;
    private String title;
    private String description;

    public Sculpture(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
        this.title = title;
        this.description = description;
    }

    public Artist getSculptureArtist() {
        return this.artist;
    }

    public String getSculptureTitle() {
        return this.title;
    }

    public String getSculptureDescription() {
        return this.description;
    }
}
