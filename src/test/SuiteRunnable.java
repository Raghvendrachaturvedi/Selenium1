package test;

import com.qtpselenium.util.Xls_Reader;

public class SuiteRunnable {

	public static void main(String[] args) {
		
		Xls_Reader x = new Xls_Reader (System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\Suite.xlsx");
		System.out.println(isSuiteRunnable(x,"A Suite"));
		System.out.println(isSuiteRunnable(x,"B Suite"));
		System.out.println(isSuiteRunnable(x,"C Suite"));
		}
	
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
	
	}
