package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

// Failed tests stored in test-output/testng-failed.xml
// So you can run "testng-failed.xml" directly
public class TestNG_RerunFailedDemo {
	
	// Rerun calls from "listeners" package
	@Test(retryAnalyzer = listeners.TestNGRerunAnalyzer.class)
	public void test1() {
		System.out.println("This is test 1");
		Assert.assertTrue(0>1);
	}

	@Test(retryAnalyzer = listeners.TestNGRerunAnalyzer.class)
	public void test2() {
		System.out.println("This is test 2");
		 int i =1/0;

	}

	@Test
	public void test3() {
		System.out.println("This is test 3");

	}

}
