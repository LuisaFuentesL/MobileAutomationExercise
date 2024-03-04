package com.sampleMobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen{
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Drag and Drop\")")
    WebElement dragAndDropTitle;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public String getDragTitle(){
        return dragAndDropTitle.getText();
    }
}
