package A4.G2.model.artwork;

import A4.G2.model.users.Artist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class PaintingTest {

    Painting painting;
    Artist artist = Mockito.mock(Artist.class) ;


    @BeforeAll
    public void setUp() {
        painting = new Painting(artist, "title", "description", "urltoimage.com");
    }

    @Test
    public void testGetArtist() {
        assertEquals(artist, painting.getArtist());
    }
}
