package base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlActions {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;

	public static void start() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://staging.app.hirecorrecto.com/login");
	}

	protected enum LocatorType {
		XPATH, ID, NAME, CSS, LINK_TEXT;

		public static LocatorType fromString(String type) {
			return LocatorType.valueOf(type.toUpperCase());
		}
	}

	protected WebElement getElement(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement element = null;

		switch (locatorType) {
		case XPATH:
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			} else {
				element = driver.findElement(By.xpath(locatorValue));
			}
			break;

		case ID:
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			} else {
				element = driver.findElement(By.id(locatorValue));
			}
			break;

		case NAME:
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} else {
				element = driver.findElement(By.name(locatorValue));
			}
			break;

		case CSS:
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			} else {
				element = driver.findElement(By.cssSelector(locatorValue));
			}
			break;

		case LINK_TEXT:
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			} else {
				element = driver.findElement(By.linkText(locatorValue));
			}
			break;

		}
		return element;

	}

	protected List<WebElement> getElements(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		List<WebElement> listOfElements = null;

		switch (locatorType) {
		case XPATH:
			if (isWaitRequired) {
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			} else {
				listOfElements = driver.findElements(By.xpath(locatorValue));
			}
			break;

		case ID:
			if (isWaitRequired) {
				listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
			} else {
				listOfElements = driver.findElements(By.id(locatorValue));
			}
			break;

		case NAME:
			if (isWaitRequired) {
				listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
			} else {
				listOfElements = driver.findElements(By.name(locatorValue));
			}
			break;

		case CSS:
			if (isWaitRequired) {
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
			} else {
				listOfElements = driver.findElements(By.cssSelector(locatorValue));
			}
			break;

		case LINK_TEXT:
			if (isWaitRequired) {
				listOfElements = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));
			} else {
				listOfElements = driver.findElements(By.linkText(locatorValue));
			}
			break;

		}
		return listOfElements;

	}

	protected void scrollToElement(WebElement e) {

		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	protected void setText(LocatorType locatorType, String locatorValue, boolean isWaitRequired,
			String textToBeEntered) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		if (!e.isDisplayed()) {
			scrollToElement(e);
		}
		e.sendKeys(textToBeEntered);
	}

	protected void setText(LocatorType locatorType, String locatorValue, String textToBeEntered) {
		setText(locatorType, locatorValue, false, textToBeEntered);
	}

	protected void clickOnElement(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		if (!e.isDisplayed()) {
			scrollToElement(e);
		}
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}

	protected boolean isElementDisplayed(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return e.isDisplayed();
	}

	protected String getElementText(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return e.getText();
	}

	protected String getInputElementText(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		WebElement e = getElement(locatorType, locatorValue, isWaitRequired);
		return e.getDomAttribute("value");
	}

	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected boolean waitUntilURLContains(String text) {
		return wait.until(ExpectedConditions.urlContains(text));
	}

	protected int getAllElementCount(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		List<WebElement> listOfWebElements = getElements(locatorType, locatorValue, isWaitRequired);
		return listOfWebElements.size();
	}

	protected List<String> getAllElementsText(LocatorType locatorType, String locatorValue, boolean isWaitRequired) {
		List<WebElement> listOfWebElements = getElements(locatorType, locatorValue, isWaitRequired);
		List<String> listOfElementText = new ArrayList<String>();
		for (WebElement e : listOfWebElements) {
			listOfElementText.add(e.getText());
		}
		return listOfElementText;
	}

	public static void closeBrowser() {
		driver.quit();
	}
}