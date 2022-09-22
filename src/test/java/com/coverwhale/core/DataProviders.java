package com.coverwhale.core;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// since test ids used in this data provider have same steps except the Auto liability option, we can use the same test to run multiple times

	@DataProvider(name = "ChangeDriverName")
	public Object[][] changeDriverName() {

		 return new Object[][]{ 
			 { "TC_04_01"},
			 { "TC_04_02"},
			 { "TC_04_03"},
			 { "TC_04_04"},
		 };
	}
	
}
