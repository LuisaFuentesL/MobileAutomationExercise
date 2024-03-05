package com.sampleMobile.utils;

import com.sampleMobile.screens.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    protected static final Properties properties = new Properties();
    protected static AndroidDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void environmentSetUp() {
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        }catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void loadProperties() {
        try{
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }catch(IOException e){
            throw new RuntimeException("Error loading the properties file " + PROPERTIES_FILE);
        }
    }

    public void setUpCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public static HomeScreen returnHomeScreen(){
        return new HomeScreen(driver);
    }
}
