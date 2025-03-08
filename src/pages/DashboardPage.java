package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class DashboardPage extends ControlActions {

	@FindBy(xpath = "//div[text()='Hello, Welcome Back!!']")
	WebElement welcomeElement;

	@FindBy(xpath = "//p[text()='Total Assessments']")
	WebElement totalAssessmentsLabelElement;

	@FindBy(xpath = "//p[text()='Total Assessments']//following-sibling::h6")
	WebElement totalAssessmentsCountElement;

	@FindBy(xpath = "//p[text()='Total Appeared']")
	WebElement totalAppearedLabelElement;

	@FindBy(xpath = "//p[text()='Total Appeared']//following-sibling::h6")
	WebElement totalAppearedCountElement;

	@FindBy(xpath = "//p[text()='Total Qualified']")
	WebElement totalQualifiedLabelElement;

	@FindBy(xpath = "//p[text()='Total Qualified']//following-sibling::h6")
	WebElement totalQualifiedCountElement;

	@FindBy(xpath = "//p[text()='View Template']")
	WebElement viewTemplateButtonElement;

	@FindBy(xpath = "//p[text()='Create Question']")
	WebElement createQuestionButtonElement;

	@FindBy(xpath = "//p[text()='Create Assessment']")
	WebElement createAssessmentButtonElement;

	@FindBy(xpath = "//span[text()='Library']")
	WebElement libraryButtonElement;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean waitForPageLoad(String text) {
		return waitUntilURLContains(text);
	}

	public String getDashboardPageUrl() {
		return getCurrentURL();
	}

	public boolean isWelcomeMessageVisible() {
		return isElementDisplayed(welcomeElement, true);
	}

	public boolean isTotalAssessmentsLabelVisible() {
		return isElementDisplayed(totalAssessmentsLabelElement, false);
	}

	public int getTotalAssessmentsCount() {
		String totalAssessmentCount = getElementText(totalAssessmentsCountElement, false);
		return Integer.parseInt(totalAssessmentCount);
	}

	public boolean isTotalAppearedLabelVisible() {
		return isElementDisplayed(totalAppearedLabelElement, false);
	}

	public int getTotalAppearedCount() {
		String totalAppearedCount = getElementText(totalAppearedCountElement, false);
		return Integer.parseInt(totalAppearedCount);
	}

	public boolean isTotalQualifiedLabelVisible() {
		return isElementDisplayed(totalQualifiedLabelElement, false);
	}

	public int getTotalQualifiedCount() {
		String totalQualifiedCount = getElementText(totalQualifiedCountElement, false);
		return Integer.parseInt(totalQualifiedCount.replace("%", ""));
	}

	public boolean isViewTemplateButtonLabelVisible() {
		return isElementDisplayed(viewTemplateButtonElement, false);
	}

	public boolean isCreateQuestionButtonDisplayed() {
		return isElementDisplayed(createQuestionButtonElement, true);
	}

	public boolean isCreateAssessmentButtonDisplayed() {
		return isElementDisplayed(createAssessmentButtonElement, false);
	}

	public CreateQuestionPage clickOnCreateQuestionButton() {
		clickOnElement(createQuestionButtonElement, false);
		return new CreateQuestionPage();
	}

	public LibraryPage clickOnLibraryMenuButton() {
		clickOnElement(libraryButtonElement, true);
		return new LibraryPage();
	}
}