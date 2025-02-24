package base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlActions {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static final String BASE_URL = "https://staging.app.hirecorrecto.com";

    /**
     * Launches a Chrome browser instance and navigates to the base URL.
     * Maximizes the window and initializes the WebDriverWait.
     */
    public static void launchBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    /**
     * Closes the browser instance and cleans up WebDriver resources.
     * Sets driver to null to prevent memory leaks.
     */
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Finds a web element using the specified locator.
     * 
     * @param locator The By locator strategy to find the element
     * @return The located WebElement
     */
    protected static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Clicks on a web element identified by the specified locator.
     * 
     * @param locator The By locator strategy to find the element to click
     */
    protected static void clickElement(By locator) {
        findElement(locator).click();
    }

    /**
     * Enters text into a web element after clearing its existing content.
     * 
     * @param locator The By locator strategy to find the input element
     * @param text The text to enter into the element
     */
    protected static void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}