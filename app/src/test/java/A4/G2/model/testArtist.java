package A4.G2.model;

import A4.G2.service.LinkGenerator;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class testArtist {

	@Test
	public void should_return_artist_page_link() {
		LinkGenerator artistLink = new LinkGenerator();
		Artist artist = new Artist();
		String link = artistLink.generateLink(artist.getArtistId());
		assertFalse(artist.getArtistId()=="");
		assertEquals("https://www.g2gallery.com/"+artist.getArtistId(), link);
	}

}