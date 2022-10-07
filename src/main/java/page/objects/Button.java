package page.objects;

import common.TestBase;
import org.openqa.selenium.WebElement;
import utilities.Locator;
import utilities.PageElementType;

public class Button extends BasePageElement{
    public Button(String elementName, Locator elementLocator) {
        super(elementName, elementLocator);
        this.type = PageElementType.BUTTON;
    }

    public void click(){
        WebElement button = TestBase.getElement(this.locator);
        if(button != null){
            button.click();
//            CommonLogic.logInfo("Clicked on "+this.type.getName()+" '"+this.name+"'");
//        } else {
//            CommonLogic.validationFail("Couldn't find "+this.type.getName()+" '"+this.name+"'");
        }
    }

}
