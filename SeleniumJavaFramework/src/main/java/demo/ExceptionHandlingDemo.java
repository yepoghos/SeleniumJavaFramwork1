package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		try {
			demo1();
		} catch (Exception exp) {
			System.out.println("Catched!!!");
			System.out.println("Messegi is " + exp.getMessage());
			System.out.println("Cause is " + exp.getCause());
			exp.printStackTrace();
		} finally {
			System.out.println("Finaly block!");
		}

	}

	public static void demo1() throws Exception {

		System.out.println("\n Start ... \n");
		//throw new ArithmeticException("My error, not valid operation!");
		int i = 1 / 0;
		System.out.println("... End");

	}
}
