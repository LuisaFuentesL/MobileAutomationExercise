package com.sampleMobile.screens;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen extends BaseScreen{
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Login / Sign up Form\")")
    WebElement loginAndSignUpTitle;

    @AndroidFindBy(accessibility="Forms")
    WebElement formsButton;

    @AndroidFindBy(uiAutomator = "UiSelector().text(\"Sign up\")")
    WebElement signUpSectionButton;

    @AndroidFindBy(accessibility = "input-email")
    WebElement emailInput;

    @AndroidFindBy(accessibility="input-password")
    WebElement passwordInput;

    @AndroidFindBy(accessibility="input-repeat-password")
    WebElement confirmPasswordInput;

    @AndroidFindBy(accessibility="button-SIGN UP")
    WebElement signUpButton;

    @AndroidFindBy(id="android:id/message")
    WebElement signedUpSuccessText;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.Button).text(\"OK\")")
    WebElement okSignedUpButton;

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
        fillEmailInput();
        String password = fillPasswordInput();
        fillConfirmPasswordInput(password);
    }

    public void fillEmailInput(){
        emailInput.click();
        String email = faker.internet().emailAddress();
        emailInput.sendKeys(email);
    }

    public String fillPasswordInput(){
        passwordInput.click();
        String password = faker.internet().password();
        passwordInput.sendKeys(password);
        return password;
    }

    public void fillConfirmPasswordInput(String password){
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(password);
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public String returnSignedUpSuccessfullyText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(signedUpSuccessText));
        return signedUpSuccessText.getText();
    }

    public void clickOkSignedUp(){
        okSignedUpButton.click();
        driver.hideKeyboard();
    }

}
