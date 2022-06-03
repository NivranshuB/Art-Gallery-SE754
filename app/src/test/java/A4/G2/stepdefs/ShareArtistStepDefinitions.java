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
import pages.ArtistDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareArtistStepDefinitions {

	private ArtistDetailsPage artistDetailsPage;
	private WebDriver driver;
	@Before
	public void setup(){

		System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
		driver = new ChromeDriver();
		this.artistDetailsPage = new ArtistDetailsPage(driver);
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

	@Given("I access an artist's profile page")
	public void iAccessAnArtistSProfilePage() {
		driver.get("http://localhost:8080/artist-details");
	}

	@When("I click on the share artist button")
	public void iClickOnTheShareArtistButton() {
		artistDetailsPage.clickShare();
	}

	@Then("I want to generate a link of the artist profile to share")
	public void iWantToGenerateALinkOfTheArtistProfileToShare() {
		String url = driver.getCurrentUrl();
		String link = artistDetailsPage.getGeneratedArtistLink();
		assertEquals(url, link);
	}
}
