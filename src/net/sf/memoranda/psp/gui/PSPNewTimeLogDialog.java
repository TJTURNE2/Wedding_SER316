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
import java.awt.Color;
import javax.swing.ImageIcon;

public class PSPNewTimeLogDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PSPNewTimeLogDialog dialog = new PSPNewTimeLogDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewTimeLogDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel topPanel = new JPanel();
			topPanel.setBackground(Color.WHITE);
			topPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			topPanel.setPreferredSize(new Dimension(10, 50));
			getContentPane().add(topPanel, BorderLayout.NORTH);
			{
				JLabel lblLogTitle = new JLabel("Log Entry");
				lblLogTitle.setPreferredSize(new Dimension(100, 50));
				lblLogTitle.setIcon(new ImageIcon(PSPNewTimeLogDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
				topPanel.add(lblLogTitle);
			}
		}
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
