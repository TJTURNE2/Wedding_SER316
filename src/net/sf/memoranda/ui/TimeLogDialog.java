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

public class TimeLogDialog extends JDialog {
	Dimension dialogSize = new Dimension(420,230);
	public boolean isCancelled = true;
	
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	JPanel startPanel = new JPanel(new FlowLayout());
	JLabel dateLabel = new JLabel("Date");
	MaskFormatter dateFormat = createFormatter("##/##/##");
	JFormattedTextField date = new JFormattedTextField(dateFormat);
	JLabel startLabel = new JLabel("Start Time");
	MaskFormatter timeFormat = createFormatter("##:##");
	JFormattedTextField startTime = new JFormattedTextField(timeFormat);
	
	JPanel endPanel = new JPanel(new FlowLayout());
	JLabel endLabel = new JLabel("End Time");
	JFormattedTextField endTime = new JFormattedTextField(timeFormat);
	
	
	JPanel interruptPanel = new JPanel();
	JLabel interruptLabel = new JLabel("<html><center>Interrupts<br>(separate by '+')</center></html>");
	JTextField interrupts = new JTextField();
	
	JPanel phasePanel = new JPanel();
	JLabel phaseLabel = new JLabel("<html><center>Phase</center></html>");
	JTextField phase = new JTextField();
	
	JPanel commentsPanel = new JPanel();
	JLabel commentsLabel = new JLabel("<html><center>Comments</center></html>");
	JTextField comments = new JTextField();
	// JScrollPane scrollPane = new JScrollPane(comments);		// For use with JTextArea
	
	JPanel buttonPanel = new JPanel();
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	public TimeLogDialog(Frame frame, String title) {
		super(frame, title, true);
		
		this.setResizable(false);
		this.setSize(dialogSize);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		dateFormat.setPlaceholderCharacter('-');
		date.setColumns(6);
		timeFormat.setPlaceholderCharacter('0');
		startTime.setColumns(4);
		endTime.setColumns(4);

		startPanel.add(dateLabel);
		startPanel.add(date);
		startPanel.add(startLabel);
		startPanel.add(startTime);
		
		endPanel.add(endLabel);
		endPanel.add(endTime);
		
		interruptPanel.setPreferredSize(new Dimension(dialogSize.width/3,dialogSize.height-100));
		interruptPanel.setLayout(new BoxLayout(interruptPanel, BoxLayout.Y_AXIS));
		interruptLabel.setHorizontalAlignment(JLabel.CENTER);
		interruptPanel.add(interruptLabel);
		interruptPanel.add(interrupts);
		
		phasePanel.setPreferredSize(new Dimension(dialogSize.width/3,dialogSize.height-100));
		phasePanel.setLayout(new BoxLayout(phasePanel, BoxLayout.Y_AXIS));
		phaseLabel.setHorizontalAlignment(JLabel.CENTER);
		phasePanel.add(Box.createVerticalStrut(15));
		phasePanel.add(phaseLabel);
		phasePanel.add(phase);
		
		commentsPanel.setPreferredSize(new Dimension(dialogSize.width/3,dialogSize.height-100));
		commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));
		commentsLabel.setHorizontalAlignment(JLabel.CENTER);
		// comments.setLineWrap(true);		//For use with JTextArea
		commentsPanel.add(Box.createVerticalStrut(15));
		commentsPanel.add(commentsLabel);
		commentsPanel.add(comments);
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
		mainPanel.add(interruptPanel, BorderLayout.LINE_START);
		mainPanel.add(phasePanel, BorderLayout.CENTER);
		mainPanel.add(commentsPanel, BorderLayout.LINE_END);
		mainPanel.add(endPanel, BorderLayout.PAGE_END);
		
		this.add(mainPanel);
		this.add(Box.createVerticalStrut(10));
		this.add(buttonPanel, BorderLayout.PAGE_END);
		pack();
	}
	
	public TimeLogDialog(Frame frame, String title, String[] initValues) {
		this(frame, title);
		
		date.setText(initValues[0]);
		startTime.setText(initValues[1]);
		endTime.setText(initValues[2]);
		interrupts.setText(initValues[3]);
		phase.setText(initValues[4]);
		comments.setText(initValues[5]);
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
