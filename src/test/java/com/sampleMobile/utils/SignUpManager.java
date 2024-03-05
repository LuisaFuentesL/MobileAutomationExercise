package com.sampleMobile.utils;

import com.sampleMobile.screens.HomeScreen;
import com.sampleMobile.screens.LoginScreen;
import org.testng.Assert;

public class SignUpManager extends BaseTest{

    private static final String SIGNED_UP_SUCCESSFULLY_TEXT = "You successfully signed up!";

    public static LoginScreen returnLoginScreen(){
        HomeScreen homeScreen = returnHomeScreen();
        LoginScreen loginScreen = homeScreen.clickLogInButton();
        boolean isLoginAndSignUpTitlePresent = loginScreen.loginAndSignUpTitleIsPresent();
        Assert.assertTrue(isLoginAndSignUpTitlePresent);
        return loginScreen;
    }

    public static void signUp(LoginScreen loginScreen) {
        loginScreen.clickSignUpSectionButton();
        loginScreen.fillSignUpInfo();
        loginScreen.clickSignUpButton();
        String signedUpSuccessText = loginScreen.returnSuccessfullText();
        Assert.assertEquals(signedUpSuccessText, SIGNED_UP_SUCCESSFULLY_TEXT);
        loginScreen.clickOkButton();
    }
}
