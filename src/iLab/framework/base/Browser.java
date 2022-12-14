package iLab.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public BrowserType Type;

    public void GoToUrl(String url){

        driver.get(url);
    }

    public void maximize(){
        driver.manage().window().maximize();

    }

    public void clearCatch(){

        driver.manage().deleteAllCookies();
    }



}
