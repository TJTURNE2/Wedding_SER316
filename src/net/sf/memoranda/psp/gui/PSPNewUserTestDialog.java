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
import net.sf.memoranda.psp.PSPProjectTestCase.PSPProjectTestCaseStatus;

@SuppressWarnings("serial")
public class PSPNewUserTestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewUserTestDialog nd = new PSPNewUserTestDialog();
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewUserTestDialog() {
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 35));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panel, BorderLayout.NORTH);
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][grow]"));
		{
			JLabel lblNewLabel = new JLabel("Module Name");
			contentPanel.add(lblNewLabel, "cell 0 0,alignx trailing");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 1 0,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Title");
			contentPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "cell 1 1,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			contentPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2, "cell 1 2,growx");
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Designed By");
			contentPanel.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3, "cell 1 3,growx");
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Pre Conditions");
			contentPanel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4, "cell 1 4,growx");
			textField_4.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Expected Results");
			contentPanel.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		}
		{
			textField_5 = new JTextField();
			contentPanel.add(textField_5, "cell 1 5,growx");
			textField_5.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Actual Result");
			contentPanel.add(lblNewLabel_6, "cell 0 6,alignx trailing");
		}
		{
			textField_6 = new JTextField();
			contentPanel.add(textField_6, "cell 1 6,growx");
			textField_6.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Status");
			contentPanel.add(lblNewLabel_7, "cell 0 7,alignx trailing");
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(PSPProjectTestCaseStatus.values()));
			contentPanel.add(comboBox, "cell 1 7");
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Notes");
			contentPanel.add(lblNewLabel_8, "cell 0 8,alignx right");
		}
		{
			JTextArea textArea = new JTextArea();
			contentPanel.add(textArea, "cell 1 8,grow");
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
