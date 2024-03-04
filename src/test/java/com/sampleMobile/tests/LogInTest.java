package com.sampleMobile.tests;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logIn(){
        HomeScreen homeScreen = returnHomeScreen();
        LoginScreen loginScreen = homeScreen.clickLogInButton();
        boolean isLoginAndSignUpTitlePresent = loginScreen.loginAndSignUpTitleIsPresent();
        Assert.assertTrue(isLoginAndSignUpTitlePresent);
    }
}
