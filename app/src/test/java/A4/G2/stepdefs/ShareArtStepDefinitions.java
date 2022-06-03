package A4.G2.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ArtDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareArtStepDefinitions {
	private ArtDetailsPage artDetailsPage;
	private WebDriver driver;
	@Before
	public void setup(){

		System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
		driver = new ChromeDriver();
		this.artDetailsPage = new ArtDetailsPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait((long)30, TimeUnit.SECONDS);
	}

	@AfterStep
	public void afterEachStep(){
		// to make the test at human speed
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("I access an art details page")
	public void iAccessAnArtDetailsPage() {
		driver.get("http://localhost:8080/art-details");
	}

	@When("I click on the share button")
	public void iClickOnTheShareButton() {
		artDetailsPage.clickShare();
	}

	@Then("I want to generate a link of the art piece to share")
	public void iWantToGenerateALinkOfTheArtPieceToShare() {
		String url = driver.getCurrentUrl();
		String link = artDetailsPage.getGeneratedLink();
		assertEquals(url, link);
	}
}
