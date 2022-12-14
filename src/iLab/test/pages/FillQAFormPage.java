package iLab.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import iLab.framework.base.BasePage;
import iLab.framework.base.DriverContext;

import java.text.DecimalFormat;
import java.util.Random;

public class FillQAFormPage extends BasePage {

    public FillQAFormPage() {
    }

    @FindBy(how = How.NAME, using = "firstname")
    public WebElement txtFirstName;


    @FindBy(how = How.NAME, using = "lastname")
    public WebElement txtLastName;

    @FindBy(how = How.NAME, using = "email")
    public WebElement txtEmail;

    @FindBy(how = How.NAME, using = "phone")
    public WebElement txtPhoneNumber;

    @FindBy(how = How.ID, using = "hs-form-iframe-0")
    public WebElement frameID;


    @FindBy(how = How.XPATH, using = "//input[@class='hs-button primary large']")
    public WebElement btnSubmit;

    @FindBy(how = How.XPATH, using = "//label[@class='hs-error-msg']")
    public WebElement actualString;


    public void setFirstName(String name){
        JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
        js.executeScript("scrollBy(0, 1200)");
        DriverContext.Driver.switchTo().frame(frameID);

        DriverContext.WaitForElementVisible(txtFirstName);
        txtFirstName.clear();
        txtFirstName.sendKeys(name);
    }

    public void setLastName(String lastName){

        DriverContext.WaitForElementVisible(txtLastName);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }

    public void setEmail(String email){

        DriverContext.WaitForElementVisible(txtEmail);
        txtEmail.sendKeys(email);
    }

    public void setPhoneNumber(){

        Random rand = new Random();
        int num1 = (rand.nextInt(1) ) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);

        DriverContext.WaitForElementVisible(txtPhoneNumber);
        txtPhoneNumber.sendKeys(phoneNumber);
    }

    public void clickSubmit(){

        DriverContext.WaitForElementVisible(btnSubmit);
        btnSubmit.click();
    }

    public String actualText(){

        String actualText = actualString.getText();
        return  actualText;

    }



    public void textValidation(){

        //String error =
    }





}
