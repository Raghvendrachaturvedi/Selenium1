package com.qtpselenium.suiteC;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.qtpselenium.base.TestBase;
import com.qtpselenium.util.TestUtil;

public class TestSuieBase extends TestBase{

	@BeforeSuite
	
	public void checksSkipSuite() throws Exception{
		initialize();

		if (!TestUtil.isSuiteRunnable(suitexls, "C Suite")){
			
			APP_LOGS.debug("Skipping Test SuiteC because its Runmode is set to NO in Excel Sheet");	
		throw new SkipException("Skipping all test cases of Suite C because its runmode is set to NO");
	
		}
	}

}
