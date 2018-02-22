package com.qtpselenium.base;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.qtpselenium.util.Xls_Reader;

public class TestBase {

		public static Logger APP_LOGS=null;
		public static Properties CONFIG = null;
		public static Properties OR = null;
		
		public static Xls_Reader suitexls = null;
		public static Xls_Reader suiteAxls = null;
		public static Xls_Reader suiteBxls = null;
		public static Xls_Reader suiteCxls = null;
		public static boolean isInitialized= false;
		
		
		//Initialize tests
		
		public void initialize() throws Exception{
			
			if(!isInitialized){
			
				APP_LOGS=Logger.getLogger("devpinoyLogger");
			
	// Initialization of Config Properties file
			
			APP_LOGS.debug(".....Loading Properies files........");
			
			CONFIG = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties");
			CONFIG.load(ip);
			
	//Initialization of OR Properties file
			
			OR = new Properties();
			
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\OR.properties");
			OR.load(ip);
			
			APP_LOGS.debug("Properties files loaded successfully");
		
	// XLS Files
			
			APP_LOGS.debug("Loading XLS Files");
			
			suiteAxls = new Xls_Reader (System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteA.xlsx");
			suiteBxls = new Xls_Reader (System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteB.xlsx");
			suiteCxls = new Xls_Reader (System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteC.xlsx");
			suitexls =  new Xls_Reader (System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\Suite.xlsx");
			
			APP_LOGS.debug("Xls file are loaded successfully");
			
			isInitialized = true;
			}
 }
		
		
		
		

	

}
