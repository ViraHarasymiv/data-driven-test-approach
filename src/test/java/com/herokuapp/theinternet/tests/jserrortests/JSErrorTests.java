package com.herokuapp.theinternet.tests.jserrortests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.application.pages.JSErrorPage;
import com.herokuapp.theinternet.utils.TestUtilities;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends TestUtilities {

    @Test
    public void jsErrorTest() {
        log.info("Starting jsErrorTest");
        // Open JSErrorPage
        JSErrorPage jSErrorPage = new HomePage(driver,log)
                .clickOnJavaScriptOnLoadEventError();
        // Get logs
        List<LogEntry> logs = getBrowserLogs();
        // Verifying there are no JavaScript errors in console
        SoftAssert softAssert = new SoftAssert();
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }
}
