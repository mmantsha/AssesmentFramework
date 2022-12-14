package iLab.test;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import iLab.framework.base.DriverContext;
import iLab.framework.base.FrameworkInitialize;
import iLab.framework.config.ConfigReader;
import iLab.framework.config.Settings;
import iLab.framework.utilities.LogUtil;

import java.io.File;
import java.io.IOException;

public class InitializeTests extends FrameworkInitialize {

    @BeforeMethod
    public void Initialize() throws IOException {

        //Initialise Config
        ConfigReader.PopulateSettings();

        //Logging
        Settings.Logs = new LogUtil();
        //create file
        Settings.Logs.CreateLogFile();
        //write
        Settings.Logs.Write("Framework Initialize ");

        InitializeBrowser(Settings.BrowserType);
        Settings.Logs.Write("Browser Initialised");
        DriverContext.Browser.GoToUrl(Settings.AUT);
        Settings.Logs.Write("navigated to URL " + Settings.AUT);
        DriverContext.Browser.maximize();
        DriverContext.Browser.clearCatch();


    }

    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts =(TakesScreenshot) DriverContext.Driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file =new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png";

    }

    @AfterMethod
    public void close(){

        DriverContext.Driver.quit();
    }

}
