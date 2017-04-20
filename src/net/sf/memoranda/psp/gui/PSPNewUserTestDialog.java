package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.PSPProjectRequirement;
import net.sf.memoranda.psp.PSPProjectTestCase;
import net.sf.memoranda.psp.PSPProjectTestCase.PSPProjectTestCaseStatus;
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.RequirementTableModel;
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.UserTestTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class PSPNewUserTestDialog extends JDialog {

	private PSPProjectTestCase entry;
	private static UserTestTableModel Model = null;
	private static PSPProjectManager Manager;
	private static int ProjectID;
	private final JPanel contentPanel = new JPanel();
	private JTextField moduleTextField;
	private JTextField titleTextField;
	private JTextField descriptionTextField;
	private JTextField designedByTextField;
	private JTextField preConditionTextField;
	private JTextField expectedTextField;
	private JTextField actualTextField;
	private JTextArea notesTextArea;
	private JComboBox statusComboBox;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewUserTestDialog nd = new PSPNewUserTestDialog(ProjectID, Model);
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewUserTestDialog(int pID, UserTestTableModel model) {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}

			public void windowLostFocus(WindowEvent arg0) {
				dispose();
			}
		});
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
			panel.setPreferredSize(new Dimension(150, 35));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel_9 = new JLabel("New User Test");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				panel.add(lblNewLabel_9);
			}
		}
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][grow]"));
		{
			JLabel lblNewLabel = new JLabel("Module Name");
			contentPanel.add(lblNewLabel, "cell 0 0,alignx trailing");
		}
		{
			moduleTextField = new JTextField();
			contentPanel.add(moduleTextField, "cell 1 0,growx");
			moduleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Title");
			contentPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		}
		{
			titleTextField = new JTextField();
			contentPanel.add(titleTextField, "cell 1 1,growx");
			titleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			contentPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		}
		{
			descriptionTextField = new JTextField();
			contentPanel.add(descriptionTextField, "cell 1 2,growx");
			descriptionTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Designed By");
			contentPanel.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		}
		{
			designedByTextField = new JTextField();
			contentPanel.add(designedByTextField, "cell 1 3,growx");
			designedByTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Pre Conditions");
			contentPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		}
		{
			preConditionTextField = new JTextField();
			contentPanel.add(preConditionTextField, "cell 1 4,growx");
			preConditionTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Expected Results");
			contentPanel.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		}
		{
			expectedTextField = new JTextField();
			contentPanel.add(expectedTextField, "cell 1 5,growx");
			expectedTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Actual Result");
			contentPanel.add(lblNewLabel_6, "cell 0 6,alignx trailing");
		}
		{
			actualTextField = new JTextField();
			contentPanel.add(actualTextField, "cell 1 6,growx");
			actualTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Status");
			contentPanel.add(lblNewLabel_7, "cell 0 7,alignx trailing");
		}
		{
			statusComboBox = new JComboBox();
			statusComboBox.setModel(new DefaultComboBoxModel(PSPProjectTestCaseStatus.values()));
			contentPanel.add(statusComboBox, "cell 1 7");
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Notes");
			contentPanel.add(lblNewLabel_8, "cell 0 8,alignx right");
		}
		{
			notesTextArea = new JTextArea();
			notesTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			contentPanel.add(notesTextArea, "cell 1 8,grow");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						entry = new PSPProjectTestCase();
						entry.setDescription(descriptionTextField.getText());
						entry.setModuleName(moduleTextField.getText());
						entry.setNotes(notesTextArea.getText());
						entry.setStatus((PSPProjectTestCaseStatus) statusComboBox.getSelectedItem());
						entry.setExpectedResults(expectedTextField.getText());
						entry.setActualResults(actualTextField.getText());
						entry.setTestTitle(titleTextField.getText());
						entry.setPreConditions(preConditionTextField.getText());
						entry.setDesignedBy(designedByTextField.getText());
						Manager = new PSPProjectManager();
						Manager.getProject(pID).addUserTests(entry);
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
