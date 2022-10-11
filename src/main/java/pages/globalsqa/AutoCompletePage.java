package pages.globalsqa;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.objects.TextField;
import pages.BasePage;
import utilities.ExtentTestManager;
import utilities.Locator;

public class AutoCompletePage extends BasePage {
    public AutoCompletePage(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }

    public static TextField searchField = new TextField(
            "Search field", new Locator(Locator.LocatorType.XPATH, "//input[@id='search']"));

    public static void inputText(String text) {
        WebElement iframe = TestBase.getElement(new Locator(Locator.LocatorType.XPATH,"//*[@id=\"post-2656\"]/div[2]/div/div/div[1]/p/iframe"));
        TestBase.getDriver().switchTo().frame(iframe);
        searchField.textInput(text);
    }

    public static void selectValue() {
        WebElement sorting = TestBase.getElement(new Locator(Locator.LocatorType.XPATH,"//*[@id='ui-id-1']/li[4]/div"));
        if (sorting != null) {
            sorting.click();
        }
        ExtentTestManager.logInfo("Selected Anders andersson");  //Var labāk protams.
    }




}

