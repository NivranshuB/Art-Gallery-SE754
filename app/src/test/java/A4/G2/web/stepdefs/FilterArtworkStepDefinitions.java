package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtGalleryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FilterArtworkStepDefinitions {
    private WebDriver driver;
    private ArtGalleryPage artGalleryPage;

    @Given("Driver set up for art gallery page")
    public void driverSetUpForArtGalleryPage() {
        driver = Hooks.getDriver();
        artGalleryPage = new ArtGalleryPage(driver);
    }

    @Given("I am currently on the art gallery page")
    public void iAmCurrentlyOnTheArtGalleryPage() {
        driver.get("http://localhost:8080/art-gallery");
    }
    @When("I select the buy now filter option")
    public void iSelectTheBuyNowFilterOption() {
        artGalleryPage.selectBuyNowFilterOption();
    }
    @When("I press the filter by sale type button")
    public void iPressTheFilterBySaleTypeButton() {
        artGalleryPage.clickFilterSaleButton();
    }
    @Then("I should see all the art pieces with a buy now")
    public void iShouldSeeAllTheArtPiecesWithABuyNow() {
        artGalleryPage.checkAllBuyNowPiecesDisplayed();
    }
}
