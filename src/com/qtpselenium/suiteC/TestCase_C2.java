package com.qtpselenium.suiteC;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class TestCase_C2 extends TestSuieBase{
	
	@BeforeTest
	
	public void checkTestSkip(){
		
		if(! TestUtil.isTestCaseRunnable(suiteCxls, this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping this test"+this.getClass().getSimpleName()+" because RunMode in excel is Set to NO");//Go in Log
			throw new SkipException("Skipping this test" + this.getClass().getSimpleName()+"because RunMode in excel is Set to NO");// Go in Report
		}
		
	}
	
	@Test
	
	public void testcaseC2(){
		
		System.out.println("testcaseC2");
	}

}
