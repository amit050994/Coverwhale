package com.coverwhale.core;

import org.testng.annotations.BeforeSuite;;

/**
 * This class is responsible for all before and after suite configurations.
 *
 * @author Jaikant
 */
public class SuiteConfiguration {

	@BeforeSuite
	public void setUp() {
		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
	} 
}
