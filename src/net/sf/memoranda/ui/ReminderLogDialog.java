package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ReminderLogDialog extends JDialog {
	Dimension dialogSize = new Dimension(420,230);
	public boolean isCancelled = true;
	
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	JPanel startPanel = new JPanel(new FlowLayout());
	JLabel dateLabel = new JLabel("Date");
	MaskFormatter dateFormat = createFormatter("##/##/##");
	JFormattedTextField date = new JFormattedTextField(dateFormat);
	
	JPanel reminderPanel = new JPanel();
	JLabel reminderLabel = new JLabel("<html><center>Reminder</center></html>");
	JTextField reminder = new JTextField(20);
	
	// JScrollPane scrollPane = new JScrollPane(comments);		// For use with JTextArea
	
	JPanel buttonPanel = new JPanel();
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	public ReminderLogDialog(Frame frame, String title) {
		super(frame, title, true);
		
		this.setResizable(false);
		this.setSize(dialogSize);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		dateFormat.setPlaceholderCharacter('-');
		date.setColumns(6);


		startPanel.add(dateLabel);
		startPanel.add(date);
		startPanel.add(reminderLabel);
		startPanel.add(reminder);
		
		//reminderPanel.setPreferredSize(new Dimension(dialogSize.width/3,dialogSize.height-100));
		//reminderPanel.setLayout(new BoxLayout(reminderPanel, BoxLayout.Y_AXIS));
		//reminderLabel.setHorizontalAlignment(JLabel.CENTER);
		// comments.setLineWrap(true);		//For use with JTextArea
		//reminderPanel.add(Box.createVerticalStrut(15));
		
		// commentsPanel.add(scrollPane);	//For use with JTextArea
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isCancelled = false;
				dispose();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		buttonPanel.add(save);
		buttonPanel.add(cancel);
		
		mainPanel.add(startPanel, BorderLayout.PAGE_START);
		
		this.add(mainPanel);
		this.add(Box.createVerticalStrut(10));
		this.add(buttonPanel, BorderLayout.PAGE_END);
		pack();
	}
	
	public ReminderLogDialog(Frame frame, String title, String[] initValues) {
		this(frame, title);
		
		date.setText(initValues[0]);
		reminder.setText(initValues[1]);
	}
	
	private MaskFormatter createFormatter(String format) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(format);
	    } catch (ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	    }
	    return formatter;
	}
}
