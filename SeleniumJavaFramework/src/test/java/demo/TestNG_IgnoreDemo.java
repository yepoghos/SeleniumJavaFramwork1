package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore // Ignore all class tests(methods)
public class TestNG_IgnoreDemo {
	
	@Test
	@Ignore // Ignore only this method
	public void test1() {
		System.out.println("This is test 1");
	}

	@Test
	public void test2() {
		System.out.println("This is test 2");
	}

	@Test
	public void test3() {
		System.out.println("This is test 3");
	}

	@Test
	public void test4() {
		System.out.println("This is test 4");
	}
}
