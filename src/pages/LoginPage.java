package pages;

import base.ControlActions;

public class LoginPage extends ControlActions {

	public boolean waitForPageLoad() {
		return isElementDisplayed(LocatorType.XPATH, "//span[text()='Welcome to Hire360']", true);
	}

	public void enterUsername(String username) {
		setText(LocatorType.XPATH, "//input[@id='outlined-adornment-email']", username);
	}

	public void enterPassword(String password) {
		setText(LocatorType.XPATH, "//input[@id='outlined-adornment-password']", false, password);
	}

	public void clickOnLoginBtn() {
		clickOnElement(LocatorType.XPATH, "//button[text()='Login']", false);
	}

	public DashboardPage login(String username, String password) {
		waitForPageLoad();
		enterUsername(username);
		enterPassword(password);
		clickOnLoginBtn();
		return new DashboardPage();
	}
}