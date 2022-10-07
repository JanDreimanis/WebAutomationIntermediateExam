package pages.globalsqa;

import page.objects.TextField;
import pages.BasePage;
import utilities.Locator;

public class SamplePageTest extends BasePage {

    public SamplePageTest(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }

    public static TextField nameField = new TextField("Name field",
            new Locator(Locator.LocatorType.ID, "g2599-name"));

    public static TextField emailField = new TextField("Email field",
            new Locator(Locator.LocatorType.ID, "g2599-email"));

    public static void fillForm(String name, String email) {
        nameField.textInput(name);
        emailField.textInput(email);
    }

    public static void clearForm() {
        nameField.clearInputField();
        emailField.clearInputField();
    }


}
