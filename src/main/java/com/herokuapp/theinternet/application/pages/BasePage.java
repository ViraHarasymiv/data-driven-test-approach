package com.herokuapp.theinternet.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    /**
     * Wait for given number of seconds for the text becomes visible in the element given by the locator
     */
    protected void waitForTextToBePresentInElement(By locator, String text) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /**
     * Open page with given URL
     */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Get URL of current page from browser
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Find element using given locator
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Click on element with given locator when its visible
     */
    protected void click(By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).click();
    }

    /**
     * Type given text into element with given locator
     */
    protected void type(String text, By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).sendKeys(text);
    }

    /**
     * Find all elements using the given locator
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Wait for alert present and then switch to it
     */
    protected Alert switchToAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    /** Switch to iFrame using it's locator */
    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }
    /** Get title of current page */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();
        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }
    /** Get source of current page */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }
    /** Press Key on locator */
    protected void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    /** Press Key using Actions class */
    public BasePage pressKeyWithActions(Keys key) {
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
        return this;
    }
    /** Perform scroll to the bottom */
    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
