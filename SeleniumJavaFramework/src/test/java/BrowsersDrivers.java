import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

// WARNING: ALWAYS CHECK THE LATEST VERSION OF DRIVERS!!!

public class BrowsersDrivers {
	
	public static void main(String[] args) throws InterruptedException {
	// Get current project path
		String projectPath = System.getProperty("user.dir");
		System.out.println("ProjectPAth : " + projectPath);
		
	// Defining System Property for the Browsers  (Or set the driver paths in the OS PATHS variable) 
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe"); // Mozilla
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe"); // Chrome
		System.setProperty("webdriver.edge.driver", projectPath + "/drivers/edgedriver//msedgedriver.exe"); // Edge
		//System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe"); // Internet Explorer
	// Instantiate a Browser Driver class.
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		
	// Start browser with specified URL
		driver.get("https://www.globbing.com/");
		Thread.sleep(5000);
		driver.close(); // Close current session
		driver.quit(); // Close all Browsers
			}
}
