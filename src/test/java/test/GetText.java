package test;

import BaseConfig.StartBrowse;
import newFramePackage.management.ExcelManager;
import org.testng.annotations.Listeners;
import newFramePackage.management.ExcelManager;
import org.testng.annotations.Test;
import page.GetTextPage;
import newFramePackage.utils.TestListenors;

import java.io.IOException;

@Listeners(TestListenors.class)
public class GetText extends StartBrowse {
    private GetTextPage getTextPage;
    private ExcelManager excel;

    @Test
    public void getTexts() throws InterruptedException, IOException {
        getTextPage = new GetTextPage(driver);
        excel = new ExcelManager();

        getTextPage.sText();
    }


}
