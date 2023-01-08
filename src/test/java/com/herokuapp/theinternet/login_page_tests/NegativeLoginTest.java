package com.herokuapp.theinternet.login_page_tests;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class contains user's automated steps for logging with the invalid data.
 *
 * @author Vira Harasymiv
 */
public class NegativeLoginTest extends BaseTest {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedMessage) {
        log.info("Starting negativeTest");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // execute negative login
        loginPage.negativeLogIn(username, password);

        // wait for error message
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(expectedMessage), "Message doesn't contain expected text.");
    }
}

