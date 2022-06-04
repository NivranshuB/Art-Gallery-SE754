package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GalleryPage {
    public GalleryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
