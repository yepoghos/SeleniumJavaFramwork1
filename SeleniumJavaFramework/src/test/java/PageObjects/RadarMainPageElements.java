package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadarMainPageElements {

	private static WebElement element = null;

	// find/set elements
	// text box
	public static WebElement textBox_search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
	}
	// search button
	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.id("search_btn"));
		return element;
	}
}
