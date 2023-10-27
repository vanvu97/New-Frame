package tests;

import core.BaseTests;
import data.Constants;
import manage.PropertiesManager;
import org.testng.annotations.Test;
import pages.CustomDashboardPage;


public class TC02_CustomDashboard extends BaseTests {
    @Test(description = "Navigate to Custom Dashboard page!")
    public void CustomDashboardPage() {
        CustomDashboardPage customDashboard = new CustomDashboardPage(getDriver());
        customDashboard
                .navigateToCustomDashboard()
                .verifyCustomDashboardIsOpened()
                .verifyInitialCustomDashboard()
                .verifyPopupWidget("line", "Line Widget", Constants.listDataTypeOfLine);
    }
}
