package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer
{
	private int retryCount=0;
	private static final int maxRetryCount=4;
	
	@Override
	public boolean retry(ITestResult result)
	{
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
		}
		return false;
		
	}
}

	


