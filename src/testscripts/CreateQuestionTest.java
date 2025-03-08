package testscripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ControlActions;
import base.TestConfigs;
import pages.CreateQuestionPage;
import pages.DashboardPage;
import pages.LibraryPage;
import pages.LoginPage;
import utility.ExcelOperations;

public class CreateQuestionTest {
	DashboardPage dashboardPage;
	CreateQuestionPage createQuestionPage;
	LibraryPage libraryPage;

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
		System.out.println("VERIFY - Create Question button is displayed");
		boolean createQuestionBtnFlag = dashboardPage.isCreateQuestionButtonDisplayed();
		Assert.assertTrue(createQuestionBtnFlag, "Create Question button was not displayed");

		System.out.println("STEP - Click on Library Menu Button in left navigation");
		libraryPage = dashboardPage.clickOnLibraryMenuButton();

		System.out.println("STEP - Get existing question Count on My Library button");
		int existingQuestionCount = libraryPage.getQuestionCountOnMyLibraryButton();

		System.out.println("STEP - Click on Dashboard button in left navigation");
		libraryPage.clickOnDashboardButton();

		System.out.println("STEP - Click on Create Question button");
		createQuestionPage = dashboardPage.clickOnCreateQuestionButton();

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

		System.out.println("STEP - Enter Problem Title");
		createQuestionPage.setProblemTitle("Predict Correct Answer--2");

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

		System.out.println("STEP - Assign Score");
		createQuestionPage.setScore(2);

		System.out.println("STEP - Enter Label");
		createQuestionPage.setLabel("Automation");

		System.out.println("STEP - Select Skills");
		createQuestionPage.setSkill("debugging abilities");

		System.out.println("STEP - Select Topics");
		createQuestionPage.setTopic("stepping through code");

		System.out.println("STEP - Click on publish button");
		createQuestionPage.clickOnPublishBtn();

		System.out.println("VERIFY - 'Question published successfully' toast message displayed");
		boolean toastMessageFlag = createQuestionPage.isTostMessageDisplyed();
		Assert.assertTrue(toastMessageFlag, "Question published successfully toast message was not displayed");

		System.out.println("STEP - Close Create Question Drawer");
		createQuestionPage.closeCreateQuestionDrawer();

		System.out.println("STEP - Click on Library Menu Button in Left Navigation");
		dashboardPage.clickOnLibraryMenuButton();

		System.out.println("VERIFY - Check Question Count on My Library Button Increased By 1");
		int newQuestionCount = libraryPage.getQuestionCountOnMyLibraryButton();
		Assert.assertEquals(newQuestionCount, existingQuestionCount + 1);
	}

	private void setOption(String option, int index) {
		if (option != null && option.trim().length() > 0) {
			System.out.println("STEP - Add Option");
			createQuestionPage.clickOnAddOptionBtn();

			System.out.println("STEP - Enter Option " + index);
			createQuestionPage.setOptionAtIndex(index, option);
		}
	}

	@Test(dataProvider = "getDataForCreateQuestion")
	public void verifyCreateQuestionDataDriven(String title, String statement, String option1, String option2,
			String option3, String option4, String option5, String option6, String correctAns, String score,
			String difficulty, String label, String skill, String topic, String result) {

		System.out.println("VERIFY - Create Question button is displayed");
		boolean createQuestionBtnFlag = dashboardPage.isCreateQuestionButtonDisplayed();
		Assert.assertTrue(createQuestionBtnFlag, "Create Question button was not displayed");

		System.out.println("STEP - Click on Library Menu Button in left navigation");
		libraryPage = dashboardPage.clickOnLibraryMenuButton();

		System.out.println("STEP - Get existing question Count on My Library button");
		int existingQuestionCount = libraryPage.getQuestionCountOnMyLibraryButton();

		System.out.println("STEP - Click on Dashboard button in left navigation");
		libraryPage.clickOnDashboardButton();

		System.out.println("STEP - Click on Create Question button");
		createQuestionPage = dashboardPage.clickOnCreateQuestionButton();

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

		System.out.println("STEP - Enter Problem Title");
		createQuestionPage.setProblemTitle(title);

		System.out.println("STEP - Enter Problem statement");
		createQuestionPage.setProblemStatement(statement); // What is the default value of a local variable in Java?

		System.out.println("STEP - Select Difficulty");
		createQuestionPage.clickOnDifficultyLevel(difficulty);

		System.out.println("STEP - Enter Option 1");
		createQuestionPage.setOptionAtIndex(1, option1);
		String actualOption1 = createQuestionPage.getOptionAtIndex(1);
		Assert.assertEquals(actualOption1, option1);

		System.out.println("STEP - Enter Option 2");
		createQuestionPage.setOptionAtIndex(2, option2);

		setOption(option3, 3);
		setOption(option4, 4);
		setOption(option5, 5);
		setOption(option6, 6);

		int correctAnsIndex = Character.getNumericValue(correctAns.trim().charAt(correctAns.length() - 1));
		System.out.println("STEP - Select Option " + correctAnsIndex + " radio button as answer");
		createQuestionPage.setCorrectAnswerAtIndex(correctAnsIndex);

		System.out.println("STEP - Assign Score");
		createQuestionPage.setScore(score);

		System.out.println("STEP - Enter Label");
		createQuestionPage.setLabel(label);

		System.out.println("STEP - Select Skills");
		createQuestionPage.setSkill(skill);

		System.out.println("STEP - Select Topics");
		createQuestionPage.setTopic(topic);

		System.out.println("STEP - Click on publish button");
		createQuestionPage.clickOnPublishBtn();

		System.out.println("VERIFY - 'Question published successfully' toast message displayed");
		boolean toastMessageFlag = createQuestionPage.isTostMessageDisplyed();
		Assert.assertTrue(toastMessageFlag, "Question published successfully toast message was not displayed");

		System.out.println("STEP - Close Create Question Drawer");
		createQuestionPage.closeCreateQuestionDrawer();

		System.out.println("STEP - Click on Library Menu Button in Left Navigation");
		dashboardPage.clickOnLibraryMenuButton();

		System.out.println("VERIFY - Check Question Count on My Library Button Increased By 1");
		int newQuestionCount = libraryPage.getQuestionCountOnMyLibraryButton();
		Assert.assertEquals(newQuestionCount, existingQuestionCount + 1);
	}

	@DataProvider
	public Object[][] getDataForCreateQuestion() throws Exception {
		return ExcelOperations.getSheetData("testdata/CreateQuestion.xlsx", "Data");
	}

	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
