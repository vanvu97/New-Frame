package test;

import BaseConfig.StartBrowse;
import newFramePackage.management.ExcelManager;
import org.testng.annotations.Test;
import page.GetTextPage;

import java.io.IOException;

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
