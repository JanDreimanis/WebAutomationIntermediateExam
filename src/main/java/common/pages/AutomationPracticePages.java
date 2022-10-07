package common.pages;

import pages.Automation_practice.AutomationPracticeHomePage;
import pages.Automation_practice.DressesPage;
import pages.Automation_practice.WomenPage;
import utilities.Locator;

public class AutomationPracticePages {

    public static ThreadLocal<AutomationPracticeHomePage> automationPracticeHomePage = new ThreadLocal<>();
    public static ThreadLocal<WomenPage> womenPage = new ThreadLocal<>();
    public static ThreadLocal<DressesPage> dressesPage = new ThreadLocal<>();

    public static void initialiseAutomationPracticeHomePage() {
        automationPracticeHomePage.set(new AutomationPracticeHomePage("Automation practice home page",
                new Locator(Locator.LocatorType.ID, "index")));
    }

    public static void initialiseWomenPage() {
        womenPage.set(new WomenPage("Women page", new Locator(Locator.LocatorType.CLASS, "category category-3 category-women hide-right-column lang_en")));
    }

    public static void initialiseDressesPage() {
        dressesPage.set(new DressesPage("Dresses page", new Locator(Locator.LocatorType.CLASS, "category category-8 category-dresses hide-right-column lang_en")));
    }
}
