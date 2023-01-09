package com.herokuapp.theinternet.application.locators.checkboxesPageLocators;

import org.openqa.selenium.By;

public enum CheckBoxesPageLocators {
    CHECKBOX(By.xpath("//a[@class='comparison-modal__link']"));

    private final By path;
    CheckBoxesPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
