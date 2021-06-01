import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    @Test
    public void correctRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://localhost:4444/Account/Register");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("user"+System.currentTimeMillis()+"@gmail.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys("Test1!");

        WebElement confirmPasswordTxt = driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmPasswordTxt.sendKeys("Test1!");

        WebElement registerBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        registerBtn.click();

        WebElement welcomeElm = driver.findElement(By.cssSelector(".profile_info>h2"));

        Assert.assertTrue(welcomeElm.getText().contains("Welcome"));

        driver.quit();
    }
}