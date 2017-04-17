package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.PSPProjectRequirement;
import net.sf.memoranda.psp.PSPProjectRequirement.PSPRequirementType;
import net.sf.memoranda.psp.PSPProjectTestCase;
import net.sf.memoranda.psp.PSPProjectTestCase.PSPProjectTestCaseStatus;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PSPNewUserTestDialog extends JDialog {

	private final JPanel userTestContentPanel = new JPanel();
	private PSPProjectManager Manager;
	private static int ProjectID = 0;
	private JTextField moduleTextField;
	private JTextField titleTextField;
	private JTextField descriptionTextField;
	private JTextField designedByTextField;
	private JTextField preConditionTextField;
	private JTextField expectedResultsTextField;
	private JTextField actualResultsTextField;
	private JComboBox statusComboBox;
	private JTextArea notesTestArea;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewUserTestDialog nd = new PSPNewUserTestDialog(ProjectID);
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewUserTestDialog(int pID) {
		ProjectID =pID;
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 35));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel_9 = new JLabel("New User Test -updateicon#");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblNewLabel_9);
			}
		}
		userTestContentPanel.setBackground(Color.WHITE);
		userTestContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(userTestContentPanel, BorderLayout.CENTER);
		userTestContentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][grow]"));
		{
			JLabel lblNewLabel = new JLabel("Module Name");
			userTestContentPanel.add(lblNewLabel, "cell 0 0,alignx trailing");
		}
		{
			moduleTextField = new JTextField();
			userTestContentPanel.add(moduleTextField, "cell 1 0,growx");
			moduleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Title");
			userTestContentPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		}
		{
			titleTextField = new JTextField();
			userTestContentPanel.add(titleTextField, "cell 1 1,growx");
			titleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			userTestContentPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		}
		{
			descriptionTextField = new JTextField();
			userTestContentPanel.add(descriptionTextField, "cell 1 2,growx");
			descriptionTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Designed By");
			userTestContentPanel.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		}
		{
			designedByTextField = new JTextField();
			userTestContentPanel.add(designedByTextField, "cell 1 3,growx");
			designedByTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Pre Conditions");
			userTestContentPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		}
		{
			preConditionTextField = new JTextField();
			userTestContentPanel.add(preConditionTextField, "cell 1 4,growx");
			preConditionTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Expected Results");
			userTestContentPanel.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		}
		{
			expectedResultsTextField = new JTextField();
			userTestContentPanel.add(expectedResultsTextField, "cell 1 5,growx");
			expectedResultsTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Actual Result");
			userTestContentPanel.add(lblNewLabel_6, "cell 0 6,alignx trailing");
		}
		{
			actualResultsTextField = new JTextField();
			userTestContentPanel.add(actualResultsTextField, "cell 1 6,growx");
			actualResultsTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Status");
			userTestContentPanel.add(lblNewLabel_7, "cell 0 7,alignx trailing");
		}
		{
			 statusComboBox = new JComboBox();
			statusComboBox.setModel(new DefaultComboBoxModel(PSPProjectTestCaseStatus.values()));
			userTestContentPanel.add(statusComboBox, "cell 1 7");
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Notes");
			userTestContentPanel.add(lblNewLabel_8, "cell 0 8,alignx right");
		}
		{
			notesTestArea = new JTextArea();
			notesTestArea.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			userTestContentPanel.add(notesTestArea, "cell 1 8,grow");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Manager = new PSPProjectManager();
						PSPProjectTestCase entry = new PSPProjectTestCase();
						entry.setActualResults(actualResultsTextField.getText());
						entry.setDesignedBy(designedByTextField.getText());
						entry.setModuleName(moduleTextField.getText());
						entry.setPreConditions(preConditionTextField.getText());
						entry.setStatus((PSPProjectTestCaseStatus)statusComboBox.getSelectedItem());
						entry.setNotes(notesTestArea.getText());
						entry.setExpectedResults(expectedResultsTextField.getText());
						entry.setTestTitle(titleTextField.getText());
						Manager.getProject(ProjectID).addUserTests(entry);
						try {
							Manager.saveProjects();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							Manager.saveProjects();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
