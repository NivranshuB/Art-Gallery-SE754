package A4.G2.web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ArtGalleryPage {

    public ArtGalleryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="arts")
    private WebElement arts;

    @FindBy(how=How.ID, using="sales")
    private WebElement sales;

    public void checkArtworks(List<String> titles, List<String> images){
        for(String title:titles){
            assertTrue(arts.getText().contains(title));
        }
        for(String image:images){
            assertTrue(arts.getText().contains(image));
        }
    }

    public void checkArtworksOnSale(List<String> titles, List<String> images,
                                    List<String> saleTypes, List<Double> prices){
        for(String title:titles){
            assertTrue(sales.getText().contains(title));
        }
        for(String image:images){
            assertTrue(sales.getText().contains(image));
        }
        for(String saleType:saleTypes){
            assertTrue(sales.getText().contains(saleType));
        }
        for(Double price:prices){
            assertTrue(sales.getText().contains(price.toString()));
        }
    }

    public void checkArtworksImage(List<String> images){
        for(String image:images){
            assertTrue(arts.getText().contains(image));
        }
    }

    //Filter artwork functionality
    @FindBy(how=How.ID, using="buynow")
    private WebElement buynowRadioButton;

    @FindBy(how=How.ID, using="auction")
    private WebElement auctionRadioButton;

    @FindBy(how=How.ID, using="filterBySaleBtn")
    private WebElement filterBySaleButton;

    public void selectBuyNowFilterOption() {
        this.buynowRadioButton.click();
    }

    public void clickFilterSaleButton() {
        this.filterBySaleButton.click();
    }

    public void checkAllBuyNowPiecesDisplayed(List<String> buyNowTitles) {
        for (String title:buyNowTitles) {
            assertTrue(sales.getText().contains(title));
        }
    }

    public void selectAuctionFilterOption() {
        this.auctionRadioButton.click();
    }

    public void checkAllAuctionPiecesDisplayed(List<String> buyNowTitles) {
        for (String title:buyNowTitles) {
            assertTrue(sales.getText().contains(title));
        }
    }
}
