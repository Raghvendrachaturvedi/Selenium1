package test;

import com.qtpselenium.util.Xls_Reader;

public class TestRunnable {

	public static void main(String[] args) {
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteA.xlsx");
		System.out.println(isTestCaseRunnable(x, "TestCase_A1"));
		
		Xls_Reader x1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteB.xlsx");
		System.out.println(isTestCaseRunnable(x1, "TestCase_B1"));
	}
		
	public static boolean isTestCaseRunnable (Xls_Reader xls, String Testcase){
		boolean testrunstatus = false;
		for(int i =2; i<= xls.getRowCount("Test Cases");i++){
//			System.out.println(xls.getCellData("Test Cases", "TCID", i));
//			System.out.println(xls.getCellData("Test Cases", "Runmode", i));
			if (xls.getCellData("Test Cases", "TCID", i).equals(Testcase)){
				if (xls.getCellData("Test Cases", "Runmode", i).equals("Y")){
					testrunstatus =true;
				}
			}
		}
		return testrunstatus;
	}

}
