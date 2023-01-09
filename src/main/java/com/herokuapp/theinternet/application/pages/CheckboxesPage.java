package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.checkboxesPageLocators.CheckBoxesPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePage {
    private By checkbox = CheckBoxesPageLocators.CHECKBOX.getPath();

    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get the checkboxes list and check all list checkboxes */
    public CheckboxesPage selectAllCheckboxes(){
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox: checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
        return this;
    }

    /**
     * Verify all available checkboxes are checked. If at least one unchecked,
     * return false
     */
    public boolean areAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
