package A4.G2.web.stepdefs;

import A4.G2.web.pages.ArtDetailsPage;
import A4.G2.web.pages.EditArtPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class EditArtStepDefinitions {
    private WebDriver driver;
    private EditArtPage editArtPage;
    private ArtDetailsPage artDetailsPage;

    @Given("Driver set up for edit art page")
    public void driverSetUpForEditArtPage(){
        driver = Hooks.getDriver();
        editArtPage = new EditArtPage(driver);
        artDetailsPage = new ArtDetailsPage(driver);
    }
    @Given("I am on an edit art details page for {string}")
    public void iAmOnAnEditArtDetailsPageFor(String string) {
        driver.get("http://localhost:8080/edit-art?ID="+string);
    }


    @When("I enter {string} as edit title field")
    public void iEnterAsEditTitleField(String string) {
        editArtPage.insertNewTitle(string);
    }

    @And("I click on the submit edit button")
    public void iClickOnTheSubmitEditButton() {
        editArtPage.clickSubmit();
    }

    @Then("I should see successfully edit message")
    public void iShouldSeeSuccessfullyEditMessage() {
        assertTrue(editArtPage.getMessage().contains("Art successfully edited"));
    }


}
