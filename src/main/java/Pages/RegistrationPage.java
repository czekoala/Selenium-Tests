package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RegistrationPage {
    protected WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;

    public RegistrationPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public RegistrationPage typeConfirmPassword(String password) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitRegistration() {
        registerBtn.click();
        return new HomePage(driver);
    }

    public RegistrationPage submitRegistrationFailure() {
        registerBtn.click();
        return new RegistrationPage(driver);
    }

    public RegistrationPage assertRegistrationFailure(String expError) {
        boolean doesErrorExists = confirmPasswordErrorTxt.getText().equals(expError);
        Assert.assertTrue(doesErrorExists);
        return this;
    }
    public RegistrationPage assertRegistrationFailureValidation(String expError) {
        boolean doesErrorExists = loginErrors.get(0).getText().equals(expError);
        Assert.assertTrue(doesErrorExists);
        return this;
    }

}