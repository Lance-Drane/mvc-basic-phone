package com.mvc_phone.vaadin_archetype_application;

public class Controller {

    private Model model;
    private PhoneNumber phoneNum = new PhoneNumber();
       
    //MINIMAL CONTROLLER
    //TODO: Only thing to do with the controller is update the data fields
    
    public Controller(Model model) {
    	
        this.model = model;
        
        //TODO: figure out constructor
        
        //tests
                
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
        System.out.println("Setting volume down... " + myUI.getVolume());
        myUI.setVolumeDown();
        System.out.println("Volume set down! " +  myUI.getVolume());
        */
        

        //myUI.setVolumeDown();
       // myUI.setAreaField(phoneNum.getAreaCode());
        //System.out.println("VOLUME: " + myUI.getVolume());
        //System.out.println("Area field: " + myUI.getAreaField());
       
        //TODO: possibly implement an observer interface with an update() method 
    }
	
	
	
}
