/**
 *  @file TimePicker.java
 *  @author Andrew Steinmetz
 *  
 *  @description file creates a component for the time picker to be reused
 */

package net.sf.memoranda.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class TimePicker {

	//Variables jcombo box
	private String[] timeStrings;
	
	//GUI Components
	//container
	JPanel container;
	
	//top pane
	JButton upHour;
	JButton upMin;
	JPanel topPane;
	
	//middle
	JComboBox timeComboBox;
	
	//bottom pane
	JButton downHour;
	JButton downMin;
	JPanel bottomPane;
	
	public TimePicker(){
		initTimeValues();
		timeComboBox = new JComboBox<String>(timeStrings);
		timeComboBox.setSelectedIndex(24);
		timeComboBox.setEditable(true);
		//timeComboBox.addActionListener(this);
		
	}
	
	private void initTimeValues(){
		timeStrings = new String[]{ "00:00","00:30","01:00","01:30","02:00","02:30","03:00",
						"03:30", "04:00","04:30","05:00","05:30","06:00","06:30",
						"07:00","07:30","08:00","08:30","09:00","09:30","10:00",
						"10:30", "11:00","11:30","12:00","12:30","13:00","13:30",
						"14:00","14:30","15:00","15:30","16:00","16:30","17:00",
						"17:30", "18:00","18:30","19:00","19:30","20:00","20:30",
						"21:00","21:30","22:00","22:30","23:00","23:30","24:00",
						
		};
	}
}