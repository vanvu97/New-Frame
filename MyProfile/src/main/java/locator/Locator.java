package locator;

import org.openqa.selenium.By;

public class Locator {
    public static final By USERNAME = By.id("username");
    public static final By PASSWORD = By.id("password");
    public static final By BTN_SUBMIT = By.xpath("//button[@type='submit']");
    public static final By CUSTOM_DASHBOARD_PAGE = By.xpath("//ul[contains(@class, 'ant-menu')]/li[2]");
    public static By selectDashboardTemplate(String path){
        return By.xpath("//div[@class='Template_template-title__f47UN' and contains(text(), '"+path+"')]");
    }
    public static By selectWidgetName(String title){
        return By.xpath("//div[@class='WidgetList_widget-title__GyH5Z' and contains(text(), '" + title +"')]");
    }

}
