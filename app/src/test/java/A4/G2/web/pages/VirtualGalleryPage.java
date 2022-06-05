package A4.G2.web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

public class VirtualGalleryPage {

    public VirtualGalleryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="arts")
    private WebElement arts;

    public void checkArtworks(List<String> titles, List<String> images){
        for(String title:titles){
            Assert.assertTrue(arts.getText().contains(title));
        }
        for(String image:images){
            Assert.assertTrue(arts.getText().contains(image));
        }
    }
}
