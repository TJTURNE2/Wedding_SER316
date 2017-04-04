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
import net.sf.memoranda.psp.PSPDefectLog.PSPDefectType;
import net.sf.memoranda.psp.PSPPhase;

@SuppressWarnings("serial")
public class PSPNewDefectEntryDialog extends JDialog {
	PSPProjectManager Manager;
	private JTextField textDescription;

	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				PSPNewDefectEntryDialog nd = new PSPNewDefectEntryDialog();
				nd.setVisible(true);
			}
		});
		// PSPProjectsPanel paneltest = new PSPProjectsPanel();
	}
	
	public PSPNewDefectEntryDialog() {
		setMinimumSize(new Dimension(500, 300));
		getContentPane().setMinimumSize(new Dimension(500, 500));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel TopPanel = new JPanel();
		TopPanel.setPreferredSize(new Dimension(500, 50));
		TopPanel.setBackground(Color.WHITE);
		getContentPane().add(TopPanel, BorderLayout.NORTH);
		TopPanel.setLayout(new MigLayout("", "[]", "[]"));

		JLabel lblNewDefect = new JLabel("New Defect");
		lblNewDefect.setIcon(new ImageIcon(
				PSPNewDefectEntryDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
		lblNewDefect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewDefect.setHorizontalAlignment(SwingConstants.RIGHT);
		TopPanel.add(lblNewDefect, "cell 0 0,growx");

		JPanel ContentPanel = new JPanel();
		ContentPanel.setBorder(new CompoundBorder());
		getContentPane().add(ContentPanel, BorderLayout.CENTER);
		ContentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));

		JLabel lblDateFound = new JLabel("Date Found");
		lblDateFound.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblDateFound, "cell 0 0,alignx right");

		JLabel lblDefectType = new JLabel("Defect Type");
		lblDefectType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblDefectType, "cell 0 1,alignx right");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(PSPDefectType.values()));
		ContentPanel.add(comboBox_1, "cell 2 1,alignx left");

		JLabel lblPhaseInjected = new JLabel("Phase Injected");
		lblPhaseInjected.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhaseInjected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblPhaseInjected, "cell 0 2,alignx right");

		final JComboBox comboBoxPSPType = new JComboBox();
		comboBoxPSPType.setModel(new DefaultComboBoxModel(PSPPhase.values()));
	
		
		ContentPanel.add(comboBoxPSPType, "cell 2 2,alignx left");
		
		JLabel lblPhaseRemoved = new JLabel("Phase Removed");
		lblPhaseRemoved.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhaseRemoved.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblPhaseRemoved, "cell 0 3");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(PSPPhase.values()));
		ContentPanel.add(comboBox, "cell 2 3,alignx left");
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblDescription, "cell 0 4,alignx right");
		
		textDescription = new JTextField();
		ContentPanel.add(textDescription, "cell 2 4,growx");
		textDescription.setColumns(10);

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		getContentPane().add(BottomPanel, BorderLayout.SOUTH);
		BottomPanel.setLayout(new MigLayout("", "[89px][][][][][][][][][][][][][][][][]", "[23px]"));

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager = new PSPProjectManager();

				dispose(); 
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
