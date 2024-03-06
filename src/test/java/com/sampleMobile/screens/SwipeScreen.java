package com.sampleMobile.screens;

import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    private WebElement swipeTitle;

    @AndroidFindBy(accessibility="Drag")
    private WebElement dragButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\"__CAROUSEL_ITEM_0_READY__\")")
    private WebElement firstCard;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\"__CAROUSEL_ITEM_1_READY__\")")
    private WebElement secondCard;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\"__CAROUSEL_ITEM_2_READY__\")")
    private WebElement thirdCard;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\"__CAROUSEL_ITEM_0_READY__\").childSelector(UiSelector().text(\"[]\"))")
    private WebElement firstCardOldIcon;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\"__CAROUSEL_ITEM_1_READY__\").childSelector(UiSelector().text(\"[]\"))")
    private WebElement secondCardOldIcon;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")")
    private WebElement swipeText;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"You found me!!!\")")
    private WebElement robotText;


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
        Actions action = new Actions(driver);
        action.clickAndHold(secondCard);
        action.moveToElement(firstCard).release();
        action.build().perform();
    }

    public void swipeToRight(){
        Actions action = new Actions(driver);
        action.clickAndHold(secondCard);
        action.moveToElement(thirdCard).release();
        action.build().perform();
    }

    public boolean firstCardOldIconIsPresent(){
        try {
            if (firstCardOldIcon.isDisplayed()) {
                return true;
            }
        } catch (Throwable t) {
            return false;
        }
        return false;
    }

    public boolean secondCardOldIconIsPresent(){
        try {
            if (secondCardOldIcon.isDisplayed()) {
                return true;
            }
        } catch (Throwable t) {
            return false;
        }
        return false;
    }

    public void swipeUp() {
        int height = driver.manage().window().getSize().getHeight();
        int weight = driver.manage().window().getSize().getWidth();
        Actions action = new Actions(driver);
        action.dragAndDropBy(swipeText,weight/2, - (int) (height * 0.8));
        action.build().perform();
    }

    public boolean robotTextIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(robotText));
        return isPresent(robotText);
    }
}
