package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    WebElement swipeTitle;

    @AndroidFindBy(accessibility="Drag")
    WebElement dragButton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[1]" )
    WebElement firstCard;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]" )
    WebElement secondCard;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"FULLY OPEN SOURCE\")")
    WebElement firstCardHiddenText;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"COMPATIBLE\n\")")
    WebElement lastCardHiddenText;
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

    public void swipeToLeft(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstCard));

        Actions action = new Actions(driver);
        action.clickAndHold(secondCard);
        action.moveToElement(firstCard).release();
        action.build().perform();
    }

    public void swipeToRight(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstCard));

        Actions action = new Actions(driver);
        action.clickAndHold(firstCard);
        action.moveToElement(secondCard).release();
        action.build().perform();
    }

    public boolean firstCardHiddenTextIsPresent(){
        try {
            if (firstCardHiddenText.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public boolean lastCardHiddenTextIsPresent(){
        try {
            if (lastCardHiddenText.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }
}
