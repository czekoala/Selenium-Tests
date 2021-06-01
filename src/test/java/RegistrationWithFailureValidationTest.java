import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationWithFailureValidationTest {

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][] {
                { "test1!", "Passwords must have at least one uppercase ('A'-'Z')." }, //.text-danger validation-summary-errors>ul>li
                { "Test!@", "Passwords must have at least one digit ('0'-'9')." },  //.text-danger validation-summary-errors>ul>li
                { "Test11", "Passwords must have at least one non alphanumeric character." }  //.text-danger validation-summary-errors>ul>li
        };
    }

    @Test (dataProvider = "wrongPasswords")
    public void incorrectRegistrationTest(String password, String expErrorMessage) {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://localhost:4444/Account/Register");

        WebElement emailTxt = driver.findElement(By.cssSelector("#Email"));
        emailTxt.sendKeys("user"+System.currentTimeMillis()+"@gmail.com");

        WebElement passwordTxt = driver.findElement(By.cssSelector("#Password"));
        passwordTxt.sendKeys(password);

        WebElement confirmPasswordTxt = driver.findElement(By.cssSelector("#ConfirmPassword"));
        confirmPasswordTxt.sendKeys(password);

        WebElement registerBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        registerBtn.click();

        WebElement autoOptions =driver.findElement(By.className("text-danger"));
        List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
        optionsToSelect.get(0).getText();


        Assert.assertTrue(optionsToSelect.get(0).getText().contains(expErrorMessage));

        driver.quit();
    }
}