package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.PSPProjectRequirement;
import net.sf.memoranda.psp.PSPProject.PSPType;
import net.sf.memoranda.psp.PSPProjectCodeReview;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectCatagory;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectSeverity;
import net.sf.memoranda.psp.PSPProjectRequirement.PSPRequirementType;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PSPNewCodeReviewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField locationTextField;
	private JTextArea descriptionTextArea;
	private JComboBox catagoryComboBox;
	private JComboBox severityComboBox;
	private PSPProjectManager Manager;
	private static int ProjectID = 0;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeReviewDialog nd = new PSPNewCodeReviewDialog(ProjectID);
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewCodeReviewDialog(int pID) {
		ProjectID =pID;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(new BorderLayout());
		{
			JToolBar toolBar = new JToolBar();
			getContentPane().add(toolBar, BorderLayout.NORTH);
			toolBar.setFloatable(false);
			toolBar.setPreferredSize(new Dimension(13, 35));
			{
				JLabel lblNewLabel = new JLabel("New Code Review - updateicon#");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				toolBar.add(lblNewLabel);
			}
		}
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][grow][][]"));
		{
			JLabel lblNewLabel_1 = new JLabel("Location");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel_1, "cell 0 1");
		}
		{
			locationTextField = new JTextField();
			locationTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(locationTextField, "cell 2 1,growx");
			locationTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel_2, "cell 0 3");
		}
		{
			 descriptionTextArea = new JTextArea();
			descriptionTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			contentPanel.add(descriptionTextArea, "cell 2 3,grow");
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Catagory");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel_4, "cell 0 4");
		}
		{
			 catagoryComboBox = new JComboBox();
			catagoryComboBox.setModel(new DefaultComboBoxModel(PSPDefectCatagory.values()));
			contentPanel.add(catagoryComboBox, "cell 2 4,alignx left");
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Severity");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPanel.add(lblNewLabel_5, "cell 0 5");
		}
		{
			 severityComboBox = new JComboBox();
			severityComboBox.setModel(new DefaultComboBoxModel(PSPDefectSeverity.values()));
			contentPanel.add(severityComboBox, "cell 2 5");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Manager = new PSPProjectManager();
						PSPProjectCodeReview entry = new PSPProjectCodeReview();
						entry.setCatagory((PSPDefectCatagory)catagoryComboBox.getSelectedItem());
						entry.setDescription(descriptionTextArea.getText());
						entry.setLocation(locationTextField.getText());
						entry.setServerity( (PSPDefectSeverity)severityComboBox.getSelectedItem());
						Manager.getProject(pID).addReviews(entry);
						try {
							Manager.saveProjects();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
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
