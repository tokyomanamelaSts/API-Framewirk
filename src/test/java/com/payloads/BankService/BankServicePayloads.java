package com.payloads.BankService;

public class BankServicePayloads {

	
	public static final String CancelAuthenticatedCollectionPayload = 
			"{\n"
			+ "    \"cancelAuthenticatedCollection\": {\n"
			+ "        \"authenticatedCollectionId\": \"sample\",\n"
			+ "        \"authenticatedCollectionCancellationReason\": \"sample\"\n"
			+ "    }\n"
			+ "} ";
	
	
	public static final String CreateAuthenticatedCollectionPayload =
			"{\n"
			+ "    \"createAuthenticatedCollection\": {\n"
			+ "        \"authenticatedCollection\": {\n"
			+ "            \"authenticatedCollectionId\": \"1\",\n"
			+ "            \"instructingPartyBankCode\": \"sample\",\n"
			+ "            \"instructedPartyBankCode\": \"sample\",\n"
			+ "            \"clientReference\": \"sample\",\n"
			+ "            \"creditorContractNumber\": \"sample\",\n"
			+ "            \"creditorName\": \"sample\",\n"
			+ "            \"creditorTelephoneNumber\": \"sample\",\n"
			+ "            \"creditorEmailAddress\": \"sample\",\n"
			+ "            \"creditorBankBranchNumber\": \"sample\",\n"
			+ "            \"creditorBankAccountNumber\": \"sample\",\n"
			+ "            \"ultimateCreditorName\": \"sample\",\n"
			+ "            \"creditorAbbreviatedShortName\": \"sample\",\n"
			+ "            \"debtorAuthenticationType\": \"sample\",\n"
			+ "            \"debtorName\": \"sample\",\n"
			+ "            \"debtorBankAccountNumber\": \"sample\",\n"
			+ "            \"debtorBankAccountType\": \"sample\",\n"
			+ "            \"debtorBankBranchNumber\": \"sample\",\n"
			+ "            \"debitType\": \"sample\",\n"
			+ "            \"instalmentOccurence\": \"sample\",\n"
			+ "            \"instalmentFrequency\": \"sample\",\n"
			+ "            \"firstCollectionDate\": {},\n"
			+ "            \"collectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"maxCollectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"creditorSchemeName\": \"sample\",\n"
			+ "            \"debtorIdentity\": {\n"
			+ "                \"identityType\": \"sample\",\n"
			+ "                \"identityNumber\": \"sample\"\n"
			+ "            },\n"
			+ "            \"debtorTelephoneNumber\": \"sample\",\n"
			+ "            \"ultimateDebtorName\": \"sample\",\n"
			+ "            \"collectionDay\": \"sample\",\n"
			+ "            \"collectionDayAdjustable\": false,\n"
			+ "            \"collectionAmountAdjustment\": {\n"
			+ "                \"collectionAmountAdjustmentType\": \"sample\"\n"
			+ "            },\n"
			+ "            \"firstCollectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"authenticatedCollectionStatus\": \"sample\",\n"
			+ "            \"employeeNumber\": \"sample\",\n"
			+ "            \"authenticatedToken\": \"sample\"\n"
			+ "        }\n"
			+ "    }\n"
			+ "} ";
	
	public static final String  QueryAuthenticatedCollectionPayload= 
			"{\n"
			+ "    \"queryAuthenticatedCollection\": {\n"
			+ "        \"criteria\": {\n"
			+ "            \"initiationDateFrom\": {},\n"
			+ "            \"initiationDateTo\": {},\n"
			+ "            \"ultimateCreditorName\": \"sample\",\n"
			+ "            \"debtorBankAccountNumber\": \"sample\",\n"
			+ "            \"creditorContractNumber\": \"sample\"\n"
			+ "        },\n"
			+ "        \"sortOrder\": \"sample\",\n"
			+ "        \"maximumRecordCount\": 1.0\n"
			+ "    }\n"
			+ "}";
	
	public static final String QueryBankPayload = 
			"{\n"
			+ "    \"queryBankResponse\": {\n"
			+ "        \"bankList\": [{\n"
			+ "            \"bankCode\": \"210063\",\n"
			+ "            \"bankName\": \"Discovery Bank Ltd\",\n"
			+ "            \"universalBranchCode\": \"679000\"\n"
			+ "        }]\n"
			+ "    }\n"
			+ "}";
	
	public static final String QueryBankByNamePayload =
			"{\n"
			+ "    \"queryBankByName\": {\n"
			+ "        \"bankName\": \"African Bank\"\n"
			+ "    }\n"
			+ "}";
	
	public static final String QueryBranchByBankCodePayload = 
	
			"{\n"
			+ "    \"queryBranchByBankCode\": {\n"
			+ "        \"bankCode\": \"210044\"\n"
			+ "    }\n"
			+ "}";
	
	public static final String QueryBranchByNamePayload = 
			"{\n"
			+ "    \"queryBranchByName\": {\n"
			+ "        \"bankCode\": \"210013\",\n"
			+ "        \"branchName\": \"SA Post Bank\"\n"
			+ "    }\n"
			+ "}";
			
	public static final String RetrieveAuthenticatedCollectionPayload = 
			"{\n"
			+ "    \"retrieveAuthenticatedCollection\": {\n"
			+ "        \"authenticatedCollectionId\": \"sample\"\n"
			+ "    }\n"
			+ "}";
	public static final String RetrieveBankPayload = 
			"{\n"
			+ "    \"retrieveBank\": {\n"
			+ "        \"bankCode\": \"210061\"\n"
			+ "    }\n"
			+ "}";
	public static final String RetrieveBranchPayload = 
			"{\n"
			+ "    \"retrieveBranch\": {\n"
			+ "        \"branchCode\": \"198765\"\n"
			+ "    }\n"
			+ "}";
	public static final String RetrieveVerificationPayload = 
			"{\n"
			+ "    \"retrieveVerification\": {\n"
			+ "        \"verificationId\": \"sample\"\n"
			+ "    }\n"
			+ "}";  
			
	public static final String UpdateAuthenticatedCollectionPayload = 
			"{\n"
			+ "    \"updateAuthenticatedCollection\": {\n"
			+ "        \"authenticatedCollection\": {\n"
			+ "            \"authenticatedCollectionId\": \"sample\",\n"
			+ "            \"instructingPartyBankCode\": \"sample\",\n"
			+ "            \"instructedPartyBankCode\": \"sample\",\n"
			+ "            \"clientReference\": \"sample\",\n"
			+ "            \"creditorContractNumber\": \"sample\",\n"
			+ "            \"creditorName\": \"sample\",\n"
			+ "            \"creditorTelephoneNumber\": \"sample\",\n"
			+ "            \"creditorEmailAddress\": \"sample\",\n"
			+ "            \"creditorBankBranchNumber\": \"sample\",\n"
			+ "            \"creditorBankAccountNumber\": \"sample\",\n"
			+ "            \"ultimateCreditorName\": \"sample\",\n"
			+ "            \"creditorAbbreviatedShortName\": \"sample\",\n"
			+ "            \"debtorAuthenticationType\": \"sample\",\n"
			+ "            \"debtorName\": \"sample\",\n"
			+ "            \"debtorBankAccountNumber\": \"sample\",\n"
			+ "            \"debtorBankAccountType\": \"sample\",\n"
			+ "            \"debtorBankBranchNumber\": \"sample\",\n"
			+ "            \"debitType\": \"sample\",\n"
			+ "            \"instalmentOccurence\": \"sample\",\n"
			+ "            \"instalmentFrequency\": \"sample\",\n"
			+ "            \"firstCollectionDate\": {},\n"
			+ "            \"collectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"maxCollectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"creditorSchemeName\": \"sample\",\n"
			+ "            \"debtorIdentity\": {\n"
			+ "                \"identityType\": \"sample\",\n"
			+ "                \"identityNumber\": \"sample\"\n"
			+ "            },\n"
			+ "            \"debtorTelephoneNumber\": \"sample\",\n"
			+ "            \"ultimateDebtorName\": \"sample\",\n"
			+ "            \"collectionDay\": \"sample\",\n"
			+ "            \"collectionDayAdjustable\": false,\n"
			+ "            \"collectionAmountAdjustment\": {\n"
			+ "                \"collectionAmountAdjustmentType\": \"sample\"\n"
			+ "            },\n"
			+ "            \"firstCollectionDetail\": {\n"
			+ "                \"currency\": \"sample\",\n"
			+ "                \"collectionAmount\": 1.0\n"
			+ "            },\n"
			+ "            \"authenticatedCollectionStatus\": \"sample\",\n"
			+ "            \"employeeNumber\": \"sample\",\n"
			+ "            \"authenticatedToken\": \"sample\"\n"
			+ "        },\n"
			+ "        \"authenticatedCollectionUpdateReason\": \"sample\"\n"
			+ "    }\n"
			+ "}";    
			
			
	public static final String ValidateBankAccountPayload = 
			"{\n"
			+ "    \"validateBankAccount\": {\n"
			+ "        \"validateBankAccountCriteria\": {\n"
			+ "            \"bankAccountType\": \"Savings\",\n"
			+ "            \"branchCode\": \"210019\",\n"
			+ "            \"accountNumber\": \"1126715573\"\n"
			+ "        }\n"
			+ "    }\n"
			+ "}";   
			
	public static final String ValidateCreditCardPayload = 
			"{\n"
			+ "    \"validateCreditCard\": {\n"
			+ "        \"creditCardNumber\": \"5555341244441115\"\n"
			+ "    }\n"
			+ "}";  
			
	public static final String VerifyBankAccountPayload = 
			"{\n"
			+ "    \"verifyBankAccount\": {\n"
			+ "        \"verifyBankAccountCriteria\": {\n"
			+ "            \"verificationId\": \"sample\",\n"
			+ "            \"retrieveFromCacheDuration\": {},\n"
			+ "            \"bankAccountType\": \"sample\",\n"
			+ "            \"branchCode\": \"sample\",\n"
			+ "            \"accountNumber\": \"sample\",\n"
			+ "            \"accountHolder\": {\n"
			+ "                \"taxReference\": \"sample\"\n"
			+ "            },\n"
			+ "            \"reference\": \"sample\"\n"
			+ "        }\n"
			+ "    }\n"
			+ "}";
	
	
}
