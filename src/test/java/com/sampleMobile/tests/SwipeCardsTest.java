package com.sampleMobile.tests;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.SwipeScreen;
import com.sampleMobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    private SwipeScreen swipeScreen;
    @BeforeTest
    public void goToSwipeScreen(){
        HomeScreen homeScreen = returnHomeScreen();
        swipeScreen = homeScreen.clickSwipeButton();
        boolean isSwipeTitlePresent= swipeScreen.swipeTitleIsPresent();
        Assert.assertTrue(isSwipeTitlePresent);
    }

    @Test
    public void swipesOnCards() {
        swipeScreen.swipeToLeft();
        boolean isFirstCardOldIconPresent = swipeScreen.firstCardOldIconIsPresent();
        Assert.assertFalse(isFirstCardOldIconPresent);

        swipeScreen.swipeToRight();
        boolean isSecondCardOldIconPresent = swipeScreen.secondCardOldIconIsPresent();
        Assert.assertFalse(isSecondCardOldIconPresent);
    }
}
