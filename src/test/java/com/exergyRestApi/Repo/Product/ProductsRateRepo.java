package com.exergyRestApi.Repo.Product;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Utilities.DataProvider;

public class ProductsRateRepo {

	protected static String lifeAssuredType1;protected static String Age1;protected static String lifeAssuredType2; protected static String Age2; 
	protected static String lifeAssuredType3;protected static String Age3;protected static String lifeAssuredType4; protected static String Age4; 
	protected static String description;protected static String TestCaseNumber; protected static String ProductCode;protected static String runMe;
	protected static String lifeAssuredType5 ;protected static String Age5 ;protected static String lifeAssuredType6 ;protected static String Age6 ;
	protected static String lifeAssured;protected static String  MainpremiumAmount10K; protected static String MainpremiumAmount15K; protected static String MainpremiumAmount20K;
	protected static String MainpremiumAmount35K;protected static String MainpremiumAmount50K;protected static String NonePayeable; protected static String partnerPremiumAmount10K;
	protected static String partnerPremiumAmount15K; protected static String partnerPremiumAmount20K;protected static String partnerPremiumAmount35K; protected static String partnerPremiumAmount50K;
	protected static String ChildPremiumAmount5K; protected static String ChildPremiumAmount7_5K; protected static String ChildPremiumAmount10K;protected static String ChildPremiumAmount15K;
	protected static String ChildPremiumAmount20K;protected static String  ParentPremiumAmount10K; protected static String ParentPremiumAmount20K;  protected static String ParentPremiumAmount15K; 
	protected static String  statusCode;
	
	protected static String MainpremiumAmount25K; protected static String MainpremiumAmount30K;	protected static String MainpremiumAmount40K; protected static String MainpremiumAmount45K;protected static String MainpremiumAmount55K;
	protected static String MainpremiumAmount60K; protected static String MainpremiumAmount65K; protected static String MainpremiumAmount70K; protected static String MainpremiumAmount75K ;protected static String partnerPremiumAmount25K;protected static String  partnerPremiumAmount30K;	
	protected static String partnerPremiumAmount40K	; protected static String partnerPremiumAmount45K; protected static String 	partnerPremiumAmount55K;protected static String partnerPremiumAmount60K;protected static String partnerPremiumAmount65K; 
	protected static String partnerPremiumAmount70K; protected static String ChildPremiumAmount25K; protected static String ChildPremiumAmount30K; protected static String  ChildPremiumAmount35K;protected static String 	ChildPremiumAmount40K;
	protected static String ChildPremiumAmount45K;protected static String ChildPremiumAmount50K; protected static String ParentPremiumAmount25K; protected static String ParentPremiumAmount30K;protected static String  ParentPremiumAmount35K;
	protected static String ParentPremiumAmount40K; protected static String ParentPremiumAmount45K; protected static String ParentPremiumAmount50K; protected static String ExtendedChildPremium5K; protected static String ExtendedChildPremium10K;
	protected static String ExtendedChildPremium15K; protected static String ExtendedChildPremium20K; protected static String 	ExtendedChildPremium25K; protected static String ExtendedChildPremium30K;protected static String ExtendedAdultPremium5K;
	protected static String ExtendedAdultPremium10K; protected static String ExtendedAdultPremium15K; protected static String ExtendedAdultPremium20K; protected static String 	ExtendedAdultPremium25K;protected static String ExtendedAdultPremium30K;
	protected static String MainMemorialBenefit5K; protected static String	MainMemorialBenefit10K;protected static String MainMonthlyAssistance0_5K;protected static String MainMonthlyAssistance1K;protected static String MainMonthlyAssistance1_5K	;
	protected static String MainMonthlyAssistance2K; protected static String VehicleAccessBenefitS6;protected static String	VehicleAccessBenefitL6;
	protected static String  partnerPremiumAmount75K;
	protected static String partnerRetirementPaidUp10K; protected static String partnerRetirementPaidUp15K; protected static String	partnerRetirementPaidUp20K; protected static String	partnerRetirementPaidUp25K; protected static String	partnerRetirementPaidUp30K;
	protected static String partnerRetirementPaidUp35K; protected static String	partnerRetirementPaidUp40K; protected static String	partnerRetirementPaidUp45K; protected static String	partnerRetirementPaidUp50K; protected static String	partnerRetirementPaidUp55K;
	protected static String partnerRetirementPaidUp60K; protected static String	partnerRetirementPaidUp65K; protected static String	partnerRetirementPaidUp70K; protected static String partnerRetirementPaidUp75K; protected static String	partnerMemorialBenefit5K;
	protected static String partnerMemorialBenefit10K; protected static String partnerMonthlyBenefit5K;protected static String	partnerMonthlyBenefit1K;
	public static void loadRequestData(Recordset recordset, String productCode ) throws FilloException {
		
		
		 
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
		
		if(productCode.equals("1960C") || productCode.equals("1960E")) {
			
			lifeAssuredType5= recordset.getField("lifeAssuredType5");
			Age5 = recordset.getField("Age5");
			
			lifeAssuredType6= recordset.getField("lifeAssuredType6");
			Age6 = recordset.getField("Age6");
			
		}
		
		
			
	
	}
	
	public static void loadTCExpectedResponse(String filename, String testCase) throws FilloException {
		
        String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
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
		ParentPremiumAmount15K = recordset.getField("ParentPremiumAmount15K");	
		statusCode = recordset.getField("statusCode");	
		
	}
	
public static void loadTCExpectedResponseFor1960(String filename, String testCase, String ProductCode) throws FilloException {
		
        String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		recordset.next();
		lifeAssured = recordset.getField("lifeAssured");
	
		MainpremiumAmount10K = recordset.getField("MainpremiumAmount10K");
		MainpremiumAmount15K= recordset.getField("MainpremiumAmount15K");	
		MainpremiumAmount20K= recordset.getField("MainpremiumAmount20K");	
		MainpremiumAmount25K= recordset.getField("MainpremiumAmount25K");	
		MainpremiumAmount30K= recordset.getField("MainpremiumAmount30K");	
		MainpremiumAmount35K= recordset.getField("MainpremiumAmount35K");	
		MainpremiumAmount40K= recordset.getField("MainpremiumAmount40K");	
		MainpremiumAmount45K= recordset.getField("MainpremiumAmount45K");	
		MainpremiumAmount50K= recordset.getField("MainpremiumAmount50K");	
		MainpremiumAmount55K= recordset.getField("MainpremiumAmount55K");	
		MainpremiumAmount60K= recordset.getField("MainpremiumAmount60K");	
		MainpremiumAmount65K= recordset.getField("MainpremiumAmount65K");	
		MainpremiumAmount70K= recordset.getField("MainpremiumAmount70K");
		
		MainpremiumAmount75K= recordset.getField("MainpremiumAmount75K");
		
		NonePayeable	= recordset.getField("NonePayeable");
		
		partnerPremiumAmount10K	= recordset.getField("partnerPremiumAmount10K");
		partnerPremiumAmount15K	= recordset.getField("partnerPremiumAmount15K");
		partnerPremiumAmount20K	= recordset.getField("partnerPremiumAmount20K");
		partnerPremiumAmount25K	= recordset.getField("partnerPremiumAmount25K");
		partnerPremiumAmount30K	= recordset.getField("partnerPremiumAmount30K");
		partnerPremiumAmount35K	= recordset.getField("partnerPremiumAmount35K");
		partnerPremiumAmount40K	= recordset.getField("partnerPremiumAmount40K");
		partnerPremiumAmount45K	= recordset.getField("partnerPremiumAmount45K");
		partnerPremiumAmount50K	= recordset.getField("partnerPremiumAmount50K");
		partnerPremiumAmount55K	= recordset.getField("partnerPremiumAmount55K");
		partnerPremiumAmount60K	= recordset.getField("partnerPremiumAmount60K");
		partnerPremiumAmount65K	= recordset.getField("partnerPremiumAmount65K");
		partnerPremiumAmount70K	= recordset.getField("partnerPremiumAmount70K");
		partnerPremiumAmount75K	= recordset.getField("partnerPremiumAmount75K");
		
		if(!ProductCode.equals("1960L")) {
			
			ChildPremiumAmount10K	= recordset.getField("ChildPremiumAmount10K");
			ChildPremiumAmount15K	= recordset.getField("ChildPremiumAmount15K");
			ChildPremiumAmount20K	= recordset.getField("ChildPremiumAmount20K");
			ChildPremiumAmount25K	= recordset.getField("ChildPremiumAmount25K");
			ChildPremiumAmount30K	= recordset.getField("ChildPremiumAmount30K");
			ChildPremiumAmount35K	= recordset.getField("ChildPremiumAmount35K");
			ChildPremiumAmount40K	= recordset.getField("ChildPremiumAmount40K");
			ChildPremiumAmount45K	= recordset.getField("ChildPremiumAmount45K");
			ChildPremiumAmount50K	= recordset.getField("ChildPremiumAmount50K");
		}
		
		
		ParentPremiumAmount10K	= recordset.getField("ParentPremiumAmount10K");
		ParentPremiumAmount15K	= recordset.getField("ParentPremiumAmount15K");
		ParentPremiumAmount20K	= recordset.getField("ParentPremiumAmount20K");
		ParentPremiumAmount25K	= recordset.getField("ParentPremiumAmount25K");
		ParentPremiumAmount30K	= recordset.getField("ParentPremiumAmount30K");
		ParentPremiumAmount35K	= recordset.getField("ParentPremiumAmount35K");
		ParentPremiumAmount40K	= recordset.getField("ParentPremiumAmount40K");
		ParentPremiumAmount45K	= recordset.getField("ParentPremiumAmount45K");
		ParentPremiumAmount50K	= recordset.getField("ParentPremiumAmount50K");
		
		ExtendedChildPremium5K	= recordset.getField("ExtendedChildPremium5K");
		ExtendedChildPremium10K	= recordset.getField("ExtendedChildPremium10K");
		ExtendedChildPremium15K	= recordset.getField("ExtendedChildPremium15K");
		ExtendedChildPremium20K	= recordset.getField("ExtendedChildPremium20K");
		ExtendedChildPremium25K	= recordset.getField("ExtendedChildPremium25K");
		ExtendedChildPremium30K	= recordset.getField("ExtendedChildPremium30K");
		
		ExtendedAdultPremium5K	= recordset.getField("ExtendedAdultPremium5K");
		ExtendedAdultPremium10K	= recordset.getField("ExtendedAdultPremium10K");
		ExtendedAdultPremium15K	= recordset.getField("ExtendedAdultPremium15K");
		ExtendedAdultPremium20K	= recordset.getField("ExtendedAdultPremium20K");
		ExtendedAdultPremium25K	= recordset.getField("ExtendedAdultPremium25K");
		ExtendedAdultPremium30K= recordset.getField("ExtendedAdultPremium30K");
		
		MainMemorialBenefit5K= recordset.getField("MainMemorialBenefit5K");
		MainMemorialBenefit10K= recordset.getField("MainMemorialBenefit10K");
	    MainMonthlyAssistance0_5K= recordset.getField("MainMonthlyAssistance0_5K");
	    MainMonthlyAssistance1K= recordset.getField("MainMonthlyAssistance1K");
	    MainMonthlyAssistance1_5K= recordset.getField("MainMonthlyAssistance1_5K");
	    MainMonthlyAssistance2K= recordset.getField("MainMonthlyAssistance2K");
	  
	    
	    if(ProductCode.equals("1960E")) {
	    	
	    	VehicleAccessBenefitS6= recordset.getField("VehicleAccessBenefitS6");
	  	    VehicleAccessBenefitL6= recordset.getField("VehicleAccessBenefitL6");
		    partnerRetirementPaidUp10K= recordset.getField("partnerRetirementPaidUp10K");
		    partnerRetirementPaidUp15K= recordset.getField("partnerRetirementPaidUp15K");
		    partnerRetirementPaidUp20K= recordset.getField("partnerRetirementPaidUp20K");
		    partnerRetirementPaidUp25K= recordset.getField("partnerRetirementPaidUp25K");
		    partnerRetirementPaidUp30K= recordset.getField("partnerRetirementPaidUp30K");
		    partnerRetirementPaidUp35K= recordset.getField("partnerRetirementPaidUp35K");
		    partnerRetirementPaidUp40K= recordset.getField("partnerRetirementPaidUp40K");
		    partnerRetirementPaidUp45K= recordset.getField("partnerRetirementPaidUp45K");
		    partnerRetirementPaidUp50K= recordset.getField("partnerRetirementPaidUp50K");
		    partnerRetirementPaidUp55K= recordset.getField("partnerRetirementPaidUp55K");
		    partnerRetirementPaidUp60K= recordset.getField("partnerRetirementPaidUp60K");
		    partnerRetirementPaidUp65K= recordset.getField("partnerRetirementPaidUp65K");
		    partnerRetirementPaidUp70K= recordset.getField("partnerRetirementPaidUp70K");
		    partnerRetirementPaidUp75K= recordset.getField("partnerRetirementPaidUp75K");
	    }
	    partnerMemorialBenefit5K= recordset.getField("partnerMemorialBenefit5K");
	    partnerMemorialBenefit10K= recordset.getField("partnerMemorialBenefit10K");
	    partnerMonthlyBenefit5K= recordset.getField("partnerMonthlyBenefit5K");
	    partnerMonthlyBenefit1K= recordset.getField("partnerMonthlyBenefit10K");
		statusCode = recordset.getField("statusCode");		
		NonePayeable = recordset.getField("NonePayeable");
	}
	
	
	
	
}
