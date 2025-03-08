package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class CreateQuestionPage extends ControlActions {

	private String questionTypelocator = "//div[p[text()='%s']]/button";
	private String difficultyLevelLocator = "//p[text()='%s']";
	private String optionTextLocator = "//input[@placeholder='Option %d']";
	private String correctAnswerIndexLocator = "option-radio-%d";
	private String selectSkillLocator = "//li[text()='%s']";
	private String topicLocator = "//p[text()='%s']";

	@FindBy(xpath = "//div[p[contains(@class,'css-2dyhle')]]/button/following-sibling::p")
	List<WebElement> allQuestionTypeElements;

	@FindBy(xpath = "//div[@class='se-wrapper']//div")
	WebElement problemStatementElement;

	@FindBy(xpath = "//button[text()='+ Add Option']")
	WebElement addOptionBtnElement;

	@FindBy(xpath = "//input[@placeholder='Type a label and press Enter']")
	WebElement labelTextElement;

	@FindBy(id = "skills")
	WebElement skillInputElement;

	@FindBy(xpath = "//input[@id='topics']")
	WebElement topicsInputElement;

	@FindBy(xpath = "//div[text()='Question published successfully']")
	WebElement toastMessageElement;

	@FindBy(xpath = "//input[@placeholder='Enter Problem Title']")
	WebElement problemTitleElement;

	@FindBy(id = "score")
	WebElement scoreInputElement;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtnElement;

	@FindBy(xpath = "//div[@role='presentation']/div[contains(@class,'MuiPaper-root')]/div/div[1]//*[name()='svg']")
	WebElement closeBtnElement;

	@FindBy(xpath = "//button[text()='Publish']")
	WebElement publishBtnElement;

	public CreateQuestionPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnQuestionType(String questionType) {
		String questionTypelocator = String.format(this.questionTypelocator, questionType);
		clickOnElement(LocatorType.XPATH, questionTypelocator, true);
	}

	public boolean isQuestionTypeBtnDisplayed(String questionType) {
		String questionTypelocator = String.format(this.questionTypelocator, questionType);
		return isElementDisplayed(LocatorType.XPATH, questionTypelocator, true);
	}

	public int countOfVisibleQuetionType() {
		return getAllElementCount(allQuestionTypeElements, true);
	}

	public List<String> getAllQuestionTypeText() {
		return getAllElementsText(allQuestionTypeElements, true);
	}

	public void setProblemTitle(String problemTitle) {
		setText(problemTitleElement, true, problemTitle);
		String actualTitle = getInputElementText(problemTitleElement, true);
		if (!actualTitle.equals(problemTitle)) {
			System.out.println("----Adjustment needed *****");
			clearTextUsingBackSpace(problemTitleElement, actualTitle);
			setText(problemTitleElement, false, problemTitle);
		}
	}

	public void setProblemStatement(String text) {
		clickOnElement(problemStatementElement, true);
		setText(problemStatementElement, false, text);
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
		setText(scoreInputElement, false, String.valueOf(score));
	}

	public void setScore(String score) {
		setText(scoreInputElement, false, score);
	}

	public void clickOnAddOptionBtn() {
		clickOnElement(addOptionBtnElement, false);
	}

	public String getOptionAtIndex(int index) {
		String locator = String.format(optionTextLocator, index);
		return getInputElementText(LocatorType.XPATH, locator, false);
	}

	public void setLabel(String labelText) {
		setText(labelTextElement, false, labelText);
	}

	public void setSkill(String skillName) {
		setText(skillInputElement, false, skillName);
		String locator = String.format(selectSkillLocator, skillName);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void setTopic(String topic) {
		setText(topicsInputElement, true, topic);
		String locator = String.format(topicLocator, topic);
		clickOnElement(LocatorType.XPATH, locator, true);
	}

	public void clickOnPublishBtn() {
		clickOnElement(publishBtnElement, false);
	}

	public boolean isTostMessageDisplyed() {
		return isElementDisplayed(toastMessageElement, true);
	}

	public void closeCreateQuestionDrawer() {
		clickOnElement(closeBtnElement, false);
	}
}