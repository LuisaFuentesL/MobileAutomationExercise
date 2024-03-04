package com.sampleMobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen{
    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    WebElement swipeTitle;

    @AndroidFindBy(accessibility="Drag")
    WebElement dragButton;
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean swipeTitleIsPresent(){
        return isPresent(swipeTitle);
    }

    public DragScreen clickDragButton(){
        dragButton.click();
        return new DragScreen(driver);
    }
}
