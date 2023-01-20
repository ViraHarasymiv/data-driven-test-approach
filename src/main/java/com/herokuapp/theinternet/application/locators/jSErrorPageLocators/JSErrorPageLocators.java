package com.herokuapp.theinternet.application.locators.jSErrorPageLocators;

import org.openqa.selenium.By;

public enum JSErrorPageLocators {
    JAVASCRIPT_ONLOAD_EVENT_ERROR(By.linkText("JavaScript onload event error"));

    private final By path;
    JSErrorPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
