package com.herokuapp.theinternet.tests.checkboxesPagesTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesPageTests extends TestUtilities {

    @Test
    public void selectAllCheckboxesTest(){
        boolean allCheckboxesAreSelected = new HomePage(driver,log)
                .openPage()
                .clickOnCheckboxesLink()
                .selectAllCheckboxes()
                .areAllCheckboxesChecked();
        Assert.assertTrue(allCheckboxesAreSelected, "Not all checkboxes are checked");
    }
}
