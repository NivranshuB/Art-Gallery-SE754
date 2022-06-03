package A4.G2.stepdefs;

import A4.G2.pages.AddArtPage;
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
        addArtPage = new AddArtPage(driver);
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

    @And("I press the submit button")
    public void iPressTheSubmitButton() {
        addArtPage.clickSubmit();
    }

    @And("I enter {string} as image field")
    public void iEnterAsImageField(String string) {
        addArtPage.insertImage(string);
    }

    @And("I enter {string} as buyNow price field")
    public void iEnterAsBuyNowPriceField(String string) {
        addArtPage.insertBuyNowPrice(string);
    }

    @Then("I should see the new art displayed")
    public void iShouldSeeTheNewArtDisplayed() {
        assertTrue(addArtPage.getMessage().contains("Art titled: \"Title\" successfully added"));
    }


    @Then("I should see the new art displayed with buyNow")
    public void iShouldSeeTheNewArtDisplayedWithBuyNow() {
        assertTrue(addArtPage.getMessage().contains("Art titled: \"Title\" successfully added with buy-now listing"));
    }
}
