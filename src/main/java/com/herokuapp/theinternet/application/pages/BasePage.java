package com.herokuapp.theinternet.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final long TIME_TO_WAIT = 60;
    protected WebDriver driver;
    protected Logger log;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT));
    }

    /**
     * Wait for given number of seconds for element with the given locator becomes visible
     * on the page
     */
    protected void waitForVisibilityOfElement(By locator) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /**
     * Wait for given number of seconds for elements with given locators become visible
     * on the page
     */
    protected void waitForVisibilityOfElements(By locator) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /** Open page with given URL */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /** Get URL of current page from browser */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /** Find element using given locator */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click on element with given locator when its visible */
    protected void click(By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).click();
    }

    /** Type given text into element with given locator */
    protected void type(String text, By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).sendKeys(text);
    }

    /** Find all elements using the given locator */
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
