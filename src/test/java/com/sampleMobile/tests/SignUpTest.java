package com.sampleMobile.tests;

import com.sampleMobile.screens.LoginScreen;
import com.sampleMobile.utils.BaseTest;
import com.sampleMobile.utils.SignUpManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private LoginScreen loginScreen;

    @BeforeTest
    public void goToLoginScreen(){
        loginScreen = SignUpManager.returnLoginScreen();
    }

    @Test
    public void signUp(){
        SignUpManager.signUp(loginScreen);
    }
}
