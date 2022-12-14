package iLab.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import iLab.test.InitializeTests;


import java.io.IOException;

public class Listeners extends InitializeTests implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ReportingUtil.getReportObjects();
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test Fail");
        test.fail(result.getThrowable());
        String filePath = null;
        try {
             filePath =  getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        //screenshot
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test Skipped");
        test.fail(result.getThrowable());
    }


    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
