package com.herokuapp.theinternet.application.locators.editorPageLocators;

import org.openqa.selenium.By;

public enum EditorPageLocators {
    EDITOR(By.xpath("//p[contains(text(), 'Your content goes here')]")),
    IFRAME(By.tagName("iframe"));

    private final By path;
    EditorPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
