package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.sf.memoranda.psp.PSPProjectPhase;
import net.sf.memoranda.psp.PSPProjectTimeLogEntry;
import net.sf.memoranda.psp.PSPProjectDefectEntry;
import net.sf.memoranda.psp.PSPProjectDefectEntry.PSPDefectType;
import net.sf.memoranda.psp.PSPProjectManager;

import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import javax.swing.SpringLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PSPNewDefectDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	PSPProjectManager Manager;
	private static int ProjectID = 0;
	private JTextField descriptionTextField;
	private JTextField txtPlaceForTime;
	private JLabel lblTimeFixing;
	private JComboBox phaseInjectedComboBox;
	private JComboBox defectTypeComboBox;
	private JLabel lblDefectType;
	private JLabel lblPhaseRemoved;
	private JTextField fileNameTextField;
	private JComboBox phaseRemovedComboBox;
	private JSpinner serveritySpinner;
	private JDateChooser dateFound;
	
	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewDefectDialog nd = new PSPNewDefectDialog(ProjectID);
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewDefectDialog(int pID) {
		ProjectID = pID;
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel topPanel = new JPanel();
			FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
			fl_topPanel.setAlignment(FlowLayout.LEFT);
			topPanel.setBackground(Color.WHITE);
			getContentPane().add(topPanel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("New Defect");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setPreferredSize(new Dimension(150, 40));
				lblNewLabel.setIcon(new ImageIcon(PSPNewDefectDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
				topPanel.add(lblNewLabel);
			}
		}
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			dateFound= new JDateChooser();

			
			JLabel lblDateFound = new JLabel("Date Found");
			lblDateFound.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDefectType = new JLabel("Defect Type");
			lblDefectType.setFont(new Font("Tahoma", Font.PLAIN, 15));
			JLabel lblPhaseInjected = new JLabel("Phase Injected");
			lblPhaseInjected.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPhaseRemoved = new JLabel("Phase Removed");
			lblPhaseRemoved.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTimeFixing = new JLabel("Fixing Time");
			lblTimeFixing.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			JLabel lblDescription = new JLabel("Description");
			lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblDescription);
			{
				descriptionTextField = new JTextField();
				contentPanel.add(descriptionTextField);
				descriptionTextField.setColumns(40);
			}
			{
				JLabel lblFileName = new JLabel("File Name");
				lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblFileName);
			}
			{
				fileNameTextField = new JTextField();
				contentPanel.add(fileNameTextField);
				fileNameTextField.setColumns(33);
			}
			contentPanel.add(lblDateFound);
			contentPanel.add(dateFound);
			contentPanel.add(lblDefectType);
			{
				defectTypeComboBox = new JComboBox();
				defectTypeComboBox.setModel(new DefaultComboBoxModel(PSPDefectType.values()));
				contentPanel.add(defectTypeComboBox);
			}
			contentPanel.add(lblPhaseInjected);
			{
				phaseInjectedComboBox = new JComboBox();
				phaseInjectedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
				contentPanel.add(phaseInjectedComboBox);
			}
			contentPanel.add(lblPhaseRemoved);
			{
				phaseRemovedComboBox = new JComboBox();
				phaseRemovedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
				contentPanel.add(phaseRemovedComboBox);
			}
			contentPanel.add(lblTimeFixing);
		}
		{
			txtPlaceForTime = new JTextField();
			txtPlaceForTime.setText("Place for time picker");
			contentPanel.add(txtPlaceForTime);
			txtPlaceForTime.setColumns(10);
		}
		{
			JLabel lblSeverity = new JLabel("Severity");
			lblSeverity.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblSeverity);
		}
		{
			serveritySpinner = new JSpinner();
			serveritySpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
			serveritySpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(serveritySpinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PSPProjectDefectEntry entry = new PSPProjectDefectEntry();
						entry.setDefectType((PSPDefectType)defectTypeComboBox.getSelectedItem());
						entry.setDescription(descriptionTextField.getText());
						entry.setPhaseInjected((PSPProjectPhase)phaseInjectedComboBox.getSelectedItem());
						entry.setPhaseRemoved((PSPProjectPhase)phaseRemovedComboBox.getSelectedItem());
						entry.setFileName(fileNameTextField.getText());
						entry.setSeverity((int)serveritySpinner.getValue());
						entry.setDateFound(dateFound.getDate());
						try {
							Manager = new PSPProjectManager();
							Manager.getAllProjects().get(ProjectID).addDefectEntry(entry);
							Manager.saveProjects();
							dispose();
						} catch (IOException e1) {
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

}
