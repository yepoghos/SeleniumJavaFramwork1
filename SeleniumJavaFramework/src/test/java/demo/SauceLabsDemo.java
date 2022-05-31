package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Example of running a TestNG test without using Sauce Bindings.
 */
public class SauceLabsDemo {
	protected RemoteWebDriver driver;
	
    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        // Username
        sauceOptions.setCapability("username", System.getenv("oauth-ervand.poghosyan-b9485"));
        // Access Key
        sauceOptions.setCapability("access_key", System.getenv("cf5a9462-f382-49e8-9fc5-34de116c76b4"));
        sauceOptions.setCapability("name", method.getName());
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
            
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
        
        driver = new RemoteWebDriver(url, options);
              

    }

    @Test
    public void correctTitle() {
//    	driver.get("https://google.com");
//		driver.findElement(By.name("q")).sendKeys("AMD stocks");
//		driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
//		driver.quit();
//		
        driver.navigate().to("https://www.saucedemo.com");
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        String status = result.isSuccess() ? "passed" : "failed";
        driver.executeScript("sauce:job-result=" + status);
    }
}