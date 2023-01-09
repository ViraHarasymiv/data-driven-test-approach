package com.herokuapp.theinternet.application.locators.secureAreaPageLocators;

import org.openqa.selenium.By;

public enum SecureAreaPageLocators {
    LOGIN_OUT_BUTTON(By.xpath("//a[@class='button secondary radius']")),
    MESSAGE(By.id("flash-messages"));

    private final By path;
    SecureAreaPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
