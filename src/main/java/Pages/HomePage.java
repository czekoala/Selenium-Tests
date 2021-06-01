package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends SeleniumPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".profile_info>h2")
    private WebElement welcomeElm;

    @FindBy(css = ".menu-workspace")
    private WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    private WebElement processesMenu;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardMenu;

    @FindBy(css = "a[href$='/Characteristics']")
    private WebElement characteristicsMenu;

    @FindBy(css = ".menu-home")
    private WebElement homeNav;

    @FindBy(css = "a.user-profile")
    private WebElement userProfile;

    @FindBy(css = "a[href*=Logout]")
    private WebElement logoutLnk;


    public HomePage assertWelcomeElementIsShown() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '" + welcomeElm.getText() + "' does not contain word 'Welcome'");
        return this;
    }

//    public ProcessesPage goToProcesses() {
//        if (!isParentExpanded(workspaceNav)) {
//            workspaceNav.click();
//        }
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(processesMenu));
//
//        processesMenu.click();
//        return new ProcessesPage(driver);
//    }
//
//    public CharacteristicsPage goToCharacteristics() {
//        if (!isParentExpanded(workspaceNav)) {
//            workspaceNav.click();
//        }
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(characteristicsMenu));
//
//        characteristicsMenu.click();
//        return new CharacteristicsPage(driver);
//    }
//
//    public DashboardPage goToDashboard() {
//        if (!isParentExpanded(homeNav)) {
//            homeNav.click();
//        }
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(dashboardMenu));
//
//        dashboardMenu.click();
//        return new DashboardPage(driver);
//    }

    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("active");
    }

    public LoginPage logout() {
        userProfile.click();
        logoutLnk.click();

        return new LoginPage(driver);
    }

}

