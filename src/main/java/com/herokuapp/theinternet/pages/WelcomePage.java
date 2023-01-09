package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage{
    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By fileUploadLinkLocator = By.linkText("File Upload");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open WelcomePage with it's url */
    public  WelcomePage openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
        return this;
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    /** Open File Uploader Page by clicking on the File Upload Link */
    public FileUploaderPage clickFileUploadLink() {
        log.info("Clicking the File Upload Link on the Welcome Page");
        click(fileUploadLinkLocator);
        return new FileUploaderPage(driver, log);
    }
}
