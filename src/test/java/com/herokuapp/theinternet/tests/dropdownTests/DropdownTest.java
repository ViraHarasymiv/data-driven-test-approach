package com.herokuapp.theinternet.tests.dropdownTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void selectSecondOptionTest(){
        log.info("Starting selectSecondOptionTest");
        String selectedOption = new HomePage(driver,log)
                .openPage()
                .clickDropdownLink()
                .selectOption(2)
                .getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected - " + selectedOption);
    }
}
