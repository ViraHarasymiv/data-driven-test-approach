package com.herokuapp.theinternet.tests.windowstests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends BaseTest {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");
        String pageSource = new HomePage(driver,log)
                .openPage()
                .clickMultipleWindowsLink()
                .openNewWindow()
                .switchToNewWindowPage()
                .getCurrentPageSource();
        // Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
    }
}
