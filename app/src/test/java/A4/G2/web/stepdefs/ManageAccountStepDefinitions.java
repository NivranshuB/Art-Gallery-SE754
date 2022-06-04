package A4.G2.web.stepdefs;

import A4.G2.web.pages.HomePage;
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
}
