package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import common.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class ExtentTestManager {


    private static final String PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "reports" + File.separator +
                    "TestResults.html";

    private static final String CONFIG_PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "configs" + File.separator +
                    "extentConfig.xml";

    protected static ExtentReports report;


    public static void createReport() {
        if (report != null) report.flush();
    }

    public static ExtentReports initializeReport() {
        ExtentReports newReport = new ExtentReports();
        try {
            ExtentSparkReporter spark = new ExtentSparkReporter(PATH);
            spark.loadXMLConfig(CONFIG_PATH);
            newReport.attachReporter(spark);
            spark.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();

            newReport.setSystemInfo("URL", TestBase.configReader.getAutomationPractiseUrl());
            newReport.setSystemInfo("URL", TestBase.configReader.getGlobalSqaSamplePageTestUrl());
            newReport.setSystemInfo("URL", TestBase.configReader.getGlobalSqaDemoSiteUrl());
        } catch (Exception exception) {
            //TODO need to make it better
            System.out.println("Couldn't create report");
        }
        return newReport;
    }

    public static void logInfo(String message) {
        logInfo(Status.INFO, message);
    }

    public static void logInfo(Status status, String message) {
        getTest().log(status, message);
    }

    public static void logScreenShot(String message) {
        logScreenShot(Status.INFO, message);
    }

    public static void logScreenShot(Status status, String message) {
        if (TestBase.getDriver() != null) {
            //Take screenshot
            String base64Image = "data:image/png;base64," + ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BASE64);
            //Attach screenshot to report
            getTest().log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        } else {
            logInfo(status, message);
        }
    }

    private static final ThreadLocal<ExtentTest> testRepository = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        testRepository.set(test);
    }

    public static ExtentTest getTest() {
        return testRepository.get();
    }

    public static synchronized void startTest(String testName, String description) {
        if (report == null) report = initializeReport();
        ExtentTest test = report.createTest(testName, description);
        setTest(test);
    }

    public static void logLabel(ExtentColor color, String message) {
        getTest().info(MarkupHelper.createLabel(message, color));
    }


}
