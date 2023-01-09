package com.herokuapp.theinternet.tests.loginPageTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import com.herokuapp.theinternet.application.utils.CsvDataProviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

/**
 * This class contains user's automated steps for logging with the invalid data.
 *
 * @author Vira Harasymiv
 */
public class NegativeLoginTest extends BaseTest {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLoginTest(Map<String, String> testData) {
        //Data
        String number = testData.get("number");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeLoginTest #" + number + " for " + description);

        String message = new HomePage(driver,log)
                .openPage()
                .clickFormAuthenticationLink()
                .negativeLogIn(username,password)
                .getErrorMessageText();
        Assert.assertTrue(message.contains(expectedMessage), "Message doesn't contain expected text.");
    }
}

