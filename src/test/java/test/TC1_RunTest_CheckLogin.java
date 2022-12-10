package test;

import BaseConfig.StartUp;
import BaseConfig.TestListenors;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.TC1_CheckLogin;

@Listeners(TestListenors.class)
public class TC1_RunTest_CheckLogin extends StartUp {
    TC1_CheckLogin tc1_checkLogin = new TC1_CheckLogin();

    @Test
    public void Test() {

        tc1_checkLogin.Login();

    }
}
