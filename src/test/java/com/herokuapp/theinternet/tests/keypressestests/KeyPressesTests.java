package com.herokuapp.theinternet.tests.keypressestests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends BaseTest {

    @Test
    public void pressKeyTest() {
        log.info("Starting pressKeyTest");
        String result = new HomePage(driver,log)
                .openPage()
                .clickOnKeyPresses()
                .pressKey(Keys.ENTER)
                .getResultText();
        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }
    @Test
    public void pressKeyWithActionsTest() {
        log.info("Starting pressKeyWithActionsTest");
        String result = new HomePage(driver,log)
                .openPage()
                .clickOnKeyPresses()
                .pressKeyWithActions(Keys.SPACE)
                .getResultText();
        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }
}
