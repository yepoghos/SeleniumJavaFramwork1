package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RadarMainPageObjectsInteract {

	WebDriver driver = null;
	
	By textBox_search = By.id("search_term");
	By button_search = By.id("search_btn");

// Constructor 	
	public RadarMainPageObjectsInteract(WebDriver driver) {
		this.driver = driver;
	}
// Action methods
	// set text in the search box
	public void setTextInSearchBox(String text) {
	//	WebDriverManager.edgedriver().setup();
		driver.findElement(textBox_search).sendKeys(text);		
	}
	// click on search box
	public void clickSearchButton() {
		driver.findElement(button_search).click();
	}
	// enter on search box
	public void enterSearchBox() {
		driver.findElement(textBox_search).sendKeys(Keys.RETURN);
	}
}
