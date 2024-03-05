package com.sampleMobile.tests;

import com.sampleMobile.screens.*;
import com.sampleMobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BottomNavBarTest extends BaseTest {
    private static final String DEMO_HOME_TEXT = "Demo app for the appium-boilerplate";
    private static final String DRAG_SCREEN_TITLE = "Drag and Drop";

    private HomeScreen homeScreen;
    @BeforeTest
    public void goToHomeScreen(){
        homeScreen = returnHomeScreen();
        homeScreen.clickHouseButton();
        String demoText = homeScreen.getDemoText();
        Assert.assertEquals(demoText,DEMO_HOME_TEXT);
    }

    @Test
    public void navigateNavBar() {
        WebViewScreen webViewScreen = homeScreen.clickWebViewButton();
        boolean isNodeTextPresent = webViewScreen.nodeTextIsPresent();
        Assert.assertTrue(isNodeTextPresent);

        LoginScreen loginScreen = webViewScreen.clickLoginButton();
        boolean isLoginAndSignUpTitlePresent = loginScreen.loginAndSignUpTitleIsPresent();
        Assert.assertTrue(isLoginAndSignUpTitlePresent);

        FormsScreen formsScreen = loginScreen.clickFormsButton();
        boolean isFormsTitlePresent = formsScreen.formsTitleIsPresent();
        Assert.assertTrue(isFormsTitlePresent);

        SwipeScreen swipeScreen = formsScreen.clickSwipeButton();
        boolean isSwipeTitlePresent= swipeScreen.swipeTitleIsPresent();
        Assert.assertTrue(isSwipeTitlePresent);

        DragScreen dragScreen = swipeScreen.clickDragButton();
        String dragAndDropTitle = dragScreen.getDragTitle();
        Assert.assertEquals(dragAndDropTitle,DRAG_SCREEN_TITLE);
    }
}
