package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.secureAreaPageLocators.SecureAreaPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
    private String pageUrl = "http://the-internet.herokuapp.com/secure";

    private By logOutButton = SecureAreaPageLocators.LOGIN_OUT_BUTTON.getPath();
    private By message = SecureAreaPageLocators.MESSAGE.getPath();

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get URL variable from PageObject */
    public String getPageUrl() {
        return pageUrl;
    }

    /** Verification if logOutButton is visible on the page */
    public boolean isLogOutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }

    /** Return text from success message */
    public String getSuccessMessageText() {
        return find(message).getText();
    }

}
