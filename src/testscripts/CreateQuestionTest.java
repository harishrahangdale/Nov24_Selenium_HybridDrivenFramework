package testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import base.TestConfigs;
import pages.CreateQuestionPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CreateQuestionTest {
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setup() {
		System.out.println("PREREQUISITE - Login HireCorrecto using valid credentials and user is on dashboard page.");
		ControlActions.start();
		LoginPage page = new LoginPage();
		dashboardPage = page.login(TestConfigs.VALID_USERNAME, TestConfigs.VALID_PASSWORD);
		dashboardPage.waitForPageLoad("dashboard");
	}

	@Test
	public void verifyCreateQuestion() {
		System.out.println("VERIFY - Create Question Button is displayed");
		boolean createQuestionBtnFlag = dashboardPage.isCreateQuestionButtonLabelVisible();
		Assert.assertTrue(createQuestionBtnFlag, "Create Question button was not displayed");

		System.out.println("STEP - Click on Create Questions button");
		CreateQuestionPage createQuestionPage = dashboardPage.clickCreateQuestionButton();

		System.out.println("VERIFY - MCQ Question is displayed");
		boolean createMCQBtnFlag = createQuestionPage.isQuestionTypeBtnDisplayed("MCQ");
		Assert.assertTrue(createMCQBtnFlag, "Question Type MCQ button was not displayed");

		System.out.println("VERIFY - 3 Questions Type should be displayed");
		int countOfQuestionType = createQuestionPage.countOfVisibleQuetionType();
		Assert.assertEquals(countOfQuestionType, 3);

		System.out.println("VERIFY - Text of all Questions Type");
		List<String> expectedListOfQuestionTypeText = new ArrayList<String>(Arrays.asList("MCQ", "Programming", "SQL"));
		List<String> actualListOfQuestionTypeText = createQuestionPage.getAllQuestionTypeText();

		Assert.assertEquals(actualListOfQuestionTypeText, expectedListOfQuestionTypeText);

		System.out.println("STEP - Click on MCQ button");
		createQuestionPage.clickOnQuestionType("MCQ");

		System.out.println("STEP - Enter Problem statement");
		createQuestionPage.setProblemStatement("select the correct statement from given options");

		System.out.println("STEP - Select Difficulty");
		createQuestionPage.clickOnDifficultyLevel("Medium");

		System.out.println("STEP - Enter Option 1");
		createQuestionPage.setOptionAtIndex(1, "we can declare class as protected");
		String option1 = createQuestionPage.getOptionAtIndex(1);
		Assert.assertEquals(option1, "we can declare class as protected");

		System.out.println("STEP - Enter Option 2");
		createQuestionPage.setOptionAtIndex(2, "constructors can be overriden");

		System.out.println("STEP - Add Option");
		createQuestionPage.clickOnAddOptionBtn();

		System.out.println("STEP - Enter Option 3");
		createQuestionPage.setOptionAtIndex(3, "local variable can be declared as final");

		System.out.println("STEP - Add Option");
		createQuestionPage.clickOnAddOptionBtn();

		System.out.println("STEP - Enter Option 4");
		createQuestionPage.setOptionAtIndex(4, "All the classes in set interface maintains insertion order");

		System.out.println("STEP - Select Option 1 radio button as answer");
		createQuestionPage.setCorrectAnswerAtIndex(3);

		System.out.println("STEP - Enter Label");
		createQuestionPage.setLabel("Automation");

		System.out.println("STEP - Select Skills");
		createQuestionPage.setSkill("javascript mastery");
	}

	@AfterMethod
	public void tearDown() {
		// ControlActions.closeBrowser();
	}
}