package utilities.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import common.CommonLogic;
import common.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import utilities.ExtentTestManager;


public class MyListener implements ITestListener {

 String methodName;



    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting tests.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        methodName = result.getMethod().getConstructorOrMethod().getName();
        String testDescription = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        String [] groups = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).groups();


        System.out.println("STARTED TEST: " + methodName + " - " + testDescription);
        for (String groupName : groups) {
            System.out.println("TEST GROUP: " + groupName);
        }

        ExtentTestManager.startTest(methodName + " - " + testDescription, "Exam");
        for (String groupName : groups) {
            ExtentTestManager.getTest().assignCategory(groupName);
        }
        ExtentTestManager.getTest().assignAuthor(TestBase.configReader.getAuthor());
        ExtentTestManager.logLabel(ExtentColor.ORANGE, "Test started");

        TestBase.initializeDriver();
        CommonLogic.chooseUrl(methodName);

    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test pass");
        ExtentTestManager.logLabel(ExtentColor.ORANGE, "Test finished");
        TestBase.closeDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test failed");
        ExtentTestManager.logLabel(ExtentColor.ORANGE, "Test finished");
        TestBase.closeDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("This is end of my test execution");
        ExtentTestManager.createReport();
    }

}
