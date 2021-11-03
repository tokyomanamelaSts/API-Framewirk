package com.exergyRestApi.Repo.Product;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Utilities.DataProvider;

public class ProductRuleRepo {

	protected static String TestCaseNumber;protected static String runMe; 
	protected static String Description; protected static String ProductCode;
	
	
	protected static String TestCaseNumber2; protected static String productCode;protected static String productName;
	protected static String version; protected static String maxBeneficiaries ;protected static String	MainLife_lifeAssuredType;
	protected static String Mainlife_minAllowed;protected static String Mainlife_maxAllowed; protected static String Mainlife_maxCoverAllowed;
	protected static String Mainlife_minCoverAllowed; protected static String Mainlife_minAge; protected static String	Mainlife_maxAge	;
	protected static String Partner_lifeAssuredType;protected static String Partner_minAllowed	;
	protected static String Partner_maxAllowed; protected static String	Partner_maxCoverAllowed	;
	protected static String Partner_minCoverAllowed	;protected static String Partner_minAge	;
	protected static String Partner_maxAge; protected static String	Child_lifeAssuredType; protected static String	Child_minAllowed;
	protected static String Child_maxAllowed; protected static String Child_maxCoverAllowed;protected static String Child_minCoverAllowed;
	protected static String Child_minAge; protected static String Child_MaxAge; protected static String	parent_lifeAssuredType;
	protected static String parent_minAllowed; protected static String parent_maxAllowed;protected static String parent_maxCoverAllowed;
	protected static String parent_minCoverAllowed; protected static String parent_minAge; protected static String parent_MaxAge;
	
	
	public static void loadTCsData(Recordset recordset) throws FilloException {
	
		TestCaseNumber = recordset.getField("TestCaseNumber");
		runMe = recordset.getField("runMe");
		Description = recordset.getField("Description");
		ProductCode = recordset.getField("ProductCode");
		
		
	}
	
	
	public static void loadTCExpectedResponse(String testCase) throws FilloException {
		
         String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
		
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/ProductRules.xlsx",Query );
		
		recordset.next();
		
		TestCaseNumber2 = recordset.getField("TestCaseNumber");
		productCode = recordset.getField("productCode");
		version = recordset.getField("version");
		productName = recordset.getField("productName");
		maxBeneficiaries = recordset.getField("maxBeneficiaries");
		
		MainLife_lifeAssuredType = recordset.getField("MainLife_lifeAssuredType");
		Mainlife_minAllowed = recordset.getField("Mainlife_minAllowed");
		Mainlife_maxAllowed = recordset.getField("Mainlife_maxAllowed");
		Mainlife_maxCoverAllowed = recordset.getField("Mainlife_maxCoverAllowed");
		Mainlife_minCoverAllowed = recordset.getField("Mainlife_minCoverAllowed");
		Mainlife_minAge = recordset.getField("Mainlife_minAge");
		Mainlife_maxAge = recordset.getField("Mainlife_maxAge");
		
		Partner_lifeAssuredType = recordset.getField("Partner_lifeAssuredType");
		Partner_minAllowed = recordset.getField("Partner_minAllowed");
		Partner_maxAllowed = recordset.getField("Partner_maxAllowed");
		Partner_maxCoverAllowed = recordset.getField("Partner_maxCoverAllowed");
		Partner_minCoverAllowed = recordset.getField("Partner_minCoverAllowed");
		Partner_minAge = recordset.getField("Partner_minAge");
		Partner_maxAge = recordset.getField("Partner_maxAge");
		
		Child_lifeAssuredType = recordset.getField("Child_lifeAssuredType");
		Child_minAllowed = recordset.getField("Child_minAllowed");
		Child_maxAllowed = recordset.getField("Child_maxAllowed");
		Child_maxCoverAllowed = recordset.getField("Child_maxCoverAllowed");
		Child_minCoverAllowed = recordset.getField("Child_minCoverAllowed");
		Child_minAge = recordset.getField("Child_minAge");
		Child_MaxAge = recordset.getField("Child_MaxAge");
		
		
		parent_lifeAssuredType = recordset.getField("parent_lifeAssuredType");
		parent_minAllowed = recordset.getField("parent_minAllowed");
		parent_maxAllowed = recordset.getField("parent_maxAllowed");
		parent_maxCoverAllowed = recordset.getField("parent_maxCoverAllowed");
		parent_minCoverAllowed = recordset.getField("parent_minCoverAllowed");
		parent_minAge = recordset.getField("parent_minAge");
		parent_MaxAge = recordset.getField("parent_MaxAge");
		
		
	}
	
}
