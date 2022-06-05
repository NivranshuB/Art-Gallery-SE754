package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtDetailsPage;
import A4.G2.web.pages.SuccessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseNotificationStepDefinitions {
    private ArtDetailsPage artDetailsPage;

    private SuccessPage successPage;
    private WebDriver driver;

    @Given("Driver set up for Purchase Notification")
    public void driverSetUpForPurchaseNotification() {
        driver = Hooks.getDriver();
        this.artDetailsPage = new ArtDetailsPage(driver);
    }

    @Given("I want to buy an artwork now")
    public void iAccessAnArtDetailsPage() {
        driver.get("http://localhost:8080/art-details");
    }

    @When("When I purchase an item")
    public void iClickOnThePurchaseButton() {
        artDetailsPage.clickBuyNow();
    }

    @Then("Then I want a notification to confirm my successful purchase")
    public void iWantToSeePurchaseNotification() {
        driver.get("http://localhost:8080/success-page");
        this.successPage = new SuccessPage(driver);
        boolean notification = this.successPage.purchaseConfirmationNotification();
        assertEquals(true,notification);
    }
}
