package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.ControlActions;

public class DashboardPage extends ControlActions {
    // Locators
    private static final By WELCOME_MESSAGE = By.xpath("//div[text()='Hello, Welcome Back!!']");
    private static final By TOTAL_ASSESSMENTS_LABEL = By.xpath("//p[text()='Total Assessments']");
    private static final By TOTAL_ASSESSMENTS_COUNT = By.xpath("//p[text()='Total Assessments']/following-sibling::h6");
    private static final By TOTAL_APPEARED_LABEL = By.xpath("//p[text()='Total Appeared']");
    private static final By TOTAL_APPEARED_COUNT = By.xpath("//p[text()='Total Appeared']/following-sibling::h6");
    private static final By TOTAL_QUALIFIED_LABEL = By.xpath("//p[text()='Total Qualified']");
    private static final By TOTAL_QUALIFIED_COUNT = By.xpath("//p[text()='Total Qualified']/following-sibling::h6");
    private static final By VIEW_TEMPLATE_LABEL = By.xpath("//p[text()='View Template']");
    private static final By CREATE_QUESTION_LABEL = By.xpath("//p[text()='Create Question']");
    private static final By CREATE_ASSESSMENT_LABEL = By.xpath("//p[text()='Create Assessment']");

    /**
     * Waits for the dashboard page to load by checking if the URL contains "dashboard".
     * 
     * @return true if the dashboard URL is loaded, false otherwise
     */
    public boolean waitForPageLoad() {
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    /**
     * Gets the current URL of the page.
     * 
     * @return The current URL as a String
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Verifies if the welcome message is visible on the dashboard.
     * 
     * @return true if the welcome message is visible, false otherwise
     */
    public boolean isWelcomeMessageVisible() {
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(WELCOME_MESSAGE));
        return welcome.isDisplayed();
    }

    /**
     * Gets the text of the Total Assessments label.
     * 
     * @return The text of the Total Assessments label
     */
    public String getTotalAssessmentsLabel() {
        return findElement(TOTAL_ASSESSMENTS_LABEL).getText();
    }

    /**
     * Gets the count of total assessments.
     * 
     * @return The count as an integer
     */
    public int getTotalAssessmentsCount() {
        String countText = findElement(TOTAL_ASSESSMENTS_COUNT).getText();
        return Integer.parseInt(countText);
    }

    /**
     * Gets the text of the Total Appeared label.
     * 
     * @return The text of the Total Appeared label
     */
    public String getTotalAppearedLabel() {
        return findElement(TOTAL_APPEARED_LABEL).getText();
    }

    /**
     * Gets the count of total appeared.
     * 
     * @return The count as an integer
     */
    public int getTotalAppearedCount() {
        String countText = findElement(TOTAL_APPEARED_COUNT).getText();
        return Integer.parseInt(countText);
    }

    /**
     * Gets the text of the Total Qualified label.
     * 
     * @return The text of the Total Qualified label
     */
    public String getTotalQualifiedLabel() {
        return findElement(TOTAL_QUALIFIED_LABEL).getText();
    }

    /**
     * Gets the percentage of total qualified.
     * 
     * @return The percentage value as a String
     */
    public String getTotalQualifiedCount() {
        return findElement(TOTAL_QUALIFIED_COUNT).getText();
    }

    /**
     * Gets the text of the View Template label.
     * 
     * @return The text of the View Template label
     */
    public String getViewTemplateLabel() {
        return findElement(VIEW_TEMPLATE_LABEL).getText();
    }

    /**
     * Gets the text of the Create Question label.
     * 
     * @return The text of the Create Question label
     */
    public String getCreateQuestionLabel() {
        return findElement(CREATE_QUESTION_LABEL).getText();
    }

    /**
     * Gets the text of the Create Assessment label.
     * 
     * @return The text of the Create Assessment label
     */
    public String getCreateAssessmentLabel() {
        return findElement(CREATE_ASSESSMENT_LABEL).getText();
    }
}