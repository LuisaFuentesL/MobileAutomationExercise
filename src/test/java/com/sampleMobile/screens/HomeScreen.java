package com.sampleMobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen{
    @AndroidFindBy(accessibility="Home")
    WebElement houseButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Demo app for the appium-boilerplate\")")
    WebElement demoText;

    @AndroidFindBy(accessibility="Webview")
    WebElement webViewButton;

    @AndroidFindBy(accessibility="Login")
    WebElement loginButton;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    public void clickHouseButton(){
        houseButton.click();
    }

    public String getDemoText(){
        return demoText.getText();
    }

    public WebViewScreen clickWebViewButton(){
        webViewButton.click();
        return new WebViewScreen(driver);
    }

    public LoginScreen clickLogInButton(){
        loginButton.click();
        return new LoginScreen(driver);
    }

}
