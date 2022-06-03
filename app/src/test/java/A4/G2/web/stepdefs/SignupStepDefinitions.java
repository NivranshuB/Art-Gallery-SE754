package A4.G2.web.stepdefs;

import A4.G2.web.pages.SignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import A4.G2.web.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupStepDefinitions {

    private WebDriver driver;
    private SignupPage signupPage;
    private HomePage homePage;

    @Given("Driver set up for signup page")
    public void driver_set_up_for_signup_page() {
        driver = Hooks.getDriver();
        signupPage = new SignupPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am currently on the home page")
    public void i_am_currently_on_the_home_page() {
        driver.get("http://localhost:8080/home");
    }
    @When("I press the signup button")
    public void i_press_the_signup_button() {
        homePage.clickSignupNavButton();
    }
    @Then("I should see the signup page")
    public void i_should_see_the_signup_page() {
        assertTrue(driver.getCurrentUrl().contains("signup"));
    }
}
