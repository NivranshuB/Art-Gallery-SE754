package A4.G2.service;

import A4.G2.model.sale.Auction;
import A4.G2.model.sale.Sale;

import java.util.ArrayList;
import java.util.List;

public class FilterArtService implements IFilterArtService{
    @Override
    public List<Sale> getAuctionItems(List<Sale> saleList) {
        List<Sale> auctionItemsList = new ArrayList<>();

        for (Sale sale : saleList) {
            if (sale instanceof Auction) {
                auctionItemsList.add(sale);
            }
        }
        return auctionItemsList;
    }
}
