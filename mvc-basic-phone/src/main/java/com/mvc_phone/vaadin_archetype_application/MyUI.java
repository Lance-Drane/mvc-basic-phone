package com.mvc_phone.vaadin_archetype_application;

import java.awt.event.ActionListener;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
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
	
	//this is kind of Vaadin's main method
	@Override
	protected void init(VaadinRequest vaadinRequest) {

		model = new Model();
		controller = new Controller(model);
		//myUI = new MyUI(controller, model);
		
		initLayout(); //since the layout will be static, just put everything relevant to it in the method
		initModifications(); //
		initListeners(); //TODO: move these to Controller
        			
	}
	
	/*
	public myUI(Controller controller, Model model) {
		
		this.model = model;
		this.controller = controller;
		initLayout(); //since the layout will be static, just put everything relevant to it in the method
		initModifications(); //
		initListeners(); //TODO: move these to Controller
	}
	*/
	
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

	/*	
	public void addKeypadListeners (ActionListener listenForAnswerButton) {

			button1.addActionListener(listenForAnswerButton);
			//answerButton2.addActionListener(listenForAnswerButton);
	}
		*/
	
	private void initListeners() {
				
		buttonDelete.addClickListener(e -> {

			// logic chains to ensure that values to the right are deleted first
			
			if (lineNumberField.getValue().length() > 0)
				lineNumberField
						.setValue(lineNumberField.getValue().substring(0, lineNumberField.getValue().length() - 1));
			else if (prefixCodeField.getValue().length() > 0)
				prefixCodeField
						.setValue(prefixCodeField.getValue().substring(0, prefixCodeField.getValue().length() - 1));
			else if (areaCodeField.getValue().length() > 0)
				areaCodeField.setValue(areaCodeField.getValue().substring(0, areaCodeField.getValue().length() - 1));
			else if (countryCodeField.getValue().length() > 0)
				countryCodeField
						.setValue(countryCodeField.getValue().substring(0, countryCodeField.getValue().length() - 1));
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
			
			if (Integer.parseInt(volumeDisplay.getValue()) > 0)
			{
				volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) - 1));
			}
			
		});
		
		volumeUp.addClickListener(e -> {
			
			if (Integer.parseInt(volumeDisplay.getValue()) < 10)
			{
				volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) + 1));
			}
			
		});		
				
	}
	
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
	

	
	public String getCountryField() {
		return countryCodeField.getValue();
	}
	
	public void setCountryField(String tempStr) {
		countryCodeField.setValue(tempStr);
	}

	public String getAreaField() {
		return countryCodeField.getValue();
	}
	
	public void setAreaField(String tempStr) {
		areaCodeField.setValue(tempStr);
	}
	
	public String getPrefixField() {
		return countryCodeField.getValue();
	}
	
	public void setPrefixField(String tempStr) {
		prefixCodeField.setValue(tempStr);
	}
	
	public String getLineField() {
		return countryCodeField.getValue();
	}
	
	public void setLineField(String tempStr) {
		lineNumberField.setValue(tempStr);
	}
	
	public String getVolume() {
		return volumeDisplay.getValue();
	}
	
	public void setVolumeDown() {
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) - 1));
	}
	
	public void setVolumeUp() {
		volumeDisplay.setValue(Integer.toString(Integer.parseInt(volumeDisplay.getValue()) + 1));
	}
	
	public String deleteTextField(String string) {
		
		if (string.length() != 0) 
		{
			return string.substring(0, string.length() - 1);
		}
		else
		{
			return string;
		}
		
	}
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
