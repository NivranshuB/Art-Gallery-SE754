package A4.G2.model.artwork;

import A4.G2.model.Gallery;
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
public class testGetArtsDetailsFromGallery {
    Gallery gallery;
    Art art1, art2, art3;
    Image image;
    Artist artist;

    @BeforeAll
    public void setUp() throws IOException {
        gallery = Mockito.spy(new Gallery());
        image = ImageIO.read(new File("src/test/java/A4/G2/model/artwork/testImage.png"));
        artist = Mockito.mock(Artist.class);
        gallery.addArt(Mockito.spy(new Painting(artist,"Art 1","",image,"")));
        gallery.addArt(Mockito.spy(new Print(artist,"Art 2","",image,"")));
        gallery.addArt(Mockito.spy(new Sculpture(artist,"Art 3","",image,"")));
    }

    @Test
    public void testGetTitleFromoGallery(){
        for(int i=1;i<3;i++){
            assertEquals("Art "+Integer.toString(i+1), gallery.getArtList().get(i).getTitle());
        }
    }

    @Test
    public void testGetImageFromoGallery(){
        for(int i=1;i<3;i++){
            assertEquals(image, gallery.getArtList().get(i).getImage());
        }
    }
}
