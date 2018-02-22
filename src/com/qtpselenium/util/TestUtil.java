package com.qtpselenium.util;

import java.io.FileInputStream;
import java.util.Properties;

public class TestUtil {

	
//Method to check Suite is Runnable or not
	
public static boolean isSuiteRunnable (Xls_Reader xls,  String SuiteName)
	
	{
		boolean isexecutable = false;
		for(int i =2;i<=xls.getRowCount("Test Suite");i++){
			
//			System.out.println(xls.getCellData("Test Suite", "TSID", i));
//			System.out.println(xls.getCellData("Test Suite", "Runmode", i));
			
			if(xls.getCellData("Test Suite", "TSID", i).equals(SuiteName)){
				if (xls.getCellData("Test Suite", "Runmode", i).equals("Y"))
					isexecutable = true;
			}
		}
		
		return isexecutable;
	}



//Method to read config files

public static void main(String[] args) throws Exception {
	
//Config Property Read Check 
	
Properties CONFIG = new Properties();
	
FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties");
CONFIG.load(ip);

//System.out.println(CONFIG.getProperty("username"));


//OR Property Read Check

Properties OR = new Properties();

ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\OR.properties");
OR.load(ip);

//System.out.println(OR.getProperty("SiteURL"));

}


//To get data from Xls file


public static Object[][] getdata(Xls_Reader xls, String TestcaseName){
	//if sheet is not present
	
	if(! xls.isSheetExist(TestcaseName)){
		return new Object[1][0]; 
	}
	
	int Rows = xls.getRowCount(TestcaseName);
	int Cols = xls.getColumnCount(TestcaseName);

//	System.out.println("Rows are "+ Rows);
//	System.out.println("Cols are "+ Cols);
	
	Object [][] data = new Object[Rows-1][Cols-3];
	
	for(int i=2;i<=xls.getRowCount(TestcaseName);i++){
		
		for(int j=0;j<xls.getColumnCount(TestcaseName)-3;j++){
			
			data[i-2][j] = xls.getCellData(TestcaseName, j, i);
					
//			System.out.print(xls.getCellData(TestcaseName, j, i));
		}			
//			System.out.println(" ");		
	}
	return data;
		}

// To check the istest runnable?

public static boolean isTestCaseRunnable (Xls_Reader xls, String Testcase){
	boolean testrunstatus = false;
	for(int i =2; i<= xls.getRowCount("Test Cases");i++){
//		System.out.println(xls.getCellData("Test Cases", "TCID", i));
//		System.out.println(xls.getCellData("Test Cases", "Runmode", i));
		if (xls.getCellData("Test Cases", "TCID", i).equals(Testcase)){
			if (xls.getCellData("Test Cases", "Runmode", i).equals("Y")){
				testrunstatus =true;
			}
		}
	}
	return testrunstatus;
}

// To update data in Excel sheet

public static void reportDataSetResult (Xls_Reader xls, String TestCasenName, int RowNum, String Result){
	
	xls.setCellData(TestCasenName, "Result", RowNum, Result);
	
	
	
	
}

//checks RUnmode for dataSet
		public static String[] getDataSetRunmodes(Xls_Reader xlsFile,String sheetName){
			String[] runmodes=null;
			if(!xlsFile.isSheetExist(sheetName)){
				xlsFile=null;
				sheetName=null;
				runmodes = new String[1];
				runmodes[0]="Y";
				xlsFile=null;
				sheetName=null;
				return runmodes;
			}
			runmodes = new String[xlsFile.getRowCount(sheetName)-1];
			for(int i=2;i<=runmodes.length+1;i++){
				runmodes[i-2]=xlsFile.getCellData(sheetName, "Runmode", i);
			}
			xlsFile=null;
			sheetName=null;
			return runmodes;
			
		}


}
