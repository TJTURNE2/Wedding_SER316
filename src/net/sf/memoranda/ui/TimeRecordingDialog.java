package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TimeRecordingDialog extends JDialog {
	Dimension dialogSize = new Dimension(420,230);
	public boolean isCancelled = true;
	
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	JPanel startPanel = new JPanel(new FlowLayout());
	JLabel dateLabel = new JLabel("Date");
	JTextField date = new JTextField(5);
	JLabel startLabel = new JLabel("Start Time");
	JTextField startTime = new JTextField(5);
	
	JPanel endPanel = new JPanel(new FlowLayout());
	JLabel endLabel = new JLabel("End Time");
	JTextField endTime = new JTextField(5);
	
	
	JPanel interruptPanel = new JPanel();
	JLabel interruptLabel = new JLabel("<html><center>Interrupts<br>(separate by '+')</center></html>");
	JTextField interrupts = new JTextField(5);
	
	JPanel phasePanel = new JPanel();
	JLabel phaseLabel = new JLabel("<html><center>Phase</center></html>");
	JTextField phase = new JTextField(5);
	
	JPanel commentsPanel = new JPanel();
	JLabel commentsLabel = new JLabel("<html><center>Comments</center></html>");
	JTextArea comments = new JTextArea(3, 5);
	JScrollPane scrollPane = new JScrollPane(comments);
	
	JPanel buttonPanel = new JPanel();
	JButton save = new JButton("Save");
	JButton cancel = new JButton("Cancel");
	
	public TimeRecordingDialog(Frame frame, String title) {
		super(frame, title, true);
		
		this.setResizable(false);
		this.setSize(dialogSize);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

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
		comments.setLineWrap(true);
		commentsPanel.add(Box.createVerticalStrut(15));
		commentsPanel.add(commentsLabel);
		commentsPanel.add(scrollPane);
		
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
	
	
}
