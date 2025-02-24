package testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.ControlActions;
import base.TestConfigs;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest {
    /**
     * Sets up the test environment by launching the browser and logging in.
     */
    @BeforeMethod
    public void setup() {
        System.out.println("STEP - Open chrome browser and load https://staging.app.hirecorrecto.com");
        ControlActions.launchBrowser();

        LoginPage loginPage = new LoginPage();

        System.out.println("VERIFY - Login page is loaded.");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.waitForPageLoad(), "Login page failed to load");
        softAssert.assertAll(); // Ensure login page loads before proceeding

        System.out.println("STEP - Enter username");
        loginPage.enterUsername(TestConfigs.VALID_USERNAME);

        System.out.println("STEP - Enter password");
        loginPage.enterPassword(TestConfigs.VALID_PASSWORD);

        System.out.println("STEP - Click on login button");
        loginPage.clickLoginButton();
    }

    /**
     * Verifies various elements on the dashboard page are displayed correctly using soft assertions.
     * All assertions are collected and reported at the end of the test.
     */
    @Test
    public void verifyDashboardPage() {
        DashboardPage dashboardPage = new DashboardPage();
        SoftAssert softAssert = new SoftAssert();

        System.out.println("VERIFY - Dashboard page is loaded.");
        softAssert.assertTrue(dashboardPage.waitForPageLoad(), "Dashboard page failed to load");
        softAssert.assertTrue(dashboardPage.isWelcomeMessageVisible(), "Welcome message not visible");

        System.out.println("VERIFY - Total Assessments label");
        softAssert.assertEquals(dashboardPage.getTotalAssessmentsLabel(), "Total Assessments",
            "Total Assessments label mismatch");

        System.out.println("VERIFY - Total Assessments Count");
        softAssert.assertTrue(dashboardPage.getTotalAssessmentsCount() >= 0,
            "Total Assessments count should be non-negative");

        System.out.println("VERIFY - Total Appeared label");
        softAssert.assertEquals(dashboardPage.getTotalAppearedLabel(), "Total Appeared",
            "Total Appeared label mismatch");

        System.out.println("VERIFY - Total Appeared Count");
        softAssert.assertTrue(dashboardPage.getTotalAppearedCount() >= 0,
            "Total Appeared count should be non-negative");

        System.out.println("VERIFY - Total Qualified label");
        softAssert.assertEquals(dashboardPage.getTotalQualifiedLabel(), "Total Qualified",
            "Total Qualified label mismatch");

        System.out.println("VERIFY - Total Qualified Count");
        softAssert.assertTrue(dashboardPage.getTotalQualifiedCount().contains("%"),
            "Total Qualified count should contain percentage symbol");

        System.out.println("VERIFY - View Template label");
        softAssert.assertEquals(dashboardPage.getViewTemplateLabel(), "View Template",
            "View Template label mismatch");

        System.out.println("VERIFY - Create Question label");
        softAssert.assertEquals(dashboardPage.getCreateQuestionLabel(), "Create Question",
            "Create Question label mismatch");

        System.out.println("VERIFY - Create Assessment label");
        softAssert.assertEquals(dashboardPage.getCreateAssessmentLabel(), "Create Assessment",
            "Create Assessment label mismatch");

        // Report all assertion failures at the end
        softAssert.assertAll();
    }

    /**
     * Tears down the test environment by closing the browser.
     */
    @AfterMethod
    public void teardown() {
        ControlActions.closeBrowser();
    }
}