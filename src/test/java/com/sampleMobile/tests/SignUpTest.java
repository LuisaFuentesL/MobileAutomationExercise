package com.sampleMobile.tests;

import com.sampleMobile.screens.LoginScreen;
import com.sampleMobile.utils.BaseTest;
import com.sampleMobile.utils.SignUpAux;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private LoginScreen loginScreen;

    @BeforeTest
    public void goToLoginScreen(){
        loginScreen = SignUpAux.returnLoginScreen();
    }

    @Test
    public void signUp(){
        SignUpAux.signUp(loginScreen);
    }
}
