package A4.G2.service;

import A4.G2.model.sale.Auction;
import A4.G2.model.sale.BuyNow;
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

    @Override
    public List<Sale> getBuyNowItems(List<Sale> saleList) {
        List<Sale> buyNowItemsList = new ArrayList<>();

        for (Sale sale : saleList) {
            if (sale instanceof BuyNow) {
                buyNowItemsList.add(sale);
            }
        }
        return buyNowItemsList;
    }

    @Override
    public List<Sale> getPriceLowerThan(List<Sale> saleList, double max) {
        List<Sale> lowerPriceList = new ArrayList<>();

        for (Sale sale : saleList) {
            if ((sale instanceof BuyNow) && (Double.compare(sale.getPrice(), max) <= 0)) {
                lowerPriceList.add(sale);
            }
        }
        return lowerPriceList;
    }

    @Override
    public List<Sale> getPriceHigherThan(List<Sale> saleList, double min) {
        List<Sale> higherPriceList = new ArrayList<>();

        for (Sale sale : saleList) {
            if ((sale instanceof BuyNow) && (Double.compare(sale.getPrice(), min) >= 0)) {
                higherPriceList.add(sale);
            }
        }
        return higherPriceList;
    }

    @Override
    public List<Sale> getPriceBetween(List<Sale> saleList, double max, double min) {
        List<Sale> inRangeList = new ArrayList<>();

        for (Sale sale : saleList) {
            if ((sale instanceof BuyNow) && (Double.compare(sale.getPrice(), max) >= 0) &&
                    (Double.compare(sale.getPrice(), min) <= 0)) {
                inRangeList.add(sale);
            }
        }
        return inRangeList;
    }

    @Override
    public List<Sale> filterAuctionItemsUnderTime(List<Sale> saleList, int max) {
        List<Sale> lowerTimeRemainingList = new ArrayList<>();

        for (Sale sale : saleList) {
            if ((sale instanceof Auction) && (sale.getTimeRemaining() < max)) {
                lowerTimeRemainingList.add(sale);
            }
        }
        return lowerTimeRemainingList;
    }

    @Override
    public List<Sale> filterAuctionItemsOverTime(List<Sale> saleList, int min) {
        return new ArrayList<>();
    }
}
