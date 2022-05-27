package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RadarMainPageObjects {

	WebDriver driver = null;
	
	By textBox_search = By.id("search_term");
	By button_search = By.id("search_btn");

// Constructor 	
	public RadarMainPageObjects(WebDriver driver) {
		this.driver = driver;
	}
// Methods	
	public void setTextInSearchBox(String text) {
	//	WebDriverManager.edgedriver().setup();
		driver.findElement(textBox_search).sendKeys(text);		
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).click();
	}
	public void enterSearchBox() {
		driver.findElement(textBox_search).sendKeys(Keys.RETURN);
	}
}
