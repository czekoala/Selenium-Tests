import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationWithFailureValidationTestPOP extends SeleniumBaseTest {

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][] {
                { "test1!", "Passwords must have at least one uppercase ('A'-'Z')." }, //.text-danger validation-summary-errors>ul>li
                { "Test!@", "Passwords must have at least one digit ('0'-'9')." },  //.text-danger validation-summary-errors>ul>li
                { "Test11", "Passwords must have at least one non alphanumeric character." }  //.text-danger validation-summary-errors>ul>li
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
