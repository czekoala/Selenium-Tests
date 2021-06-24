package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReportPage {
    protected WebDriver driver;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Mean (x)']/../td[2]")
    private WebElement meanCell;

    public ReportPage assertMean(String expMean){
        Assert.assertEquals(meanCell.getText(), expMean);

        return this;
    }
}
