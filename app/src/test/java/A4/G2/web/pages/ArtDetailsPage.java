package A4.G2.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArtDetailsPage {

	public ArtDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="shareButton")
	private WebElement shareButton;

	@FindBy(how=How.ID, using ="generatedLink")
	private WebElement generatedLink;

	public void clickShare(){
		this.shareButton.click();
	}

	public String getGeneratedLink(){
		return this.generatedLink.getText();
	}



}