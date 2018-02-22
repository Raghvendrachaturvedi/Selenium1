package test;

import org.apache.log4j.Logger;

public class LoggingTest {

	public static void main(String[] args) {
		 
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		
		APP_LOGS.debug("First Log Generation in MY2 Project");
	}

}
