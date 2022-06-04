package A4.G2.web.stepdefs;

import A4.G2.web.pages.VirtualGalleryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualGallery {
    private WebDriver driver;
    private VirtualGalleryPage virtualGalleryPage;

    @Given("Driver set up for virtual gallery page")
    public void driver_set_up_for_login_page() {
        driver = Hooks.getDriver();
        virtualGalleryPage = new VirtualGalleryPage(driver);
    }

    @Given("I access virtual gallery page")
    public void i_access_virtual_gallery_page() {
        driver.get("http://localhost:8080/virtual-gallery");
    }

    @When("I click on the art description button")
    public void i_click_on_the_art_description_button() {
        virtualGalleryPage.clickArtDescription();
    }

    @Then("I should see title and photo of all the artworks displayed in a compact card")
    public void i_should_see_title_and_photo_of_artworks() throws Throwable{
        List<String> titles = Arrays.asList("Art 1", "Art 2", "Art 3");
        List<String> images = Arrays.asList("src/test/java/A4/G2/model/artwork/testImage1",
                "src/test/java/A4/G2/model/artwork/testImage2",
                "src/test/java/A4/G2/model/artwork/testImage3");
        this.virtualGalleryPage.checkArtworks(titles, images);
    }
}
