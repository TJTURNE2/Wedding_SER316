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
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PSPNewProjectDialog extends JDialog {
	private JTextField textFieldProjectName;
	private JTextField textFieldDescription;
	PSPProjectManager Manager;

	public static void NewDialog() throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PSPNewProjectDialog nd = new PSPNewProjectDialog();
				nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				nd.setAlwaysOnTop(true);
				nd.setVisible(true);
			}
		});
	}

	public PSPNewProjectDialog() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
				dispose();
			}
		});

		setMinimumSize(new Dimension(500, 250));
		getContentPane().setMinimumSize(new Dimension(500, 500));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(5, 5));
		JPanel TopPanel = new JPanel();
		TopPanel.setBorder(null);
		getContentPane().add(TopPanel, BorderLayout.NORTH);
		TopPanel.setBackground(Color.WHITE);
		TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewProject = new JLabel("New Project");
		lblNewProject.setPreferredSize(new Dimension(120, 35));
		lblNewProject.setIcon(new ImageIcon(
				PSPNewProjectDialog.class.getResource("/net/sf/memoranda/ui/htmleditor/resources/icons/filenew.png")));
		lblNewProject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewProject.setHorizontalAlignment(SwingConstants.LEFT);
		TopPanel.add(lblNewProject);

		JPanel ContentPanel = new JPanel();
		ContentPanel.setBorder(new CompoundBorder());
		getContentPane().add(ContentPanel, BorderLayout.CENTER);
		ContentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));

		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblProjectName, "cell 0 0");

		textFieldProjectName = new JTextField();
		ContentPanel.add(textFieldProjectName, "cell 2 0,growx");
		textFieldProjectName.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblDescription, "cell 0 1,alignx right");

		textFieldDescription = new JTextField();
		ContentPanel.add(textFieldDescription, "cell 2 1,growx");
		textFieldDescription.setColumns(10);

		JLabel lblPSPType = new JLabel("PSP Type");
		lblPSPType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPSPType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContentPanel.add(lblPSPType, "cell 0 2,alignx right");

		final JComboBox comboBoxPSPType = new JComboBox();
		comboBoxPSPType.setModel(new DefaultComboBoxModel(PSPType.values()));
		comboBoxPSPType.setMaximumRowCount(4);
		ContentPanel.add(comboBoxPSPType, "cell 2 2,alignx left");

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		getContentPane().add(BottomPanel, BorderLayout.SOUTH);
		BottomPanel.setLayout(new MigLayout("", "[89px][][][][][][][][][][][][][][][][]", "[23px]"));

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Manager = new PSPProjectManager();
					Manager.newProject(textFieldProjectName.getText(), textFieldDescription.getText(),
							(PSPType) comboBoxPSPType.getSelectedItem());
					Manager.saveProjects();
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					dispose();
				}
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), TopPanel, lblNewProject, ContentPanel, lblProjectName, textFieldProjectName, lblDescription, textFieldDescription, lblPSPType, comboBoxPSPType, BottomPanel, btnOK, btnCancel}));

	}

}
