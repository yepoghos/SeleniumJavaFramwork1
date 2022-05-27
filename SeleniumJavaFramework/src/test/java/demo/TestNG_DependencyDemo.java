package demo;

import org.testng.annotations.Test;

public class TestNG_DependencyDemo {
	// "dependsOnMethods" is over "priority"
	@Test(dependsOnMethods = { "test3", "test4" }, priority = 1)
	public void test1() {
		System.out.println("This is test 1");

	}

	@Test(dependsOnGroups = {"Group.*"})
	public void test2() {
		System.out.println("This is test 2");

	}

	@Test(groups = {"Group1"})
	public void test3() {
		System.out.println("This is test 3");

	}

	@Test
	public void test4() {
		System.out.println("This is test 4");
	}
}
