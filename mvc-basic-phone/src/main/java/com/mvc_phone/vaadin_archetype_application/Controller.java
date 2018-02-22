package com.mvc_phone.vaadin_archetype_application;

public class Controller {

    private Model model;
    protected PhoneNumber phoneNum;
       
    //MINIMAL CONTROLLER
    //TODO: Only thing to do with the controller is update the data fields
    
    public Controller(Model model) {
    	
        this.model = model;
        
        createNewPhoneNumberOneArg();
                
        System.out.println("in the controller uhhh");      
        //TODO: possibly implement an observer interface with an update() method 
    }
    
    public void testDataEditing() {
    	System.out.println("COUNTRY CODE: " + phoneNum.getCountryCode());
    	System.out.println("AREA CODE: " + phoneNum.getAreaCode());
    	System.out.println("PREFIX CODE: " + phoneNum.getPrefixCode());
    	System.out.println("LINE NUMBER: " + phoneNum.getLineNumber());    	
    }
    
    public void createNewPhoneNumberNoArg() {
    	phoneNum = new PhoneNumber();
    }
    
    public void createNewPhoneNumberOneArg() {
    	phoneNum = new PhoneNumber("1");
    }
    
    public void createNewPhoneNumberTwoArg() {
    	phoneNum = new PhoneNumber("1", "865");
    }
	
    public void append(String tempStr) {
		if (phoneNum.getCountryCode().length() != 1)
		{
			phoneNum.appendCountryCode(tempStr);
		}
		else if (phoneNum.getAreaCode().length() != 3)
		{
			phoneNum.appendAreaCode(tempStr);
		}
		else if (phoneNum.getPrefixCode().length() != 3)
		{
			phoneNum.appendPrefixCode(tempStr);
		}
		else if (phoneNum.getLineNumber().length() != 4)
		{
			phoneNum.appendLineNumber(tempStr);
		}	
    }
    
    public void snip() {
		if (phoneNum.getLineNumber().length() != 0)
		{
			phoneNum.snipLineNumber();
		}
		else if (phoneNum.getPrefixCode().length() != 0)
		{
			phoneNum.snipPrefixCode();
		}
		else if (phoneNum.getAreaCode().length() != 0)
		{
			phoneNum.snipAreaCode();		
		}
		else if (phoneNum.getCountryCode().length() != 0)
		{
			phoneNum.snipCountryCode();
		}		
    }
    
    /*
    public void editCountryCode() {
    	phoneNum.getCountryCode();
    }
    
    public void editAreaCode() {
    	phoneNum.getAreaCode();
    }
    
    public void editPrefixCode() {
    	phoneNum.getPrefixCode();
    }
    
    public void editLineNumber() {
    	phoneNum.getLineNumber();
    }
	*/
	
}
