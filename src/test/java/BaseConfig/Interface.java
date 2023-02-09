package BaseConfig;

import core.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

public class Interface extends Elements {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected ValidateAction ACTIONs;
    protected Button btn;
    protected final int second_10s = 10;

    protected final int seconds_30s = 30;

    protected final int seconds_60s = 60;


}
