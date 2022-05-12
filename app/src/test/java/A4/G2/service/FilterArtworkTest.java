package A4.G2.service;

import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
import A4.G2.model.sale.Sale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * USER STORY: Filter artwork
 *
 * As a user, I would like a way to filter both artwork for display and for sale by their type, price(auction and
 * buy now if applicable), for auction or buy now, auction time left(if applicable) and artist so that I can view
 * the pieces of artwork that are of interest to me.
 *
 * ACs
 * - A user should be able to filter art so that they can see all pieces on auction
 * - A user should be able to filter art so that they can see all pieces that can be directly bought (have a
 *   ‘buy now’)
 * - A user should be able to filter art based on a price range (for items with a ‘buy now’)
 * - A user should be able to filter art being sold on auction based on the time remaining on the auction
 * - A user should be able to filter art so that they can see all the art from a specific artist
 * - A user should be able to filter art to view a specific type of art, such as sculptures, paintings, prints etc.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FilterArtworkTest {

    IFilterArtService filterService;
    List<Sale> saleList = new ArrayList<>();

    @BeforeAll
    public void setup() {
        Sale buyNow1 = Mockito.mock(BuyNow.class);
        Sale buyNow2 = Mockito.mock(BuyNow.class);
        Sale auction1 = Mockito.mock(Auction.class);

        Mockito.when(buyNow1.getPrice()).thenReturn(120.00);
        Mockito.when(buyNow2.getPrice()).thenReturn(101.00);
        Mockito.when(auction1.getTimeRemaining()).thenReturn(90000);

        saleList.add(buyNow1);
        saleList.add(buyNow2);
        saleList.add(auction1);

        filterService = new FilterArtService();
    }

    @Test
    public void testFilterOnlyAuctionPieces() {
        List<Sale> actual = filterService.getAuctionItems(saleList);
        assertEquals(1, actual.size());

        for (Sale sale : actual) {
            assertTrue(sale instanceof Auction);
        }
    }

    @Test
    public void testFilterOnlyBuyNowPieces() {
        List<Sale> actual = filterService.getBuyNowItems(saleList);
        assertEquals(2, actual.size());

        for (Sale sale : actual) {
            assertTrue(sale instanceof BuyNow);
        }
    }

    @Test
    public void testFilterOnlyBuyNowPiecesLowerThan$100() {
        List<Sale> actual = filterService.getPriceLowerThan(saleList, 100.0);

        assertEquals(0, actual.size());
    }

    @Test
    public void testFilterOnlyBuyNowPiecesHigherThan$100() {
        List<Sale> actual = filterService.getPriceHigherThan(saleList, 100.0);

        assertEquals(2, actual.size());
        for (Sale sale : actual) {
            assertTrue(sale.getPrice() > 100);
        }
    }

    @Test
    public void testFilterOnlyBuyNowPiecesBetween$100and$110() {
        List<Sale> actual = filterService.getPriceBetween(saleList, 100.0, 110.0);

        assertEquals(1, actual.size());
        for (Sale sale : actual) {
            assertTrue((Double.compare(sale.getPrice(), 100.0) > 0) && (Double.compare(sale.getPrice(), 110.0) < 0));
        }
    }
}
