package iLab.framework.base;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage( ) {
        PageFactory.initElements(DriverContext.Driver,this);
    }
}
