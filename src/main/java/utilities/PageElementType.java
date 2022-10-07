package utilities;

public enum PageElementType {

        BUTTON("Button"),
        TEXT_FIELD("Textfield");

    public final String name;

    PageElementType(String enumName) {
     this.name = enumName;
    }

    public String getName() {
        return this.name;
    }
}




