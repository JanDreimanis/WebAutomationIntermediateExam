package common;

import com.aventstack.extentreports.Status;
import utilities.ExtentTestManager;

import static common.TestBase.configReader;
import static common.TestBase.getDriver;

public class CommonLogic {


    public static void validationPass(String message) {
        ExtentTestManager.logInfo(Status.PASS, message);
        System.out.println(message);
    }

    public static void validationFail(String message) {
        validationFail(message, false);
    }

    public static void validationFail(String message, boolean stopTest) {
        System.out.println(message);
        ExtentTestManager.logInfo(Status.FAIL, message);
        logScreenshot();
        if (stopTest) {
            throw new RuntimeException(message);
        }
    }

    public static void logInfo(String message) {
        System.out.println(message);
    }

    public static void chooseUrl(String test) {
        switch (test) {
            case "test001":
            case "test002":
            case "test003":
                openUrl(configReader.getAutomationPractiseUrl());
                return;

            case "test004":
                openUrl(configReader.getGlobalSqaSamplePageTestUrl());
                return;

            case "test005":
                openUrl(configReader.getGlobalSqaDemoSiteUrl());
        }
    }

    public static void logScreenshot() {
        ExtentTestManager.logScreenShot("Screenshot");
    }

    public static void openUrl(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }


}
