package com.coverwhale.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.coverwhale.utils.common.Config;

/** This class will be utilized in RetryListener
 * 
 * @author Jaikant
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RetryAnalyzer.class);
	
	int counter = 0;
	int maxRetryCount = Integer.parseInt(Config.getProperty("maxRetryCount"));  // getting max retry count from properties file

	@Override
	public boolean retry(ITestResult result) {
		if (counter < maxRetryCount) {
			LOGGER.info("Retry [{}] for test [{}] ", counter + 1, result.getMethod().getMethodName());
			
			counter++;
			
			return true;
		}
		return false;
	}
}
