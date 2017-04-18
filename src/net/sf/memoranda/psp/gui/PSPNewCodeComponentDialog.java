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

@SuppressWarnings("serial")
public class PSPNewCodeComponentDialog extends JDialog {

	private final JPanel codeContentPanel = new JPanel();
	private PSPProjectManager Manager;
	private static int ProjectID = 0;
	private JTextField moduleTextField;
	private JTextField purposeTextField;
	private JTextField functionTextField;
	private JTextField dataTextField;
	private JComboBox<PSPProjectComponentType> typeComboBox;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeComponentDialog nd = new PSPNewCodeComponentDialog(ProjectID);
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewCodeComponentDialog(int pID) {
		ProjectID =pID;
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(new BorderLayout());
		{
			JToolBar toolBar = new JToolBar();
			toolBar.setPreferredSize(new Dimension(13, 35));
			toolBar.setFloatable(false);
			getContentPane().add(toolBar, BorderLayout.NORTH);
			{
				JLabel lblNewLabel_5 = new JLabel("New Code Module - updateicon#");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
				toolBar.add(lblNewLabel_5);
			}
		}
		codeContentPanel.setBackground(Color.WHITE);
		codeContentPanel.setBorder(new CompoundBorder(new EmptyBorder(2, 0, 2, 0), null));
		getContentPane().add(codeContentPanel, BorderLayout.CENTER);
		codeContentPanel.setLayout(new MigLayout("", "[][:350px:350px,grow]", "[][][][][][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Module");
			codeContentPanel.add(lblNewLabel, "cell 0 1,alignx trailing");
		}
		{
			moduleTextField = new JTextField();
			codeContentPanel.add(moduleTextField, "cell 1 1,growx");
			moduleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Type");
			codeContentPanel.add(lblNewLabel_4, "cell 0 2,alignx right");
		}
		{
		 typeComboBox = new JComboBox();
			typeComboBox.setModel(new DefaultComboBoxModel(PSPProjectComponentType.values()));
			codeContentPanel.add(typeComboBox, "cell 1 2,alignx left");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Purpose");
			codeContentPanel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		}
		{
			purposeTextField = new JTextField();
			codeContentPanel.add(purposeTextField, "cell 1 3,growx");
			purposeTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Function");
			codeContentPanel.add(lblNewLabel_2, "cell 0 4,alignx trailing");
		}
		{
			functionTextField = new JTextField();
			codeContentPanel.add(functionTextField, "cell 1 4,growx");
			functionTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Data");
			codeContentPanel.add(lblNewLabel_3, "cell 0 5,alignx trailing");
		}
		{
			dataTextField = new JTextField();
			codeContentPanel.add(dataTextField, "cell 1 5,growx");
			dataTextField.setColumns(10);
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
						PSPProjectCodeComponent entry = new PSPProjectCodeComponent();
						entry.setModule(moduleTextField.getText());
						entry.setFunction(functionTextField.getText());
						entry.setPurpose(purposeTextField.getText());
						entry.setType((PSPProjectComponentType)typeComboBox.getSelectedItem());
						entry.setData(dataTextField.getText());
						Manager.getProject(pID).addComponents(entry);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
