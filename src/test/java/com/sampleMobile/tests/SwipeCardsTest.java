package com.sampleMobile.tests;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.SwipeScreen;
import com.sampleMobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwipeCardsTest extends BaseTest {

    SwipeScreen swipeScreen;
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
        swipeScreen.swipeToLeft();
        boolean isFirstCardHiddenTextPresent = swipeScreen.firstCardHiddenTextIsPresent();
        Assert.assertFalse(isFirstCardHiddenTextPresent);
        swipeScreen.swipeToRight();
        swipeScreen.swipeToRight();
        boolean isLastCardHiddenTextPresent = swipeScreen.lastCardHiddenTextIsPresent();
        Assert.assertFalse(isLastCardHiddenTextPresent);
    }
}
