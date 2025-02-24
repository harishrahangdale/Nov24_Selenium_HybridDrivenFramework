package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.ControlActions;

public class LoginPage extends ControlActions {
	private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
	private static final By USERNAME_FIELD = By.xpath("//input[@id='outlined-adornment-email']");
	private static final By PASSWORD_FIELD = By.xpath("//input[@id='outlined-adornment-password']");

	/**
	 * Waits for the login page to load by checking the login button's visibility
	 * and enabled state.
	 * 
	 * @return true if the login button is visible and enabled, false otherwise
	 */
	public boolean waitForPageLoad() {
		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
		return loginButton.isEnabled();
	}

	/**
	 * Enters the specified username into the username field.
	 * 
	 * @param username The username to enter
	 */
	public void enterUsername(String username) {
		enterText(USERNAME_FIELD, username);
	}

	/**
	 * Enters the specified password into the password field.
	 * 
	 * @param password The password to enter
	 */
	public void enterPassword(String password) {
		enterText(PASSWORD_FIELD, password);
	}

	/**
	 * Clicks the login button to submit the login form.
	 */
	public void clickLoginButton() {
		clickElement(LOGIN_BUTTON);
	}
}