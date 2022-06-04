package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountPage {

    public ManageAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
