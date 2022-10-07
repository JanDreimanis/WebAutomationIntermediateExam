package pages.globalsqa;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.objects.TextField;
import pages.BasePage;
import utilities.Locator;

public class AutoCompletePage extends BasePage {
    public AutoCompletePage(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }
    public static TextField searchField = new TextField(
            "Search field", new Locator(Locator.LocatorType.XPATH, "//input[@id='search']"));
    public static void inputText() {
        WebElement iframe = TestBase.getDriver().findElementByXPath("//*[@id=\"post-2656\"]/div[2]/div/div/div[1]/p/iframe");
        TestBase.getDriver().switchTo().frame(iframe);
        searchField.textInput("and");
    }
    public static void selectValueInSortingField() {
        WebElement sorting = TestBase.getDriver().findElement(By.xpath("//*[@id='ui-id-1']/li[4]/div")); //Safe for nullpointer
        sorting.click();
    }
}
