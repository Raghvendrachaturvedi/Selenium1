 package test;

import com.qtpselenium.util.Xls_Reader;

public class UpdateDataInExcel {

	public static void main(String[] args) {
	
	Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteA.xlsx");
	 
	reportDataSetResult(x,"TestCase_A1",3,"Pass");
	 
	}
	
	public static void reportDataSetResult (Xls_Reader xls, String TestCasenName, int RowNum, String Result){
		
		xls.setCellData(TestCasenName, "Result", RowNum, Result);
		
	}

} 
