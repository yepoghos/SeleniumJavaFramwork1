package conifg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import demo.TestNG_ExtentReports2;

public class PropertiesFile {

	static Properties prop = new Properties();

	public static void main(String[] args) {
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		try {
			InputStream input = new FileInputStream("./src/test/java/conifg/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TestNG_ExtentReports2.browserName=browser;
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream("./src/test/java/conifg/config.properties");
			prop.setProperty("myKey", "myValue");
			prop.store(output, null);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
