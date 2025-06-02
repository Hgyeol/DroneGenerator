package test;

import org.apache.log4j.PropertyConfigurator;

public class Logmain {
	public static void main(String[] args) {
		PropertyConfigurator.configure("./resource/log4j.properties");
		Log4jTest log4j = new Log4jTest();
		log4j.userLogger();
	}
}
