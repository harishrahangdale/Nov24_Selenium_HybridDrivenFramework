package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LoginPage extends ControlActions {

	@FindBy(xpath = "//span[text()='Welcome to Hire360']")
	WebElement welcomeElement;

	@FindBy(xpath = "//input[@id='outlined-adornment-email']")
	WebElement emailInputElement;

	@FindBy(xpath = "//input[@id='outlined-adornment-password']")
	WebElement passwordInputElement;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButtonElement;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean waitForPageLoad() {
		return isElementDisplayed(welcomeElement, true);
	}

	public void enterUsername(String username) {
		setText(emailInputElement, false, username);
	}

	public void enterPassword(String password) {
		setText(passwordInputElement, false, password);
	}

	public void clickOnLoginBtn() {
		clickOnElement(loginButtonElement, false);
	}

	public DashboardPage login(String username, String password) {
		waitForPageLoad();
		enterUsername(username);
		enterPassword(password);
		clickOnLoginBtn();
		return new DashboardPage();
	}
}