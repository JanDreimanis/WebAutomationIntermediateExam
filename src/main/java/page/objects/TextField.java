package page.objects;

import common.CommonLogic;
import common.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ExtentTestManager;
import utilities.Locator;
import utilities.PageElementType;

public class TextField extends BasePageElement {
    public TextField(String elementName, Locator elementLocator) {
        super(elementName, elementLocator);
        this.type = PageElementType.TEXT_FIELD;
    }

    public void textInput(String text) {
        WebElement field = TestBase.getElement(this.locator);
        if (field != null) {
            field.sendKeys(text);
            ExtentTestManager.logInfo("Entered :" + " '" + text + "' " + " in " + this.type.getName() + " '" + this.name + "'");
        } else {
            CommonLogic.validationFail("Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
    }

    public void clearInputField() {
        WebElement field = TestBase.getElement(this.locator);
        if (field != null) {
            field.clear();
            ExtentTestManager.logInfo("Cleared text in " + this.type.getName() + " '" + this.name + "'");
        } else {
            CommonLogic.validationFail("Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
    }

    public String getText() {
        WebElement field = TestBase.getElement(this.locator);
        if (field != null) {
            return field.getText();

        }
        return null;

    }
}
