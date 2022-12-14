package iLab.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import iLab.framework.config.Settings;


public class FrameworkInitialize extends BasePage {

    public void InitializeBrowser(BrowserType browserType){
        WebDriver driver = null;


        switch (browserType){

            //open the browser

            case Chrome:{
                System.setProperty("webdriver.chrome.driver", Settings.ChromeDriverPath);
                driver = new ChromeDriver();
                DriverContext.setDriver(driver);
                break;

            }

            case Edge:{

                System.setProperty("webdriver.edge.driver", Settings.EdgeDriverPath);
                driver = new EdgeDriver();
                DriverContext.setDriver(driver);
                break;
            }

        }

        //set the Browser
        DriverContext.Browser = new Browser(driver);


    }
}
