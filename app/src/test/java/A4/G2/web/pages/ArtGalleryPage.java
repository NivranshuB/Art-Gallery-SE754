package A4.G2.web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

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
            Assert.assertTrue(arts.getText().contains(title));
        }
        for(String image:images){
            Assert.assertTrue(arts.getText().contains(image));
        }
    }

    public void checkArtworksOnSale(List<String> titles, List<String> images,
                                    List<String> saleTypes, List<Double> prices){
        for(String title:titles){
            Assert.assertTrue(sales.getText().contains(title));
        }
        for(String image:images){
            Assert.assertTrue(sales.getText().contains(image));
        }
        for(String saleType:saleTypes){
            Assert.assertTrue(sales.getText().contains(saleType));
        }
        for(Double price:prices){
            Assert.assertTrue(sales.getText().contains(price.toString()));
        }
    }
}
