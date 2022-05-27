package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_ParametersDemo {
	@Test
	@Parameters({"myname"})
	public void tets(@Optional("DefaultName") String name) {
		System.out.println("Name is :" + name);
		
	}
}
