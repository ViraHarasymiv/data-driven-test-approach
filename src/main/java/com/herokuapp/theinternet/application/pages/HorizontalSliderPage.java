package com.herokuapp.theinternet.application.pages;

import com.herokuapp.theinternet.application.locators.horizontalSliderPageLocators.HorizontalSliderPageLocators;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage{
    private By range = HorizontalSliderPageLocators.RANGE.getPath();
    private By slider = HorizontalSliderPageLocators.SLIDER.getPath();
    public HorizontalSliderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Move slider to specified value */
    public HorizontalSliderPage setSliderTo(String value) {
        log.info("Moving slider to " + value);

        // Move slider normal method
        // Find the xOffset using given value
        // int width = find(sliderLocator).getSize().getWidth();
        // double percent = Double.parseDouble(value) / 5;
        // int xOffset = (int) (width * percent);

        // Actions action = new Actions(driver);
        // action.dragAndDropBy(find(sliderLocator), xOffset, 0).build().perform();

        // Workaround method
        // Calculate number of steps
        int steps = (int) (Double.parseDouble(value) / 0.5);
        // Perform steps
        pressKey(slider, Keys.ENTER);
        for (int i = 0; i < steps; i++) {
            pressKey(slider, Keys.ARROW_RIGHT);
        }
        return this;
    }

    /** Getting slider value */
    public String getSliderValue() {
        String value = find(range).getText();
        log.info("Slider value is " + value);
        return value;
    }
}
