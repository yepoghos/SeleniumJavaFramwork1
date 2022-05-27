package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.RadarMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_MultiBrowser {
	// different threads for each driver
	public static ThreadLocal <WebDriver> driver = new InheritableThreadLocal<WebDriver>();	
	// driver get method 
	public WebDriver getDriver() {
		return driver.get();
	}	
	@BeforeMethod
	// this "browserName" parameter from testng3MultiBrowser.xml
	@Parameters("browserName")
	public void setup1(String browserName) {
		System.out.println("Browser is : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			// Driver end
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		getDriver().get("https://radar.am/ru/");
	}

	@Test
	public void test1() throws InterruptedException {
		RadarMainPage.textBox_search(getDriver()).sendKeys("Путин");
		Thread.sleep(1000);
		RadarMainPage.button_search(getDriver()).click();
		Thread.sleep(1000);		
		
	}
	@Test
	public void test2() throws InterruptedException {
		getDriver().get("https://www.list.am/login");
		getDriver().findElement(By.id("_idyour_email")).sendKeys("Yervand");
		getDriver().findElement(By.id("_idpassword")).sendKeys("abcd1234");
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDownTest() {
		getDriver().close();
		getDriver().quit();
		System.out.println("Test Succesfully passed");
	}
	
}
