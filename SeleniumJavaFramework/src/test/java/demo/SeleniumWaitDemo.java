package demo;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		seleniumWaits();
	}

	public static void seleniumWaits() throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		// Method 1
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Method 2 
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5, 1));
		// Explicit wait 
		// Default time for "implicitlyWait"(Deprecated) is 250ms!!!	
	
		driver.get("https://google.com");

		//wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("RNmpXc")));

		driver.findElement(By.name("q")).sendKeys("Automation Selenium");
		
		Thread.sleep(1000);
		//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("gb_d")));
		
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		// Thread.sleep(2000);
	
		driver.close();
		driver.quit();

	}
}
