package test;

import java.io.FileInputStream;
import java.util.Properties;

public class TestConfig {

	public static void main(String[] args) throws Exception {
		
	//Config Property Read Check 
		
	Properties CONFIG = new Properties();
		
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties");
	CONFIG.load(ip);
	
	System.out.println(CONFIG.getProperty("username"));
	
	
	//OR Property Read Check
	
	Properties OR = new Properties();
	
	ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\OR.properties");
	OR.load(ip);
	
	System.out.println(OR.getProperty("SiteURL"));
	
	}

}
