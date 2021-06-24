package Pages;

import Pages.CreateAccountPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(id = "Email-error")
    public WebElement emailError;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;

    @FindBy(css = ".flash-message>strong")
    private WebElement logoutMsg;

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();
        return this;
    }


    //do 9
    public LoginPage assertLoginErrorIsShown(String expError) {
        boolean doesErrorExists = loginErrors
                .stream()
                .anyMatch(validationError -> validationError.getText().equals(expError));
        Assert.assertTrue(doesErrorExists);
        return this;
    }

    //do 10
    public LoginPage assertEmailErrorIsShown() {
        Assert.assertTrue(emailError.isDisplayed());
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }

    public LoginPage assertUserSuccessfullyLogOut() {
        Assert.assertTrue(logoutMsg.isDisplayed());
        Assert.assertEquals(logoutMsg.getText(), "User succesfully logged out");

        return this;
    }
    public RegistrationPage goToRegisterPage() {
        registerLnk.click();
        return new RegistrationPage(driver);
    }
}
