package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import PageObjects.RadarMainPageObjectsInteract;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4_ExtendReportsBasic {

	private static WebDriver driver = null;
	@Test
	public static void main(String[] args) throws InterruptedException {
		
		// Reports code starts here
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		// Test 3 report part starts here
		ExtentTest test3 = extent.createTest("Test3: radar.am main page search 1")
		  .log(Status.PASS, "This is a logging event for Test3, and it passed!");
		extent.flush();
		// Test 3 reports part ends here
				
		// WebDriver code start
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();			
		// WebDriver code end
		
		// Test 3 code starts here ---------------------------------------------
		RadarMainPageObjectsInteract searchPageObj = new RadarMainPageObjectsInteract(driver);
	test3.log(Status.INFO, "Starting Testcase");
		driver.get("https://radar.am");
	test3.pass("Navigate to radar.am");
		searchPageObj.setTextInSearchBox("Փաշինյան");
		Thread.sleep(1000);
	test3.pass("Entered text in Search box");
		//searchPageObj.clickSearchButton();
		searchPageObj.enterSearchBox();
		Thread.sleep(3000);
	test3.pass("Pressed the search button");
		driver.close();
		driver.quit();
	test3.fail("Closed the browser");
		// Test 3 code ends here ------------------------------------------------
	test3.info("Test Completed");
	
		extent.flush();
	}

}
