package utilities;

public class Locator {
    public enum LocatorType {
        XPATH,
        ID,
        LINK_TEXT,
        CLASS,
    }

    public LocatorType type;
    public String value;

    public Locator(LocatorType locatorType, String locatorValue) {
        this.type = locatorType;
        this.value = locatorValue;
    }
}
