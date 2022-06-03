package A4.G2.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ArtDetailsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PurchaseBuyNowStepDefinitions {
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

	@Given("I am on the details page for a piece of art")
	public void iAmOnTheDetailsPageForAPieceOfArt() {
		driver.get("http://localhost:8080/art-details");
	}

	@When("I click the Buy Now button")
	public void iClickTheBuyNowButton() {
		artDetailsPage.clickBuyNow();
	}

	@And("I am not logged into an account")
	public void iAmNotLoggedIntoAnAccount() {
		assertEquals("Not logged in",artDetailsPage.getLoginStatus());
	}

	@Then("Deny the buying attempt")
	public void denyTheBuyingAttempt() {
		assertEquals(driver.getCurrentUrl(),"http://localhost:8080/art-details");
	}

	@And("Notify me to sign up or sign in")
	public void notifyMeToSignUpOrSignIn() {
		String notification = "Please sign up or log in.";
		String getNotification = artDetailsPage.getLoginNotification();
		Assertions.assertEquals(notification, getNotification);
	}
}
