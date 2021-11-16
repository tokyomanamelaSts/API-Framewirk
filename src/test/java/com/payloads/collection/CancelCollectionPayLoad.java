package com.payloads.collection;

public class CancelCollectionPayLoad {

	public static String cancelCollectionPayLoad() {

		return "{\n"
				+ "  \"policyNumber\": \"50000043\",\n"
				+ "  \"collectionReference\": \"ref123\",\n"
				+ "  \"channel\": {\n"
				+ "    \"tillNumber\": \"till\",\n"
				+ "    \"serialNumber\": \"serial\",\n"
				+ "    \"transactionIdentity\": \"transid\",\n"
				+ "    \"messageIdentity\": \"id\",\n"
				+ "    \"networkTransactionIdentity\": \"network\",\n"
				+ "    \"vendorType\": {\n"
				+ "      \"paymentSources\": \"PayAt\"\n"
				+ "    },\n"
				+ "    \"channelType\": \"TillPoint\",\n"
				+ "    \"channelLocation\": \"location\",\n"
				+ "    \"channelReference\": \"reference\"\n"
				+ "  },\n"
				+ "  \"amount\": 319,\n"
				+ "  \"status\": \"None\",\n"
				+ "  \"message\": \"message\"\n"
				+ "}";

}
}
