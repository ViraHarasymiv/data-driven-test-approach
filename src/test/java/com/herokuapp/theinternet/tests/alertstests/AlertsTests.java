package com.herokuapp.theinternet.tests.alertstests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.application.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends BaseTest {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");
        JavaScriptAlertsPage javaScriptAlertsPage = new HomePage(driver, log)
                .openPage()
                .clickJavaScriptAlertsLink()
                .openJSAlert();
        String alertMessage = javaScriptAlertsPage.getAlertText();
        String result = javaScriptAlertsPage
                .acceptAlert()
                .getResultText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");
        softAssert.assertTrue(result.equals("You successfully clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsDismissTest() {
        log.info("Starting jsDismissTest");
        JavaScriptAlertsPage javaScriptAlertsPage = new HomePage(driver,log)
                .openPage()
                .clickJavaScriptAlertsLink()
                .openJSConfirm();
        String alertMessage = javaScriptAlertsPage.getAlertText();
        String result = javaScriptAlertsPage
                .dismissAlert()
                .getResultText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
        softAssert.assertAll();
}
    @Test
    public void jsPromptTest() {
        log.info("Starting jsDismissTest");
        JavaScriptAlertsPage javaScriptAlertsPage = new HomePage(driver,log)
                .openPage()
                .clickJavaScriptAlertsLink()
                .openJSPrompt();
        String alertMessage = javaScriptAlertsPage.getAlertText();
        String result = javaScriptAlertsPage.typeTextIntoAlert("Hello Alert")
                .getResultText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");
        softAssert.assertTrue(result.equals("You entered: Hello Alert"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
                        + "'");
        softAssert.assertAll();
    }
}
