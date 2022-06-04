package A4.G2.web.stepdefs;

import A4.G2.web.pages.AddArtPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageNewArt {
    private WebDriver driver;
    private AddArtPage addArtPage;

    @Given("I am on the add art page")
    public void iAmOnTheAddArtPage() {
        driver.get("http://localhost:8080/add-art");
    }

    @When("I enter {string} as title field")
    public void iEnterAsTitleField(String string) {
        addArtPage.insertTitle(string);
    }

    @And("I enter {string} as description field")
    public void iEnterAsDescriptionField(String string) {
        addArtPage.insertDescription(string);
    }

    @And("I select {string} as art type")
    public void iSelectAsArtType(String string) {
        addArtPage.selectArtType(string);
    }

    @And("I enter {string} as dimension field")
    public void iEnterAsDimensionField(String string) {
        addArtPage.insertDimension(string);
    }

    @And("I enter {string} as artist name field")
    public void iEnterAsArtistNameField(String string) {
        addArtPage.insertArtistName(string);
    }

    @And("I enter {string} as image field")
    public void iEnterAsImageField(String string) {
        addArtPage.insertImage(string);
    }

    @And("I enter {string} as buyNow price field")
    public void iEnterAsBuyNowPriceField(String string) {
        addArtPage.insertBuyNowPrice(string);
    }

    @And("I enter {string} as auction start price field")
    public void iEnterAsAuctionStartPriceField(String string) {
        addArtPage.insertAuctionStartPrice(string);
    }

    @And("I enter {string} as auction reserve price field")
    public void iEnterAsAuctionReservePriceField(String string) {
        addArtPage.insertAuctionReservePrice(string);
    }

    @And("I enter {string} as auction time remaining field")
    public void iEnterAsAuctionTimeRemainingField(String string) {
        addArtPage.insertAuctionTimeRemaining(string);
    }

    @And("I press the submit new art button")
    public void iPressTheSubmitButton() {
        addArtPage.clickSubmit();
    }

    @Then("I should see the new art displayed")
    public void iShouldSeeTheNewArtDisplayed() {
        assertTrue(addArtPage.getMessage().contains("Art titled: \"Title\" successfully added"));
    }


    @Then("I should see the new art displayed with buyNow")
    public void iShouldSeeTheNewArtDisplayedWithBuyNow() {
        assertTrue(addArtPage.getMessage().contains("Art titled: \"Title\" successfully added with buy-now listing"));
    }


    @Then("I should see the new art displayed with auction")
    public void iShouldSeeTheNewArtDisplayedWithAuction() {
        assertTrue(addArtPage.getMessage().contains("Art titled: \"Title\" successfully added with auction listing"));
    }

    @Then("I should see error message")
    public void iShouldSeeErrorMessage() {
        assertTrue(addArtPage.getErrorMessage().contains("Invalid inputs try again"));
    }
}
