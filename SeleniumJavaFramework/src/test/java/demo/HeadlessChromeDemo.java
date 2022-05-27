package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		testGoogleSearch();

	}

	public static void testGoogleSearch() throws Exception {
		
		// Define options for ChromeBrowser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		// Define window size
		options.addArguments("window-size=1280,800");
		
		WebDriverManager.chromedriver().setup();
		// Pass argument to Browser
		driver = new ChromeDriver(options);

		driver.get("https://google.com");
		System.out.println(driver.getTitle());

		// enter text in search box
		driver.findElement(By.name("q")).sendKeys("AMD stocks");
		Thread.sleep(1000);
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);

		Thread.sleep(2000);
		// close the browser
		driver.close();
		driver.quit();
		System.out.println("Test Passed");
	}
}
