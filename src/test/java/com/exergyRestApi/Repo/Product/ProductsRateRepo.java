package com.exergyRestApi.Repo.Product;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class ProductsRateRepo {

	protected static String lifeAssuredType1;protected static String Age1;protected static String lifeAssuredType2; protected static String Age2; 
	protected static String lifeAssuredType3;protected static String Age3;protected static String lifeAssuredType4; protected static String Age4; 
	protected static String lifeAssuredType5;protected static String Age5;protected static String lifeAssuredType6; protected static String Age6;
	protected static String description;protected static String TestCaseNumber; protected static String ProductCode;protected static String runMe;
	public static void loadRequestData(Recordset recordset) throws FilloException {
		
		
		
		lifeAssuredType1 = recordset.getField("lifeAssuredType1");
		lifeAssuredType2 = recordset.getField("lifeAssuredType2");
		lifeAssuredType3 = recordset.getField("lifeAssuredType3");
		lifeAssuredType4 = recordset.getField("lifeAssuredType4");
		lifeAssuredType5 = recordset.getField("lifeAssuredType5");
		lifeAssuredType6 = recordset.getField("lifeAssuredType6");
		
		Age1 = recordset.getField("Age1");		
		Age2 = recordset.getField("Age2");		
		Age3 = recordset.getField("Age3");		
		Age4 = recordset.getField("Age4");		
		Age5 = recordset.getField("Age5");		
		Age6 = recordset.getField("Age6");		
		
		description = recordset.getField("description");	
		TestCaseNumber = recordset.getField("TestCaseNumber");	
		ProductCode = recordset.getField("ProductCode");	
		
		runMe = recordset.getField("runMe");	
	
	}
	
	
	
	
}
