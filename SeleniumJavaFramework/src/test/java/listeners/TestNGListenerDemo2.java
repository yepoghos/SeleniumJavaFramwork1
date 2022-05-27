package listeners;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// Annotation is out of Class!!
//@Listeners({listeners.TestNGListeners.class}) // already set in testng1.xml

public class TestNGListenerDemo2 {

	private static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	@Test
	public void test3() {
		System.out.println("This is test 3");
		throw new SkipException("This test is skipped");
	}

	@Test
	public void test4() {
		System.out.println("This is test 4");
	}

	@Test
	public void test5() throws InterruptedException {
		driver.get("https://www.list.am/login");
		driver.findElement(By.id("_idyour_email-----")).sendKeys("Yervand");
		driver.findElement(By.id("_idpassword")).sendKeys("abcd1234");
		Thread.sleep(1000);
		driver.close();
	}

}
