package iLab.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import iLab.framework.base.BasePage;
import iLab.framework.base.DriverContext;

public class CareerOpportunitiesSouthAfricaPage extends BasePage {

    public CareerOpportunitiesSouthAfricaPage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Software Quality Assurance (SQA) Lead")
    public WebElement lnkQAJob;


    public void clickQaJob(){

        DriverContext.WaitForElementVisible(lnkQAJob);
        DriverContext.clickWebElement(lnkQAJob);
    }
}
