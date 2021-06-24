package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    protected WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Add results sample")
    private WebElement addResultsBtn;

    @FindBy(linkText = "Back to characteristics")
    private WebElement backBtn;

    public Pages.CreateResultsPage clickAddResults(){
        addResultsBtn.click();

        return new Pages.CreateResultsPage(driver);
    }

    public CharacteristicsPage backToCharacteristics(){
        backBtn.click();
        return new CharacteristicsPage(driver);
    }
}
