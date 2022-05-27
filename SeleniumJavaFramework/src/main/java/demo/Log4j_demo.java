package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_demo {
	
	private static Logger logger = LogManager.getLogger(Log4j_demo.class);
	
	public static void main(String[] args) {
	
		System.out.println("\n Hohohohho...start! \n");
		
		logger.info("This is information message");
		logger.error("This is Error message");
		logger.warn("This is Warn message");
		logger.fatal("This is Fatal message");
		
		System.out.println("\n Heheheehheee...finish! \n");
	}

}
