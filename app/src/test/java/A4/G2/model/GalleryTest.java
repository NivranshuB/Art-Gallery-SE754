package A4.G2.model;

import A4.G2.model.artwork.Art;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class GalleryTest {

    @Test
    public void testAddingArtToGalleryArtList() {
        Gallery gallery = new Gallery();
        Art art = Mockito.mock(Art.class);
        gallery.addArt(art);
        assertEquals(gallery.getArtList().size(), 1);
    }
}
