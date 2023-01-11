package com.herokuapp.theinternet.application.locators.horizontalSliderPageLocators;

import org.openqa.selenium.By;

public enum HorizontalSliderPageLocators {
    RANGE(By.id("range")),
    SLIDER(By.tagName("input"));

    private final By path;
    HorizontalSliderPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
