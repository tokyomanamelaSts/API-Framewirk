package com.exergyRestApi.Repo.Product;

import org.json.JSONObject;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Utilities.DataProvider;
import io.restassured.response.Response;

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
	protected static String MainMonthlyAssistance10K;protected static String MainMonthlyAssistance15K;protected static String MainMonthlyAssistance20K;protected static String MainMonthlyAssistance35K;protected static String MainMonthlyAssistance50K;
	protected static String MainMonthlyAssistance55K;protected static String MainMonthlyAssistance60K;protected static String MainMonthlyAssistance65K;protected static String MainMonthlyAssistance70K;protected static String MainMonthlyAssistance75K;
	protected static String MainMemorialBenefit15K;protected static String MainMemorialBenefit20K;protected static String MainMemorialBenefit35K;protected static String MainMemorialBenefit50K;protected static String MainMemorialBenefit55K;
	protected static String MainMemorialBenefit60K;protected static String MainMemorialBenefit65K;protected static String MainMemorialBenefit70K;protected static String MainMemorialBenefit75K;
	protected static String MainHospitalBenefit10K;protected static String MainHospitalBenefit15K;protected static String MainHospitalBenefit20K; protected static String MainHospitalBenefit35K; protected static String MainHospitalBenefit50K; protected static String MainHospitalBenefit55K;
	protected static String MainHospitalBenefit60K;protected static String MainHospitalBenefit65K; protected static String MainHospitalBenefit70K;protected static String MainHospitalBenefit75K;
	protected static String MainVehicleAccessBenefit4_5K;protected static String MainVehicleAccessBenefit6K;protected static String MainVehicleAccessBenefit10_5K;protected static String MainVehicleAccessBenefit15K;
	protected static String MainLifeCoverBenefit10K; protected static String MainLifeCoverBenefit15K; protected static String MainLifeCoverBenefit20K;protected static String MainLifeCoverBenefit35K; protected static String MainLifeCoverBenefit50K;protected static String MainLifeCoverBenefit55K;
	protected static String MainLifeCoverBenefit60K; protected static String MainLifeCoverBenefit65K;protected static String MainLifeCoverBenefit70K; protected static String MainLifeCoverBenefit75K;
    protected static String partnerMemorialBenefit15K;protected static String partnerMemorialBenefit20K;protected static String	partnerMemorialBenefit35K; protected static String	partnerMemorialBenefit50K;protected static String partnerMemorialBenefit55K; protected static String partnerMemorialBenefit60K;
    protected static String partnerMemorialBenefit65K; protected static String	partnerMemorialBenefit70K;protected static String partnerMemorialBenefit75K; protected static String	partnerLifeCoverBenefit10K; protected static String	partnerLifeCoverBenefit15K; protected static String partnerLifeCoverBenefit20K;
    protected static String partnerLifeCoverBenefit35K; protected static String	partnerLifeCoverBenefit50K; protected static String	partnerLifeCoverBenefit55K; protected static String partnerLifeCoverBenefit60K; protected static String	partnerLifeCoverBenefit65K; protected static String	partnerLifeCoverBenefit70K;
    protected static String partnerLifeCoverBenefit75K;
	
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
	protected static String partnerMemorialBenefit10K; protected static String partnerMonthlyBenefit5K;protected static String	partnerMonthlyBenefit1K; protected static String ExtendedAdultPremium55K;protected static String ExtendedAdultPremium60K;protected static String ExtendedAdultPremium65K;
	protected static String ExtendedAdultPremium70K;protected static String ExtendedAdultPremium75K;protected static String ParentPremiumAmount55K;protected static String ParentPremiumAmount60K;protected static String ParentPremiumAmount65K;protected static String ParentPremiumAmount70K;protected static String ParentPremiumAmount75K;
	protected static String ChildPremiumAmount55K; protected static String ChildPremiumAmount60K;protected static String ChildPremiumAmount65K;protected static String ChildPremiumAmount70K;protected static String ChildPremiumAmount75K;
	protected static int mainLifeIndex = 0;protected static int PartnerIndex = 0; protected static int ParentIndex = 0;protected static int ChildIndex = 0;protected static int extendChildIndex = 0;protected static int extendAdultIndex = 0;protected static int  lifeCoverBenIndex;
	protected static int FunBenIndex = 0;protected static int MemBenIndex = 0;protected static int MonAssIndex = 0;protected static int AirBenIndex = 0;protected static int VehAccIndex = 0;protected static int GrocBen = 0; protected static int HospitalBenindex = 0;
	          
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
		
		if(productCode.equals("1960C") || productCode.equals("1960E")||productCode.equals("1960L")||productCode.equals("1977")) {
			
			lifeAssuredType5= recordset.getField("lifeAssuredType5");
			Age5 = recordset.getField("Age5");
			
			lifeAssuredType6= recordset.getField("lifeAssuredType6");
			Age6 = recordset.getField("Age6");
			
		}
		
		
			
	
	}
	
	public static void setindexes(Response response, String lifeAssured) {
		
		
		JSONObject innerJson = new JSONObject(response.getBody().asString());
		
		int count = innerJson.getJSONArray("lifesAssured").length();
		
		for(int x = 0 ; x< count ; x++) {
			
			
			String currentLifeAssured = innerJson.getJSONArray("lifesAssured").getJSONObject(x).get("lifeAssured").toString();
			
			if(currentLifeAssured.equalsIgnoreCase(lifeAssured)) {
				
				mainLifeIndex = x;PartnerIndex = x;ParentIndex = x;
				ChildIndex = x;extendChildIndex =x;extendAdultIndex = x; 
				
				int innercount = innerJson.getJSONArray("lifesAssured").getJSONObject(x).getJSONArray("benefits").length();
				
				for(int y = 0 ; y< innercount; y++) {
					
					String benefitCategory = innerJson.getJSONArray("lifesAssured").getJSONObject(x).getJSONArray("benefits").getJSONObject(y).get("benefitCategory").toString();
					
					if(benefitCategory.equalsIgnoreCase("FuneralBenefit")) {
						
						FunBenIndex = y;
						
					}
					else
						if(benefitCategory.equalsIgnoreCase("MemorialBenefit")) {
							
							MemBenIndex = y;
							
						}
					else
						if(benefitCategory.equalsIgnoreCase("MonthlyAssistanceBenefit")) {
								
							MonAssIndex = y;
							
					  
								
						}
					else
						if(benefitCategory.equalsIgnoreCase("AirtimeBenefit")) {
								
							AirBenIndex = y;
								
						}
				    else
						if(benefitCategory.equalsIgnoreCase("VehicleAccessBenefit")) {
									
							VehAccIndex = y;
									
						}
					else
						if(benefitCategory.equalsIgnoreCase("GroceryBenefit")) {
										
							GrocBen = y;
										
						}  
					else
						if(benefitCategory.equalsIgnoreCase("HospitalBenefit")) { 
											
							HospitalBenindex = y;
											
						}
					else
						if(benefitCategory.equalsIgnoreCase("LifeBenefit")) { 
												
							lifeCoverBenIndex = y;
												
						}
						
					
				}
				
			}

		}
		
		
		
	}
	public static void loadTCExpectedResponse(String filename, String testCase, String ProductCode) throws FilloException {
		
        String Query = "Select * from Response where TestCaseNumber = '"+testCase+"'";
		
		Recordset recordset =DataProvider.getDataFromExcelbyQuery("TestData/"+filename+".xlsx",Query );
		
		recordset.next();
		lifeAssured = recordset.getField("lifeAssured");
		 
		if(ProductCode.equalsIgnoreCase("60200000")) {
			
			
			MainpremiumAmount35K = recordset.getField("MainpremiumAmount35K");
			partnerPremiumAmount15K = recordset.getField("partnerPremiumAmount15K");
			partnerPremiumAmount35K = recordset.getField("partnerPremiumAmount35K");
			ChildPremiumAmount7_5K = recordset.getField("ChildPremiumAmount7_5K");
			ParentPremiumAmount15K = recordset.getField("ParentPremiumAmount15K");	
			MainpremiumAmount15K = recordset.getField("MainpremiumAmount15K");
			
		}
		
		
		if(ProductCode.equalsIgnoreCase("60100000")) {
			
			MainpremiumAmount30K = recordset.getField("MainpremiumAmount30K");
			MainpremiumAmount40K = recordset.getField("MainpremiumAmount40K");
			partnerPremiumAmount40K = recordset.getField("partnerPremiumAmount40K");
			partnerPremiumAmount30K = recordset.getField("partnerPremiumAmount30K");
			
			
		} 
		
		
		MainpremiumAmount10K = recordset.getField("MainpremiumAmount10K");
		
		
		MainpremiumAmount20K = recordset.getField("MainpremiumAmount20K");
		
		MainpremiumAmount50K = recordset.getField("MainpremiumAmount50K");
		
		NonePayeable = recordset.getField("NonePayeable");
		
		partnerPremiumAmount10K = recordset.getField("partnerPremiumAmount10K");
		
		partnerPremiumAmount20K = recordset.getField("partnerPremiumAmount20K");
	
		partnerPremiumAmount50K = recordset.getField("partnerPremiumAmount50K");
		
		ChildPremiumAmount5K = recordset.getField("ChildPremiumAmount5K");
		
		ChildPremiumAmount10K = recordset.getField("ChildPremiumAmount10K");
		ChildPremiumAmount15K = recordset.getField("ChildPremiumAmount15K");
		ChildPremiumAmount20K = recordset.getField("ChildPremiumAmount20K");
		
		ParentPremiumAmount10K = recordset.getField("ParentPremiumAmount10K");
		ParentPremiumAmount20K = recordset.getField("ParentPremiumAmount20K");	
		
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
		MainpremiumAmount35K= recordset.getField("MainpremiumAmount35K");	
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
	
		
		partnerPremiumAmount35K	= recordset.getField("partnerPremiumAmount35K");
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
		
		if(!ProductCode.equals("1977")) {
			partnerPremiumAmount25K	= recordset.getField("partnerPremiumAmount25K");
			partnerPremiumAmount30K	= recordset.getField("partnerPremiumAmount30K");
			partnerPremiumAmount40K	= recordset.getField("partnerPremiumAmount40K");
			partnerPremiumAmount45K	= recordset.getField("partnerPremiumAmount45K");
			
			MainpremiumAmount25K= recordset.getField("MainpremiumAmount25K");	
			MainpremiumAmount30K= recordset.getField("MainpremiumAmount30K");
			MainpremiumAmount40K= recordset.getField("MainpremiumAmount40K");	
			MainpremiumAmount45K= recordset.getField("MainpremiumAmount45K");	
			
			ParentPremiumAmount25K	= recordset.getField("ParentPremiumAmount25K");
			ParentPremiumAmount30K	= recordset.getField("ParentPremiumAmount30K");
			ParentPremiumAmount40K	= recordset.getField("ParentPremiumAmount40K");
			ParentPremiumAmount45K	= recordset.getField("ParentPremiumAmount45K");
			
			ExtendedChildPremium5K	= recordset.getField("ExtendedChildPremium5K");
			ExtendedAdultPremium5K	= recordset.getField("ExtendedAdultPremium5K");
			ExtendedChildPremium10K	= recordset.getField("ExtendedChildPremium10K");
			ExtendedChildPremium15K	= recordset.getField("ExtendedChildPremium15K");
			ExtendedChildPremium20K	= recordset.getField("ExtendedChildPremium20K");
			ExtendedChildPremium25K	= recordset.getField("ExtendedChildPremium25K");
			ExtendedChildPremium30K	= recordset.getField("ExtendedChildPremium30K");
			
			ExtendedAdultPremium25K	= recordset.getField("ExtendedAdultPremium25K");
			ExtendedAdultPremium30K= recordset.getField("ExtendedAdultPremium30K");
			

			MainMemorialBenefit5K= recordset.getField("MainMemorialBenefit5K");
		    MainMonthlyAssistance0_5K= recordset.getField("MainMonthlyAssistance0_5K");
		    MainMonthlyAssistance1K= recordset.getField("MainMonthlyAssistance1K");
		    MainMonthlyAssistance1_5K= recordset.getField("MainMonthlyAssistance1_5K");
		    MainMonthlyAssistance2K= recordset.getField("MainMonthlyAssistance2K");
		    
		    partnerMemorialBenefit5K= recordset.getField("partnerMemorialBenefit5K");
		    partnerMonthlyBenefit5K= recordset.getField("partnerMonthlyBenefit5K");
		    
		   
		
			

			
		}
		
		if(ProductCode.equals("1977")) {
			
			MainMonthlyAssistance10K =  recordset.getField("MainMonthlyAssistance10K");
			MainMonthlyAssistance15K =  recordset.getField("MainMonthlyAssistance15K");
			MainMonthlyAssistance20K =  recordset.getField("MainMonthlyAssistance20K");
			MainMonthlyAssistance35K =  recordset.getField("MainMonthlyAssistance35K");
			MainMonthlyAssistance50K =  recordset.getField("MainMonthlyAssistance50K");
			MainMonthlyAssistance55K =  recordset.getField("MainMonthlyAssistance55K");
			MainMonthlyAssistance60K =  recordset.getField("MainMonthlyAssistance60K");
			MainMonthlyAssistance65K =  recordset.getField("MainMonthlyAssistance65K");
			MainMonthlyAssistance70K =  recordset.getField("MainMonthlyAssistance70K");
			MainMonthlyAssistance75K =  recordset.getField("MainMonthlyAssistance75K");
			
			MainHospitalBenefit10K  =  recordset.getField("MainHospitalBenefit10K");
			MainHospitalBenefit15K	 =  recordset.getField("MainHospitalBenefit15K");
			MainHospitalBenefit20K	 =  recordset.getField("MainHospitalBenefit20K");
			MainHospitalBenefit35K	 =  recordset.getField("MainHospitalBenefit35K");
			MainHospitalBenefit50K	 =  recordset.getField("MainHospitalBenefit50K");
			MainHospitalBenefit55K	 =  recordset.getField("MainHospitalBenefit55K");
			MainHospitalBenefit60K	 =  recordset.getField("MainHospitalBenefit60K");
			MainHospitalBenefit65K	 =  recordset.getField("MainHospitalBenefit65K");
			MainHospitalBenefit70K	 =  recordset.getField("MainHospitalBenefit70K");
			MainHospitalBenefit75K =  recordset.getField("MainHospitalBenefit75K");
			
			MainMemorialBenefit10K= recordset.getField("MainMemorialBenefit10K");
			MainMemorialBenefit15K= recordset.getField("MainMemorialBenefit15K");
			MainMemorialBenefit20K= recordset.getField("MainMemorialBenefit20K");
			MainMemorialBenefit35K= recordset.getField("MainMemorialBenefit35K");
			MainMemorialBenefit50K= recordset.getField("MainMemorialBenefit50K");
			MainMemorialBenefit55K= recordset.getField("MainMemorialBenefit55K");
			MainMemorialBenefit60K= recordset.getField("MainMemorialBenefit60K");
			MainMemorialBenefit65K= recordset.getField("MainMemorialBenefit65K");
			MainMemorialBenefit70K= recordset.getField("MainMemorialBenefit70K");
			MainMemorialBenefit75K= recordset.getField("MainMemorialBenefit75K");

			
			MainVehicleAccessBenefit4_5K = recordset.getField("MainVehicleAccessBenefit4_5K");
			MainVehicleAccessBenefit6K = recordset.getField("MainVehicleAccessBenefit6K");
			MainVehicleAccessBenefit10_5K = recordset.getField("MainVehicleAccessBenefit10_5K");
			MainVehicleAccessBenefit15K = recordset.getField("MainVehicleAccessBenefit15K");
			
			
			MainLifeCoverBenefit10K	= recordset.getField("MainLifeCoverBenefit10K");
			MainLifeCoverBenefit15K	= recordset.getField("MainLifeCoverBenefit15K");
			MainLifeCoverBenefit20K	= recordset.getField("MainLifeCoverBenefit20K");
			MainLifeCoverBenefit35K	= recordset.getField("MainLifeCoverBenefit35K");
			MainLifeCoverBenefit50K	= recordset.getField("MainLifeCoverBenefit50K");
			MainLifeCoverBenefit55K	= recordset.getField("MainLifeCoverBenefit55K");
			MainLifeCoverBenefit60K	= recordset.getField("MainLifeCoverBenefit60K");
			MainLifeCoverBenefit65K	= recordset.getField("MainLifeCoverBenefit65K");
			MainLifeCoverBenefit70K	= recordset.getField("MainLifeCoverBenefit70K");
			MainLifeCoverBenefit75K = recordset.getField("MainLifeCoverBenefit75K");
			
		
			ParentPremiumAmount50K= recordset.getField("ParentPremiumAmount50K");	
			ParentPremiumAmount55K= recordset.getField("ParentPremiumAmount55K");	
			ParentPremiumAmount60K= recordset.getField("ParentPremiumAmount60K");	
			ParentPremiumAmount65K= recordset.getField("ParentPremiumAmount65K");	
			ParentPremiumAmount70K= recordset.getField("ParentPremiumAmount70K");
			ParentPremiumAmount75K= recordset.getField("ParentPremiumAmount75K");
			
			ExtendedAdultPremium55K= recordset.getField("ExtendedAdultPremium55K");	
			ExtendedAdultPremium60K= recordset.getField("ExtendedAdultPremium60K");	
			ExtendedAdultPremium65K= recordset.getField("ExtendedAdultPremium65K");	
			ExtendedAdultPremium70K= recordset.getField("ExtendedAdultPremium70K");
			ExtendedAdultPremium75K= recordset.getField("ExtendedAdultPremium75K");
			

			ChildPremiumAmount55K= recordset.getField("ChildPremiumAmount55K");	
			ChildPremiumAmount60K= recordset.getField("ChildPremiumAmount60K");	
			ChildPremiumAmount65K= recordset.getField("ChildPremiumAmount65K");	
			ChildPremiumAmount70K= recordset.getField("ChildPremiumAmount70K");
			ChildPremiumAmount75K= recordset.getField("ChildPremiumAmount75K");
			
			    partnerMemorialBenefit10K = recordset.getField("partnerMemorialBenefit10K");
			    partnerMemorialBenefit15K= recordset.getField("partnerMemorialBenefit15K");
			    partnerMemorialBenefit20K= recordset.getField("partnerMemorialBenefit20K");
			    partnerMemorialBenefit35K= recordset.getField("partnerMemorialBenefit35K");
			    partnerMemorialBenefit50K= recordset.getField("partnerMemorialBenefit50K");
			    partnerMemorialBenefit55K= recordset.getField("partnerMemorialBenefit55K");
			    partnerMemorialBenefit60K= recordset.getField("partnerMemorialBenefit60K");
			    partnerMemorialBenefit65K= recordset.getField("partnerMemorialBenefit65K");
			    partnerMemorialBenefit70K= recordset.getField("partnerMemorialBenefit70K");
			    partnerMemorialBenefit75K= recordset.getField("partnerMemorialBenefit75K");
			    
			    partnerLifeCoverBenefit10K= recordset.getField("partnerLifeCoverBenefit10K");
			    partnerLifeCoverBenefit15K= recordset.getField("partnerLifeCoverBenefit15K");
			    partnerLifeCoverBenefit20K= recordset.getField("partnerLifeCoverBenefit20K");
			    partnerLifeCoverBenefit35K= recordset.getField("partnerLifeCoverBenefit35K");
			    partnerLifeCoverBenefit50K= recordset.getField("partnerLifeCoverBenefit50K");
			    partnerLifeCoverBenefit55K= recordset.getField("partnerLifeCoverBenefit55K");
			    partnerLifeCoverBenefit60K= recordset.getField("partnerLifeCoverBenefit60K");
			    partnerLifeCoverBenefit65K= recordset.getField("partnerLifeCoverBenefit65K");
			    partnerLifeCoverBenefit70K= recordset.getField("partnerLifeCoverBenefit70K");
			    partnerLifeCoverBenefit75K= recordset.getField("partnerLifeCoverBenefit75K");
			    
			    

			
		}
		
		ParentPremiumAmount10K	= recordset.getField("ParentPremiumAmount10K");
		ParentPremiumAmount15K	= recordset.getField("ParentPremiumAmount15K");
		ParentPremiumAmount20K	= recordset.getField("ParentPremiumAmount20K");
		ParentPremiumAmount35K	= recordset.getField("ParentPremiumAmount35K");
		ParentPremiumAmount50K	= recordset.getField("ParentPremiumAmount50K");
		
		ExtendedAdultPremium10K	= recordset.getField("ExtendedAdultPremium10K");
		ExtendedAdultPremium15K	= recordset.getField("ExtendedAdultPremium15K");
		ExtendedAdultPremium20K	= recordset.getField("ExtendedAdultPremium20K");
	
		
		MainMemorialBenefit10K= recordset.getField("MainMemorialBenefit10K");

	  
	  
	    
	    if(ProductCode.equals("1960E")||ProductCode.equals("1960C") ) {
	    	
	    	
	    	VehicleAccessBenefitS6= recordset.getField("VehicleAccessBenefitS6");
	  	    VehicleAccessBenefitL6= recordset.getField("VehicleAccessBenefitL6");
	  	    
	  	  if(ProductCode.equals("1960E") ) {
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
	  	  }
	   
	    partnerMemorialBenefit10K= recordset.getField("partnerMemorialBenefit10K");

	    partnerMonthlyBenefit1K= recordset.getField("partnerMonthlyBenefit10K");
		statusCode = recordset.getField("statusCode");		
		NonePayeable = recordset.getField("NonePayeable");
	}
	
	
	
	
}
