package pages;

import base.ControlActions;

public class LibraryPage extends ControlActions {

	public void clickOnDashboardButton() {
		clickOnElement(LocatorType.XPATH, "//span[text()='Dashboard']", true);
	}

	public void clickOnMyLibraryButton() {
		clickOnElement(LocatorType.XPATH, "//button[contains(text(),'My Library')]", true);
	}

	public int getQuestionCountOnMyLibraryButton() {
		String libraryButtonText = getElementText(LocatorType.XPATH, "//button[contains(text(),'My Library')]", true);
		return Integer.parseInt(libraryButtonText.replaceAll("\\D+", ""));
	}
}
