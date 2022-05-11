package A4.G2.model;

import A4.G2.model.artwork.Art;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GalleryTest {

    Gallery gallery;
    Art art;
    @BeforeAll
    public void setUp() {
        gallery = Mockito.spy(new Gallery());
        art = Mockito.mock(Art.class);
    }

    @Test
    public void testAddingArtToGalleryArtList() {
        gallery.addArt(art);
        assertEquals(gallery.getArtList().size(), 1);
    }

}
