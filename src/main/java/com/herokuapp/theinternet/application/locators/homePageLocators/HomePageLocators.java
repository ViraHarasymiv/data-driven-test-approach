package com.herokuapp.theinternet.application.locators.homePageLocators;

import org.openqa.selenium.By;

public enum HomePageLocators {
    FORM_AUTHENTICATION_LINK_LOCATOR(By.linkText("Form Authentication")),
    FILE_UPLOAD_LINK_LOCATOR(By.linkText("File Upload")),
    CHECKBOXES_LOCATOR(By.linkText("Checkboxes")),
    DROPDOWN_LINK_LOCATOR(By.linkText("Dropdown")),
    JAVA_SCRIPT_ALERTS_LINK_LOCATOR(By.linkText("JavaScript Alerts")),
    MULTIPLE_WINDOWS_LINK(By.linkText("Multiple Windows")),
    EDITOR_LINK(By.linkText("WYSIWYG Editor")),
    KEY_PRESSES(By.linkText("Key Presses")),
    HORIZONTAL_SLIDER(By.linkText("Horizontal Slider")),
    JAVASCRIPT_ONLOAD_EVENT_ERROR(By.linkText("JavaScript onload event error"));

    private final By path;
    HomePageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
