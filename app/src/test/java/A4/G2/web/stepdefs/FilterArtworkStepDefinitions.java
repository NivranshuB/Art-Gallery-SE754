package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtGalleryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class FilterArtworkStepDefinitions {
    private WebDriver driver;
    private ArtGalleryPage artGalleryPage;

    @Given("Driver set up for art gallery page")
    public void driverSetUpForArtGalleryPage() {
        driver = Hooks.getDriver();
        artGalleryPage = new ArtGalleryPage(driver);
    }
    @And("Gallery populated with test artwork")
    public void galleryPopulatedWithTestArtwork() {
        driver.get("http://localhost:8080/art-gallery/populate-testing");
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
        List<String> titles = Arrays.asList("Art 2", "Art 4", "Art 6", "Art 8");
        artGalleryPage.checkAllBuyNowPiecesDisplayed(titles);
    }

    @When("I select the auction filter option")
    public void iSelectTheAuctionFilterOption() {
        artGalleryPage.selectAuctionFilterOption();
    }
    @Then("I should see all the art pieces on auction")
    public void iShouldSeeAllTheArtPiecesOnAuction() {
        List<String> titles = Arrays.asList("Art 1", "Art 5", "Art 7", "Art 9");
        artGalleryPage.checkAllAuctionPiecesDisplayed(titles);
    }

    @When("I select the painting filter option")
    public void iSelectThePaintingFilterOption() {
        artGalleryPage.selectPaintingFilterOption();
    }
    @And("I press the filter by art type button")
    public void iPressTheFilterByArtTypeButton() {
        artGalleryPage.clickFilterArtOption();
    }
    @Then("I should see all the painting art pieces")
    public void iShouldSeeAllThePaintingArtPieces() {
        List<String> titles = Arrays.asList("Title", "Art 1", "Art 4", "Art 5");
        artGalleryPage.checkAllPaintingArtDisplayed(titles);
    }

    @When("I select the print filter option")
    public void iSelectThePrintFilterOption() {
        artGalleryPage.selectPrintFilterOption();
    }
    @Then("I should see all the print art pieces")
    public void iShouldSeeAllThePrintArtPieces() {
        List<String> titles = Arrays.asList("Art 2", "Art 6", "Art 7");
        artGalleryPage.checkAllPrintArtDisplayed(titles);
    }

    @When("I select the sculpture filter option")
    public void iSelectTheSculptureFilterOption() {
        artGalleryPage.selectSculptureFilterOption();
    }
    @Then("I should see all the sculpture art pieces")
    public void iShouldSeeAllTheSculptureArtPieces() {
        artGalleryPage.checkAllSculptureArtDisplayed();
    }
}
