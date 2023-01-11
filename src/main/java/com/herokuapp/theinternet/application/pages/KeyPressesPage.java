package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.keyPressesPageLocators.KeyPressesPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage{
    private By body = KeyPressesPageLocators.BODY.getPath();
    private By resultTextLocator = KeyPressesPageLocators.RESULT_TEXT.getPath();
    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Press given key while on this page */
    public KeyPressesPage pressKey(Keys key) {
        log.info("Pressing " + key.name());
        pressKey(body, key);
        return this;
    }

    /** Get result text */
    public String getResultText() {
        String result = find(resultTextLocator).getText();
        log.info("Result text: " + result);
        return result;
    }

    @Override
    public KeyPressesPage pressKeyWithActions(Keys key) {
        super.pressKeyWithActions(key);
        return this;
    }
}
