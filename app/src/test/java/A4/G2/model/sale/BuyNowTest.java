package A4.G2.model.sale;


import A4.G2.model.artwork.Painting;
import A4.G2.model.users.Artist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BuyNowTest {
	Artist artist;
	Image image;
	Painting painting;
	BuyNow buyNow;
	int saleId;
	double price;

	@BeforeAll
	public void setUp() throws IOException {
		artist = Mockito.mock(Artist.class);
		image = ImageIO.read(new File("src/test/java/A4/G2/model/artwork/testImage.png"));
		painting = Mockito.spy(new Painting(artist, "Art Title", "Art Description", image, "2x1m"));

		saleId = 1;
		price = 111.11;
		buyNow = Mockito.spy(new BuyNow(saleId, price, painting));
	}

	@Test
	public void testGetBuyNowSaleId() {
		Mockito.doReturn(saleId).when(buyNow).getSaleId();
		assertEquals(saleId, buyNow.getSaleId());
	}

	@Test
	public void testGetBuyNowPrice() {
		Mockito.doReturn(price).when(buyNow).getPrice();
		assertEquals(price, buyNow.getPrice());
	}

	@Test
	public void testGetBuyNowDeliveryCost() {
		Mockito.doReturn(15.00).when(buyNow).getDeliveryCost();
		assertEquals(15.00, buyNow.getDeliveryCost());
	}

	@Test
	public void testGetBuyNowDeliveryTime() {
		Mockito.doReturn("5 working days").when(buyNow).getDeliveryTime();
		assertEquals("5 working days", buyNow.getDeliveryTime());
	}

	@Test
	public void testGetBuyNowGstCalculation() {
		double gst = price * 0.15;
		Mockito.doReturn(gst).when(buyNow).getGst();
		assertEquals(gst, buyNow.getGst());
	}

	@Test
	public void testGetArtwork() {
		Mockito.doReturn(painting).when(buyNow).getArtPiece();
		assertEquals(painting, buyNow.getArtPiece());
	}

}
