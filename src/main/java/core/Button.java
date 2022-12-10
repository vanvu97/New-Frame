package core;

public class Button extends Handler {

    public void clickButton(String a) {
        click(a);
    }

    public void sendKey(String a, String b) {
        sendKeys(a, b);
    }

    public void selectOptions(String a, String b) {
        selectOption(a, b);
    }

    public void checkBoxs(String a) {
        checkBox(a);
    }


}
