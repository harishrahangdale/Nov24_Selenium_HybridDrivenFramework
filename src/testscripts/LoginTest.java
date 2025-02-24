package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest {
    private static final String VALID_USERNAME = "hsr.29978@gmail.com";
    private static final String VALID_PASSWORD = "Pass@123";
    private static final String EXPECTED_DASHBOARD_URL = "https://staging.app.hirecorrecto.com/dashboard";

    /**
     * Verifies login functionality with valid credentials.
     * Runs 5 times as specified by invocationCount.
     * Tests page load, credential entry, and dashboard navigation.
     */
    @Test(invocationCount = 5)
    public void verifyValidLoginCredentials() {
        System.out.println("STEP - Open chrome browser and load https://staging.app.hirecorrecto.com");
        ControlActions.launchBrowser();

        LoginPage loginPage = new LoginPage();

        System.out.println("VERIFY - Login page is loaded");
        Assert.assertTrue(loginPage.waitForPageLoad(), "Login page failed to load");

        System.out.println("STEP - Enter username");
        loginPage.enterUsername(VALID_USERNAME);

        System.out.println("STEP - Enter password");
        loginPage.enterPassword(VALID_PASSWORD);

        System.out.println("STEP - Click on login button");
        loginPage.clickLoginButton();

        System.out.println("VERIFY - Dashboard page is displayed for valid credentials");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitForPageLoad();

        String actualUrl = dashboardPage.getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith(EXPECTED_DASHBOARD_URL), 
            "Expected URL to start with: " + EXPECTED_DASHBOARD_URL + ", but got: " + actualUrl);

        ControlActions.closeBrowser();
    }
}