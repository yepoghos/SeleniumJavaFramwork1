package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.RadarMainPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_RadarMainPageObjects {
	
	private static WebDriver driver = null;
	
	// setup the test
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}
	// run test
	@Test
	public static void radarSearchTest() throws InterruptedException {
				
		RadarMainPageObjects searchPageObj = new RadarMainPageObjects(driver);
		
		driver.get("https://radar.am");
		searchPageObj.setTextInSearchBox("Yervand Poghosyan");
		Thread.sleep(1000);
		//searchPageObj.clickSearchButton();
		searchPageObj.enterSearchBox();	
		
	}
	// close test
	@AfterTest
	public void tearDownTest() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	    System.out.println("Test Succesfully passed");
	}
}
