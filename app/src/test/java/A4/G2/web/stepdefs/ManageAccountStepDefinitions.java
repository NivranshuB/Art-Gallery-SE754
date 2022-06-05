package A4.G2.web.stepdefs;

import A4.G2.web.pages.HomePage;
import A4.G2.web.pages.ManageAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageAccountStepDefinitions {

    private WebDriver driver;
    private ManageAccountPage manageAccountPage;
    private HomePage homePage;

    @Given("Driver set up for manage account page")
    public void driver_set_up_for_manage_account_page() {
        driver = Hooks.getDriver();
        manageAccountPage = new ManageAccountPage(driver);
        homePage = new HomePage(driver);
    }
    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("http://localhost:8080/manage-account/testing");
        driver.get("http://localhost:8080");
    }

    @Given("I start on the home page")
    public void i_start_on_the_home_page() {
        driver.get("http://localhost:8080/home");
    }
    @When("I press the manage account button")
    public void i_press_the_manage_account_button() {
        homePage.clickManageAccountButton();
    }
    @Then("I should see the manage account page")
    public void i_should_see_the_manage_account_page() {
        assertTrue(driver.getCurrentUrl().contains("manage-account"));
    }

    @Given("I am currently on the manage account page")
    public void iAmCurrentlyOnTheManageAccountPage() {
        driver.get("http://localhost:8080/manage-account");
    }
    @When("I enter {string} in the new username field")
    public void i_enter_in_the_new_username_field(String string) {
        manageAccountPage.insertNewUsername(string);
    }
    @And("I press the submit username button")
    public void iPressTheSubmitUsernameButton() {
        manageAccountPage.clickSubmitUsernameButton();
    }
    @Then("I should see the invalid username message")
    public void iShouldSeeTheInvalidUsernameMessage() {
        assertTrue(manageAccountPage.getUsernameErrorMessage().contains("Invalid username"));
    }

    @Then("I should see the new current username")
    public void iShouldSeeTheNewCurrentUsername() {
        assertTrue(manageAccountPage.getCurrentUsername().contains("user3"));
    }

    @When("I enter {string} as current password field")
    public void i_enter_as_current_password_field(String string) {
        manageAccountPage.insertCurrentPassword(string);
    }
    @When("I enter {string} as new password field")
    public void i_enter_as_new_password_field(String string) {
        manageAccountPage.insertNewPassword(string);
    }
    @When("I enter {string} as retyped new password field")
    public void i_enter_as_retyped_new_password_field(String string) {
        manageAccountPage.insertRetypedNewPassword(string);
    }
    @And("I press the submit password button")
    public void iPressTheSubmitPasswordButton() {
        manageAccountPage.clickSubmitPasswordButton();
    }
    @Then("I should see the invalid password message")
    public void i_should_see_the_invalid_password_message() {
        assertTrue(manageAccountPage.getPasswordErrorMessage().contains("Invalid password"));
    }

    @Then("I should see the password changed message")
    public void iShouldSeeThePasswordChangedMessage() {
        assertTrue(manageAccountPage.getPasswordSuccessMessage().contains("Password changed successfully"));
    }

    @When("I enter {string} in shipping address field")
    public void iEnterInShippingAddressField(String string) {
        manageAccountPage.insertNewShippingAddress(string);
    }
    @And("I press the submit shipping details button")
    public void iPressTheSubmitShippingDetailsButton() {
        manageAccountPage.clickSubmitShippingButton();
    }
    @Then("I should see the new address as my shipping address")
    public void iShouldSeeTheNewAddressAsMyShippingAddress() {
        assertTrue(manageAccountPage.getShippingAddress().contains("8, Rollers Avenue, Paper town"));
    }

    @When("I enter {string} in shipping preference field")
    public void iEnterInShippingPreferenceField(String string) {
        manageAccountPage.insertNewShippingPreference(string);
    }
    @Then("I should see the new preference as my shipping preference")
    public void iShouldSeeTheNewPreferenceAsMyShippingPreference() {
        assertTrue(manageAccountPage.getShippingPreference().contains("Only available on weekends"));
    }
}
