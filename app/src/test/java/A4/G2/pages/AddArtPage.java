package A4.G2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddArtPage {

    public AddArtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "title")
    private WebElement title;

    @FindBy(how = How.ID, using = "description")
    private WebElement description;

    @FindBy(how = How.ID, using = "artType")
    private WebElement artType;

    @FindBy(how = How.ID, using = "artistName")
    private WebElement artistName;

    @FindBy(how = How.ID, using = "fileOfImage")
    private WebElement image;

    @FindBy(how = How.ID, using = "dimensions")
    private WebElement dimensions;

    @FindBy(how = How.ID, using = "addArtBtn")
    private WebElement addArtButton;

    @FindBy(how = How.ID, using = "submitNewArtBtn")
    private WebElement submitNewArtButton;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    public void insertTitle(String title) {
        this.title.sendKeys(title);
    }

    public void insertDescription(String description) {
        this.description.sendKeys(description);
    }

    public void insertDimension(String dimensions) {
        this.dimensions.sendKeys(dimensions);
    }

    public void selectArtType(String artType) {
        this.artType.click();
        List<WebElement> l = this.artType.findElements(By.cssSelector("option"));
        WebElement optionElement = l.get(Integer.parseInt(artType));
        if (optionElement == null) {
            // optionally throw error
            return;
        }
        optionElement.click();
    }

    public void insertArtistName(String name) {
        this.artistName.sendKeys(name);
    }

    public void insertImage(String imageFile) {
        this.image.sendKeys(imageFile);
    }

    public void clickSubmit() {
        this.submitNewArtButton.click();
    }

    public String getMessage() {
        return this.message.getText();
    }


}
