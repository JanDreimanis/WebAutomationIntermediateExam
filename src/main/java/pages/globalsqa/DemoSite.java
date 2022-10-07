package pages.globalsqa;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import page.objects.Button;
import page.objects.TextField;
import pages.BasePage;
import utilities.Locator;

public class DemoSite extends BasePage {

    public DemoSite(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }


    public static WebElement autoCompleteButton =
           TestBase.getDriver().findElementByXPath( "//div[@class='row price_table_holder col_4']/div[2]/ul/li[6]/a");


    public static void clickAutoCompleteButton() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor)TestBase.getDriver();
        executor.executeScript("arguments[0].click();", autoCompleteButton);
    }



}
