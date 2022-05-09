package A4.G2.model;

import java.util.UUID;

public class Artist {
    private String name;
    private Art[] arts;
    private String id;

    public Artist() {
        this.id = UUID.randomUUID().toString();
    }

    public String getArtistId() {
        return this.id;
    }
}
