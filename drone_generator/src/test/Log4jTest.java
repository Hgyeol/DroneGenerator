package test;

import org.apache.log4j.Logger;

public class Log4jTest {
	private Logger logger = Logger.getLogger(Log4jTest.class);
	
	public void userLogger() {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
