package A5.G2.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShareArtStepDefinitions {

	private WebDriver driver;
	private String url;
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		this.url = driver.getCurrentUrl();
	}

	@When("I click on the share button")
	public void iClickOnTheShareButton() {
		driver.findElement(By.id("shareButton")).click();
	}

	@Then("I want to generate a link of the art piece to share")
	public void iWantToGenerateALinkOfTheArtPieceToShare() {
		String link = driver.findElement(By.id("generatedLink")).getText();
		assertEquals(link, url);
	}
}
