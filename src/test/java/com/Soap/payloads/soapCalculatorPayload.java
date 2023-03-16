package com.Soap.payloads;

public class soapCalculatorPayload {

	public soapCalculatorPayload() {
		// TODO Auto-generated constructor stub
	}
	
public static String CalcAdd()

{
	
	return  "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
			+ "   <soapenv:Header/>\n"
			+ "   <soapenv:Body>\n"
			+ "      <tem:Add>\n"
			+ "         <tem:intA>9</tem:intA>\n"
			+ "         <tem:intB>9</tem:intB>\n"
			+ "      </tem:Add>\n"
			+ "   </soapenv:Body>\n"
			+ "</soapenv:Envelope>";
	
}

}
