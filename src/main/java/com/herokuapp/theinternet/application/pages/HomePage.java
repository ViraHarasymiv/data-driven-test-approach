package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.homePageLocators.HomePageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = HomePageLocators.FORM_AUTHENTICATION_LINK_LOCATOR.getPath();
    private By fileUploadLinkLocator = HomePageLocators.FILE_UPLOAD_LINK_LOCATOR.getPath();
    private By checkboxesLocator = HomePageLocators.CHECKBOXES_LOCATOR.getPath();
    private By dropdownLinkLocator = HomePageLocators.DROPDOWN_LINK_LOCATOR.getPath();

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open HomePage with it's url */
    public HomePage openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
        return this;
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on the Home Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    /** Open File Uploader Page by clicking on the File Upload Link */
    public FileUploaderPage clickFileUploadLink() {
        log.info("Clicking the File Upload Link on the Home Page");
        click(fileUploadLinkLocator);
        return new FileUploaderPage(driver, log);
    }

    /** Open the Checkboxes Page by clicking on the Checkboxes link */
    public CheckboxesPage clickOnCheckboxesLink(){
        log.info("Clicking on the Checkboxes link on the Home Page");
        click(checkboxesLocator);
        return new CheckboxesPage(driver,log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }
}
