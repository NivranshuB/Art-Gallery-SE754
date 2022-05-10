package A4.G2.model.artwork;

import A4.G2.model.users.Artist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testGetSculptureDetails {
	Artist artist;
	Image image;
	Sculpture sculpture;
	@BeforeAll
	public void setUp() throws IOException {
		artist = Mockito.mock(Artist.class);
		image = ImageIO.read(new File("src/test/java/A4/G2/model/artwork/testImage.png"));
		sculpture = Mockito.spy(new Sculpture(artist, "Art Title", "Art Description", image));
	}

	@Test
	public void testGetSculptureArtist() {
		assertEquals(artist, sculpture.getSculptureArtist());
	}

	@Test
	public void testGetSculptureTitle() {
		assertEquals("Art Title", sculpture.getSculptureTitle());
	}

	@Test
	public void testGetSculptureDescription() {
		assertEquals("Art Description", sculpture.getSculptureDescription());
	}

	@Test
	public void testGetSculptureImage() {
		assertEquals(image, sculpture.getSculptureImage());
	}
}
