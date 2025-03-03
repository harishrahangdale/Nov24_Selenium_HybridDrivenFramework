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

	public void clickOnQuestionType(String questionType) {
		String questionTypelocator = String.format(this.questionTypelocator, questionType);
		super.clickOnElement(LocatorType.XPATH, questionTypelocator, true);
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

	public void setProblemStatement(String text) {
		super.clickOnElement(LocatorType.XPATH, problemStatementLocator, true);
		setText(LocatorType.XPATH, problemStatementLocator, text);
	}

	public void clickOnDifficultyLevel(String level) {
		String locator = String.format(difficultyLevelLocator, level);
		super.clickOnElement(LocatorType.XPATH, locator, true);
		super.clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void setOptionAtIndex(int index, String optionText) {
		String locator = String.format(optionTextLocator, index);
		setText(LocatorType.XPATH, locator, true, optionText);
	}

	@Override
	protected void clickOnElement(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		js.executeScript("document.getElementById('" + locatorValue + "').click()");
	}

	public void setCorrectAnswerAtIndex(int index) {
		String locator = String.format(correctAnswerIndexLocator, index);
		clickOnElement(LocatorType.ID, locator, true);
	}

	public void clickOnAddOptionBtn() {
		super.clickOnElement(LocatorType.XPATH, addOptionBtnLocator, false);
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
		super.clickOnElement(LocatorType.XPATH, locator, true);
	}

}