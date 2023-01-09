package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.runners.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int number, String fileName) {
        log.info("Starting fileUploadTest #" + number + " for " + fileName);
        String fileNames = new WelcomePage(driver,log)
                .openPage()
                .clickFileUploadLink()
                .selectFile(fileName)
                .pushUploadButton()
                .getUploadedFilesNames();
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
