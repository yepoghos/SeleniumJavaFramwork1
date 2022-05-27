package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		ExcelUtils excel = new ExcelUtils("./excel/data.xlsx", "Sheet1");

		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);

	}

}
