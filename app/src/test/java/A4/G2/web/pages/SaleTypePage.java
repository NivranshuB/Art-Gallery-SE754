package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SaleTypePage {

    public SaleTypePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="sales")
    private WebElement sales;

    @FindBy(how= How.ID, using ="min")
    private WebElement minPrice;

    @FindBy(how=How.ID, using="max")
    private WebElement maxPrice;

    @FindBy(how=How.ID, using="submitPriceBtn")
    private WebElement submitPriceButton;

    public void insertMinimumPrice(double d) {
        this.minPrice.sendKeys(d + "");
    }

    public void insertMaximumPrice(double d) {
        this.maxPrice.sendKeys(d + "");
    }

    public void clickFilterByPriceButton() {
        this.submitPriceButton.click();
    }

    public void checkAllInPriceRangeDisplayed(List<String> titles) {
        for (String title:titles) {
            assertTrue(sales.getText().contains(title));
        }
    }
}
