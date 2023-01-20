package com.herokuapp.theinternet.tests.uploadTests;

import com.herokuapp.theinternet.application.pages.HomePage;
import com.herokuapp.theinternet.utils.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int number, String fileName) {
        log.info("Starting fileUploadTest #" + number + " for " + fileName);
        String fileNames = new HomePage(driver,log)
                .openPage()
                .clickFileUploadLink()
                .selectFile(fileName)
                .pushUploadButton()
                .getUploadedFilesNames();
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
