package pages;

import com.aventstack.extentreports.ExtentReports;
import data.Constants;
import locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Logs;
import utils.ValidateAction;

import java.util.ArrayList;
import java.util.List;

public class CustomDashboardPage extends BasePage{

    private final By menuIcon = By.xpath("//i[@class='gx-icon-btn icon icon-menu-unfold']");
    private final By getPageTitle = By.xpath("//div[@class='title']/div[2]");
    private final By settingIcon = By.xpath("//span[@aria-label='setting']");
    private final By checkFilterDomain = By.xpath("//div[@class='Wrapper_selector-wrapper__8Zp63']/div/div/div/div/label");
    private final By closeGlobalFilterBtn = By.xpath("//div[contains(@class, 'Header_selector-header__H6RE4')]//span[@aria-label='close']");
    private final By shapeTitle = By.xpath("//div[@class='Container_dashboard-wrapper__549FV Container_LIGHT__uefoN']//div[contains(@class, '-title__')]/div[1]");
    private final By getCreateDashboardBtn = By.xpath("//div[@class='EmptyCustom_create-dashboard__Qwzjy']");
    private final By dashboardTemplatePopup = By.xpath("//div[@class='Template_create-title__GrsTG']");
    private final By templateTitle = By.xpath("//div[@class='Template_template-title__f47UN']");
    private final By widgetTitle = By.xpath("//div[@class='WidgetList_widget-title__GyH5Z']");
    private final By isWidgetEmpty = By.xpath("//div[@class='Empty_empty-text__cu5nk']");
    private final By widgetPopupTitle = By.xpath("//div[@class='ant-modal-title']");
    private final By dataTypeField = By.xpath("//span[@class='ant-select-selection-item']");
    private final By dataTypeValues = By.xpath("//div[@class='ant-select-item-option-content']");

    protected ValidateAction ACTION;
    public CustomDashboardPage(WebDriver driver) {
        super(driver);
        ACTION = new ValidateAction(driver);
    }

    public CustomDashboardPage navigateToCustomDashboard() {
        Logs.info("Open left side panel");
        ACTION.clickElement(menuIcon);

        Logs.info("Navigate to Custom Dashboard page!");
        ACTION.clickElement(Locator.CUSTOM_DASHBOARD_PAGE);
        return this;
    }

    public CustomDashboardPage verifyCustomDashboardIsOpened(){
        Logs.info("Verify the Custom Dashboard page is opened");
        ACTION.assertTitleText("Custom Dashboard", getPageTitle);
        return this;
    }

    public CustomDashboardPage filterAllDomain(){
        Logs.info("Click on Setting icon");
        ACTION.clickElement(settingIcon);

        Logs.info("Check on checkbox filter Domain");
        ACTION.clickElement(checkFilterDomain);

        Logs.info("Close filter panel");
        ACTION.clickElement(closeGlobalFilterBtn);
        return this;
    }

    public CustomDashboardPage verifyInitialCustomDashboard(){
        Logs.info("Is the Create Dashboard button is displayed?");
        if(ACTION.isExisting(getCreateDashboardBtn)){
            Logs.info("No, Create Dashboard button is displayed, Click Create Dashboard button");
            ACTION.clickElement(getCreateDashboardBtn);
            verifyDashboardTemplatePopupIsDisplayed();
            createCustomDashboard("New Dashboard");
        }else {
            Logs.info("Yes, Custom Dashboard already existed, getting listTemplateTitle of shape's name");
            ACTION.getListText(shapeTitle);
        }
        return this;
    }

    public CustomDashboardPage verifyDashboardTemplatePopupIsDisplayed(){
        Logs.info("Verify Choose Dashboard Template pop-up is displayed?");
        if(ACTION.isExisting(dashboardTemplatePopup)){
            Logs.info("Verify Choose Dashboard Template pop-up title!");
            ACTION.assertTitleText("Choose Dashboard Template", dashboardTemplatePopup);

            Logs.info("Verify title of template list!");
            String [] listTemplateTitle = Constants.listTemplateTitle;
            ACTION.assertListText(templateTitle, listTemplateTitle);
        }
        return this;
    }

    public CustomDashboardPage createCustomDashboard(String customDashboard){
        Logs.info("Select Custom Dashboard: " + customDashboard);
        ACTION.clickElement(Locator.selectDashboardTemplate(customDashboard));

        Logs.info("Is Widget of Custom Dashboard is empty when select " + customDashboard);
        if(ACTION.isExisting(isWidgetEmpty)){
            Logs.info("Yes, Widget of Custom Dashboard is empty");
            ACTION.assertTitleText("Click to place widget!", isWidgetEmpty);
        }

        String [] listWidgetTitle = Constants.listWidgetTitle;
        Logs.info("Verify list widget name is correct!");
        ACTION.assertListText(widgetTitle, listWidgetTitle);
        return this;
    }

    public CustomDashboardPage verifyPopupWidget(String widgetName, String popupTitle, String[] listDataType){
        Logs.info("Click on " + widgetName + " button");
        ACTION.clickElement(Locator.selectWidgetName(widgetName));

        Logs.info("Verify the " + popupTitle + " pop-up is displayed");
        ACTION.assertTitleText(popupTitle, widgetPopupTitle);

        Logs.info("Verify the Data Type of " + widgetName);
        ACTION.clickElement(dataTypeField);
        ACTION.assertListText(dataTypeValues, listDataType);
        return this;
    }
}
