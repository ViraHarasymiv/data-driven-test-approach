package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.homePageLocators.HomePageLocators;
import com.herokuapp.theinternet.application.locators.javaScriptAlertsPageLocators.JavaScriptAlertsPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = HomePageLocators.FORM_AUTHENTICATION_LINK_LOCATOR.getPath();
    private By fileUploadLinkLocator = HomePageLocators.FILE_UPLOAD_LINK_LOCATOR.getPath();
    private By checkboxesLocator = HomePageLocators.CHECKBOXES_LOCATOR.getPath();
    private By dropdownLinkLocator = HomePageLocators.DROPDOWN_LINK_LOCATOR.getPath();
    private By javaScriptAlertsLinkLocator = HomePageLocators.JAVA_SCRIPT_ALERTS_LINK_LOCATOR.getPath();
    private By multipleWindowsLinkLocator = HomePageLocators.MULTIPLE_WINDOWS_LINK.getPath();
    private By editorLinkLocator = HomePageLocators.EDITOR_LINK.getPath();
    private By keyPresses = HomePageLocators.KEY_PRESSES.getPath();
    private By horizontalSlider = HomePageLocators.HORIZONTAL_SLIDER.getPath();
    private By javaScriptOnLoadEventError = HomePageLocators.JAVASCRIPT_ONLOAD_EVENT_ERROR.getPath();

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

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new EditorPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }
    public KeyPressesPage clickOnKeyPresses(){
        log.info("Clicking on the Key Presses link");
        click(keyPresses);
        return new KeyPressesPage(driver,log);
    }

    public HorizontalSliderPage clickOnHorizontalSlider(){
        click(horizontalSlider);
        return new HorizontalSliderPage(driver,log);
    }
    public JSErrorPage clickOnJavaScriptOnLoadEventError(){
        log.info("Clicking on the JavaScript OnLoad EventError link");
        click(javaScriptOnLoadEventError);
        return new JSErrorPage(driver,log);
    }

}
