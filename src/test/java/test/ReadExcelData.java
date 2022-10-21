package test;

import BaseConfig.BaseConfig;
import BaseConfig.TestListenors;
import management.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPage;

import java.io.IOException;


@Listeners(TestListenors.class)
public class ReadExcelData {

    private WebDriver driver;
    private LoginPage login;

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

        excel.setExcelFile("src/test/dataFile/Boo.xlsx", "Sheet1");

        login = new LoginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        login.login(excel.getCellData("username", 1), excel.getCellData("password", 1));

        excel.setCellData("TestLG", 1, 2);
    }
}
