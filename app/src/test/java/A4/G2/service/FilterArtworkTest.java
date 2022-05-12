package A4.G2.service;

import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
import A4.G2.model.sale.Sale;
import org.junit.jupiter.api.Test;
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

public class FilterArtworkTest {

    IFilterArtService filterService;
    List<Sale> saleList = new ArrayList<>();

    @Test
    public void testFilterOnlyAuctionPieces() {
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

        List<Sale> actual = filterService.getAuctionItems(saleList);
        assertEquals(1, actual.size());

        for (Sale sale : actual) {
            assertTrue(sale instanceof Auction);
        }
    }

    @Test
    public void testFilterOnlyBuyNowPieces() {
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

        List<Sale> actual = filterService.getBuyNowItems(saleList);
        assertEquals(2, actual.size());

        for (Sale sale : actual) {
            assertTrue(sale instanceof BuyNow);
        }
    }
}
