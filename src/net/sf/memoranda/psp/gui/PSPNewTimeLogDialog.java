package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.io.IOException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PSPNewTimeLogDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewTimeLogDialog nd = new PSPNewTimeLogDialog();
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewTimeLogDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel topPanel = new JPanel();
			topPanel.setBackground(Color.WHITE);
			topPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(topPanel, BorderLayout.NORTH);
			{
				JLabel lblLogTitle = new JLabel("Time Log Entry");
				lblLogTitle.setPreferredSize(new Dimension(120, 30));
				lblLogTitle.setIcon(new ImageIcon(PSPNewTimeLogDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
				topPanel.add(lblLogTitle);
			}
		}
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblComments = new JLabel("Comments");
			contentPanel.add(lblComments);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(40);
		}
		{
			JLabel lblPlanSize = new JLabel("Plan Size");
			lblPlanSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblPlanSize);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner.setPreferredSize(new Dimension(50, 30));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			contentPanel.add(spinner);
		}
		{
			JLabel lblActualSize = new JLabel("Actual Size");
			lblActualSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblActualSize);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner.setPreferredSize(new Dimension(50, 30));
			contentPanel.add(spinner);
		}
		{
			JLabel lblToDateSize = new JLabel("To Date Size");
			lblToDateSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblToDateSize);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner.setPreferredSize(new Dimension(50, 30));
			contentPanel.add(spinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setPreferredSize(new Dimension(70, 25));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setPreferredSize(new Dimension(70, 25));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
