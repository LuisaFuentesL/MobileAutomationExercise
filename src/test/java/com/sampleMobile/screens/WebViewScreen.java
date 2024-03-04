package com.sampleMobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen{
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    WebElement nodeText;

    @AndroidFindBy(accessibility="Login")
    WebElement loginButton;
    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean nodeTextIsPresent(){
        return isPresent(nodeText);
    }

    public LoginScreen clickLoginButton(){
        loginButton.click();
        return new LoginScreen(driver);
    }
}
