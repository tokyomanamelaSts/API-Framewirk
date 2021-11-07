package com.exergyRestApi.Repo.Product;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Utilities.DataProvider;

public class ProductsRateRepo {

	protected static String lifeAssuredType1;protected static String Age1;protected static String lifeAssuredType2; protected static String Age2; 
	protected static String lifeAssuredType3;protected static String Age3;protected static String lifeAssuredType4; protected static String Age4; 
	protected static String description;protected static String TestCaseNumber; protected static String ProductCode;protected static String runMe;
	
	protected static String lifeAssured;protected static String  MainpremiumAmount10K; protected static String MainpremiumAmount15K; protected static String MainpremiumAmount20K;
	protected static String MainpremiumAmount35K;protected static String MainpremiumAmount50K;protected static String NonePayeable; protected static String partnerPremiumAmount10K;
	protected static String partnerPremiumAmount15K; protected static String partnerPremiumAmount20K;protected static String partnerPremiumAmount35K; protected static String partnerPremiumAmount50K;
	protected static String ChildPremiumAmount5K; protected static String ChildPremiumAmount7_5K; protected static String ChildPremiumAmount10K;protected static String ChildPremiumAmount15K;protected static String ChildPremiumAmount20K;
	protected static String  ParentPremiumAmount10K; protected static String ParentPremiumAmount20K;
	
	
	public static void loadRequestData(Recordset recordset) throws FilloException {
		
		
		
		lifeAssuredType1 = recordset.getField("lifeAssuredType1");
		lifeAssuredType2 = recordset.getField("lifeAssuredType2");
		lifeAssuredType3 = recordset.getField("lifeAssuredType3");
		lifeAssuredType4 = recordset.getField("lifeAssuredType4");
	
		
		Age1 = recordset.getField("Age1");		
		Age2 = recordset.getField("Age2");		
		Age3 = recordset.getField("Age3");		
		Age4 = recordset.getField("Age4");		
			
		
		description = recordset.getField("description");	
		TestCaseNumber = recordset.getField("TestCaseNumber");	
		ProductCode = recordset.getField("ProductCode");	
		
		runMe = recordset.getField("runMe");	
	
	}
	
	public static void loadTCExpectedResponse(String testCase) throws FilloException {
		
        String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/rates.xlsx",Query );
		
		recordset.next();
		lifeAssured = recordset.getField("lifeAssured");
		MainpremiumAmount10K = recordset.getField("MainpremiumAmount10K");
		MainpremiumAmount15K = recordset.getField("MainpremiumAmount15K");
		MainpremiumAmount20K = recordset.getField("MainpremiumAmount20K");
		MainpremiumAmount35K = recordset.getField("MainpremiumAmount35K");
		MainpremiumAmount50K = recordset.getField("MainpremiumAmount50K");
		NonePayeable = recordset.getField("NonePayeable");
		partnerPremiumAmount10K = recordset.getField("partnerPremiumAmount10K");
		partnerPremiumAmount15K = recordset.getField("partnerPremiumAmount15K");
		partnerPremiumAmount20K = recordset.getField("partnerPremiumAmount20K");
		partnerPremiumAmount35K = recordset.getField("partnerPremiumAmount35K");
		partnerPremiumAmount50K = recordset.getField("partnerPremiumAmount50K");
		ChildPremiumAmount5K = recordset.getField("ChildPremiumAmount5K");
		ChildPremiumAmount7_5K = recordset.getField("ChildPremiumAmount7_5K");
		ChildPremiumAmount10K = recordset.getField("ChildPremiumAmount10K");
		ChildPremiumAmount15K = recordset.getField("ChildPremiumAmount15K");
		ChildPremiumAmount20K = recordset.getField("ChildPremiumAmount20K");
		ParentPremiumAmount10K = recordset.getField("ParentPremiumAmount10K");
		ParentPremiumAmount20K = recordset.getField("ParentPremiumAmount20K");	
	}
	
	
	
	
}
