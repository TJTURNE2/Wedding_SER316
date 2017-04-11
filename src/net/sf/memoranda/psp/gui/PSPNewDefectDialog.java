package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.sf.memoranda.psp.PSPProjectPhase;
import net.sf.memoranda.psp.PSPProjectDefectEntry.PSPDefectType;
import net.sf.memoranda.psp.PSPProjectManager;

import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PSPNewDefectDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	PSPProjectManager Manager = new PSPProjectManager();
	private static int count = 0;
	private JTextField textField;
	private JTextField txtPlaceForTime;
	private SpringLayout sl_contentPanel;
	private JLabel lblTimeFixing;
	private JComboBox phaseInjectedComboBox;
	private JComboBox defectTypeComboBox;
	private JLabel lblDefectType;
	private JLabel lblPhaseRemoved;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		int ID;
		Date dateFound;
		PSPDefectType defectType;
		PSPProjectPhase phaseInjected;
		PSPProjectPhase phaseRemoved;
		Time lengthFixing;
		String description;
		
		try {
			PSPNewDefectDialog dialog = new PSPNewDefectDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PSPNewDefectDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel topPanel = new JPanel();
			FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
			fl_topPanel.setAlignment(FlowLayout.LEFT);
			topPanel.setBackground(Color.WHITE);
			getContentPane().add(topPanel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("New Defect");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setPreferredSize(new Dimension(150, 40));
				lblNewLabel.setIcon(new ImageIcon(PSPNewDefectDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
				topPanel.add(lblNewLabel);
			}
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JDateChooser dateFound= new JDateChooser();

			
			JLabel lblDateFound = new JLabel("Date Found");
			lblDefectType = new JLabel("Defect Type");
			JLabel lblPhaseInjected = new JLabel("Phase Injected");
			lblPhaseRemoved = new JLabel("Phase Removed");
			lblTimeFixing = new JLabel("Fixing Time");
			sl_contentPanel = new SpringLayout();
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblTimeFixing, 0, SpringLayout.EAST, dateFound);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblDefectType, 0, SpringLayout.NORTH, lblDateFound);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblDefectType, 0, SpringLayout.WEST, lblPhaseRemoved);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblDateFound, -7, SpringLayout.NORTH, lblPhaseInjected);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblPhaseRemoved, 0, SpringLayout.NORTH, lblPhaseInjected);
			contentPanel.setLayout(sl_contentPanel);
			JLabel lblDescription = new JLabel("Description");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblDescription, 10, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblDescription, 190, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblDescription);
			{
				textField = new JTextField();
				sl_contentPanel.putConstraint(SpringLayout.NORTH, dateFound, 6, SpringLayout.SOUTH, textField);
				sl_contentPanel.putConstraint(SpringLayout.WEST, lblDateFound, 0, SpringLayout.WEST, textField);
				sl_contentPanel.putConstraint(SpringLayout.WEST, lblPhaseInjected, 0, SpringLayout.WEST, textField);
				sl_contentPanel.putConstraint(SpringLayout.NORTH, textField, 29, SpringLayout.NORTH, contentPanel);
				sl_contentPanel.putConstraint(SpringLayout.WEST, textField, 14, SpringLayout.WEST, contentPanel);
				contentPanel.add(textField);
				textField.setColumns(50);
			}
			contentPanel.add(lblDateFound);
			contentPanel.add(dateFound);
			contentPanel.add(lblDefectType);
			{
				defectTypeComboBox = new JComboBox();
				sl_contentPanel.putConstraint(SpringLayout.NORTH, defectTypeComboBox, 6, SpringLayout.SOUTH, textField);
				sl_contentPanel.putConstraint(SpringLayout.EAST, defectTypeComboBox, 0, SpringLayout.EAST, textField);
				defectTypeComboBox.setModel(new DefaultComboBoxModel(PSPDefectType.values()));
				contentPanel.add(defectTypeComboBox);
			}
			contentPanel.add(lblPhaseInjected);
			{
				phaseInjectedComboBox = new JComboBox();
				sl_contentPanel.putConstraint(SpringLayout.NORTH, lblTimeFixing, 11, SpringLayout.SOUTH, phaseInjectedComboBox);
				sl_contentPanel.putConstraint(SpringLayout.NORTH, phaseInjectedComboBox, 4, SpringLayout.SOUTH, dateFound);
				sl_contentPanel.putConstraint(SpringLayout.EAST, dateFound, 0, SpringLayout.EAST, phaseInjectedComboBox);
				sl_contentPanel.putConstraint(SpringLayout.WEST, lblPhaseRemoved, 46, SpringLayout.EAST, phaseInjectedComboBox);
				sl_contentPanel.putConstraint(SpringLayout.WEST, phaseInjectedComboBox, 13, SpringLayout.EAST, lblPhaseInjected);
				sl_contentPanel.putConstraint(SpringLayout.NORTH, lblPhaseInjected, 3, SpringLayout.NORTH, phaseInjectedComboBox);
				phaseInjectedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
				contentPanel.add(phaseInjectedComboBox);
			}
			contentPanel.add(lblPhaseRemoved);
			{
				JComboBox phaseRemovedComboBox = new JComboBox();
				sl_contentPanel.putConstraint(SpringLayout.NORTH, phaseRemovedComboBox, 5, SpringLayout.SOUTH, defectTypeComboBox);
				sl_contentPanel.putConstraint(SpringLayout.EAST, phaseRemovedComboBox, 0, SpringLayout.EAST, textField);
				phaseRemovedComboBox.setModel(new DefaultComboBoxModel(PSPProjectPhase.values()));
				contentPanel.add(phaseRemovedComboBox);
			}
			contentPanel.add(lblTimeFixing);
		}
		{
			txtPlaceForTime = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, txtPlaceForTime, 11, SpringLayout.SOUTH, lblPhaseRemoved);
			sl_contentPanel.putConstraint(SpringLayout.WEST, txtPlaceForTime, -86, SpringLayout.EAST, lblDefectType);
			sl_contentPanel.putConstraint(SpringLayout.EAST, txtPlaceForTime, 34, SpringLayout.EAST, lblDefectType);
			txtPlaceForTime.setText("Place for time picker");
			contentPanel.add(txtPlaceForTime);
			txtPlaceForTime.setColumns(10);
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
