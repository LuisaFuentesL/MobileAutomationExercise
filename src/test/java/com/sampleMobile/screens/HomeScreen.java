package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeScreen extends BaseScreen {
    @AndroidFindBy(accessibility="Home")
    private WebElement houseButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Demo app for the appium-boilerplate\")")
    private WebElement demoText;

    @AndroidFindBy(accessibility="Webview")
    private WebElement webViewButton;

    @AndroidFindBy(accessibility="Login")
    private WebElement loginButton;

    @AndroidFindBy(accessibility="Swipe")
    private WebElement swipeButton;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public void clickHouseButton(){
        houseButton.click();
    }

    public String getDemoText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(demoText));
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

    public SwipeScreen clickSwipeButton(){
        swipeButton.click();
        return new SwipeScreen(driver);
    }

}
