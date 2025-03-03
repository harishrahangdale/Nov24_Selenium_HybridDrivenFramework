package pages;

import base.ControlActions;

public class DashboardPage extends ControlActions {

	public boolean waitForPageLoad(String text) {
		return waitUntilURLContains(text);
	}

	public String getDashboardPageUrl() {
		return getCurrentURL();
	}

	public boolean isWelcomeMessageVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//div[text()='Hello, Welcome Back!!']", true);
	}

	public boolean isTotalAssessmentsLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='Total Assessments']", false);
	}

	public int getTotalAssessmentsCount() {
		String totalAssessmentCount = getElementText(LocatorType.XPATH,
				"//p[text()='Total Assessments']//following-sibling::h6", false);
		return Integer.parseInt(totalAssessmentCount);
	}

	public boolean isTotalAppearedLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='Total Appeared']", false);
	}

	public int getTotalAppearedCount() {
		String totalAppearedCount = getElementText(LocatorType.XPATH,
				"//p[text()='Total Appeared']//following-sibling::h6", false);
		return Integer.parseInt(totalAppearedCount);
	}

	public boolean isTotalQualifiedLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='Total Qualified']", false);
	}

	public int getTotalQualifiedCount() {
		String totalQualifiedCount = getElementText(LocatorType.XPATH,
				"//p[text()='Total Qualified']//following-sibling::h6", false);
		return Integer.parseInt(totalQualifiedCount.replace("%", ""));
	}

	public boolean isViewTemplateButtonLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='View Template']", false);
	}

	public boolean isCreateQuestionButtonLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='Create Question']", false);
	}

	public boolean isCreateAssessmentButtonLabelVisible() {
		return isElementDisplayed(LocatorType.XPATH, "//p[text()='Create Assessment']", false);
	}

	public void clickCreateQuestionButton() {
		clickOnElement(LocatorType.XPATH, "//p[text()='Create Question']", false);
	}
}