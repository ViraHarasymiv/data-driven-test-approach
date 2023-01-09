package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.loginPageLocators.LoginPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameLocator = LoginPageLocators.USERNAME_LOCATOR.getPath();
    private By passwordLocator = LoginPageLocators.PASSWORD_LOCATOR.getPath();
    private By logInButtonLocator = LoginPageLocators.LOGIN_BUTTON_LOCATOR.getPath();
    private By errorMessageLocator = LoginPageLocators.ERROR_MESSAGE_LOCATOR.getPath();

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Execute log in */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public LoginPage negativeLogIn(String username, String password) {
        log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return this;
    }
    /** Wait for error message becomes visible on the page*/
    public String getErrorMessageText() {
        waitForVisibilityOfElement(errorMessageLocator);
        return find(errorMessageLocator).getText();
    }
}
