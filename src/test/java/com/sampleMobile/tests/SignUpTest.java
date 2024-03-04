package com.sampleMobile.tests;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    private static final String SIGNED_UP_SUCCESSFULLY_TEXT = "You successfully signed up!";

    @Test
    public void signUp(){
        HomeScreen homeScreen = returnHomeScreen();
        LoginScreen loginScreen = homeScreen.clickLogInButton();
        boolean isLoginAndSignUpTitlePresent = loginScreen.loginAndSignUpTitleIsPresent();
        Assert.assertTrue(isLoginAndSignUpTitlePresent);

        loginScreen.clickSignUpSectionButton();
        loginScreen.fillSignUpInfo();
        loginScreen.clickSignUpButton();
        String signedUpSuccessText = loginScreen.returnSignedUpSuccessfullyText();
        Assert.assertEquals(signedUpSuccessText,SIGNED_UP_SUCCESSFULLY_TEXT);
        loginScreen.clickOkSignedUp();

    }
}
