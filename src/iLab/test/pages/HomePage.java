package iLab.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import iLab.framework.base.BasePage;
import iLab.framework.base.DriverContext;

public class HomePage extends BasePage {

    public HomePage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Career Opportunities")
    public WebElement lnkCareerOpportunities;



    @FindBy(how = How.XPATH, using = "//button[@data-cky-tag='accept-button']")
    public WebElement btnAcceptAll;

    public void clickCareerLnk() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
        js.executeScript("scrollBy(0, 6000)");
        DriverContext.WaitForElementVisible(lnkCareerOpportunities);
        //lnkCareerOpportunities.click();
        DriverContext.clickWebElement(lnkCareerOpportunities);
    }

    public void isLoaded(String title){

       // String text = DriverContext.Driver.getTitle();

       // Settings.Logs.Write("Page - " + text + " is loaded");

       DriverContext.isPageLoaded(title);
    }

    public void clickAcceptAll(){

        DriverContext.WaitForElementVisible(btnAcceptAll);
        btnAcceptAll.click();
    }




}
