package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage{
    private By choseFileFieldLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadedFilesLocator = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Push Upload button */
    public  FileUploaderPage pushUploadButton() {
        log.info("Clicking on upload button");
        click(uploadButtonLocator);
        return this;
    }

    /** Push Upload button */
    public FileUploaderPage selectFile(String fileName) {
        log.info("Selecting '" + fileName + "' file from Files folder");
        // Selecting file
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(filePath, choseFileFieldLocator);
        log.info("File selected");
        return this;
    }

    /** Get names of uploaded files */
    public String getUploadedFilesNames() {
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded files: " + names);
        return names;
    }
}
