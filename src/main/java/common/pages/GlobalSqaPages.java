package common.pages;

import pages.globalsqa.AutoCompletePage;
import pages.globalsqa.DemoSite;
import pages.globalsqa.SamplePageTest;
import utilities.Locator;

public class GlobalSqaPages {

    public static ThreadLocal<SamplePageTest> samplePageTest = new ThreadLocal<>();
    public static ThreadLocal<DemoSite> demoSite = new ThreadLocal<>();
    public static ThreadLocal<AutoCompletePage> autoCompletePage = new ThreadLocal<>();

    public static void initializeSamplePageTestPage() {
        samplePageTest.set(new SamplePageTest("Sample page test",
                new Locator(Locator.LocatorType.ID, "post-2599")));
    }

    public static void initializeDemoSitePage() {
        demoSite.set(new DemoSite("Demo-site",
                new Locator(Locator.LocatorType.CLASS, "sixteen columns")));
    }

    public static void initializeAutoCompletePage() {
        autoCompletePage.set(new AutoCompletePage("Autocomplete page",
                new Locator(Locator.LocatorType.XPATH, "//*[@id=\"wrapper\"]/div[1]/div[1]/div/div/div/div[2]/h1")));
    }
}
