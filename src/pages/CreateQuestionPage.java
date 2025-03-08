package pages;

import java.util.List;

import base.ControlActions;

public class CreateQuestionPage extends ControlActions {
	private String questionTypelocator = "//div[p[text()='%s']]/button";
	private String allQuestionTypeTextLocator = "//div[p[contains(@class,'css-2dyhle')]]/button/following-sibling::p";
	private String problemStatementLocator = "//div[@class='se-wrapper']//div";
	private String difficultyLevelLocator = "//p[text()='%s']";
	private String optionTextLocator = "//input[@placeholder='Option %d']";
	private String addOptionBtnLocator = "//button[text()='+ Add Option']";
	private String correctAnswerIndexLocator = "option-radio-%d";
	private String labelTextLocator = "//input[@placeholder='Type a label and press Enter']";
	private String skillInputLocator = "//input[@id='skills']";
	private String selectSkillLocator = "//li[text()='%s']";
	private String topicLocator = "//p[text()='%s']";
	private String toastMessageLocator = "//div[text()='Question published successfully']";
	private String problemTitleLocator = "//input[@placeholder='Enter Problem Title']";
	private String scoreInputLocator = "score";
	private String cancelBtnLocator = "//button[text()='Cancel']";
	private String closeBtnLocator = "//div[@role='presentation']/div[contains(@class,'MuiPaper-root')]/div/div[1]//*[name()='svg']";

	public void clickOnQuestionType(String questionType) {
		String questionTypelocator = String.format(this.questionTypelocator, questionType);
		clickOnElement(LocatorType.XPATH, questionTypelocator, true);
	}

	public boolean isQuestionTypeBtnDisplayed(String questionType) {
		String questionTypelocator = String.format(this.questionTypelocator, questionType);
		return isElementDisplayed(LocatorType.XPATH, questionTypelocator, true);
	}

	public int countOfVisibleQuetionType() {
		return getAllElementCount(LocatorType.XPATH, allQuestionTypeTextLocator, true);
	}

	public List<String> getAllQuestionTypeText() {
		return getAllElementsText(LocatorType.XPATH, allQuestionTypeTextLocator, true);
	}

	public void setProblemTitle(String problemTitle) {
		setText(LocatorType.XPATH, problemTitleLocator, problemTitle);
		String actualTitle = getInputElementText(LocatorType.XPATH, problemTitleLocator, true);
		if (!actualTitle.equals(problemTitle)) {
			System.out.println("----Adjustment needed *****");
			clearTextUsingBackSpace(LocatorType.XPATH, problemTitleLocator, actualTitle);
			setText(LocatorType.XPATH, problemTitleLocator, problemTitle);
		}
	}

	public void setProblemStatement(String text) {
		super.clickOnElement(LocatorType.XPATH, problemStatementLocator, true);
		setText(LocatorType.XPATH, problemStatementLocator, text);
	}

	public void clickOnDifficultyLevel(String level) {
		String locator = String.format(difficultyLevelLocator, level);
		clickOnElement(LocatorType.XPATH, locator, true);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void setOptionAtIndex(int index, String optionText) {
		String locator = String.format(optionTextLocator, index);
		setText(LocatorType.XPATH, locator, true, optionText);
	}

	protected void clickOnElementUsingJs(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		js.executeScript("document.getElementById('" + locatorValue + "').click();");
	}

	public void setCorrectAnswerAtIndex(int index) {
		String locator = String.format(correctAnswerIndexLocator, index);
		clickOnElementUsingJs(LocatorType.ID, locator, true);
	}

	public void setScore(int score) {
		setText(LocatorType.ID, scoreInputLocator, false, String.valueOf(score));
	}

	public void setScore(String score) {
		setText(LocatorType.ID, scoreInputLocator, false, score);
	}

	public void clickOnAddOptionBtn() {
		clickOnElement(LocatorType.XPATH, addOptionBtnLocator, false);
	}

	public String getOptionAtIndex(int index) {
		String locator = String.format(optionTextLocator, index);
		return getInputElementText(LocatorType.XPATH, locator, false);
	}

	public void setLabel(String labelText) {
		setText(LocatorType.XPATH, labelTextLocator, labelText);
	}

	public void setSkill(String skillName) {
		setText(LocatorType.XPATH, skillInputLocator, skillName);
		String locator = String.format(selectSkillLocator, skillName);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void setTopic(String topic) {
		String locator = String.format(topicLocator, topic);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void clickOnPublishBtn() {
		clickOnElement(LocatorType.XPATH, "//button[text()='Publish']", false);
	}

	public boolean isTostMessageDisplyed() {
		return isElementDisplayed(LocatorType.XPATH, toastMessageLocator, true);
	}

	public void closeCreateQuestionDrawer() {
		clickOnElement(LocatorType.XPATH, closeBtnLocator, false);
	}
}