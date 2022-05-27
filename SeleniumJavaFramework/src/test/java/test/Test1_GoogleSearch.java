package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch {
	
	public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
		
	}
	
	public static void googleSearch() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
	// go to google.com	
		driver.get("https://google.com");
	// enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Selenium");
		
		//driver.findElement(By.name("btnK")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
	    Thread.sleep(2000);
     // close the browser   
        driver.close();
        
        System.out.println("Test Passed");
	}
}
