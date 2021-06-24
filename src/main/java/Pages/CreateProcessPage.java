package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CreateProcessPage extends HomePage {

    public CreateProcessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(id = "Description")
    private WebElement descriptionTxt;

    @FindBy(id = "Notes")
    private WebElement notesTxt;

    @FindBy(linkText = "Back to List")
    private WebElement backToListBtn;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=Name]")
    private WebElement nameError;

    public CreateProcessPage typeName(String processName) {
        nameTxt.clear();
        nameTxt.sendKeys(processName);

        return this;
    }
    public CreateProcessPage typeDescription(String processName) {
        descriptionTxt.clear();
        descriptionTxt.sendKeys(processName);

        return this;
    }
    public CreateProcessPage typeNotes(String processName) {
        notesTxt.clear();
        notesTxt.sendKeys(processName);

        return this;
    }

    public ProcessesPage backToList() {
        backToListBtn.click();

        return new ProcessesPage(driver);
    }

    public ProcessesPage submitCreate() {
        createBtn.click();

        return new ProcessesPage(driver);
    }

    public CreateProcessPage submitCreateWithFailure() {
        createBtn.click();

        return this;
    }

    public CreateProcessPage assertProcessNameError(String expError) {
        Assert.assertEquals(nameError.getText(), expError);

        return this;
    }
}
