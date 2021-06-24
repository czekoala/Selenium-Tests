import Pages.LoginPage;
import org.testng.annotations.Test;

public class CheckIfProcessIsInDashboardTestPOP extends SeleniumBaseTest {

    @Test
    public void correctLoginTest() {
        String name = "Process " + System.currentTimeMillis();
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(name)
                .typeDescription("Description")
                .typeNotes("Notes")
                .submitCreate()
                .goToDashboard()
                .assertProcessOnDashboard(name);
    }
}
