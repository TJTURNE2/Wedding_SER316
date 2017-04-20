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
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.DefectTableModel;
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
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PSPNewDefectDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static PSPProjectManager Manager;
	private static DefectTableModel Model;
	private static int ProjectID;
	private PSPProjectDefectEntry entry;
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
	private JTextArea descriptionTextArea;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {

		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewDefectDialog nd = new PSPNewDefectDialog(ProjectID, Model);
				nd.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewDefectDialog(int pID, DefectTableModel model) {
		ProjectID = pID;
		setBounds(100, 100, 500, 378);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel topPanel = new JPanel();
			topPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
			FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
			fl_topPanel.setAlignment(FlowLayout.LEFT);
			topPanel.setBackground(Color.WHITE);
			getContentPane().add(topPanel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("New Defect");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setPreferredSize(new Dimension(150, 40));
				lblNewLabel.setIcon(new ImageIcon(PSPNewDefectDialog.class
						.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
				topPanel.add(lblNewLabel);
			}
		}
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblDefectType = new JLabel("Defect Type");
			lblDefectType.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPhaseRemoved = new JLabel("Phase Removed");
			lblPhaseRemoved.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.setLayout(
					new MigLayout("", "[70px][150px,grow][52px][64px]", "[20px,grow][20px][20px][20px][26px][][]"));
			JLabel lblDescription = new JLabel("Description");
			lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblDescription, "cell 0 0,alignx left,growy");
			{
				descriptionTextArea = new JTextArea();
				descriptionTextArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
				contentPanel.add(descriptionTextArea, "cell 1 0,grow");
			}
			{
				JLabel lblFileName = new JLabel("File Name");
				lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				contentPanel.add(lblFileName, "flowx,cell 0 1,alignx left,aligny center");
			}
			{
				fileNameTextField = new JTextField();
				contentPanel.add(fileNameTextField, "cell 1 1,alignx center,aligny center");
				fileNameTextField.setColumns(33);
			}
			contentPanel.add(lblDefectType, "cell 0 2,alignx left,aligny center");
			{
				defectTypeComboBox = new JComboBox();
				defectTypeComboBox.setModel(new DefaultComboBoxModel(PSPDefectType.values()));
				contentPanel.add(defectTypeComboBox, "cell 1 2,growx,aligny top");
			}
			contentPanel.add(lblPhaseRemoved, "cell 0 3,alignx left,aligny center");
			{
				phaseRemovedComboBox = new JComboBox();
				phaseRemovedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
				contentPanel.add(phaseRemovedComboBox, "cell 1 3,growx,aligny top");
			}
		}
		JLabel lblPhaseInjected = new JLabel("Phase Injected");
		lblPhaseInjected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblPhaseInjected, "cell 0 4,alignx left,aligny center");
		{
			phaseInjectedComboBox = new JComboBox();
			phaseInjectedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
			contentPanel.add(phaseInjectedComboBox, "flowx,cell 1 4,growx,aligny top");
		}

		JLabel lblDateFound = new JLabel("Date Found");
		lblDateFound.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblDateFound, "cell 0 5,alignx left,aligny center");
		dateFound = new JDateChooser();
		contentPanel.add(dateFound, "flowx,cell 1 5,alignx left,aligny top");
		lblTimeFixing = new JLabel("Fixing Time");
		lblTimeFixing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblTimeFixing, "cell 0 6,alignx left,aligny top");
		{
			txtPlaceForTime = new JTextField();
			txtPlaceForTime.setText("Place for time picker");
			contentPanel.add(txtPlaceForTime, "cell 1 6,alignx left,aligny top");
			txtPlaceForTime.setColumns(10);
		}
		{
			JLabel lblSeverity = new JLabel("Severity");
			lblSeverity.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblSeverity, "cell 1 5,alignx left,aligny center");
		}
		{
			serveritySpinner = new JSpinner();
			serveritySpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
			serveritySpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(serveritySpinner, "cell 1 5,growx,aligny top");
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
						entry = new PSPProjectDefectEntry();
						entry.setDefectType((PSPDefectType) defectTypeComboBox.getSelectedItem());
						entry.setDescription(descriptionTextArea.getText());
						entry.setPhaseInjected((PSPProjectPhase) phaseInjectedComboBox.getSelectedItem());
						entry.setPhaseRemoved((PSPProjectPhase) phaseRemovedComboBox.getSelectedItem());
						entry.setFileName(fileNameTextField.getText());
						entry.setSeverity((int) serveritySpinner.getValue());
						entry.setDateFound(dateFound.getDate());
						Manager = new PSPProjectManager();
						Manager.getProject(pID).addDefectEntry(entry);
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

}
