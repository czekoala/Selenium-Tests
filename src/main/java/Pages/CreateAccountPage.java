package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    public WebElement emailTxt;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage submitRegisterWithFailure() {
        registerBtn.click();
        return this;
    }

    public CreateAccountPage assertEmailErrorIsShown() {
        Assert.assertTrue(emailError.isDisplayed());
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }


}
