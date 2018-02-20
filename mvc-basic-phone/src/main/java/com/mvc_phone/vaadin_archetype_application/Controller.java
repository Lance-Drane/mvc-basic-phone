package com.mvc_phone.vaadin_archetype_application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.vaadin.ui.Button.ClickEvent;

public class Controller {

    private Model model;
    private MyUI myUI;
    private PhoneNumber phoneNum = new PhoneNumber();
    
    //do this outside of the constructor later
    //PhoneNumber phoneNum = new PhoneNumber();
    
    public Controller(Model model) {
    	
        this.model = model;
        //myUI = new MyUI(this, model);
        
        System.out.println("in the controller uhhh");
        System.out.println(phoneNum.getCountryCode());
        System.out.println(phoneNum.getAreaCode());
        System.out.println(phoneNum.getPrefixCode());
        phoneNum.setCountryCode("4");
        System.out.println("NOW: " + phoneNum.getCountryCode());
        phoneNum.setAreaCode("423");
        System.out.println("AGAIN: " + phoneNum.getAreaCode());
        phoneNum.snip();
        phoneNum.append("6");
        System.out.println(phoneNum.getCountryCode() + " " + phoneNum.getAreaCode());
      

        //myUI.setVolumeDown();
       // myUI.setAreaField(phoneNum.getAreaCode());
        //System.out.println("VOLUME: " + myUI.getVolume());
        //System.out.println("Area field: " + myUI.getAreaField());
       
        //TODO: possibly implement an observer interface with an update() method 
    }
    
    /*
	public String getButtonPressed(ClickEvent event) {
		
		String text = "";
		
		if (event.getButton() == button1) {
		text = "1";
		}
		else if (event.getButton() == button2) {
		text = "2";
		}
		else if (event.getButton() == button3) {
		text = "3";
		}
		else if (event.getButton() == button4) {
		text = "4";
		}
		else if (event.getButton() == button5) {
		text = "5";
		}
		else if (event.getButton() == button6) {
		text = "6";
		}
		else if (event.getButton() == button7) {
		text = "7";
		}
		else if (event.getButton() == button8) {
		text = "8";
		}
		else if (event.getButton() == button9) {
		text = "9";
		}
		else if (event.getButton() == button0) {
		text = "0";
		}
		else if (event.getButton() == buttonStar) {
		text = "*";
		}
		else if (event.getButton() == buttonPound) {
		text = "#";
		}
		
		return text;
	}
	
	public void keypadPressed(String getButtonPressed) {
		if (lineNumberField.getValue().length() >= 4) {
		} // do nothing
		else if (countryCodeField.getValue().length() < 1) {
			countryCodeField.setValue(countryCodeField.getValue() + getButtonPressed);
		} else if (areaCodeField.getValue().length() < 3) {
			areaCodeField.setValue(areaCodeField.getValue() + getButtonPressed);
		} else if (prefixCodeField.getValue().length() < 3) {
			prefixCodeField.setValue(prefixCodeField.getValue() + getButtonPressed);
		} else {
			lineNumberField.setValue(lineNumberField.getValue() + getButtonPressed);
		}
	}
    */
	/*
	
	public void createNewPhoneNumber() {
	
		Random randomInt = new Random();
		
		for (int i = 0; i < 11; i++)
		{
			int temp = randomInt.nextInt(10);
			String tempStr = Integer.toString(temp);
			
			if (phoneNumber.getCountryCode().length() != 1)
			{
				phoneNumber.setCountryCode(tempStr);
			}
			else if (phoneNumber.getAreaCode().length() != 3)
			{
				phoneNumber.setAreaCode(tempStr);
			}
			else if (phoneNumber.getPrefixCode().length() != 3)
			{
				phoneNumber.setPrefixCode(tempStr);
			}
			else if (phoneNumber.getLineNumber().length() != 4)
			{
				phoneNumber.setLineNumber(tempStr);
			}			
		}
		
		phoneNumber.append();
	}
	
	public void deletePhoneNumber() {
	
	
	
	}
	
	
	
	public void dial(String number) {
	
		//disable button listeners
		//reference the model
	
	}
	
	public String getAddressBook() {
	
		return HereLiesTheModel.addressBook(); 
	
	}
	
	
	public void Disconnect() {
	
		//re-enable button listeners
	
	}
	
	public void volumeUp() {
	
			if (Integer.parseInt(volumeDisplay.getCaption()) > 0)
			{
				volumeDisplay.setCaption(Integer.toString(Integer.parseInt(volumeDisplay.getCaption()) - 1));
			}
	}
	
	public void volumeDown() {

		volumeUp.addClickListener(e -> {
			
			if (Integer.parseInt(volumeDisplay.getCaption()) < 10)
			{
				volumeDisplay.setCaption(Integer.toString(Integer.parseInt(volumeDisplay.getCaption()) + 1));
			}
	
	}
	
	public int getVolume() {
	
	return Integer.parseInt(MyUI.volumeDisplay.getCaption());
	
	}
	
	public void setVolume() {
	
				
	}
	}
*/	
}
