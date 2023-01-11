package com.herokuapp.theinternet.tests.horizontalslidertests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.runners.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTest {
    private static final String VALUE = "3.5";

    @Test
    public void sliderTest() {
        log.info("Starting sliderTest");
        String sliderValue = new HomePage(driver,log)
                .openPage()
                .clickOnHorizontalSlider()
                .setSliderTo(VALUE)
                .getSliderValue();
        // Verify slider value
        Assert.assertTrue(sliderValue.equals(VALUE), "Range is not correct. It is: " + sliderValue);
    }
}
