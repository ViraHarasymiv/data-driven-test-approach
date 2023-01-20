package loginPageTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.application.pages.LoginPage;
import com.herokuapp.theinternet.application.pages.SecureAreaPage;
import com.herokuapp.theinternet.runners.BaseTest;
import com.herokuapp.theinternet.utils.TestUtilities;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class contains user's automated steps for the success logging.
 *
 * @author Vira Harasymiv
 */
public class PositiveLoginTest extends TestUtilities {

    @Parameters({ "username", "password", "expectedSuccessMessage" })
    @Test
    public void logInTest(String username, String password, String expectedSuccessMessage) {
        log.info("Starting logIn test");

        //open main page
        HomePage homePage = new HomePage(driver,log);
        homePage.openPage();
        takeScreenshot("Home Page is opened");


        // Click on Form Authentication link
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        takeScreenshot("Login Page is opened");

        // Add new cookie
        Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
        loginPage.setCookie(ck);

        // execute log in
        SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
        takeScreenshot("Secure Area Page is opened");

        // Get cookies
        log.info("Username cookie: " + secureAreaPage.getCookie("username"));
        String session = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + session);

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
