package com.mvc_phone.vaadin_archetype_application;

//commenting to attempt a staged change

public class PhoneNumber {

	private String countryCode = "";
	private String areaCode = "";
	private String prefixCode = "";
	private String lineNumber = "";

	//default constructor, use for 11 digits entered
	PhoneNumber() {

	}
	
	//constructor for 10 digits
	PhoneNumber(String countryCode) {
		this.countryCode = countryCode;
	}
	
	//use for 7 digits entered
	PhoneNumber(String countryCode, String areaCode) {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	public void appendCountryCode(String a) {

		countryCode += a;
	}
	
	public void snipCountryCode() {
		countryCode = countryCode.substring(0, countryCode.length() - 1);
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode)
	{
		this.areaCode = areaCode;
	}	
	
	public void appendAreaCode(String b) {
		areaCode += b;
	}

	public void snipAreaCode() {
		areaCode = areaCode.substring(0, areaCode.length() - 1);
	}	
	
	public String getPrefixCode() {
		return prefixCode;
	}

	public void setPrefixCode(String prefixCode)
	{
		this.prefixCode = prefixCode;
	}	
	
	public void appendPrefixCode(String c) {
		prefixCode += c;
	}

	public void snipPrefixCode() {
		prefixCode = prefixCode.substring(0, prefixCode.length() - 1);
	}
	
	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber)
	{
		this.lineNumber = lineNumber;
	}	
	
	public void appendLineNumber(String d) {
		lineNumber += d;
	}
	
	public void snipLineNumber() {
		lineNumber = lineNumber.substring(0, lineNumber.length() - 1);
	}
	
	//call when adding on to the phone string
	/*
	public void append(String tempStr) {
		
		if (getCountryCode().length() != 1)
		{
			appendCountryCode(tempStr);
		}
		else if (getAreaCode().length() != 3)
		{
			appendAreaCode(tempStr);
		}
		else if (getPrefixCode().length() != 3)
		{
			appendPrefixCode(tempStr);
		}
		else if (getLineNumber().length() != 4)
		{
			appendLineNumber(tempStr);
		}	
		
	}
	*/
	
	//call when deleting phone string... will be called on by delete button
	/*
	public void snip() {
		
		if (getLineNumber().length() != 0)
		{
			snipLineNumber();
		}
		else if (getPrefixCode().length() != 0)
		{
			snipPrefixCode();
		}
		else if (getAreaCode().length() != 0)
		{
			snipAreaCode();		
		}
		else if (getCountryCode().length() != 0)
		{
			snipCountryCode();
		}		
	}
	*/
	
	public String getFullPhoneNumber() {
		return countryCode + areaCode + prefixCode + lineNumber;
	}
	
	
	
}
