package com.sampleMobile.tests;

import com.sampleMobile.screens.LoginScreen;
import com.sampleMobile.utils.BaseTest;
import com.sampleMobile.utils.SignUpAux;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    private static final String LOGGED_IN_SUCCESSFULLY_TEXT = "You are logged in!";
    private LoginScreen loginScreen;

    @BeforeTest
    public void goToLoginScreen(){
        loginScreen = SignUpAux.returnLoginScreen();
    }

    @BeforeTest
    public void signUp(){
        SignUpAux.signUp(loginScreen);
    }

    @Test
    public void logIn(){
        loginScreen.clickLogInSectionButton();
        loginScreen.fillLogInInfo();
        loginScreen.clickLogInButton();
        String loggedInSuccessText = loginScreen.returnSuccessfullText();
        Assert.assertEquals(loggedInSuccessText,LOGGED_IN_SUCCESSFULLY_TEXT);
        loginScreen.clickOkButton();
    }
}
