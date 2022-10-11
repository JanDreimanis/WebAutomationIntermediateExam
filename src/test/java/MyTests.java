import com.aventstack.extentreports.Status;
import common.TestBase;
import common.data.providers.globalsqa.SamplePageTestDataProvider;
import common.pages.AutomationPracticePages;
import common.pages.GlobalSqaPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Automation_practice.AutomationPracticeHomePage;
import pages.Automation_practice.DressesPage;
import pages.Automation_practice.WomenPage;
import pages.globalsqa.AutoCompletePage;
import pages.globalsqa.DemoSite;
import pages.globalsqa.SamplePageTest;
import utilities.ExtentTestManager;
import utilities.Locator;
import utilities.listeners.MyListener;

import java.io.IOException;


@Listeners({MyListener.class})
public class MyTests extends SamplePageTestDataProvider {

    @Test(groups = "automation_practice")
    public void test001() {
        AutomationPracticePages.initialiseAutomationPracticeHomePage();
        AutomationPracticeHomePage.womenButton.click();
        AutomationPracticePages.initialiseWomenPage();
        WomenPage.womenPageSearchField.textInput("Blouse");
        WebElement productCount = (TestBase.getElement(
                new Locator(Locator.LocatorType.CLASS, "product-count")));
        if (productCount != null) {
            ExtentTestManager.logInfo(Status.INFO, productCount.getText());
        }

    }

    @Test(groups = "automation_practice")
    public void test002() throws IOException {
        AutomationPracticePages.initialiseAutomationPracticeHomePage();
        AutomationPracticeHomePage.dressesButton.click();
        AutomationPracticePages.initialiseDressesPage();
        DressesPage.selectValueInSortingField("Product Name: A to Z");
        ExtentTestManager.logScreenShot("");

    }

    @Test(groups = "automation_practice")
    public void test003() {
        AutomationPracticePages.initialiseAutomationPracticeHomePage();
        AutomationPracticeHomePage.womenButton.click();
        AutomationPracticePages.initialiseWomenPage();
        WomenPage.getElementsFromGrid();
    }

    @Test(dataProvider = "sample page testdata", groups = "globalSqa")
    public void test004(String name, String email) throws IOException {
        GlobalSqaPages.initializeSamplePageTestPage();
        SamplePageTest.fillForm(name, email);
        ExtentTestManager.logScreenShot(Status.INFO, "Filled form");
        SamplePageTest.clearForm();
        ExtentTestManager.logScreenShot(Status.INFO, "Cleared form");

    }

    @Test(groups = "globalSqa")
    public void test005() throws InterruptedException {
        GlobalSqaPages.initializeDemoSitePage();
        DemoSite.clickAutoCompleteButton();
        GlobalSqaPages.initializeAutoCompletePage();
        AutoCompletePage.inputText();
        AutoCompletePage.selectValueInSortingField();
    }
}
