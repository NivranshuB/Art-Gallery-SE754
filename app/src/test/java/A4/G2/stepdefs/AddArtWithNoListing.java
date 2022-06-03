package A4.G2.stepdefs;

import A4.G2.pages.ArtGalleryPage;
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

public class AddArtWithNoListing {
    private WebDriver driver;
    private ArtGalleryPage artGalleryPage;

    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (System.getenv("headless") != null && System.getenv("headless").equals("true")) {
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1200");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        artGalleryPage = new ArtGalleryPage(driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv("headless") == null || !System.getenv("headless").equals("true")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("I am on the art page")
    public void iAmOnTheArtPage() {
        driver.get("http://localhost:8080/artGallery");
    }

    @And("I press the add art button")
    public void iPressTheAddArtButton() {
        artGalleryPage.clickAddArt();
    }

    @When("I enter {string} as title field")
    public void iEnterAsTitleField(String string) {
        artGalleryPage.insertTitle(string);
    }

    @And("I enter {string} as description field")
    public void iEnterAsDescriptionField(String string) {
        artGalleryPage.insertDescription(string);
    }

    @And("I select {string} as art type")
    public void iSelectAsArtType(String string) {
        artGalleryPage.insertArtType(string);
    }

    @And("I enter {string} as dimension field")
    public void iEnterAsDimensionField(String string) {
        artGalleryPage.insertDimension(string);
    }

    @And("I enter {string} as artist name field")
    public void iEnterAsArtistNameField(String string) {
        artGalleryPage.insertArtistName(string);
    }

    @And("I press the submit button")
    public void iPressTheSubmitButton() {
        artGalleryPage.clickSubmit();
    }

    @And("I upload test image as image")
    public void iUploadTestImageAsImage(String pathToImage) {
        artGalleryPage.uploadImage(pathToImage);
    }

    @Then("I should see the new art displayed")
    public void iShouldSeeTheNewArtDisplayed() {
        assertTrue(artGalleryPage.getMessage().contains("Art Title successfully added"));
    }



}
