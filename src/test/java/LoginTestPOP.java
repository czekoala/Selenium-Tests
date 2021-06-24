import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTestPOP extends SeleniumBaseTest {

    @Test
    public void correctLoginTest() {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .assertWelcomeElementIsShown();
    }
}
