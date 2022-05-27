package demo;
import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNG_GroupsDemo {
	
	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("This is Test 1");
	}
	
	@Test(groups= {"sanity", "smoke"})	
	public void test2() {
		System.out.println("This is Test 2");
	}
	@Test(groups= {"windows.regression"})
	public void test3() {
		System.out.println("This is Test 3");
	}
	@Test(groups= {"linux.regression"})
	public void test4() {
		System.out.println("This is Test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("This is Test 5");
	}
	
	
}
