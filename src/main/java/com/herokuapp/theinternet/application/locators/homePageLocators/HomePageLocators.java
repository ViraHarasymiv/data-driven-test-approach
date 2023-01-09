package com.herokuapp.theinternet.application.locators.homePageLocators;

import org.openqa.selenium.By;

public enum HomePageLocators {
    FORM_AUTHENTICATION_LINK_LOCATOR(By.linkText("Form Authentication")),
    FILE_UPLOAD_LINK_LOCATOR(By.linkText("File Upload")),
    CHECKBOXES_LOCATOR(By.linkText("Checkboxes")),
    DROPDOWN_LINK_LOCATOR(By.linkText("Dropdown"));

    private final By path;
    HomePageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
