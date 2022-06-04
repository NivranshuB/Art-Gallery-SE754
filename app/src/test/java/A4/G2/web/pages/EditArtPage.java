package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class EditArtPage {

    public EditArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "editTitle")
    private WebElement editTitle;
    @FindBy(how = How.ID, using = "editSubmit")
    private WebElement editSubmitBtn;
    @FindBy(how=How.ID, using = "message")
    private WebElement message;


    public void insertNewTitle(String string) {
        editTitle.sendKeys(string);
    }

    public void clickSubmit() {
        editSubmitBtn.click();
    }

    public String getMessage() {
        return this.message.getText();
    }
}
