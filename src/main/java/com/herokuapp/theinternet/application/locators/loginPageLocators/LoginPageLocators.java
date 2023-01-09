package com.herokuapp.theinternet.application.locators.loginPageLocators;

import org.openqa.selenium.By;

public enum LoginPageLocators {
    USERNAME_LOCATOR(By.id("username")),
    PASSWORD_LOCATOR(By.name("password")),
    LOGIN_BUTTON_LOCATOR(By.tagName("button")),
    ERROR_MESSAGE_LOCATOR(By.id("flash"));

    private final By path;
    LoginPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
