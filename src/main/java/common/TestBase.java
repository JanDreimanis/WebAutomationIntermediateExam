package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Locator;

public class TestBase {

    public static ConfigFileReader configReader = new ConfigFileReader();

    private static final ThreadLocal<RemoteWebDriver> driverRepository = new ThreadLocal<>();
    public static RemoteWebDriver getDriver() {
        return driverRepository.get();
    }

    private static void setDriver(RemoteWebDriver driver){
        driverRepository.set(driver);
        int implicitWait = 20;
        waitRepository.set(new WebDriverWait(getDriver(), implicitWait));
    }

    private static final ThreadLocal<WebDriverWait> waitRepository = new ThreadLocal<WebDriverWait>();
    public static WebDriverWait getWait(){
        return waitRepository.get();
    }

    public static void initializeDriver() {
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
    }

    public static void closeDriver(){
        if(getDriver() != null){
            getDriver().close();
        }
    }

    public static WebElement getElement(Locator locator){
        try{
            switch (locator.type){
                case ID: return getWait().until(ExpectedConditions.elementToBeClickable(By.id(locator.value)));
                case LINK_TEXT: return getWait().until(ExpectedConditions.elementToBeClickable(By.linkText(locator.value)));
                case XPATH: return getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(locator.value)));
                case CLASS: return getWait().until(ExpectedConditions.elementToBeClickable(By.className(locator.value)));
                default: return null;
            }
        }catch (Exception exception){
            return null;
        }
    }
}
