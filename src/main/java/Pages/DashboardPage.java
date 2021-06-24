package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardPage extends HomePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='DEMO PROJECT']")
    private WebElement demoProjectHeader;

    @FindBy(linkText = "Create your first process")
    private WebElement createFirstProjectBtn;

    public DashboardPage assertDashboardUrl(String pageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), pageUrl);

        return this;
    }

    public DashboardPage assertDemoProjectIsShown() {
        Assert.assertTrue(isElementPresent(demoProjectHeader) || isElementPresent(createFirstProjectBtn));

        return this;
    }
    public DashboardPage assertProcessOnDashboard (String name) {
        Assert.assertTrue(driver.getPageSource().contains(name));
        return this;
    }

}
