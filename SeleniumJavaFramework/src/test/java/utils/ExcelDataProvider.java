package utils;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	private static WebDriver driver = null;
	//public static void main(String[] args) {
	//	getData();
	//}
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}
	
	// ---Demo test -------------------------------------------------------
	// Use captured data from test1data
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username+" | "+password);
		driver.get("https://www.list.am/login");
		driver.findElement(By.id("_idyour_email")).sendKeys(username);
		driver.findElement(By.id("_idpassword")).sendKeys(password);
		Thread.sleep(1000);
	}
	// ---Demo test -------------------------------------------------------
	
	
	// TestNG DataProvider, gets data from Excel and store to test1data
	@DataProvider(name = "test1data")
	public static Object[][] getData() {

		String excelPath = "./excel/data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	// Return data from provided Excel
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		// get count of Row and Column from Excel
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		// define array [rowCountXcolCount]
		Object dataExcel [][] = new Object[rowCount-1][colCount];
		for (int i = 1; i < rowCount; i++) {
			
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				dataExcel[i-1][j]= cellData;

			}
			//System.out.println();
		}
		return dataExcel;
	}
}
