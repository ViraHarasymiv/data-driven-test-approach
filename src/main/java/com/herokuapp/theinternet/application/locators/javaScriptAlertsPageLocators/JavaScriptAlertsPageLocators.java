package com.herokuapp.theinternet.application.locators.javaScriptAlertsPageLocators;

import org.openqa.selenium.By;

public enum JavaScriptAlertsPageLocators {
    CLICK_FOR_JS_ALERT_BUTTON(By.xpath("//button[text()='Click for JS Alert']")),
    CLICK_FOR_JS_CONFIRM_BUTTON(By.xpath("//button[text()='Click for JS Confirm']")),
    CLICK_FOR_JS_PROMPT_BUTTON(By.xpath("//button[text()='Click for JS Prompt']")),
    TEXT_RESULT(By.id("result"));

    private final By path;
    JavaScriptAlertsPageLocators(By path) {
        this.path = path;
    }
    public By getPath() {
        return path;
    }
}
