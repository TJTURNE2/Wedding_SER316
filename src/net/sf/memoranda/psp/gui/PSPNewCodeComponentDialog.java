package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import net.sf.memoranda.psp.PSPProjectCodeComponent;
import net.sf.memoranda.psp.PSPProjectCodeComponent.PSPProjectComponentType;
import net.sf.memoranda.psp.PSPProjectManager;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.sf.memoranda.psp.PSPProjectCodeComponent.PSPProjectComponentType;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PSPNewCodeComponentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeComponentDialog nd = new PSPNewCodeComponentDialog();
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewCodeComponentDialog() {
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(new BorderLayout());
		{
			JToolBar toolBar = new JToolBar();
			toolBar.setPreferredSize(new Dimension(13, 35));
			toolBar.setFloatable(false);
			getContentPane().add(toolBar, BorderLayout.NORTH);
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][:350px:350px,grow]", "[][][][][][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Module");
			contentPanel.add(lblNewLabel, "cell 0 1,alignx trailing");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 1 1,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Type");
			contentPanel.add(lblNewLabel_4, "cell 0 2,alignx right");
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(PSPProjectComponentType.values()));
			contentPanel.add(comboBox, "cell 1 2,alignx left");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Purpose");
			contentPanel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "cell 1 3,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Function");
			contentPanel.add(lblNewLabel_2, "cell 0 4,alignx trailing");
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2, "cell 1 4,growx");
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Data");
			contentPanel.add(lblNewLabel_3, "cell 0 5,alignx trailing");
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3, "cell 1 5,growx");
			textField_3.setColumns(10);
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
