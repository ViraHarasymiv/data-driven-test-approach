package com.herokuapp.theinternet.application.locators.dropdownPageLocators;

import org.openqa.selenium.By;

public enum DropdownPageLocators {
    DROPDOWN(By.id("dropdown"));

    private final By path;
    DropdownPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}

