package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.windowsPageLocators.WindowsPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePage{
    private By clickHereLink = WindowsPageLocators.CLICK_HERE_LINK.getPath();
    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /** Click 'Click Here' link to open new window */
    public WindowsPage openNewWindow() {
        log.info("Clicking 'Click Here' link");
        click(clickHereLink);
        return this;
    }

    /** Find page with title "New Window" and switch to it */
    public NewWindowPage switchToNewWindowPage() {
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }

}
