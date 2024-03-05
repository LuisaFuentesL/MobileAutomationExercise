package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebViewScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement nodeText;

    @AndroidFindBy(accessibility="Login")
    private WebElement loginButton;
    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean nodeTextIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(nodeText));
        return nodeText.isDisplayed();
    }

    public LoginScreen clickLoginButton(){
        loginButton.click();
        return new LoginScreen(driver);
    }
}
