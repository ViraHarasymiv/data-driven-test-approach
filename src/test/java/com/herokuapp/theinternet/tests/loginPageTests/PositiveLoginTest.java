package com.herokuapp.theinternet.tests.loginPageTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.application.pages.LoginPage;
import com.herokuapp.theinternet.application.pages.SecureAreaPage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class contains user's automated steps for the success logging.
 *
 * @author Vira Harasymiv
 */
public class PositiveLoginTest extends BaseTest {

    @Parameters({ "username", "password", "expectedSuccessMessage" })
    @Test
    public void logInTest(String username, String password, String expectedSuccessMessage) {
        log.info("Starting logIn test");

        //open main page
        HomePage homePage = new HomePage(driver,log);
        homePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = homePage.clickFormAuthenticationLink();

        // execute log in
        SecureAreaPage secureAreaPage = loginPage.logIn(username, password);

        // Verifications
        // New page url is expected
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        softAssert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
                "logOutButton is not visible.");

        // Successful log in message
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
        softAssert.assertAll();
    }
}
