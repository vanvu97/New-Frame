package page;

import BaseConfig.StartUp;
import BaseConfig.TestListenors;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test.XDr;

@Listeners(TestListenors.class)
public class XDRPage extends StartUp {

    XDr xDr = new XDr();

    @Test
    public void Test(){
        xDr.Login();
    }

}
