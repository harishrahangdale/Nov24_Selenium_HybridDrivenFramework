package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import base.TestConfigs;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest {
	WebDriver driver;
	WebDriverWait wait;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setup() {

		System.out.println("STEP - Open chrome browser and load https://staging.app.hirecorrecto.com");
		ControlActions.start();

		System.out.println("STEP - Perform login action and go to dashboard page");
		LoginPage loginPage = new LoginPage();
		dashboardPage = loginPage.login(TestConfigs.VALID_USERNAME, TestConfigs.VALID_PASSWORD);
	}

	@Test
	public void verifyDashboardUiElements() {
		System.out.println("VERIFY - Dashboard Page is loaded");
		Assert.assertTrue(dashboardPage.waitForPageLoad("dashboard"));

		System.out.println("VERIFY - The 'Hello, Welcome Back' message on the dashboard");
		Assert.assertTrue(dashboardPage.isWelcomeMessageVisible());

		System.out.println("VERIFY - 'Total Assessments' Lable");
		Assert.assertTrue(dashboardPage.isTotalAssessmentsLabelVisible());

		System.out.println("VERIFY - 'Total Assessments' count");
		Assert.assertTrue(dashboardPage.getTotalAssessmentsCount() >= 0);

		System.out.println("VERIFY - 'Total Appeared' Lable");
		Assert.assertTrue(dashboardPage.isTotalAppearedLabelVisible());

		System.out.println("VERIFY - 'Total Appeared' count");
		Assert.assertTrue(dashboardPage.getTotalAppearedCount() >= 0);

		System.out.println("VERIFY - 'Total Qualified' Lable");
		Assert.assertTrue(dashboardPage.isTotalQualifiedLabelVisible());

		System.out.println("VERIFY - 'Total Qualified' count");
		int totalQualifiedCount = dashboardPage.getTotalQualifiedCount();
		Assert.assertTrue(totalQualifiedCount >= 0,
				"Qualified % count should be >=0, but it was displayed as " + totalQualifiedCount);

		System.out.println("VERIFY - 'View Template' button is visible");
		Assert.assertTrue(dashboardPage.isViewTemplateButtonLabelVisible(), "View Template button was not displayed");

		System.out.println("VERIFY - 'Create Question' button is visible");
		Assert.assertTrue(dashboardPage.isCreateQuestionButtonLabelVisible(),
				"Create Question button was not displayed");

		System.out.println("VERIFY - 'Create Assessment' button is visible");
		Assert.assertTrue(dashboardPage.isCreateAssessmentButtonLabelVisible(),
				"Create Assessement button was not displayed");
	}
}