package com.mvc_phone.vaadin_archetype_application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */

//PhoneNumber class needs a test
//do this by creating a unit test in JUnit
//

@Theme("mytheme")
public class MyUI extends UI {

	//first line, where the phone number is written to
	final static private Label beginningLabel = new Label("+");
	final private TextField countryCodeField = new TextField();
	final static private Label labelSeparator1 = new Label("- (");
	final private TextField areaCodeField = new TextField();
	final static private Label labelSeparator2 = new Label(") -");
	final private TextField prefixCodeField = new TextField();
	final static private Label labelSeparator3 = new Label("-");
	final private TextField lineNumberField = new TextField();		
	final private Button buttonDelete = new Button("DELETE THIS");
	
	//second line, which handles the call status
	final private Button startButton = new Button("CALL");
	final private Button endButton = new Button("END");
	final static private String noInCall = "Standing by...";
	final static private String yesInCall = "Calling...";
	final private Label callStatus = new Label(noInCall);
	private Boolean inCall = false;
	
	//number grid
	//IMPORTANT: variable names MUST be consistent ("button 1", " button 2")
	final private Button button1 = new Button("1");
	final private Button button2 = new Button("2");
	final private Button button3 = new Button("3");
	final private Button button4 = new Button("4");
	final private Button button5 = new Button("5");
	final private Button button6 = new Button("6");
	final private Button button7 = new Button("7");
	final private Button button8 = new Button("8");
	final private Button button9 = new Button("9");
	final private Button buttonStar = new Button("*");
	final private Button button0 = new Button("0");
	final private Button buttonPound = new Button("#");
	
	//volume controls
	final private Button volumeDown = new Button("\\|/");
	final private Label volumeDisplay = new Label("5");
	final private Button volumeUp = new Button("/|\\");
	final private int MIN_VOLUME = 0;
	final private int MAX_VOLUME = 10;
	
	//volume slider
	final private Slider volumeSlider = new Slider("Volume", MIN_VOLUME, MAX_VOLUME);
	
	private Model model;
	private Controller controller;
		
	//Binder
	Binder<PhoneNumber> binder = new Binder<>();

	//this is kind of Vaadin's main method
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		
		initLayout(); //since the layout will be static, just put everything relevant to it in the method
		initModifications(); //
		initListeners();
		initBinder();
		System.out.println("Start?");
		controller.testDataEditing();
        
		//TODO: temporary testing block
	}
		
	public MyUI() {
		
		System.out.println("Now I'm in the constructor!");
		model = new Model();
		System.out.println("First constructor executed");
		controller = new Controller(model);
		System.out.println("Second constructor executed");
		
	}
	
	
	private void initLayout() {
		// master layout
		final VerticalLayout layout = new VerticalLayout();

		// make it legible and not huge, that's it		
		final int FIELD_HEIGHT = 30;		
		countryCodeField.setWidth(40, Unit.PIXELS);
		countryCodeField.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		areaCodeField.setWidth(60, Unit.PIXELS);
		areaCodeField.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		prefixCodeField.setWidth(60, Unit.PIXELS);
		prefixCodeField.setHeight(FIELD_HEIGHT, Unit.PIXELS);
		lineNumberField.setWidth(80, Unit.PIXELS);
		lineNumberField.setHeight(FIELD_HEIGHT, Unit.PIXELS);

		final HorizontalLayout DisplayAndDelete = new HorizontalLayout(beginningLabel, countryCodeField,
				labelSeparator1, areaCodeField, labelSeparator2, prefixCodeField, labelSeparator3, lineNumberField,
				buttonDelete);		
		final HorizontalLayout CallAndCancel = new HorizontalLayout(startButton, endButton, callStatus);

		final HorizontalLayout numberRow1 = new HorizontalLayout(button1, button2, button3);
		final HorizontalLayout numberRow2 = new HorizontalLayout(button4, button5, button6);
		final HorizontalLayout numberRow3 = new HorizontalLayout(button7, button8, button9);
		final HorizontalLayout numberRow4 = new HorizontalLayout(buttonStar, button0, buttonPound);
		final VerticalLayout keypad = new VerticalLayout(numberRow1, numberRow2, numberRow3, numberRow4);
		
		final HorizontalLayout volumeLayout = new HorizontalLayout(volumeDown, volumeDisplay, volumeUp);
		final HorizontalLayout volumeLayout2 = new HorizontalLayout(volumeSlider);
		
		layout.addComponents(DisplayAndDelete, CallAndCancel, keypad, volumeLayout, volumeLayout2);
		setContent(layout);
				
	}
	
	private void initModifications() {
		
		countryCodeField.setReadOnly(true);
		countryCodeField.setValue(controller.phoneNum.getCountryCode());
		areaCodeField.setReadOnly(true);
		areaCodeField.setValue(controller.phoneNum.getAreaCode());
		prefixCodeField.setReadOnly(true);
		areaCodeField.setValue(controller.phoneNum.getPrefixCode());
		lineNumberField.setReadOnly(true);
		areaCodeField.setValue(controller.phoneNum.getLineNumber());
		
		volumeSlider.setValue((volumeSlider.getMin() + volumeSlider.getMax())/2);
		
	}
	
	//controller.getPhoneNumber
	//from the UI get the phone number from the controller
	//controller tells phone number to edit itself
	//Vaadin data (i.e. textfield) binding
	
	private void initListeners() {
				
		buttonDelete.addClickListener(e -> {
			determineDeletion();
		});
		
		startButton.addClickListener(e -> {
			changeCallStatus(getButtonPressed(e));
		});
		
		endButton.addClickListener(e -> {
			changeCallStatus(getButtonPressed(e));
		});
		  
		button1.addClickListener(e -> {		
			keypadPressed(getButtonPressed(e));	
		});

		button2.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button3.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button4.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button5.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button6.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button7.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));		
		});

		button8.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));	
		});

		button9.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));		
		});

		button0.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));			
		});

		buttonStar.addClickListener(e -> {	
			keypadPressed(getButtonPressed(e));		
		});

		buttonPound.addClickListener(e -> {				
			keypadPressed(getButtonPressed(e));		
		});
		
		volumeDown.addClickListener(e -> {		
				setVolumeDown();		
		});
		
		volumeUp.addClickListener(e -> {		
				setVolumeUp();		
		});		
				
	}
	
	private void initBinder() {
		binder.bind(countryCodeField, PhoneNumber::getCountryCode, PhoneNumber::setCountryCode);
		binder.bind(areaCodeField, PhoneNumber::getAreaCode, PhoneNumber::setAreaCode);
		binder.bind(prefixCodeField, PhoneNumber::getPrefixCode, PhoneNumber::setPrefixCode);
		binder.bind(lineNumberField, PhoneNumber::getLineNumber, PhoneNumber::setLineNumber);				
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public void determineDeletion() {
		if (!inCall)
		{
			controller.snip();
			if (getLineField().length() > 0)
			{
				setLineField(getLineField().substring(0, getLineField().length() - 1));
			}
			else if (getPrefixField().length() > 0)
			{
				setPrefixField(getPrefixField().substring(0, getPrefixField().length() - 1));
			}
			else if (getAreaField().length() > 0)
			{
				setAreaField(getAreaField().substring(0, getAreaField().length() - 1));
			}
			else if (getCountryField().length() > 0)
			{
				setCountryField(getCountryField().substring(0, getCountryField().length() - 1));
			}
			//handleBinderUpdates();
			controller.testDataEditing();
			/*
			if (controller.phoneNum.getLineNumber().length() > 0)
			{
				setLineField(getLineField().substring(0, getLineField().length() - 1));
				controller.phoneNum.setLineNumber(getLineField());
				//handleBinderUpdates();
				controller.testDataEditing();
			}
			else if (controller.phoneNum.getPrefixCode().length() > 0)
			{
				setPrefixField(getPrefixField().substring(0, getPrefixField().length() - 1));
				controller.phoneNum.setPrefixCode(getPrefixField());
				//handleBinderUpdates();
				controller.testDataEditing();
			}
			else if (controller.phoneNum.getAreaCode().length() > 0)
			{
				setAreaField(getAreaField().substring(0, getAreaField().length() - 1));
				controller.phoneNum.setAreaCode(getAreaField());
				//handleBinderUpdates();
				controller.testDataEditing();
			}
			else if (controller.phoneNum.getCountryCode().length() > 0)
			{
				setCountryField(getCountryField().substring(0, getCountryField().length() - 1));
				controller.phoneNum.setCountryCode(getCountryField());
				//handleBinderUpdates();
				controller.testDataEditing();
			}
			*/
		}
	}
	
	public String getButtonPressed(ClickEvent event) {
		return event.getButton().getCaption();
	}
	
	public void keypadPressed(String getButtonPressed) {
		
		controller.append(getButtonPressed);
		if (getCountryField().length() != 1) 
		{
			setCountryField(getCountryField() + getButtonPressed);
		} 
		else if (getAreaField().length() != 3) 
		{
			setAreaField(getAreaField() + getButtonPressed);
		} 
		else if (getPrefixField().length() != 3) 
		{
			setPrefixField(getPrefixField() + getButtonPressed);
		} 
		else if (getLineField().length() != 4)
		{
			setLineField(getLineField() + getButtonPressed);
		}
		//handleBinderUpdates();
		controller.testDataEditing();
		
		/*
		if (controller.phoneNum.getCountryCode().length() != 1) 
		{
			setCountryField(getCountryField() + getButtonPressed);
			controller.phoneNum.setCountryCode(getCountryField());
			//handleBinderUpdates();
			controller.testDataEditing();
		} 
		else if (controller.phoneNum.getAreaCode().length() != 3) 
		{
			setAreaField(getAreaField() + getButtonPressed);
			controller.phoneNum.setAreaCode(getAreaField());
			//handleBinderUpdates();
			controller.testDataEditing();
		} 
		else if (controller.phoneNum.getPrefixCode().length() != 3) 
		{
			setPrefixField(getPrefixField() + getButtonPressed);
			controller.phoneNum.setPrefixCode(getPrefixField());
			//handleBinderUpdates();
			controller.testDataEditing();
		} 
		else if (controller.phoneNum.getLineNumber().length() != 4)
		{
			setLineField(getLineField() + getButtonPressed);
			controller.phoneNum.setLineNumber(getLineField());
			//handleBinderUpdates();
			controller.testDataEditing();
		}
		*/
	}
	
	public void changeCallStatus(String caption) { //can potentially have this method return a Boolean and ditch inCall variable
		if (caption == startButton.getCaption() && controller.phoneNum.getFullPhoneNumber().length() == 11)
		{			
			//TODO: check the phoneNumber class to make sure this is valid, not the text field
			inCall = true;
			callStatus.setValue(yesInCall);
		}
		else
		{
			inCall = false;
			callStatus.setValue(noInCall);
		}
	}
	
	public void handleBinderUpdates() {
		binder.readBean(controller.phoneNum);
	}
	
	public String getCountryField() {
		return countryCodeField.getValue();
	}
	
	public void setCountryField(String tempStr) {
		countryCodeField.setValue(tempStr);
	}

	public String getAreaField() {
		return areaCodeField.getValue();
	}
	
	public void setAreaField(String tempStr) {
		areaCodeField.setValue(tempStr);
	}
	
	public String getPrefixField() {
		return prefixCodeField.getValue();
	}
	
	public void setPrefixField(String tempStr) {
		prefixCodeField.setValue(tempStr);
	}
	
	public String getLineField() {
		return lineNumberField.getValue();
	}
	
	public void setLineField(String tempStr) {
		lineNumberField.setValue(tempStr);
	}
	
	public String getVolume() {
		return volumeDisplay.getValue();
	}
	
	public void setVolumeDown() {
		if (Integer.parseInt(volumeDisplay.getValue()) > MIN_VOLUME) {
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) - 1));
		}
	}
	
	public void setVolumeUp() {
		if (Integer.parseInt(volumeDisplay.getValue()) < MAX_VOLUME) 
		{
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) + 1));
		}
	}
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
