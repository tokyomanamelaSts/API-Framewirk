package com.exergyRestApi.Product;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

public class TC_002_60200000 {

	public static void Tc_002_60200000(ExtentReports extent) throws IOException, SAXException, ParserConfigurationException {
		
		
		
        String productSitUrl = DataProvider.GetPropVal(DataProvider.propertyFilePath, "productSitUrl");
		
		String productSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubId");

		String productSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "SubKey");
		
		
		ExtentTest test;
		test=extent.createTest("TC_002_60200000");
		Response response;
		response =  ApiHelper.sendRestGetRequest(productSitUrl,productSubKey,productSubId, "/Products?productType=NonUnderwritten&productCode=60200000");
		response.prettyPrint();
		
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
		
		
        if(response.statusCode() == 200 ) {
			
			JSONArray innerJson = new JSONArray(response.getBody().asString());
		
			
			test.info("productCode");
			String productCode = innerJson.getJSONObject(0).get("productCode").toString();
			ApiHelper.AssertEquals("productCode" ,"60200000", productCode, test);
			test.info("productName");
			String productName = innerJson.getJSONObject(0).get("productName").toString();
			ApiHelper.AssertEquals("productName" ,"Tyme Bank Funeral", productName, test);
			
			test.info("productRules");
			String debit = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("premiumCollectionMethodsAllowed").get(0).toString();
			ApiHelper.AssertEquals("premium Collection Method Debit Order" ,"DebitOrder", debit, test);
			
			
			String beneficiary = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(0).toString();
			ApiHelper.AssertEquals(" Beneficiary Role Player" ,"Beneficiary", beneficiary, test);
			
			String policyPayer = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(1).toString();
			ApiHelper.AssertEquals("Policy payer Role Player" ,"PolicyPayer", policyPayer, test);
			
			String policyHolder = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").get(2).toString();
			ApiHelper.AssertEquals("Policy holder Role Player" ,"PolicyHolder", policyHolder, test);
			
			test.info("Beneficiary role");
			
			String rules = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("rolePlayerType").toString();
			ApiHelper.AssertEquals("role Player Type" ,"Beneficiary", rules, test);
			
			String MinAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("minAge").toString();
			ApiHelper.AssertEquals("minimum Age" ,"18.0", MinAge, test);
			
			String MaxAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("maxAge").toString();
			ApiHelper.AssertEquals("Maximum Age" ,"99.0", MaxAge, test);
			
			String MinAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum Allowed" ,"1", MinAllowed, test);
			
			String MaxAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("maxAllowed").toString();
			ApiHelper.AssertEquals("Maximum Allowed" ,"1", MaxAllowed, test);
			
			
			test.info("Policy payer role");
			
			String rules2 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("rolePlayerType").toString();
			ApiHelper.AssertEquals("role Player Type" ,"PolicyPayer", rules2, test);
			
			String MinAge2 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAge").toString();
			ApiHelper.AssertEquals("minimum Age" ,"18.0", MinAge2, test);
			
			String MaxAge2 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAge").toString();
			ApiHelper.AssertEquals("Maximum Age" ,"79.0", MaxAge2, test);
			
			String MinAllowed2 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum Allowed" ,"1", MinAllowed2, test);
			
			String MaxAllowed2 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAllowed").toString();
			ApiHelper.AssertEquals("Maximum Allowed" ,"1", MaxAllowed2, test);
			
			
            test.info("Policy holder role");
			
			String rules3 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("rolePlayerType").toString();
			ApiHelper.AssertEquals("role Player Type" ,"PolicyPayer", rules3, test);
			
			String MinAge3 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAge").toString();
			ApiHelper.AssertEquals("minimum Age" ,"18.0", MinAge3, test);
			
			String MaxAge3 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAge").toString();
			ApiHelper.AssertEquals("Maximum Age" ,"79.0", MaxAge3, test);
			
			String MinAllowed3 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum Allowed" ,"1", MinAllowed3, test);
			
			String MaxAllowed3 = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAllowed").toString();
			ApiHelper.AssertEquals("Maximum Allowed" ,"1", MaxAllowed3, test);
			
			test.info("Funeral Benefits");
			
			String benefitName = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).get("benefitName").toString();
			ApiHelper.AssertEquals("benefit Name" ,"Funeral Benefit", benefitName, test);
			
			String MinCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
			ApiHelper.AssertEquals("minimum Cover Allowed" ,"10000", MinCoverAllowed, test);
			
			String MaxCoverAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
			ApiHelper.AssertEquals("maximum Cover Allowed" ,"50000", MaxCoverAllowed, test);
			
			String MinBenAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum benefits Allowed" ,"1", MinBenAllowed, test);
			
			
			String MaxBenAllowed = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
			ApiHelper.AssertEquals("maximum benefits Allowed" ,"1", MaxBenAllowed, test);
			
            
			test.info("Grocery Benefit");
			
			String benefitName2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).get("benefitName").toString();
			ApiHelper.AssertEquals("benefit Name" ,"Grocery Benefit", benefitName2, test);
			
			String MinCoverAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
			ApiHelper.AssertEquals("minimum Cover Allowed" ,"0", MinCoverAllowed2, test);
			
			String MaxCoverAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
			ApiHelper.AssertEquals("maximum Cover Allowed" ,"0", MaxCoverAllowed2, test);
			
			String MinBenAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum benefits Allowed" ,"1", MinBenAllowed2, test);
			
			
			String MaxBenAllowed2 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
			ApiHelper.AssertEquals("maximum benefits Allowed" ,"1", MaxBenAllowed2, test);
			
			
            test.info("Monthly Assistance Benefit");
			
			String benefitName3 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).get("benefitName").toString();
			ApiHelper.AssertEquals("benefit Name" ,"Monthly Assistance Benefit", benefitName3, test);
			
			String MinCoverAllowed3 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
			ApiHelper.AssertEquals("minimum Cover Allowed" ,"0", MinCoverAllowed3, test);
			
			String MaxCoverAllowed3 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
			ApiHelper.AssertEquals("maximum Cover Allowed" ,"0", MaxCoverAllowed3, test);
			
			String MinBenAllowed3 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum benefits Allowed" ,"1", MinBenAllowed3, test);
			
			
			String MaxBenAllowed3 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
			ApiHelper.AssertEquals("maximum benefits Allowed" ,"1", MaxBenAllowed3, test);
			
			
            test.info("Airtime Benefit");
			
			String benefitName5 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).get("benefitName").toString();
			ApiHelper.AssertEquals("benefit Name" ,"Airtime Benefit", benefitName5, test);
			
			String MinCoverAllowed5 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
			ApiHelper.AssertEquals("minimum Cover Allowed" ,"0", MinCoverAllowed5, test);
			
			String MaxCoverAllowed5 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
			ApiHelper.AssertEquals("maximum Cover Allowed" ,"0", MaxCoverAllowed5, test);
			
			String MinBenAllowed5 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
			ApiHelper.AssertEquals("minimum benefits Allowed" ,"1", MinBenAllowed5, test);
			
			
			String MaxBenAllowed5 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
			ApiHelper.AssertEquals("maximum benefits Allowed" ,"1", MaxBenAllowed5, test);
			
		
	}
        
        test.info( "Product code used: 60200000");
		
		test.info( "Find response below");
		test.info( MarkupHelper.createCodeBlock(response.asString(),CodeLanguage.JSON));
		

}
	
}
