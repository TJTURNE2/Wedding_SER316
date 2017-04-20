package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.TimeLogTableModel;
import net.sf.memoranda.psp.PSPProject.PSPType;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PSPNewTimeEntryDialog extends JDialog {
	private static PSPProjectManager Manager;
	private static int ProjectID = 0;
	private PSPProjectTimeLogEntry entry;
	private final JPanel contentPanel = new JPanel();
	private static TimeLogTableModel Model;
	private JSpinner entryDateSpinner;
	private JSpinner startingTimeSpinner;
	private JSpinner stoppingTimeSpinner;
	//dateFound = new JDateChooser();
	private JDateChooser entryDate;
	private JComboBox phaseComboBox;
	private JTextArea commentTextArea;


	/**
	 * Create the dialog.
	 */
	public PSPNewTimeEntryDialog(int pID, TimeLogTableModel model) {
		Model = model;
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}

			public void windowLostFocus(WindowEvent arg0) {
				dispose();
			}
		});
		ProjectID = pID;
		
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
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
		contentPanel.setLayout(new MigLayout("", "[50px][200,grow]", "[20px,grow][20px][20px][][]"));
		{
			JLabel lblComments = new JLabel("Comments");
			contentPanel.add(lblComments, "flowx,cell 0 0,alignx left,aligny center");
		}
		{
			commentTextArea = new JTextArea();
			commentTextArea.setBorder(new LineBorder(Color.BLACK, 1, true));
			contentPanel.add(commentTextArea, "cell 1 0,grow");
		}
		{
			JLabel lblEntryDate = new JLabel("Entry Date");
			contentPanel.add(lblEntryDate, "flowx,cell 0 1,alignx left,aligny center");
		}
		{
			entryDate = new JDateChooser();
			entryDateSpinner = new JSpinner();
			entryDateSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_WEEK));
//			contentPanel.add(entryDateSpinner, "cell 1 1,alignx left,aligny top");
			contentPanel.add(entryDate);
		}
		{
			JLabel lblStartingTime = new JLabel("Starting Time");
			contentPanel.add(lblStartingTime, "flowx,cell 0 2,alignx left,aligny center");
		}
		{
			startingTimeSpinner = new JSpinner();
			startingTimeSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(startingTimeSpinner, "cell 1 2,alignx left,aligny top");
		}
		{
			JLabel lblStoppingTime = new JLabel("Stopping Time");
			contentPanel.add(lblStoppingTime, "flowx,cell 0 3,alignx left,aligny center");
		}
		{
			stoppingTimeSpinner = new JSpinner();
			stoppingTimeSpinner.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(stoppingTimeSpinner, "cell 1 3,alignx left,aligny top");
		}
		{
			JLabel lblPhase = new JLabel("Phase");
			contentPanel.add(lblPhase, "cell 0 4,alignx left,aligny center");
		}
		{
			phaseComboBox = new JComboBox();
			phaseComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
			contentPanel.add(phaseComboBox, "cell 1 4,alignx left,aligny top");
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
						entry = new PSPProjectTimeLogEntry();
						entry.setComments(commentTextArea.getText());
						entry.setEntryDate(entryDate.getDate());
						//entry.setStartingTime((Time)startingTimeSpinner.getValue());
						//entry.setStoppingTime((Time)stoppingTimeSpinner.getValue());
						entry.setPhase((PSPProjectPhase)phaseComboBox.getSelectedItem());
							Manager = new PSPProjectManager();
							Manager.getProject(pID).addTimeEntry(entry);
							Manager.saveProjects();
							model.fireTableDataChanged();
							dispose();
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
			 PSPNewTimeEntryDialog nd = new PSPNewTimeEntryDialog(ProjectID, Model);
				nd.setVisible(true);
			}
		});
	}
}
