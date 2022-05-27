package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFluentWaitDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		testFluentWait();

	}

	public static void testFluentWait() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get("https://google.com");
		// enter text in search box
		driver.findElement(By.name("q")).sendKeys("AMD stocks");
		Thread.sleep(1000);
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.className("LC20lb MBeuO DKV0Md")).click();

// ------------------------------------------------------		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// return driver.findElement(By.id("element"));
				
			// find element and store into variable
				WebElement linkElement = driver.findElement(By.linkText("AMD - Stock Summary"));
				
				if (linkElement.isEnabled()) {
					System.out.println("Element Found");
				}
			// return element after its found	
				return linkElement;
			}
		});
// -----------------------------------------------------------
		// click on element after its found
		element.click();

		Thread.sleep(2000);
		// close the browser
		driver.close();
		System.out.println("Test Passed");
	}
}
