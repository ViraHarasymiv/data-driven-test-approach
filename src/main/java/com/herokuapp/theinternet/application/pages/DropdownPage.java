package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.dropdownPageLocators.DropdownPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
    private By dropdown = DropdownPageLocators.DROPDOWN.getPath();

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** This method selects given option from dropdown */
    public DropdownPage selectOption(int i) {
        log.info("Selecting option " + i + " from dropdown");
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        // There are three ways to use Select class
        // #1
        // dropdown.selectByIndex(i);

        // #2
        dropdown.selectByValue("" + i);

        // #3
        // dropdown.selectByVisibleText("Option " + i);
        return this;
    }

    /** This method returns selected option in dropdown as a string */
    public String getSelectedOption() {
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }
}