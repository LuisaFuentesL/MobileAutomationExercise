package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Form components\")")
    private WebElement formsTitle;

    @AndroidFindBy(accessibility="Swipe")
    private WebElement swipeButton;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean formsTitleIsPresent(){
        return isPresent(formsTitle);
    }

    public SwipeScreen clickSwipeButton(){
        swipeButton.click();
        return new SwipeScreen(driver);
    }
}
