package test;

import com.qtpselenium.util.Xls_Reader;

public class TestDataExtract {

	public static void main(String[] args) {
		Xls_Reader x = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\SuiteA.xlsx");
		getdata(x, "TestCase_A1");
}
	
	public static Object[][] getdata(Xls_Reader xls, String TestcaseName){
		//if sheet is not present
		
		if(! xls.isSheetExist(TestcaseName)){
			return new Object[1][0]; 
		}
		
		int Rows = xls.getRowCount(TestcaseName);
		int Cols = xls.getColumnCount(TestcaseName);
//		
//		System.out.println("Rows are "+ Rows);
//		System.out.println("Cols are "+ Cols);
		
		Object [][] data = new Object[Rows-1][Cols-3];
		
		for(int i=2;i<=xls.getRowCount(TestcaseName);i++){
			
			for(int j=0;j<xls.getColumnCount(TestcaseName)-3;j++){
				
				data[i-2][j] = xls.getCellData(TestcaseName, j, i);
						
//				System.out.print(xls.getCellData(TestcaseName, j, i));
			}			
				System.out.println(" ");		
		}
		return data;
			}

}
