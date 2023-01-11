package com.herokuapp.theinternet.application.locators.windowsPageLocators;

import org.openqa.selenium.By;

public enum WindowsPageLocators {
    CLICK_HERE_LINK(By.linkText("Click Here"));

    private final By path;
    WindowsPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
