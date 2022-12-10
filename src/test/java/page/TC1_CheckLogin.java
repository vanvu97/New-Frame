package page;

import core.Button;

public class TC1_CheckLogin {

    String username = "name//username";
    String password = "name//password";
    String loginBtn = "xpath//button";
    String a = "xpath//div[@class='oxd-input-group oxd-input-field-bottom-space']/following::label[contains(text(), 'Smoker')]/ancestor::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//input";
    String FILE_PATH;

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    Button btn = new Button();

    public void Login() {
//        Log.info("1. Nhập username");
//        btn.sendKey(username, "Admin");
//        Log.info("2. Nhập password");
//        btn.sendKey(password, "admin123");
//        Log.info("3. Nhấn Login");
//        btn.clickButton(loginBtn);
//        Assert.assertEquals(btn.getDriver().getTitle(), "Test");
//        Log.info("4. Login thành công");

        btn.waitForPageLoad();
        btn.checkBoxs(a);

    }


}
