package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Painting extends Art {
    private Artist artist;
    private String title;
    private String description;

    public Painting(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
        this.title = title;
        this.description = description;
    }

    public Artist getPaintingArtist() {
        return this.artist;
    }

    public String getPaintingTitle() {
        return this.title;
    }

    public String getPaintingDescription() {
        return this.description;
    }
}
