package pages;

import utilities.Locator;

public class BasePage {
    public String name;
    public Locator locator;

    public BasePage(String pageName, Locator pageLocator) {
        this.name = pageName;
        this.locator = pageLocator;
    }

}
