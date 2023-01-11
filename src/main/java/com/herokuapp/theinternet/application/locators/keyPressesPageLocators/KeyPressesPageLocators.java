package com.herokuapp.theinternet.application.locators.keyPressesPageLocators;

import org.openqa.selenium.By;

public enum KeyPressesPageLocators {
    BODY(By.xpath("//body")),
    RESULT_TEXT(By.id("result"));

    private final By path;
    KeyPressesPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
