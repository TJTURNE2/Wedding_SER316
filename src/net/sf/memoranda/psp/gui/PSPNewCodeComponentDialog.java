package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
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
import net.sf.memoranda.psp.gui.PSPProjectsOverviewPanel.ComponentTableModel;

import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.sf.memoranda.psp.PSPProjectCodeComponent.PSPProjectComponentType;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PSPNewCodeComponentDialog extends JDialog {
	private static PSPProjectManager Manager;
	private PSPProjectCodeComponent entry;
	private static int ProjectID;
	private static ComponentTableModel Model;
	private final JPanel contentPanel = new JPanel();
	private JTextField moduleTextField;
	private JTextField purposeTextField;
	private JTextField functionTextField;
	private JComboBox typeComboBox;
	private JTextArea dataTextArea;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {

		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeComponentDialog nd = new PSPNewCodeComponentDialog(ProjectID, Model);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewCodeComponentDialog(int pID, ComponentTableModel model) {
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
		{
			JToolBar toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(Color.LIGHT_GRAY));
			toolBar.setPreferredSize(new Dimension(13, 35));
			toolBar.setFloatable(false);
			getContentPane().add(toolBar, BorderLayout.NORTH);
			{
				JLabel lblNewLabel_5 = new JLabel("New Code Module");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
				toolBar.add(lblNewLabel_5);
			}
		}
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][:350px:350px,grow]", "[][][][][][grow][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Module");
			contentPanel.add(lblNewLabel, "cell 0 1,alignx trailing");
		}
		{
			moduleTextField = new JTextField();
			contentPanel.add(moduleTextField, "cell 1 1,growx");
			moduleTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Type");
			contentPanel.add(lblNewLabel_4, "cell 0 2,alignx right");
		}
		{
			 typeComboBox = new JComboBox();
			typeComboBox.setModel(new DefaultComboBoxModel(PSPProjectComponentType.values()));
			contentPanel.add(typeComboBox, "cell 1 2,alignx left");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Purpose");
			contentPanel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		}
		{
			purposeTextField = new JTextField();
			contentPanel.add(purposeTextField, "cell 1 3,growx");
			purposeTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Function");
			contentPanel.add(lblNewLabel_2, "cell 0 4,alignx trailing");
		}
		{
			functionTextField = new JTextField();
			contentPanel.add(functionTextField, "cell 1 4,growx");
			functionTextField.setColumns(10);
		}
		{
			 dataTextArea = new JTextArea();
			dataTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
			contentPanel.add(dataTextArea, "cell 1 5 1 3,grow");
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Data");
			contentPanel.add(lblNewLabel_3, "cell 0 6,alignx trailing");
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
						entry = new PSPProjectCodeComponent();
						entry.setFunction(functionTextField.getText());
						entry.setModule(moduleTextField.getText());
						entry.setPurpose(purposeTextField.getText());
						entry.setType((PSPProjectComponentType) typeComboBox.getSelectedItem());
						entry.setData(dataTextArea.getText());
						Manager.getProject(pID).addComponents(entry);
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
