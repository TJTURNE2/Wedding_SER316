package net.sf.memoranda.psp.gui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import net.sf.memoranda.psp.PSPProject.PSPType;
import net.sf.memoranda.psp.PSPProjectManager;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import net.sf.memoranda.psp.PSPRequirements.PSPRequirementType;

@SuppressWarnings("serial")
public class PSPNewRequirementDialog extends JDialog {
	private JTextField textDescription;
	PSPProjectManager Manager;

	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				PSPNewRequirementDialog nd = new PSPNewRequirementDialog();
				nd.setVisible(true);
			}
		});
		// PSPProjectsPanel paneltest = new PSPProjectsPanel();
	}
	
	public PSPNewRequirementDialog() {
		setMinimumSize(new Dimension(500, 250));
		getContentPane().setMinimumSize(new Dimension(500, 500));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel TopPanel = new JPanel();
		TopPanel.setPreferredSize(new Dimension(500, 50));
		TopPanel.setBackground(Color.WHITE);
		getContentPane().add(TopPanel, BorderLayout.NORTH);
		TopPanel.setLayout(new MigLayout("", "[]", "[]"));

		JLabel lblNewRequirement = new JLabel("New Requirement");
		lblNewRequirement.setIcon(new ImageIcon(
				PSPNewRequirementDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
		lblNewRequirement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewRequirement.setHorizontalAlignment(SwingConstants.RIGHT);
		TopPanel.add(lblNewRequirement, "cell 0 0,growx");

		JPanel ContentPanel = new JPanel();
		ContentPanel.setBorder(new CompoundBorder());
		getContentPane().add(ContentPanel, BorderLayout.CENTER);
		ContentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));

		JLabel lblProjectName = new JLabel("Description");
		lblProjectName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblProjectName, "cell 0 0");

		textDescription = new JTextField();
		ContentPanel.add(textDescription, "cell 2 0,growx");
		textDescription.setColumns(10);
		
				JLabel lblRequirementType = new JLabel("Type");
				lblRequirementType.setHorizontalAlignment(SwingConstants.CENTER);
				lblRequirementType.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ContentPanel.add(lblRequirementType, "cell 0 1,alignx right");
		
				final JComboBox comboBoxRequirementType = new JComboBox();
				comboBoxRequirementType.setModel(new DefaultComboBoxModel(PSPRequirementType.values()));
				comboBoxRequirementType.setMaximumRowCount(4);
				ContentPanel.add(comboBoxRequirementType, "cell 2 1,alignx left");

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		getContentPane().add(BottomPanel, BorderLayout.SOUTH);
		BottomPanel.setLayout(new MigLayout("", "[89px][][][][][][][][][][][][][][][][]", "[23px]"));

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Manager.addRequirementLog(ID, entry)
				
			}
		});


		btnOK.setMinimumSize(new Dimension(65, 23));
		btnOK.setMaximumSize(new Dimension(65, 23));
		btnOK.setPreferredSize(new Dimension(65, 23));

		BottomPanel.add(btnOK, "cell 16 0");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		BottomPanel.add(btnCancel, "cell 16 0,alignx left,aligny top");

	}

}
