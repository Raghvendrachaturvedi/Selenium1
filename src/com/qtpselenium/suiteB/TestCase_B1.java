package com.qtpselenium.suiteB;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class TestCase_B1 extends TestSuieBase {
	String runmmodes[] = null;
	static int count = -1;
	
	@BeforeTest
	
	public void checkTestSkip(){
		
		if(! TestUtil.isTestCaseRunnable(suiteBxls, this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping this test because RunMode in excel is Set to NO");//Go in Log
			throw new SkipException("Skipping this test"+this.getClass().getSimpleName()+" because RunMode in excel is Set to NO");// Go in Report
		}
		

		//To load the runmode of the test
		
		runmmodes = TestUtil.getDataSetRunmodes(suiteBxls, this.getClass().getSimpleName());
		
	}
	
	@Test(dataProvider = "getTestData")
	
	public void testcaseB1(String Col1,
							String Col2,
							String Col3,
							String Col4){
		
		//Test the runmode of the current dataset
		
				count++;
				if (! runmmodes[count].equalsIgnoreCase("Y")){
					throw new SkipException("Runmode for test is Set to NO");
				}
				
				APP_LOGS.debug("Executing Test case testcaseB1");
				APP_LOGS.debug(Col1+ "...." + Col2+ "....." + Col3 +"...." +Col4 +". ....");
		
	}
	@DataProvider
	
	 public Object [][] getTestData (){
		return TestUtil.getdata(suiteBxls, this.getClass().getSimpleName());
	}

}
