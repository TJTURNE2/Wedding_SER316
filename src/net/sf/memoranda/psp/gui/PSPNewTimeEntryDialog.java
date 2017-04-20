package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.memoranda.psp.PSPProjectManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.sf.memoranda.psp.PSPProjectPhase;
import net.sf.memoranda.psp.PSPProjectTimeLogEntry;
import net.sf.memoranda.psp.PSPProject.PSPType;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSPNewTimeEntryDialog extends JDialog {
	private static PSPProjectManager Manager;
	private static int ProjectID = 0;
	private final JPanel contentPanel = new JPanel();
	private JTextField commentsTextField;
	private JSpinner entryDateSpinner;
	private JSpinner startingTimeSpinner;
	private JSpinner stoppingTimeSpinner;
	private JComboBox phaseComboBox;
	


	/**
	 * Create the dialog.
	 */
	public PSPNewTimeEntryDialog(int pID) {
		ProjectID =pID;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel lblNewLabel = new JLabel("New Time Entry");
				lblNewLabel.setPreferredSize(new Dimension(300, 30));
				lblNewLabel.setIcon(new ImageIcon(PSPNewTimeEntryDialog.class.getResource("/net/sf/memoranda/ui/resources/icons/notify.png")));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblNewLabel);
			}
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblComments = new JLabel("Comments");
			contentPanel.add(lblComments);
		}
		{
			commentsTextField = new JTextField();
			contentPanel.add(commentsTextField);
			commentsTextField.setColumns(40);
		}
		{
			JLabel lblEntryDate = new JLabel("Entry Date");
			contentPanel.add(lblEntryDate);
		}
		{
			entryDateSpinner = new JSpinner();
			entryDateSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_WEEK));
			contentPanel.add(entryDateSpinner);
		}
		{
			JLabel lblStartingTime = new JLabel("Starting Time");
			contentPanel.add(lblStartingTime);
		}
		{
			startingTimeSpinner = new JSpinner();
			startingTimeSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(startingTimeSpinner);
		}
		{
			JLabel lblStoppingTime = new JLabel("Stopping Time");
			contentPanel.add(lblStoppingTime);
		}
		{
			stoppingTimeSpinner = new JSpinner();
			stoppingTimeSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(stoppingTimeSpinner);
		}
		{
			JLabel lblPhase = new JLabel("Phase");
			contentPanel.add(lblPhase);
		}
		{
			phaseComboBox = new JComboBox();
			phaseComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
			contentPanel.add(phaseComboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PSPProjectTimeLogEntry entry = new PSPProjectTimeLogEntry();
						entry.setComments(commentsTextField.getText());
						entry.setEntryDate((Date)entryDateSpinner.getValue());
						//entry.setStartingTime((Time)startingTimeSpinner.getValue());  // need to fix 
						//entry.setStoppingTime((Time)stoppingTimeSpinner.getValue());
						entry.setPhase((PSPProjectPhase)phaseComboBox.getSelectedItem());
						try {
							Manager = new PSPProjectManager();
							Manager.getAllProjects().get(ProjectID).addTimeEntry(entry);
							Manager.saveProjects();
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			 PSPNewTimeEntryDialog nd = new PSPNewTimeEntryDialog(ProjectID);
				nd.setVisible(true);
			}
		});
	}
}
