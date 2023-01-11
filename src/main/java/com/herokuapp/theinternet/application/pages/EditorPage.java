package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.editorPageLocators.EditorPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditorPage extends BasePage{
    private By editor = EditorPageLocators.EDITOR.getPath();
    private By iframe = EditorPageLocators.IFRAME.getPath();

    public EditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get text from TinyMCE WYSIWYG Editor */
    public String getEditorText() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
       // switchToFrame(iframe);
        String text = find(editor).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);
        return text;
    }
}
