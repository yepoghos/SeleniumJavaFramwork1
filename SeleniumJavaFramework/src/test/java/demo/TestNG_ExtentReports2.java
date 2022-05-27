package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjects.RadarMainPageObjects;
import conifg.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_ExtentReports2 {

	ExtentReports extent;
	ExtentSparkReporter spark;
	private static WebDriver driver = null;
	public static String browserName = null;

	@BeforeSuite // for test suite
	public void setUp() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/test.html");
		extent.attachReporter(spark);
		PropertiesFile.getProperties();
	}

	@BeforeTest // for single test
	public void beforeTest1() {
		// Driver start
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// Driver end
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@Test
	public void test1() throws InterruptedException {
		ExtentTest test = extent.createTest("Test1_TestNG_ExtentReport").log(Status.PASS,
				"This is a logging event for Test3, and it passed!");
		// Test1 code
		RadarMainPageObjects searchPageObj = new RadarMainPageObjects(driver);
		test.log(Status.INFO, "Starting Testcase");
		driver.get("https://radar.am");
		test.pass("Navigate to radar.am");
		test.info("Info test,info is Pashinyan");
		searchPageObj.setTextInSearchBox("Փաշինյան");
		Thread.sleep(500);
		test.pass("Entered text in Search box");
		searchPageObj.clickSearchButton();
		// searchPageObj.enterSearchBox();
		test.addScreenCaptureFromPath("Screenshot.png");
		Thread.sleep(1000);
		// Test1 code end
	}

	public void afterTest1() {
		driver.close();
		driver.quit();
	}

	@Test
	public void test2() throws InterruptedException {
		ExtentTest test = extent.createTest("Test2_TestNG_ExtentReport").log(Status.PASS,
				"This is a logging event for Test3, and it passed!");
		// Test2 code
		RadarMainPageObjects searchPageObj = new RadarMainPageObjects(driver);
		test.log(Status.INFO, "Starting Testcase");
		driver.get("https://radar.am");
		test.pass("Navigate to radar.am");
		test.info("Info test,info Putin");
		searchPageObj.setTextInSearchBox("Պուտին");
		Thread.sleep(500);
		test.pass("Entered text in Search box");
		searchPageObj.clickSearchButton();
		// searchPageObj.enterSearchBox();
		test.addScreenCaptureFromPath("Screenshot.png");
		Thread.sleep(1000);
		// Test2 code end
	}

	@AfterTest // for single test
	public void afterTest2() {
		driver.close();
		driver.quit();
	}

	@AfterSuite // for test suite
	public void tearDown() {
		extent.flush();
	}
}
