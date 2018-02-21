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

	//first line
	final static Label beginningLabel = new Label("+");
	final TextField countryCodeField = new TextField();
	final static Label labelSeparator1 = new Label("- (");
	final TextField areaCodeField = new TextField();
	final static Label labelSeparator2 = new Label(") -");
	final TextField prefixCodeField = new TextField();
	final static Label labelSeparator3 = new Label("-");
	final TextField lineNumberField = new TextField();		
	final Button buttonDelete = new Button("DELETE THIS");
	
	//second line
	final Button startButton = new Button("CALL");
	final Button endButton = new Button("END");
	
	//number grid
	//IMPORTANT: variable names MUST be consistent ("button 1", " button 2")
	final Button button1 = new Button("1");
	final Button button2 = new Button("2");
	final Button button3 = new Button("3");
	final Button button4 = new Button("4");
	final Button button5 = new Button("5");
	final Button button6 = new Button("6");
	final Button button7 = new Button("7");
	final Button button8 = new Button("8");
	final Button button9 = new Button("9");
	final Button buttonStar = new Button("*");
	final Button button0 = new Button("0");
	final Button buttonPound = new Button("#");
	
	//volume controls
	final Button volumeDown = new Button("\\|/");
	final Label volumeDisplay = new Label("5");
	final Button volumeUp = new Button("/|\\");
	
	//private MyUI myUI;
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
        			
	}
		
	public MyUI() {
		
		System.out.println("Now I'm in the constructor!");
		model = new Model();
		System.out.println("First constructor executed");
		controller = new Controller(model);
		System.out.println("Second constructor executed");
		
		System.out.println("VOLUME: " + getVolume());
	}
	
	
	private void initLayout() {
		// master layout
		final VerticalLayout layout = new VerticalLayout();

		// make it legible and not huge, that's it
		countryCodeField.setWidth(40, Unit.PIXELS);
		countryCodeField.setHeight(30, Unit.PIXELS);
		areaCodeField.setWidth(60, Unit.PIXELS);
		areaCodeField.setHeight(30, Unit.PIXELS);
		prefixCodeField.setWidth(60, Unit.PIXELS);
		prefixCodeField.setHeight(30, Unit.PIXELS);
		lineNumberField.setWidth(80, Unit.PIXELS);
		lineNumberField.setHeight(30, Unit.PIXELS);

		final HorizontalLayout DisplayAndDelete = new HorizontalLayout(beginningLabel, countryCodeField,
				labelSeparator1, areaCodeField, labelSeparator2, prefixCodeField, labelSeparator3, lineNumberField,
				buttonDelete);		
		final HorizontalLayout CallAndCancel = new HorizontalLayout(startButton, endButton);

		final HorizontalLayout numberRow1 = new HorizontalLayout(button1, button2, button3);
		final HorizontalLayout numberRow2 = new HorizontalLayout(button4, button5, button6);
		final HorizontalLayout numberRow3 = new HorizontalLayout(button7, button8, button9);
		final HorizontalLayout numberRow4 = new HorizontalLayout(buttonStar, button0, buttonPound);
		final VerticalLayout keypad = new VerticalLayout(numberRow1, numberRow2, numberRow3, numberRow4);
		
		final HorizontalLayout volumeLayout = new HorizontalLayout(volumeDown, volumeDisplay, volumeUp);
		
		layout.addComponents(DisplayAndDelete, CallAndCancel, keypad, volumeLayout);
		setContent(layout);
				
	}
	
	private void initModifications() {
		
		// initialize text fields
		countryCodeField.setReadOnly(true);
		countryCodeField.setValue("1"); // do this by default , because who remembers country codes?
		areaCodeField.setReadOnly(true);
		//areaCodeField.setValue("865"); //perhaps implement logic determining a default value?
		prefixCodeField.setReadOnly(true);
		lineNumberField.setReadOnly(true);
		
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
			
		});
		
		endButton.addClickListener(e -> {
		
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
		binder.forField(countryCodeField).bind(PhoneNumber::getCountryCode, PhoneNumber::setCountryCode);
		binder.forField(areaCodeField).bind(PhoneNumber::getAreaCode, PhoneNumber::setAreaCode);
		binder.forField(prefixCodeField).bind(PhoneNumber::getPrefixCode, PhoneNumber::setPrefixCode);
		binder.forField(lineNumberField).bind(PhoneNumber::getLineNumber, PhoneNumber::setLineNumber);				
	}
	
	public void determineDeletion() {
		if (getLineField().length() > 0)
			setLineField(getLineField().substring(0, getLineField().length() - 1));
		else if (getPrefixField().length() > 0)
			setPrefixField(getPrefixField().substring(0, getPrefixField().length() - 1));
		else if (getAreaField().length() > 0)
			setAreaField(getAreaField().substring(0, getAreaField().length() - 1));
		else if (getCountryField().length() > 0)
			setCountryField(getCountryField().substring(0, getCountryField().length() - 1));
	}
	
	public String getButtonPressed(ClickEvent event) {
		return event.getButton().getCaption();
	}
	
	public void keypadPressed(String getButtonPressed) {
		
		if (getCountryField().length() != 1) {
			setCountryField(getCountryField() + getButtonPressed);
		} else if (getAreaField().length() != 3) {
			setAreaField(getAreaField() + getButtonPressed);
		} else if (getPrefixField().length() != 3) {
			setPrefixField(getPrefixField() + getButtonPressed);
		} else if (getLineField().length() != 4){
			setLineField(getLineField() + getButtonPressed);
		}
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
		if (Integer.parseInt(volumeDisplay.getValue()) > 0) {
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) - 1));
		}
	}
	
	public void setVolumeUp() {
		if (Integer.parseInt(volumeDisplay.getValue()) < 10) {
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) + 1));
		}
	}
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
