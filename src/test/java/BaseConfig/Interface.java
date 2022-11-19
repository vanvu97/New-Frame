package BaseConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ValidateAction;

public class Interface {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected ValidateAction ACTIONs;

    protected final int second_10s = 10;

    protected final int seconds_30s = 30;

    protected final int seconds_60s = 60;

}
