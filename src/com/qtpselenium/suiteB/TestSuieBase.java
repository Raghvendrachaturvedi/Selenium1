package com.qtpselenium.suiteB;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.qtpselenium.base.TestBase;
import com.qtpselenium.util.TestUtil;

public class TestSuieBase extends TestBase{
	
	@BeforeSuite
		public void checkSuiteSkip() throws Exception{
        
		initialize();
		
		if(!TestUtil.isSuiteRunnable(suitexls, "B Suite")){
			APP_LOGS.debug("Skipping Test SuiteB because its Runmode is set to NO in Excel Sheet");
			throw new SkipException("Skipping all test cases of Suite B because it's runmode is set to NO");
			
		}
	}

}
