package page.objects;

import utilities.Locator;
import utilities.PageElementType;

public class BasePageElement {
    public String name;
    public Locator locator;
    public PageElementType type;

    public BasePageElement(String elementName, Locator elementLocator) {
        this.name = elementName;
        this.locator = elementLocator;
    }
}
