package com.exergyRestApi.Product;

import java.io.IOException;
import com.applicationPayloads.CreateApplicationPayloads;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.ApiHelper;
import Utilities.DataProvider;
import io.restassured.response.Response;

import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.xml.sax.SAXException;


public class TC_007_1924 {
	
	public static void  Tc_007_1924(ExtentReports extent) throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
		
		
		
	    String ProductURL = DataProvider.GetPropVal(DataProvider.propertyFilePath, "ProductURL");
		
		String ProductSubId = DataProvider.GetPropVal(DataProvider.propertyFilePath, "ProductSubID");

		String ProductSubKey = DataProvider.GetPropVal(DataProvider.propertyFilePath, "policySubKey");
		
		
		
		ExtentTest test;
		test=extent.createTest("TC_007_1924");
		Response response;
		response =  ApiHelper.sendRestGetRequest(ProductURL,ProductSubKey,ProductSubId,"/Products?productType=FullyUnderwritten&productCode=1960L");
		response.prettyPrint();
		ApiHelper.AssertEquals("Status code" ,"200", String.valueOf(response.statusCode()) , test);
		
			if(response.statusCode() == 200 ) {
		
			JSONArray innerJson = new JSONArray (response.getBody().asString());
			
				test.info("productCode");
				String productCode = innerJson.getJSONObject(0).get("productCode").toString();
				ApiHelper.AssertEquals("productCode" ,"1960L", productCode, test);
				System.out.println(productCode);
				
				test.info("productName");
				String productName = innerJson.getJSONObject(0).get("productName").toString();
				ApiHelper.AssertEquals("productName" ,"Lite V6.0", productName, test);
				
				test.info("premiumCollectionMethodsAllowed");
				String premiumCollectionMethodsAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("premiumCollectionMethodsAllowed").toString();
				ApiHelper.AssertEquals("premiumCollectionMethodsAllowed" ,"[\"DebitOrder\","+"\"Cash\"]", premiumCollectionMethodsAllowed, test);
				
				test.info("allowedRolePlayers");
				String allowedRolePlayers = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("allowedRolePlayers").toString();
				ApiHelper.AssertEquals("allowedRolePlayers" ,"[\"Beneficiary\","+"\"PolicyPayer\","+ "\"PolicyHolder\"]", allowedRolePlayers, test);
			
				test.info("rolePlayerBeneficiary");
				String BeneficiaryMinAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("minAge").toString();
				ApiHelper.AssertEquals("minAge" ,"18.0", BeneficiaryMinAge, test);
				
				String BeneficiaryMaxAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("maxAge").toString();
				ApiHelper.AssertEquals("maxAge" ,"99.0", BeneficiaryMaxAge, test);
			
				String BeneficiaryMinAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("minAllowed" ,"1", BeneficiaryMinAllowed, test);
		
				String BeneficiaryMaxAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("maxAllowed" ,"1", BeneficiaryMaxAllowed, test);
				
		
				test.info("rolePlayerPolicyPayer");
				String PPminAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAge").toString();
				ApiHelper.AssertEquals("minAge" ,"18.0", PPminAge, test);
				
				String PPmaxAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAge").toString();
				ApiHelper.AssertEquals("maxAge" ,"79.0", PPmaxAge, test);
			
				String PPminAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("minAllowed").toString();
				ApiHelper.AssertEquals("minAllowed" ,"1", PPminAllowed, test);
		
				String PPmaxAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(1).get("maxAllowed").toString();
				ApiHelper.AssertEquals("maxAllowed" ,"1", PPmaxAllowed, test);
				
				test.info("rolePlayerPolicyHolder");
				String PHminAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(2).get("minAge").toString();
				ApiHelper.AssertEquals("minAge" ,"18.0", PHminAge, test);
				
				String PHmaxAge = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(2).get("maxAge").toString();
				ApiHelper.AssertEquals("maxAge" ,"79.0", PPmaxAge, test);
			
				String PHminAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(2).get("minAllowed").toString();
				ApiHelper.AssertEquals("minAllowed" ,"1", PHminAllowed, test);
		
				String PHmaxAllowed = innerJson.getJSONObject(0).getJSONObject("productRules").getJSONArray("rolePlayerRules").getJSONObject(2).get("maxAllowed").toString();
				ApiHelper.AssertEquals("maxAllowed" ,"1", PHmaxAllowed, test);
		
				
				
				test.info("Benefit: 1100");
				String MinCoverAllowed1100 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1100" ,"10000", MinCoverAllowed1100, test);
				
				String MaxCoverAllowed1100 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1100" ,"75000", MaxCoverAllowed1100, test);
				
				String MinAllowed1100 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1100" ,"1", MinAllowed1100, test);
			
				
				String MaxAllowed1100 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(0).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1100" ,"1", MaxAllowed1100, test);
				
				test.info("Benefit: 1160");
				String MinCoverAllowed1160 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1160" ,"10000", MinCoverAllowed1160, test);
				
				String MaxCoverAllowed1160 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1160" ,"75000", MaxCoverAllowed1160, test);
				
				String MinAllowed1160 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1160" ,"0", MinAllowed1160, test);
			
				
				String MaxAllowed1160 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(1).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1160" ,"1", MaxAllowed1160, test);
				
				test.info("Benefit: 1150");
				String MinCoverAllowed1150 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1150" ,"10000", MinCoverAllowed1150, test);
				
				String MaxCoverAllowed1150 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1150" ,"50000", MaxCoverAllowed1150, test);
				
				String MinAllowed1150 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1150" ,"0", MinAllowed1150, test);
			
				
				String MaxAllowed1150 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(2).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1150" ,"10", MaxAllowed1150, test);
		

				test.info("Benefit: 1140");
				String MinCoverAllowed1140 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1140" ,"5000", MinCoverAllowed1140, test);
				
				String MaxCoverAllowed1140 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1140" ,"30000", MaxCoverAllowed1140, test);
				
				String MinAllowed1140 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1140" ,"0", MinAllowed1140, test);
			
				
				String MaxAllowed1140 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(3).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1140" ,"2", MaxAllowed1140, test);
		
				test.info("Benefit: Extended Family Child");
				String MinCoverAllowed1170 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(4).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1170" ,"5000", MinCoverAllowed1170, test);
				
				String MaxCoverAllowed1170 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(4).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1170" ,"30000", MaxCoverAllowed1170, test);
				
				String MinAllowed1770 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(4).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1170" ,"0", MinAllowed1770, test);
			
				
				String MaxAllowed1170 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(4).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1170" ,"2", MaxAllowed1170, test);
				
				test.info("Benefit: 1130 ");
				String MinCoverAllowed1130 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(5).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1130" ,"10000", MinCoverAllowed1130, test);
				
				String MaxCoverAllowed1130 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(5).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1130" ,"50000", MaxCoverAllowed1130, test);
				
				String MinAllowed1130 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(5).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1130", "0", MinAllowed1130, test);
			
				
				String MaxAllowed1130 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(5).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1130" ,"4", MaxAllowed1130, test);
				
				test.info("Benefit: 1900 ");
				String MinCoverAllowed1900 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(6).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1900" ,"5000", MinCoverAllowed1900, test);
				
				String MaxCoverAllowed1900 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(6).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1900" ,"10000", MaxCoverAllowed1900, test);
				
				String MinAllowed1900 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(6).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1900", "0", MinAllowed1900, test);
			
				
				String MaxAllowed1900 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(6).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1900" ,"2", MaxAllowed1900, test);
		
				test.info("Benefit: 1910 ");
				String MinCoverAllowed1910 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(7).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1910" ,"5000", MinCoverAllowed1910, test);
				
				String MaxCoverAllowed1910 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(7).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1910" ,"10000", MaxCoverAllowed1910, test);
				
				String MinAllowed1910 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(7).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1910", "0", MinAllowed1910, test);
			
				
				String MaxAllowed1910 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(7).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1910" ,"2", MaxAllowed1910, test);
				
				test.info("Benefit: 0016 ");
				String MinCoverAllowed0016 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(8).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed0016" ,"0", MinCoverAllowed0016, test);
				
				String MaxCoverAllowed0016 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(8).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed0016" ,"0", MaxCoverAllowed0016, test);
				
				String MinAllowed0016 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(8).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed0016", "1", MinAllowed0016, test);
			
				
				String MaxAllowed0016 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(8).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed0016" ,"1", MaxAllowed0016, test);
				
				test.info("Benefit: 0024 ");
				String MinCoverAllowed0024 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(9).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed0024" ,"0", MinCoverAllowed0024, test);
				
				String MaxCoverAllowed0024 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(9).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed0024" ,"0", MaxCoverAllowed0024, test);
				
				String MinAllowed0024 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(9).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed0024", "1", MinAllowed0024, test);
			
				
				String MaxAllowed0024 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(9).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed0024" ,"1", MaxAllowed0024, test);
				
				test.info("Benefit: 1120 ");
				String MinCoverAllowed1120 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(10).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minCoverAllowed").toString();
				ApiHelper.AssertEquals("MinCoverAllowed1120" ,"0", MinCoverAllowed1120, test);
				
				String MaxCoverAllowed1120 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(10).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxCoverAllowed").toString();
				ApiHelper.AssertEquals("MaxCoverAllowed1120" ,"0", MaxCoverAllowed1120, test);
				
				String MinAllowed1120 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(10).getJSONArray("allowedLifesAssured").getJSONObject(0).get("minAllowed").toString();
				ApiHelper.AssertEquals("MinAllowed1120", "1", MinAllowed1120, test);
			
				
				String MaxAllowed1120 = innerJson.getJSONObject(0).getJSONArray("benefits").getJSONObject(10).getJSONArray("allowedLifesAssured").getJSONObject(0).get("maxAllowed").toString();
				ApiHelper.AssertEquals("MaxAllowed1120" ,"1", MaxAllowed1120, test);
				
		

		
		
		}


}
	
}
