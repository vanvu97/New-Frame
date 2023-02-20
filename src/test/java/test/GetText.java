package test;

import BaseConfig.StartBrowse;
<<<<<<< HEAD
<<<<<<< HEAD
import management.ExcelManager;
import org.testng.annotations.Listeners;
=======
import newFramePackage.management.ExcelManager;
>>>>>>> ae33f1a6af85d7af3c8213825601a3e4fa0fa30d
=======
import newFramePackage.management.ExcelManager;
>>>>>>> refs/remotes/origin/main
import org.testng.annotations.Test;
import page.GetTextPage;
import utils.TestListenors;

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
