import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) throws InterruptedException {
		// Get current project path
		String projectPath = System.getProperty("user.dir");
		System.out.println("ProjectPAth : " + projectPath);
		
		// Set property for the browser here
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ensureCleanSession", false);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe"); // Chrome
		WebDriver driver = new ChromeDriver();

		// go to google.com	
		driver.get("https://google.com");
		// enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Selenium");
		//driver.findElement(By.name("btnK")).click();
		Thread.sleep(500);
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		// close the browser   
		driver.close();
		driver.quit();
		System.out.println("Test Passed");
	}

}
