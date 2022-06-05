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



    //Change password component
    @FindBy(how=How.ID, using="currentPassword")
    private WebElement currentPassword;

    @FindBy(how=How.ID, using="newPassword")
    private WebElement newPassword;

    @FindBy(how=How.ID, using="retypedPassword")
    private WebElement retypedPassword;

    @FindBy(how=How.ID, using="passwordError")
    private WebElement passwordError;

    @FindBy(how=How.ID, using="passwordSuccess")
    private WebElement passwordSuccess;

    @FindBy(how=How.ID, using="submitPasswordbtn")
    private WebElement submitPasswordButton;

    public void insertNewPassword(String newPassword) {
        this.newPassword.sendKeys(newPassword);
    }

    public void insertRetypedNewPassword(String retypedNewPassword) {
        this.retypedPassword.sendKeys(retypedNewPassword);
    }

    public void clickSubmitPasswordButton() {
        this.submitPasswordButton.click();
    }

    public String getPasswordErrorMessage() {
        return this.passwordError.getText();
    }

    public String getPasswordSuccessMessage() { return this.passwordSuccess.getText(); }

    public void insertCurrentPassword(String currentPassword) {
        this.currentPassword.sendKeys(currentPassword);
    }



    //Change shipping details component
    @FindBy(how=How.ID, using="address")
    private WebElement address;

    @FindBy(how=How.ID, using="preferences")
    private WebElement preferences;

    @FindBy(how=How.ID, using="currentAddress")
    private WebElement currentAddress;

    @FindBy(how=How.ID, using="currentPreferences")
    private WebElement currentPreferences;

    @FindBy(how=How.ID, using="submitShippingbtn")
    private WebElement submitShippingButton;

    @FindBy(how=How.ID, using="deleteShippingbtn")
    private WebElement deleteShippingButton;

    public void insertNewShippingAddress(String newAddress) {
        this.address.sendKeys(newAddress);
    }

    public void clickSubmitShippingButton() {
        this.submitShippingButton.click();
    }

    public String getShippingAddress() {
        return this.currentAddress.getText();
    }

    public void insertNewShippingPreference(String string) {
        this.preferences.sendKeys(string);
    }

    public String getShippingPreference() {
        return this.currentPreferences.getText();
    }

    public void clickDeleteShippingDetailsButton() {
        this.deleteShippingButton.click();
    }


}
