package com.PetStore.TestCases;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Utilities.DataProvider;


public class Repo {

	
	protected static String TestCaseNumber;protected static String runMe;protected static String PetId;
	protected static String categoryId;protected static String CategoryName;protected static String	name;
	protected static String photoUrls;protected static String tagId; protected static String TagName;
	protected static String	status; protected static String Description; protected static String endpoint;
	// response var
	protected static String ResPetId; protected static String ResStatus;protected static String statusCode;
	protected static String RescategoryId;protected static String ResCategoryName;protected static String Resname;
	protected static String ResphotoUrls;protected static String RestagId; protected static String ResTagName;
	public static void loadRequestData(Recordset recordset) throws FilloException {
			
			TestCaseNumber = recordset.getField("TestCaseNumber");
			runMe = recordset.getField("runMe");
			Description = recordset.getField("Description");
			endpoint =  recordset.getField("Endpoint");
			PetId  =  recordset.getField("PetId");
			categoryId =  recordset.getField("categoryId");
			CategoryName =  recordset.getField("CategoryName");
			name =  recordset.getField("name");
			photoUrls =  recordset.getField("photoUrls");
			tagId =  recordset.getField("tagId");
			TagName =  recordset.getField("TagName");
			status =  recordset.getField("status");
		}
	
	
	public static void loadTCExpectedResponse(String testCase, String filename) throws FilloException {
		
        String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
        
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		recordset.next();
		ResPetId=  recordset.getField("ResPetId");
		RescategoryId= recordset.getField("ResCategoryId");
	    ResCategoryName = recordset.getField("ResCategoryName");
	    Resname = recordset.getField("ResName");
		ResphotoUrls = recordset.getField("ResPhotoUrls");
		RestagId= recordset.getField("ResTagId"); 
		ResTagName= recordset.getField("ResTagName");
		ResStatus = recordset.getField("ResStatus");
		statusCode = recordset.getField("statusCode");
		
	
	}

}

