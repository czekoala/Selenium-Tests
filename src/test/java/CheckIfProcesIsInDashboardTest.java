import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckIfProcesIsInDashboardTest {
    WebDriver driver;

    @BeforeMethod
    public void baseBeforeMethod() {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void baseAfterMethod() {
        driver.quit();
    }

    @Test
    public void CheckIfProcesIsInDashboard () {
        driver.get("http://localhost:4444/");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement processesLinkPage = driver.findElement(By.cssSelector("a[href$='/Projects'"));
        System.out.println(processesLinkPage.getAttribute("href"));

        driver.get(processesLinkPage.getAttribute("href"));

        WebElement processesCreateButton = driver.findElement(By.cssSelector("a[href$='/Projects/Create'"));
        System.out.println(processesCreateButton.getAttribute("href"));

        driver.get(processesCreateButton.getAttribute("href"));

        String name = "Process " + System.currentTimeMillis();
        String description = "Description";
        String notes = "Notes";

        WebElement nameTxt = driver.findElement(By.cssSelector("#Name"));

        nameTxt.sendKeys(name);

        WebElement descriptionTxt = driver.findElement(By.cssSelector("#Description"));
        descriptionTxt.sendKeys(description);

        WebElement notesTxt = driver.findElement(By.cssSelector("#Notes"));
        notesTxt.sendKeys(notes);

        WebElement createProcessInput = driver.findElement(By.cssSelector("input[value=Create]"));
        createProcessInput.click();

        driver.get("http://localhost:4444/");
        WebElement autoOptions = driver.findElement(By.className("right_col"));

        Assert.assertTrue(autoOptions.getText().contains(name));
    }
}