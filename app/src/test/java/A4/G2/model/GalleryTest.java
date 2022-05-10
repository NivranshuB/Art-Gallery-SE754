package A4.G2.model;

import A4.G2.model.artwork.Art;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GalleryTest {

    @Test
    public void testAddingArtToGalleryArtList() {
        Gallery gallery = Mockito.mock(Gallery.class);
        Art art = Mockito.mock(Art.class);
        gallery.addArt(art);
        Mockito.verify(gallery).addArt(art);
        assert equals(gallery.getArtList().size(), 1);
    }
}
