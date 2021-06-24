import Pages.LoginPage;
import org.testng.annotations.Test;

public class RegistrationWithFailureTestPOP extends SeleniumBaseTest {

    @Test
    public void incorrectRegistrationTest() {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("user"+System.currentTimeMillis()+"@gmail.com")
                .typePassword("Test1!")
                .typeConfirmPassword("Test1!a")
                .submitRegistrationFailure()
                .assertRegistrationFailure("The password and confirmation password do not match.");
    }
}
