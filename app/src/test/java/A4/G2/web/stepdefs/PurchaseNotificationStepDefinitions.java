package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseNotificationStepDefinitions {
    private ArtDetailsPage artDetailsPage;
    private WebDriver driver;

    @Given("Driver set up for art details page")
    public void driverSetUpForArtDetailsPage() {
        driver = Hooks.getDriver();
        this.artDetailsPage = new ArtDetailsPage(driver);
    }

    @Given("I want to buy an artwork now")
    public void iAccessAnArtDetailsPage() {
        driver.get("http://localhost:8080/art-details");
    }

    @When("When I purchase an item")
    public void iClickOnThePurchaseButton() {
        artDetailsPage.clickShare();
    }

    @Then("Then I want a notification to confirm my successful purchase")
    public void iWantToSeePurchaseNotification() {
        boolean notification = artDetailsPage.purchaseConfirmationNotification();
        assertEquals(true,notification);
    }
}
