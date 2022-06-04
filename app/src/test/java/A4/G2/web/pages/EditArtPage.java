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

    @FindBy(how = How.ID, using = "editDescription")
    private WebElement editDescription;

    @FindBy(how = How.ID, using = "editDimensions")
    private WebElement editDimensions;
    @FindBy(how = How.ID, using = "editSubmit")
    private WebElement editSubmitBtn;
    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.ID, using = "artDetailButton")
    private WebElement artDetailButton;


    public void insertNewTitle(String string) {
        editTitle.sendKeys(string);
    }

    public void clickSubmit() {
        editSubmitBtn.click();
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void clickGoBackToArtDetail() {
        artDetailButton.click();
    }

    public void insertNewDescription(String string) {
        editDescription.sendKeys(string);
    }

    public void insertNewDimensions(String string) {
        editDimensions.sendKeys(string);
    }
}
