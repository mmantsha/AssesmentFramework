package iLab.framework.config;

import iLab.framework.base.BrowserType;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    //Here we will be reading the config information

    public static void PopulateSettings() throws IOException {

        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {

        //Create properties object
        Properties properties = new Properties();

        //Load the property file available
        properties.load(getClass().getResourceAsStream("GlobalConfig.properties"));

        Settings.LogPath = properties.getProperty("LogPath");

        Settings.AUT = properties.getProperty("AUT");

        Settings.ExcelSheetPath = properties.getProperty("ExcelSheetPath");

        Settings.BrowserType = BrowserType.valueOf(properties.getProperty("BrowserType")) ;

        Settings.ChromeDriverPath = properties.getProperty("ChromeDriverPath");

        Settings.EdgeDriverPath = properties.getProperty("EdgeDriverPath");


        Settings.RefNumberFile = properties.getProperty("RefNumberFile");

        Settings.FirstName = properties.getProperty("FirstName");

        Settings.LastName = properties.getProperty("LastName");


    }

}
