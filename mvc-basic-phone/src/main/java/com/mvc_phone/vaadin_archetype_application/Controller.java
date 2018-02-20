package com.mvc_phone.vaadin_archetype_application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller {

    private Model model;
    //private MyUI myUI;
    private PhoneNumber phoneNum = new PhoneNumber();
    
    //do this outside of the constructor later
    //PhoneNumber phoneNum = new PhoneNumber();
    
    public Controller(Model model) {
    	
        this.model = model;
        
        //PhoneNumber phoneNum = new PhoneNumber(); //move out of constructor
        
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
      
        /*
        myUI.setVolumeDown();
        myUI.setAreaField(phoneNum.getAreaCode());
        System.out.println("VOLUME: " + myUI.getVolume());
        System.out.println("Area field: " + myUI.getAreaField());
        */
       
    }
    
    /*
    public void initListeners() {
        myUI.button1.addClickListener(e ->{
        	
        });
        
        myUI.button2.addClickListener(e ->{
        	
        });
        
        myUI.button3.addClickListener(e ->{
        	
        });
        
        myUI.button4.addClickListener(e ->{
        	
        });
        
        myUI.button5.addClickListener(e ->{
        	
        });
        
        myUI.button6.addClickListener(e ->{
        	
        });
        
        myUI.button7.addClickListener(e ->{
        	
        });
        
        myUI.button8.addClickListener(e ->{
        	
        });
        
        myUI.button9.addClickListener(e ->{
        	
        });      
        
        myUI.button0.addClickListener(e ->{
        	
        });
        
        myUI.buttonStar.addClickListener(e ->{
        	
        });
        
        myUI.buttonPound.addClickListener(e ->{
        	
        }); 
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
