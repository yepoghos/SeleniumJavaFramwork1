package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import PageObjects.RadarMainPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3_RadarMainPageObjects {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		radarSearchTest();
	}
	@Test
	public static void radarSearchTest() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		RadarMainPageObjects searchPageObj = new RadarMainPageObjects(driver);
		
		driver.get("https://radar.am");
		searchPageObj.setTextInSearchBox("Yervand Poghosyan");
		Thread.sleep(1000);
		//searchPageObj.clickSearchButton();
		searchPageObj.enterSearchBox();
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
