import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UrlTest {

    @DataProvider
    public static Object[][] address() {
        return new Object[][]{
                {"a[href$='/']","http://localhost:4444/"},
                {"a[href$='/Projects']","http://localhost:4444/Projects"},
                {"a[href$='/Characteristics']","http://localhost:4444/Characteristics"}
        };
    }

    @Test(dataProvider = "address")
    public void correctLoginTest(String urlHref, String address) {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://localhost:4444/");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("test@test.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();

        WebElement dashboardA = driver.findElement(By.cssSelector(urlHref));
        System.out.println(dashboardA.getAttribute("href"));
        System.out.println(address);
        driver.get(dashboardA.getAttribute("href"));

        Assert.assertTrue(driver.getCurrentUrl().contains(address));

        driver.quit();
    }
}