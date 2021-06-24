import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateIncorrectNewProcessTestPOP extends SeleniumBaseTest {

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][]{
                {"", "Description", "Notes", "The Name field is required."},
                {"ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", "Description", "Notes", "The field Name must be a string with a minimum length of 3 and a maximum length of 30."},
                {"Aleksandra", "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut mollis volutpat justo, nec commodo elit. Vivamus maximus leo non nibh vehicula pharetra. Duis quis fermentum sem, et pulvinar quam. Donec pulvinar felis eu massa vehicula, ac iaculis neque pharetra. Nam placerat tellus id nibh venenatis dictum. Sed in enim a ex facilisis maximus ac sed elit. Praesent vitae sodales eros. Proin non hendrerit nulla. Cras ullamcorper erat ac nisl luctus tempor.\n" +
                        "\n" +
                        "Duis sed tortor pellentesque, dignissim lacus vel, feugiat massa. Nullam eget ipsum mi. Aenean tincidunt finibus nisi nec ultricies. In id tortor at eros euismod mattis. Curabitur sodales faucibus venenatis. Nullam cursus, urna ut accumsan venenatis, felis odio tincidunt nibh, ut molestie velit sem sed justo. Donec pharetra convallis turpis a fermentum. Aenean eget mauris est. Fusce ac rutrum sem.\n" +
                        "\n" +
                        "Nam fringilla felis ut felis hendrerit imperdiet. Vivamus venenatis, libero id pharetra cursus, erat metus pharetra mi, sit amet blandit dolor urna vel arcu. Nunc ultricies est non elit varius accumsan. Nunc facilisis ac quam at euismod. Donec scelerisque dolor lacus, in posuere metus venenatis vitae. Pellentesque et neque fermentum urna fermentum tincidunt. Nulla facilisi. Quisque laoreet tellus sapien, at consectetur ligula tincidunt eget. Curabitur vitae felis eleifend, sollicitudin dui vitae, fermentum ligula.\n" +
                        "\n" +
                        "Nunc vel rutrum nibh. Maecenas sit amet placerat ex. Etiam ut metus porttitor, euismod dolor nec, finibus elit. Proin volutpat justo risus. Etiam tempus volutpat erat, eget commodo ipsum luctus sit amet. Morbi posuere lobortis est, nec vulputate lacus placerat nec. Sed et vestibulum nunc. Nulla urna massa, ultrices sit amet erat.", "Notes", "The field Description must be a string with a maximum length of 256."},
                {"Aleksandra", "Description", "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut mollis volutpat justo, nec commodo elit. Vivamus maximus leo non nibh vehicula pharetra. Duis quis fermentum sem, et pulvinar quam. Donec pulvinar felis eu massa vehicula, ac iaculis neque pharetra. Nam placerat tellus id nibh venenatis dictum. Sed in enim a ex facilisis maximus ac sed elit. Praesent vitae sodales eros. Proin non hendrerit nulla. Cras ullamcorper erat ac nisl luctus tempor.\n" +
                        "\n" +
                        "Duis sed tortor pellentesque, dignissim lacus vel, feugiat massa. Nullam eget ipsum mi. Aenean tincidunt finibus nisi nec ultricies. In id tortor at eros euismod mattis. Curabitur sodales faucibus venenatis. Nullam cursus, urna ut accumsan venenatis, felis odio tincidunt nibh, ut molestie velit sem sed justo. Donec pharetra convallis turpis a fermentum. Aenean eget mauris est. Fusce ac rutrum sem.\n" +
                        "\n" +
                        "Nam fringilla felis ut felis hendrerit imperdiet. Vivamus venenatis, libero id pharetra cursus, erat metus pharetra mi, sit amet blandit dolor urna vel arcu. Nunc ultricies est non elit varius accumsan. Nunc facilisis ac quam at euismod. Donec scelerisque dolor lacus, in posuere metus venenatis vitae. Pellentesque et neque fermentum urna fermentum tincidunt. Nulla facilisi. Quisque laoreet tellus sapien, at consectetur ligula tincidunt eget. Curabitur vitae felis eleifend, sollicitudin dui vitae, fermentum ligula.\n" +
                        "\n" +
                        "Nunc vel rutrum nibh. Maecenas sit amet placerat ex. Etiam ut metus porttitor, euismod dolor nec, finibus elit. Proin volutpat justo risus. Etiam tempus volutpat erat, eget commodo ipsum luctus sit amet. Morbi posuere lobortis est, nec vulputate lacus placerat nec. Sed et vestibulum nunc. Nulla urna massa, ultrices sit amet erat.", "The field Notes must be a string with a maximum length of 256."}


        };
    }

    @Test(dataProvider = "wrongPasswords")
    public void correctLoginTest(String name,String description,String notes, String errorInfo) {
        new LoginPage(driver)
                .typeEmail("test@test.com")
                .typePassword("Test1!")
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(name)
                .typeDescription(description)
                .typeNotes(notes)
                .submitCreate()
                .assertProcessOnProcesses(errorInfo);

    }
}
