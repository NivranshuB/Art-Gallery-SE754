package A4.G2.web.stepdefs;

import A4.G2.web.pages.LoginPage;
import A4.G2.web.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("Driver set up for login page")
    public void driver_set_up_for_login_page() {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get("http://localhost:8080/home");
    }
    @When("I press the login button")
    public void i_press_the_login_button() {
        homePage.clickLoginNavButton();
    }
    @Then("I should see the login page")
    public void i_should_see_the_login_page() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }
}