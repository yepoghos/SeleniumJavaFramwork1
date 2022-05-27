package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// Constructor starts
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	// Constructor ends

	public static void main(String[] arg) {
		getRowCount();
		getColCount();
		getCellDataString(0, 0);
		getCellDataNumber(1, 1);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("N of row: " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("N of col: " + colCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int row, int col) {
		String cellData = null;
		try {
			cellData = sheet.getRow(row).getCell(col).getStringCellValue();
			//System.out.println("Cell data: " + cellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	public static double getCellDataNumber(int row, int col) {
		
		Double cellData = null;
		try {
			cellData = sheet.getRow(row).getCell(col).getNumericCellValue();
			//System.out.println("Cell data: " + cellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

}
