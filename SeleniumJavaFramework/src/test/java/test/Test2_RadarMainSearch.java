package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjects.RadarMainPageElements;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Test2_RadarMainSearch {
	private static WebDriver driver = null;
	// Main method, so test starts here
	public static void main(String[] args) throws InterruptedException {
		radarSearch();
	}
	// Test and checks define here
	public static void radarSearch() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	// Get the test page by URL
		driver.get("https://radar.am");
	// 
		RadarMainPageElements.textBox_search(driver).sendKeys("Փաշինյան");
		Thread.sleep(1000);
		RadarMainPageElements.button_search(driver).click();
		//RadarMainPage.textBox_search(driver).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	// Close the browser   
	    driver.close();
        System.out.println("Test2 Passed");
	}
}
