import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationWithFailureValidationTestPOP extends SeleniumBaseTest {

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][] {
                { "test1!", "Passwords must have at least one uppercase ('A'-'Z')." },
                { "Test!@", "Passwords must have at least one digit ('0'-'9')." },
                { "Test11", "Passwords must have at least one non alphanumeric character." }
        };
    }

    @Test (dataProvider = "wrongPasswords")
    public void incorrectRegistrationTest(String wrongPassword,String errorInfo) {
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail("user"+System.currentTimeMillis()+"@gmail.com")
                .typePassword(wrongPassword)
                .typeConfirmPassword(wrongPassword)
                .submitRegistrationFailure()
                .assertRegistrationFailureValidation(errorInfo);
    }
}
