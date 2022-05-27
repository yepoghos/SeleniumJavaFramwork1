package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*****Test is passed : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*****Test is failed : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Test is skipped : " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("*****Tests finished : " + context.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("*****Tests start : " + context.getName());
	}
}
