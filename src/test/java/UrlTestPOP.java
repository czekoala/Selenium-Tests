import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UrlTestPOP extends SeleniumBaseTest{

    @DataProvider
    public static Object[][] address() {
        return new Object[][]{
                {"a[href$='/']","http://qaaghspclab.northeurope.cloudapp.azure.com/"},
                {"a[href$='/Projects']","http://qaaghspclab.northeurope.cloudapp.azure.com/Projects"},
                {"a[href$='/Characteristics']","http://qaaghspclab.northeurope.cloudapp.azure.com/Characteristics"}
        };
    }

    @Test(dataProvider = "address")
    public void correctLoginTest(String urlHref, String address) {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToUrl(urlHref)
                .assertCurrentUrl(address);

    }
}