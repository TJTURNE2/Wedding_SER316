package net.sf.memoranda.psp.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectCatagory;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectSeverity;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PSPNewCodeReviewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewCodeReviewDialog nd = new PSPNewCodeReviewDialog();
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public PSPNewCodeReviewDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][grow][][]"));
		{
			JLabel lblNewLabel_1 = new JLabel("Location");
			contentPanel.add(lblNewLabel_1, "cell 0 1");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 2 1,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Description");
			contentPanel.add(lblNewLabel_2, "cell 0 3");
		}
		{
			JTextArea textArea = new JTextArea();
			contentPanel.add(textArea, "cell 2 3,grow");
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Catagory");
			contentPanel.add(lblNewLabel_4, "cell 0 4");
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(PSPDefectCatagory.values()));
			contentPanel.add(comboBox, "cell 2 4,alignx left");
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Severity");
			contentPanel.add(lblNewLabel_5, "cell 0 5");
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(PSPDefectSeverity.values()));
			contentPanel.add(comboBox, "cell 2 5");
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
		{
			JToolBar toolBar = new JToolBar();
			getContentPane().add(toolBar, BorderLayout.NORTH);
			toolBar.setFloatable(false);
			toolBar.setPreferredSize(new Dimension(13, 35));
		}
	}

}
