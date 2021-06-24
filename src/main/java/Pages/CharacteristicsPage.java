package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CharacteristicsPage extends HomePage {

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//tbody//td[text()='%s']/..";
    private String GENERIC_CHARACTERISTIC_REPORT_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Report')]";
    private String GENERIC_CHARACTERISTIC_RESULTS_XPATH = "//td[text()='%s']/..//a[contains(@href, 'Results')]";

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-title h3")
    private WebElement pageHeader;

    @FindBy(linkText = "Add new characteristic")
    private WebElement addCharacteristicBtn;

    public CreateCharacteristicPage clickAddCharacteristic() {
        addCharacteristicBtn.click();
        return new CreateCharacteristicPage(driver);
    }

    public CharacteristicsPage assertCharacteristicsUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader() {
        Assert.assertEquals(pageHeader.getText(), "Characteristics");

        return this;
    }

    public CharacteristicsPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);

        return this;
    }

    public CharacteristicsPage assertCharacteristicIsNotShown(String characteristicName) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, characteristicName);
        List<WebElement> characteristicRow = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertEquals(((List<?>) characteristicRow).size(), 0);

        return this;
    }

    public ResultsPage gotToResults(String characteristicName) {
        String resultsBtnXpath = String.format(GENERIC_CHARACTERISTIC_RESULTS_XPATH, characteristicName);
        driver.findElement(By.xpath(resultsBtnXpath)).click();

        return new ResultsPage(driver);
     }

    public ReportPage goToReport(String characteristicName){
        String reportBtnXpath = String.format(GENERIC_CHARACTERISTIC_REPORT_XPATH, characteristicName);
        driver.findElement(By.xpath(reportBtnXpath)).click();

        return new ReportPage(driver);
    }
}

