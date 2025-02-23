package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashboardTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.out.println("STEP - Open chrome browser and load https://staging.app.hirecorrecto.com");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	}

	@Test
	public void verifyDashboardPage() {
		System.out.println("Verify - Dashboard page is loaded.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Hello, Welcome Back!!']")));

		System.out.println("Verify - Total Assessment title");
		String totalAssessmentTitle = driver.findElement(By.xpath("//p[text()='Total Assessments']")).getText();
		Assert.assertEquals(totalAssessmentTitle, "Total Assessments");

		System.out.println("Verify - Total Assessment Count");
		WebElement totalAssessmentCount = driver
				.findElement(By.xpath("//p[text()='Total Assessments']/following-sibling::h6"));
		Assert.assertTrue(Integer.parseInt(totalAssessmentCount.getText()) >= 0);

		System.out.println("Verify - Total Appeared title");
		String totalAppearedTitle = driver.findElement(By.xpath("//p[text()='Total Appeared']")).getText();
		Assert.assertEquals(totalAppearedTitle, "Total Appeared");

		System.out.println("Verify - Total Appeared Count");
		WebElement totalAppeared = driver
				.findElement(By.xpath("//p[text()='Total Appeared']/following-sibling::h6"));
		Assert.assertTrue(Integer.parseInt(totalAppeared.getText()) >= 0);

		System.out.println("Verify - Total Appeared title");
		String totalQualifiedTitle = driver.findElement(By.xpath("//p[text()='Total Qualified']")).getText();
		Assert.assertEquals(totalQualifiedTitle, "Total Qualified");

		System.out.println("Verify - Total Qualified Count");
		WebElement totalQualified = driver
				.findElement(By.xpath("//p[text()='Total Qualified']/following-sibling::h6"));
		Assert.assertTrue(totalQualified.getText().contains("%"));

		System.out.println("Verify - View template title");
		String viewTemplate = driver.findElement(By.xpath("//p[text()='View Template']")).getText();
		Assert.assertEquals(viewTemplate, "View Template");

		System.out.println("Verify - Create Question title");
		String createQuestion = driver.findElement(By.xpath("//p[text()='Create Question']")).getText();
		Assert.assertEquals(createQuestion, "Create Question");

		System.out.println("Verify - Create Assessment title");
		String createAssessment = driver.findElement(By.xpath("//p[text()='Create Assessment']")).getText();
		Assert.assertEquals(createAssessment, "Create Assessment");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}