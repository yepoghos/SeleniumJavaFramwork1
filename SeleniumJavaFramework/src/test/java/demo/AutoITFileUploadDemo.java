package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITFileUploadDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		testAutoITUpload();

	}
	
	@Test
	public static void testAutoITUpload() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.simplefileupload.com/");

		Thread.sleep(4000);
		// enter text in search box
		driver.findElement(By.id("sfu-iframe-wrapper")).click();
		Thread.sleep(1000);
		
		// Execute AutoIT compiled "exe" program to upload file
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\FileUploadScript.exe");
		
		Thread.sleep(2000);
		// close the browser
		driver.close();
		driver.quit();
		System.out.println("Test Passed");
	}
}
