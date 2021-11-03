package com.payloads.collection;

public class CancelCollectionPayLoad {

	public static String cancelCollectionPayLoad() {

		return "{\r\n" + 
				"  \"policyNumber\": \"50000043\",\r\n" + 
				"  \"collectionReference\": \"ref123\",\r\n" + 
				"  \"channel\": {\r\n" + 
				"    \"tillNumber\": \"till\",\r\n" + 
				"    \"serialNumber\": \"serial\",\r\n" + 
				"    \"transactionIdentity\": \"transid\",\r\n" + 
				"    \"messageIdentity\": \"id\",\r\n" + 
				"    \"networkTransactionIdentity\": \"network\",\r\n" + 
				"    \"vendorType\": {\r\n" + 
				"      \"paymentSources\": \"PayAt\"\r\n" + 
				"    },\r\n" + 
				"    \"channelType\": \"TillPoint\",\r\n" + 
				"    \"channelLocation\": \"location\",\r\n" + 
				"    \"channelReference\": \"reference\"\r\n" + 
				"  },\r\n" + 
				"  \"amount\": 319,\r\n" + 
				"  \"status\": \"None\",\r\n" + 
				"  \"message\": \"message\"\r\n" + 
				"}";

}
}
