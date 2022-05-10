package A4.G2.model.artwork;

import A4.G2.model.users.Artist;

import java.awt.*;

public class Painting extends Art {
    private Artist artist;

    public Painting(Artist artist, String title, String description, Image photo) {
        super(artist, title, description, photo);
        this.artist = artist;
    }

    public Artist getPaintingArtist() {
        return this.artist;
    }
}
