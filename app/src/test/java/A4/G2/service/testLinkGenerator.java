package A4.G2.service;

import A4.G2.model.Artist;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testLinkGenerator {

	@Test
	public void should_return_artist_page_link() {
		String uuid = UUID.randomUUID().toString();
		LinkGenerator artistLink = new LinkGenerator();;
		Artist artist = Mockito.mock(Artist.class);
		Mockito.doReturn(uuid).when(artist).getArtistId();
		String link = artistLink.generateLink(artist.getArtistId());
		assertEquals("https://www.g2gallery.com/"+uuid, link);
	}

}