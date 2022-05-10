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

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuctionTest {
	Artist artist;
	Image image;
	Painting painting;
	Auction auction;
	int saleId;
	double price;
	double reservePrice;
	int timeRemaining;

	@BeforeAll
	public void setUp() throws IOException {
		artist = Mockito.mock(Artist.class);
		image = ImageIO.read(new File("src/test/java/A4/G2/model/artwork/testImage.png"));
		painting = Mockito.spy(new Painting(artist, "Art Title", "Art Description", image, "2x1m"));

		saleId = 2;
		price = 50.00; // starting price
		reservePrice = 200.00;
		timeRemaining = 7; // days
		auction = Mockito.spy(new Auction(saleId, price, painting, reservePrice, timeRemaining));
	}

	@Test
	public void testGetAuctionSaleId() {
		Mockito.doReturn(saleId).when(auction).getSaleId();
		assertEquals(saleId, auction.getSaleId());
	}

}
