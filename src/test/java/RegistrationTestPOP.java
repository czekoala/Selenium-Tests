import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTestPOP extends SeleniumBaseTest {

    @Test
    public void correctLoginTestWithChaining() {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("user"+System.currentTimeMillis()+"@gmail.com")
                .typePassword("Test1!")
                .typeConfirmPassword("Test1!")
                .submitRegistration()
                .assertWelcomeElementIsShown();
    }
}
