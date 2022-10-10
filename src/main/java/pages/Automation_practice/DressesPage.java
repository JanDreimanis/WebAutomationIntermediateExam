package pages.Automation_practice;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utilities.ExtentTestManager;
import utilities.Locator;

public class DressesPage extends BasePage {
    public DressesPage(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }

    public static void selectValueInSortingField(String value) {
        Select sorting = new Select(TestBase.getDriver().findElement(By.id("selectProductSort"))); //Safe for nullpointer
        sorting.selectByVisibleText(value);
        ExtentTestManager.logInfo("Selected " + value);
    }
}
