package iLab.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import iLab.framework.base.BasePage;
import iLab.framework.base.DriverContext;

public class CareerOpportunitiesPage extends BasePage {

    public CareerOpportunitiesPage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "South Africa")
    public WebElement lnkSouthAfrica;


    public void clickCareerLnk() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) DriverContext.Driver;
        js.executeScript("scrollBy(0, 500)");
        DriverContext.WaitForElementVisible(lnkSouthAfrica);
        DriverContext.clickWebElement(lnkSouthAfrica);
    }


}
