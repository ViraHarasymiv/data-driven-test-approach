package com.herokuapp.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class contains user's automated steps for the success logging.
 *
 * @author Vira Harasymiv
 */
public class PositiveLoginTest {
    @Test
    public void logInTest() {
        System.out.println("Starting logIn test");
        // Create the driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // pull up the Home Page
        String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("Main page is opened.");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click();

        // enter username and password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // push the LogIn button
        WebElement logInButton = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();

        // verifications
        // new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // log out button is visible
        softAssert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
        softAssert.assertAll();

        // Close browser
        driver.quit();
    }
}
