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

    @Given("I visit the signup page")
    public void i_visit_the_signup_page() {
        driver.get("http://localhost:8080/signup");
    }
    @When("I enter {string} as new account user name field")
    public void i_enter_as_new_account_user_name_field(String string) {
        signupPage.insertUserName(string);
    }
    @When("I enter {string} as new account password field")
    public void i_enter_as_new_account_password_field(String string) {
        signupPage.insertPassword(string);
    }
    @When("I enter {string} as new account retyped password field")
    public void i_enter_as_new_account_retyped_password_field(String string) {
        signupPage.insertRetypedPassword(string);
    }
    @When("I tick {string} for terms and conditions")
    public void i_tick_for_terms_and_conditions(String string) {
        boolean termsAccepted = Boolean.valueOf(string);
        if (termsAccepted) {
            signupPage.clickConditions();
        }
    }
    @When("I press the signup submit button")
    public void i_press_the_signup_submit_button() {
        signupPage.clickSignup();
    }
    @Then("I should see the invalid credentials message")
    public void i_should_see_the_invalid_credentials_message() {
        assertTrue(signupPage.getErrorMessage().contains("Invalid Credentials"));
    }

    @Then("I should see the welcome page for the created account")
    public void iShouldSeeTheWelcomePageForTheCreatedAccount() {
        assertTrue(signupPage.getMessage().contains("Welcome user2"));
    }
}
