package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountPage {

    public ManageAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Change username component
    @FindBy(how= How.ID, using ="newUsername")
    private WebElement newUsername;

    @FindBy(how=How.ID, using="currentUsername")
    private WebElement currentUsername;

    @FindBy(how=How.ID, using="usernameError")
    private WebElement usernameError;

    @FindBy(how=How.ID, using="submitUsernamebtn")
    private WebElement submitUsernameButton;

    public void insertNewUsername(String userName){
        this.newUsername.sendKeys(userName);
    }

    public String getCurrentUsername() { return this.currentUsername.getText(); }

    public void clickSubmitUsernameButton(){
        this.submitUsernameButton.click();
    }

    public String getUsernameErrorMessage() { return this.usernameError.getText(); }
}
