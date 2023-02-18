package test;

import BaseConfig.BaseConfig;
import page.TC1_LoginPage;
import newFramePackage.utils.TestListenors;
import newFramePackage.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(TestListenors.class)
public class ReadExcelData {

    private WebDriver driver;
    private TC1_LoginPage login;

    private ExcelManager excel;

    @BeforeClass
    public void setUp(){

        driver = new BaseConfig().setupBrowser("firefox");
        excel = new ExcelManager();
        //Run extends Base then use the following code
//        WebDriver driver = getDriver();
    }

    @Test
    public void readData() throws IOException, InterruptedException {

        excel.setExcelFile("src/Test/dataFile/Boo.xlsx", "Sheet1");

        login = new TC1_LoginPage();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        login.login(excel.getCellData("username", 1), excel.getCellData("password", 1));

        excel.setCellData("TestLG1", 1, 2);
    }
}
