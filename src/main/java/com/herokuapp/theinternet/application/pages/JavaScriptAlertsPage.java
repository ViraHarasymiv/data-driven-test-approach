package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.javaScriptAlertsPageLocators.JavaScriptAlertsPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePage{
    private By clickForJSAlertButton = JavaScriptAlertsPageLocators.CLICK_FOR_JS_ALERT_BUTTON.getPath();
    private By clickForJSConfirmButton = JavaScriptAlertsPageLocators.CLICK_FOR_JS_CONFIRM_BUTTON.getPath();
    private By clickForJSPromptButton = JavaScriptAlertsPageLocators.CLICK_FOR_JS_PROMPT_BUTTON.getPath();
    private By textResult = JavaScriptAlertsPageLocators.TEXT_RESULT.getPath();

    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Clicking on 'Click for JS Alert' button to open alert */
    public JavaScriptAlertsPage openJSAlert() {
        log.info("Clicking on 'Click for JS Alert' button to open alert");
        click(clickForJSAlertButton);
        return this;
    }

    /** Clicking on 'Click for JS Confirm' button to open alert */
    public JavaScriptAlertsPage openJSConfirm() {
        log.info("Clicking on 'Click for JS Confirm' button to open alert");
        click(clickForJSConfirmButton);
        return this;
    }

    /** Clicking on 'Click for JS Prompt' button to open alert */
    public JavaScriptAlertsPage openJSPrompt() {
        log.info("Clicking on 'Click for JS Prompt' button to open alert");
        click(clickForJSPromptButton);
        return this;
    }

    /** Switch to alert and get it's message */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }

    /** Switch to alert and press OK */
    public JavaScriptAlertsPage acceptAlert() {
        log.info("Switching to alert and pressing OK");
        Alert alert = switchToAlert();
        alert.accept();
        return this;
    }

    /** Switch to alert and press Cancel */
    public JavaScriptAlertsPage dismissAlert() {
        log.info("Switching to alert and pressing Cancel");
        Alert alert = switchToAlert();
        alert.dismiss();
        return this;
    }

    /** Type text into alert and press OK */
    public JavaScriptAlertsPage typeTextIntoAlert(String text) {
        log.info("Typing text into alert and pressing OK");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    /** Get result text */
    public String getResultText() {
        String result = find(textResult).getText();
        log.info("Result text: " + result);
        return result;
    }
}

