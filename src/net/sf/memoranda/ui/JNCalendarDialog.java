/**
 * @file: JNCalendarDialog.java
 * @author: Andrew Steinmetz
 * @date: April 15, 2017
 * 
 * @description: Instances of JNCalendarDialog will create a dialog 
 * 				box of an expanded calendar so the user may see the calendar easier 
 */

package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.sf.memoranda.date.CurrentDate;


/**
 * @class JNCalendarDialog
 * 
 * @description Creates a dialog of an expanded calendar view
 *
 */
public class JNCalendarDialog extends JDialog implements WindowListener {
    public boolean CANCELLED = false;
    
    JPanel dialogPanel = new JPanel();
    
    //calendar components
    JPanel calendarPanel = new JPanel();
    JNCalendar jnCalendar = new JNCalendar(CurrentDate.get());
    
    //nav bar components
    JPanel navBar = new JPanel();
    JButton monthForwardButton = new JButton();
    JButton monthBackwardButton = new JButton();
    JButton todayButton = new JButton();
    
    //bottom panel components
    JPanel monthYearPanel = new JPanel();
    JSpinner yearSpin = new JSpinner(new SpinnerNumberModel(jnCalendar.get().getYear(), 1980, 2999, 1));
    JSpinner.NumberEditor yearSpinner = new JSpinner.NumberEditor(yearSpin, "####");

    
    public JNCalendarDialog(Frame frame, String title){
    	super(frame, title, true);
        try {
            jbInit();
            pack();
        }
        catch (Exception ex) {
            new ExceptionDialog(ex);
        }
        super.addWindowListener(this);
    }
    
    void jbInit() throws Exception {
    	this.setResizable(true);
    	dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.PAGE_AXIS));
    	
    	//setup navbar
    	navBar.setLayout(new BorderLayout());
    	
    	calendarPanel.setLayout(new BorderLayout());
    	 jnCalendar.getTableHeader().setFont(new java.awt.Font("Dialog", 1, 20));
    	 jnCalendar.setFont(new java.awt.Font("Dialog", 0, 20));
    	 jnCalendar.setGridColor(Color.lightGray);
    	 jnCalendar.getTableHeader().setPreferredSize(new Dimension(200, 40));
    	 calendarPanel.add(jnCalendar.getTableHeader(), BorderLayout.NORTH);
    	 calendarPanel.add(jnCalendar, BorderLayout.CENTER);
    	 this.add(calendarPanel);
    	
    	
    }
	

    public void windowClosed( WindowEvent e ) {}

	public void windowIconified( WindowEvent e ) {}

	public void windowDeiconified( WindowEvent e ) {}

	public void windowActivated( WindowEvent e ) {}

	public void windowDeactivated( WindowEvent e ) {}

	public void windowClosing(WindowEvent e) {
		CANCELLED = true;
        this.dispose();	
	}

	public void windowOpened(WindowEvent e) {}
}
