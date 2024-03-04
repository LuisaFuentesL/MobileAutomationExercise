package com.sampleMobile.tests;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.LoginScreen;
import com.sampleMobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    private LoginScreen loginScreen;
    private static final String SIGNED_UP_SUCCESSFULLY_TEXT = "You successfully signed up!";


    @BeforeTest
    public void goToLoginScreen(){
        HomeScreen homeScreen = returnHomeScreen();
        loginScreen = homeScreen.clickLogInButton();
        boolean isLoginAndSignUpTitlePresent = loginScreen.loginAndSignUpTitleIsPresent();
        Assert.assertTrue(isLoginAndSignUpTitlePresent);
    }

    @BeforeTest
    public void signUp(){
        loginScreen.clickSignUpSectionButton();
        loginScreen.fillSignUpInfo();
        loginScreen.clickSignUpButton();
        String signedUpSuccessText = loginScreen.returnSignedUpSuccessfullyText();
        Assert.assertEquals(signedUpSuccessText,SIGNED_UP_SUCCESSFULLY_TEXT);
        loginScreen.clickOkSignedUp();
    }

    @Test
    public void logIn(){

    }
}
