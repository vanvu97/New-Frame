package test;

import BaseConfig.startBrowse;
import management.Log;
import org.testng.annotations.Test;

import java.io.IOException;

public class logTest extends startBrowse {
    @Test(priority = 1)
    public void login() throws InterruptedException, IOException {
        Log.info("1. Running Login");
        driver.navigate().to("https://www.google.com");

    }
}
