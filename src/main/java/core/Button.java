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
    public void checkBox(String a) {
        checkBoxs(a);
    }
    public String getTexts(String a){
        getText(a);
        return a;
    }
    public void sendkeyAndSelect(String a, String b, String c){
        sendKeyAndSelect(a, b, c);
    }
    public boolean elementIsDisplayed(String a){
        verifyEle(a);
        return false;
    }

}
