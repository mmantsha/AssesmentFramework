package iLab.framework.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingUtil   {


    public static ExtentReports getReportObjects(){

        String path =System.getProperty("user.dir")+ "//ExtentSparkReporter//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Mmantsha Monageng");
        return extent;

    }
 }
