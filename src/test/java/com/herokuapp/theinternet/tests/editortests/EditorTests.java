package com.herokuapp.theinternet.tests.editortests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends BaseTest {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");
        String editorText = new HomePage(driver,log)
                .openPage()
                .clickWYSIWYGEditorLink()
                .getEditorText();
        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}
