package A4.G2.service;

import A4.G2.model.sale.Sale;

import java.util.List;

public interface IFilterArtService {
    List<Sale> getAuctionItems(List<Sale> saleList);

    List<Sale> getBuyNowItems(List<Sale> saleList);
}
