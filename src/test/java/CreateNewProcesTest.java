import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateNewProcesTest {

    @Test
    public void createNewProcess() {
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

        WebElement processesLinkPage = driver.findElement(By.cssSelector("a[href$='/Projects'"));
        System.out.println(processesLinkPage.getAttribute("href"));

        driver.get(processesLinkPage.getAttribute("href"));

        WebElement processesCreateButton = driver.findElement(By.cssSelector("a[href$='/Projects/Create'"));
        System.out.println(processesCreateButton.getAttribute("href"));

        driver.get(processesCreateButton.getAttribute("href"));

        String name = "Process "+ System.currentTimeMillis();
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

        WebElement autoOptions =driver.findElement(By.className("jambo_table"));
//        List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("tr>td"));
//        System.out.println(optionsToSelect.get(0).getText());
        System.out.println(autoOptions.toString());
        System.out.println(autoOptions.getText().contains(notes));
      /*  Assert.assertTrue(driver.getCurrentUrl().contains("address"));
        Assert.assertTrue(driver.getCurrentUrl().contains("address"));
        Assert.assertTrue(driver.getCurrentUrl().contains("address"));*/
        System.out.println();

        Assert.assertTrue(autoOptions.getText().contains(name)
                && autoOptions.getText().contains(description)
                && autoOptions.getText().contains(notes));

        driver.quit();
    }
}