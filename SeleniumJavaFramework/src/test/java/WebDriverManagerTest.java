import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// AUTOMATIC GET THE LATEST VERSION OF DRIVERS
public class WebDriverManagerTest {
	public static void main(String[] args) throws InterruptedException {
		
	// Using a WebDriverManager automatically get the latest version of drivers
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		//WebDriverManager.operadriver().setup();
		//WebDriverManager.chromiumdriver().setup()
		//WebDriverManager.iedriver().setup();
		//WebDriverManager.chromedriver().setup();

		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		     
        driver.get("https://google.com");
        
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Yervand");
        
        //WebElement textBox = driver.findElement(By.id("lst-ib"));
        
        //textBox.sendKeys("Automation Selenium");
        
        Thread.sleep(3000);
        driver.close();
        driver.quit();
	}

}
