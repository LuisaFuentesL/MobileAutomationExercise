package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Drag and Drop\")")
    private WebElement dragAndDropTitle;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public String getDragTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(dragAndDropTitle));
        return dragAndDropTitle.getText();
    }
}
