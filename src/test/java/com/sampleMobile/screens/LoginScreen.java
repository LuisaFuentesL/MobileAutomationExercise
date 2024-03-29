package com.sampleMobile.screens;

import com.github.javafaker.Faker;
import com.sampleMobile.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Login / Sign up Form\")")
    private WebElement loginAndSignUpTitle;

    @AndroidFindBy(accessibility="Forms")
    private WebElement formsButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Sign up\")")
    private WebElement signUpSectionButton;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility="input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility="input-repeat-password")
    private WebElement confirmPasswordInput;

    @AndroidFindBy(accessibility="button-SIGN UP")
    private WebElement signUpButton;

    @AndroidFindBy(id="android:id/message")
    private WebElement successText;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.Button).text(\"OK\")")
    private WebElement okButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Login\")")
    private WebElement logInSectionButton;

    @AndroidFindBy(accessibility="button-LOGIN")
    private WebElement logInButton;

    String email;
    String password;
    Faker faker = new Faker();

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean loginAndSignUpTitleIsPresent(){
        return isPresent(loginAndSignUpTitle);
    }

    public FormsScreen clickFormsButton(){
        formsButton.click();
        return new FormsScreen(driver);
    }

    public void clickSignUpSectionButton(){
        signUpSectionButton.click();
    }

    public void fillSignUpInfo(){
        fillEmailInputSignIn();
        fillPasswordInputSignIn();
        fillConfirmPasswordInputSignIn();
    }

    public void fillEmailInputSignIn(){
        email = faker.internet().emailAddress();
        fillEmailInput();
    }

    public void fillEmailInput(){
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void fillPasswordInputSignIn(){
        password = faker.internet().password();
        fillPasswordInput();
    }

    public void fillPasswordInput(){
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void fillConfirmPasswordInputSignIn(){
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(password);
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public String returnSuccessfullText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successText));
        return successText.getText();
    }

    public void clickOkButton(){
        okButton.click();
        driver.hideKeyboard();
    }

    public void clickLogInSectionButton(){
        logInSectionButton.click();
    }

    public void fillLogInInfo(){
        fillEmailInput();
        fillPasswordInput();
    }

    public void clickLogInButton(){
        logInButton.click();
    }

}
