package pages.Automation_practice;

import common.TestBase;
import org.openqa.selenium.WebElement;
import page.objects.TextField;
import pages.BasePage;
import utilities.ExtentTestManager;
import utilities.Locator;

import java.util.ArrayList;
import java.util.List;

public class WomenPage extends BasePage {

    public WomenPage(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }

    public static TextField womenPageSearchField = new TextField("Search field",
            new Locator(Locator.LocatorType.ID,"search_query_top"));

    public static void getElementsFromGrid() {
        int counter = 1;
        List<String> rowList = new ArrayList<>();
        List<String> productList = new ArrayList<>();

        rowList.add("//*[@class='product_list grid row']/li[1]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[2]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[3]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[4]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[5]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[6]/div/div[2]/h5/a");
        rowList.add("//*[@class='product_list grid row']/li[7]/div/div[2]/h5/a");

        for (String row: rowList
            ) {
            WebElement element = TestBase.getDriver().findElementByXPath(row);
            productList.add(element.getText());
        }
        for (String product : productList
             ) {
            ExtentTestManager.logInfo("Logged product " + counter + " : " + product);
            counter++;
        }
    }
}
