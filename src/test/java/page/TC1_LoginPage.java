package page;

import newFramePackage.core.Button;
import newFramePackage.management.Log;
import newFramePackage.utils.ValidateAction;
import org.testng.Assert;

public class TC1_LoginPage extends Button {

    String username = "xpath//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@placeholder='Username']";
    String password = "name//password";
    String loginBtn = "xpath//button";

    String uName = "Admin";
    String pWord = "admin123";
    ValidateAction action;

    Button btn = new Button();

    public TC2_PIMPage login(String a, String b){
        action = new ValidateAction(getDriver());
        action.waitForPageLoad();
        Log.info(" - Nhập username");
        btn.sendKey(username, uName );
        Log.info(" - Nhập password");
        btn.sendKey(password, pWord);
        Log.info(" - Nhấn Login");
        btn.clickButton(loginBtn);
        Assert.assertEquals(btn.getDriver().getTitle(), "OrangeHRM");
        Log.info(" - Login thành công");
        return new TC2_PIMPage();
    }

}
