package com.qtpselenium.suiteA;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.qtpselenium.base.TestBase;
import com.qtpselenium.util.TestUtil;


public class TestSuieBase extends TestBase {
	@BeforeSuite
	
	public void checkSuiteSkip() throws Exception{
	
		initialize();
		
		if(!TestUtil.isSuiteRunnable(suitexls, "A Suite")){
			APP_LOGS.debug("Skipping Test SuiteA because its Runmode is set to NO in Excel Sheet");
			throw new SkipException("Skipping all test cases of Suite A because its runmode is set to NO");
			
		}
		
	}
	
}
	
	

