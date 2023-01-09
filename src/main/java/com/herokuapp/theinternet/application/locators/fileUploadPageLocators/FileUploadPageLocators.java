package com.herokuapp.theinternet.application.locators.fileUploadPageLocators;

import org.openqa.selenium.By;

public enum FileUploadPageLocators {
    CHOSE_FILE_FIELD_LOCATOR(By.id("file-upload")),
    UPLOAD_BUTTON_LOCATOR(By.id("file-submit")),
    UPLOADED_FILES_LOCATOR(By.id("uploaded-files"));

    private final By path;
    FileUploadPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
