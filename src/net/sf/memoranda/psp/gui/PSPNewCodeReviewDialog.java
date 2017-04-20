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
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.sf.memoranda.psp.PSPProjectCodeComponent;
import net.sf.memoranda.psp.PSPProjectCodeReview;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectCatagory;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectSeverity;
import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.UserReviewTableModel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class PSPNewCodeReviewDialog extends JDialog {

	private PSPProjectManager Manager;
	private static int ProjectID;
	private PSPProjectCodeReview entry;
	private static UserReviewTableModel Model;
	private JComboBox severityComboBox;
	private JComboBox categoryComboBox;
	private JTextArea descriptionTextArea;
	private final JPanel contentPanel = new JPanel();
	private JTextField locationTextField;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {

		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeReviewDialog nd = new PSPNewCodeReviewDialog(ProjectID, Model);
				nd.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewCodeReviewDialog(int pID, UserReviewTableModel model) {
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

		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][grow][][]"));
		{
			JLabel lblNewLabel_1 = new JLabel("Location");
			contentPanel.add(lblNewLabel_1, "cell 0 1");
		}
		{
			locationTextField = new JTextField();
			contentPanel.add(locationTextField, "cell 2 1,growx");
			locationTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			contentPanel.add(lblNewLabel_2, "cell 0 3");
		}
		{
			descriptionTextArea = new JTextArea();
			descriptionTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
			contentPanel.add(descriptionTextArea, "cell 2 3,grow");
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Category");
			contentPanel.add(lblNewLabel_4, "cell 0 4");
		}
		{
			categoryComboBox = new JComboBox();
			categoryComboBox.setModel(new DefaultComboBoxModel(PSPDefectCatagory.values()));
			contentPanel.add(categoryComboBox, "cell 2 4,alignx left");
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Severity");
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
						entry = new PSPProjectCodeReview();
						entry.setLocation(locationTextField.getText());
						entry.setCatagory((PSPDefectCatagory) categoryComboBox.getSelectedItem());
						entry.setServerity((PSPDefectSeverity) severityComboBox.getSelectedItem());
						entry.setDescription(descriptionTextArea.getText());
						Manager = new PSPProjectManager();
						Manager.getProject(pID).addReviews(entry);
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
		{
			JToolBar toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(Color.LIGHT_GRAY));
			getContentPane().add(toolBar, BorderLayout.NORTH);
			toolBar.setFloatable(false);
			toolBar.setPreferredSize(new Dimension(13, 35));
			{
				JLabel lblNewCodeReview = new JLabel("New Code Review");
				lblNewCodeReview.setFont(new Font("Tahoma", Font.PLAIN, 15));
				toolBar.add(lblNewCodeReview);
			}
		}
	}

}
