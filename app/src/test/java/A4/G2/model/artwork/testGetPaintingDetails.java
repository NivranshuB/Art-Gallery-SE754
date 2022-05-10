package A4.G2.model.artwork;

import A4.G2.model.users.Artist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
public class testGetPaintingDetails {
	Artist artist;
	Image image;
	Painting painting;
	@BeforeAll
	public void setUp() throws IOException {
		artist = Mockito.mock(Artist.class);
		image = ImageIO.read(new File("src/test/java/A4/G2/model/artwork/testImage.png"));

		painting = Mockito.mock(Painting.class, Mockito.withSettings().useConstructor(artist, "Art Title", "Art Description", image));

	}


	@Test
	public void testGetPaintingArtist() {
		assertEquals(artist, painting.getPaintingArtist());
	}

}
