package iLab.framework.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import iLab.framework.config.Settings;

import java.time.Duration;

public class DriverContext {

    //Responsible for bringing in our driver and browser class

    public static WebDriver Driver;

    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void WaitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(60));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver;

        ExpectedCondition<Boolean> jsLoad = webDriver ->((JavascriptExecutor)Driver)
                .executeScript("return document ready state").toString().equals("complete");

        //Get JS Ready
        boolean jsReady = javascriptExecutor.executeScript("return document.readyState").toString().equals("Complete");

        if(!jsReady)
            wait.until(jsLoad);
        else Settings.Logs.Write("Page is ready");
    }

    public static void WaitForElementVisible(final WebElement elementFindBy){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));

    }

    public static void WaitForElementClickable(final WebElement elementFindBy){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(elementFindBy));

    }

    public static boolean isPageLoaded(String title){

        try {
            WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.titleIs(title));
            Settings.Logs.Write("Page - " + title + " is loaded");
            return true;
        }catch (WebDriverException ex){
            Settings.Logs.Write("Page - " + title + " not loaded");
            return false;
        }
    }

    public static void clickWebElement(WebElement element){

        try {
            element.click();
        }catch (WebDriverException e){

            JavascriptExecutor executor = (JavascriptExecutor)Driver;
            executor.executeScript("arguments[0].click();",element);
        }
    }




}
