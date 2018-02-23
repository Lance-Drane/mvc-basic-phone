package com.mvc_phone.vaadin_archetype_application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {
	
	PhoneNumber phoneNum = new PhoneNumber();
	PhoneNumber phoneNumWithAreaCode = new PhoneNumber("7");
	PhoneNumber phoneNumWithCountryCode = new PhoneNumber("5", "423");
	
	//MyUI myUI = new MyUI();
	
	//Model model = new Model();
	//Controller controller = new Controller(model);
	Controller controller = new Controller();
	MyUI myUI = new MyUI();
	
	@Test
	void test() {
		//phoneNumTest();
		MyUITest();
	}
	
	public void phoneNumTest() {
		//no arguments: 7 digits entered (least reasonable # to enter)
		//PhoneNumber phoneNum = new PhoneNumber();
		assertEquals("", phoneNum.getCountryCode());
		assertEquals("", phoneNum.getAreaCode());
		
		//one argument: area code entered, but not country code
		//PhoneNumber phoneNumWithAreaCode = new PhoneNumber("727");
		assertEquals("7", phoneNumWithAreaCode.getCountryCode());
		assertEquals("", phoneNumWithAreaCode.getAreaCode());
		
		//two arguments: area code and country code entered
		//PhoneNumber phoneNumWithCountryCode = new PhoneNumber("5", "423");
		assertEquals("5", phoneNumWithCountryCode.getCountryCode());
		assertEquals("423", phoneNumWithCountryCode.getAreaCode());
		
		Random randomInt = new Random();
		
		//no arguments provided
		String ref = "";
		for (int i = 0; i < 11; i++)
		{
			int temp = randomInt.nextInt(10);
			String tempStr = Integer.toString(temp);
			ref += tempStr;//modify variable exclusive to PhoneTest
			controller.append(tempStr); //call PhoneNumber class to modify its own variable, then get the variable					
		}
		assertEquals(1, phoneNum.getCountryCode().length());
		assertEquals(3, phoneNum.getAreaCode().length());
		assertEquals(3, phoneNum.getPrefixCode().length());
		assertEquals(4, phoneNum.getLineNumber().length());
		assertEquals(ref, phoneNum.getFullPhoneNumber());
		
		//one argument provided
		if (phoneNumWithAreaCode.getAreaCode().length() == 3)
		{
			String refArea = "7";
			System.out.println(phoneNumWithAreaCode.getFullPhoneNumber());
			for (int i = 0; i < 10; i++)
			{
				int temp = randomInt.nextInt(10);
				String tempStr = Integer.toString(temp);
				System.out.println("tempStr" + i + " " + tempStr);
				refArea += tempStr;//modify variable exclusive to PhoneTes
				System.out.println("refArea" + i + " " + refArea);
				controller.append(tempStr); //call PhoneNumber class to modify its own variable, then get the variable
				System.out.println(phoneNumWithAreaCode.getFullPhoneNumber());
			}
			assertEquals(1, phoneNumWithAreaCode.getCountryCode().length());
			assertEquals(3, phoneNumWithAreaCode.getAreaCode().length());
			assertEquals(3, phoneNumWithAreaCode.getPrefixCode().length());
			assertEquals(4, phoneNumWithAreaCode.getLineNumber().length());
			assertEquals(refArea, phoneNumWithAreaCode.getFullPhoneNumber());
					
		}

		//two arguments provided
		if (phoneNumWithCountryCode.getAreaCode().length() == 3
				 && phoneNumWithCountryCode.getCountryCode().length() == 1)
		{
			String refCountry = "5423";
			for (int i = 0; i < 7; i++)
			{
				int temp = randomInt.nextInt(10);
				String tempStr = Integer.toString(temp);
				refCountry += tempStr;//modify variable exclusive to PhoneTest
				controller.append(tempStr); //call PhoneNumber class to modify its own variable, then get the variable					
			}
			assertEquals(1, phoneNumWithCountryCode.getCountryCode().length());
			assertEquals(3, phoneNumWithCountryCode.getAreaCode().length());
			assertEquals(3, phoneNumWithCountryCode.getPrefixCode().length());
			assertEquals(4, phoneNumWithCountryCode.getLineNumber().length());
			assertEquals(refCountry, phoneNumWithCountryCode.getFullPhoneNumber());					
		}
	
	}
	
	public void MyUITest() {
		assertEquals("5", myUI.getVolume());
		myUI.setVolumeDown();
		assertEquals("4", myUI.getVolume());
		
		myUI.setCountryField("5");
		assertEquals("5", myUI.getCountryField());
	}

}
