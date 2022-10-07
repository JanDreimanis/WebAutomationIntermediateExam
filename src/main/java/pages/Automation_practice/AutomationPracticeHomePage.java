package pages.Automation_practice;

import page.objects.Button;
import pages.BasePage;
import utilities.Locator;

public class AutomationPracticeHomePage extends BasePage {

    public AutomationPracticeHomePage(String pageName, Locator pageLocator) {
        super(pageName, pageLocator);
    }

    public static Button womenButton = new Button("Women button",
            new Locator(Locator.LocatorType.LINK_TEXT, "Women"));

    public static Button dressesButton = new Button("Dresses button",
            new Locator(Locator.LocatorType.XPATH, "//*[@id=\"block_top_menu\"]/ul/li[2]/a"));



}
