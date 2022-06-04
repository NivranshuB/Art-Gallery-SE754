package A4.G2.web.stepdefs;

import A4.G2.web.pages.AddArtPage;
import A4.G2.web.pages.RemoveArtPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageExistingArtStepDefinitions {
    private WebDriver driver;
    private RemoveArtPage removeArtPage;
    @Given("Driver set up for remove art page")
    public void driverSetUpForRemoveArtPage() {
        driver = Hooks.getDriver();
        removeArtPage = new RemoveArtPage(driver);
    }

    @Given("I am on the remove art page")
    public void iAmOnTheRemoveArtPage() {
        driver.get("http://localhost:8080/remove-art");
    }

    @When("I enter {string} as remove id field")
    public void iEnterAsRemoveIdField(String string) {
        removeArtPage.insertIdToRemove(string);
    }

    @Then("I should art successfully remove message")
    public void iShouldArtSuccessfullyRemoveMessage() {
        assertTrue(removeArtPage.getMessage().contains("Art titled: \"Title\" successfully removed"));
    }
}

