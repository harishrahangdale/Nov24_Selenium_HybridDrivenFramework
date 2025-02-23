package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(invocationCount = 5)
	public void verifyValidLoginCredentials() {
		System.out.println("STEP - Open chrome browser and load https://staging.app.hirecorrecto.com");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://staging.app.hirecorrecto.com");

		System.out.println("VERIFY - Login page is loaded.");
		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		boolean loginButtonFlag = loginButton.isEnabled();
		Assert.assertTrue(loginButtonFlag);

		System.out.println("STEP - Enter username");
		driver.findElement(By.xpath("//input[@id='outlined-adornment-email']")).sendKeys("hsr.29978@gmail.com");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("Pass@123");

		System.out.println("STEP - Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(
				"VERFIY - Dashboard page is displyed in case of correct credentials, \\\"Invalid credtentials\\\" message in case of invalid credentials.");

		wait.until(ExpectedConditions.urlContains("dashboard"));
		String expectedUrl = "https://staging.app.hirecorrecto.com/dashboard";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.startsWith(expectedUrl));

		driver.quit();
	}
}