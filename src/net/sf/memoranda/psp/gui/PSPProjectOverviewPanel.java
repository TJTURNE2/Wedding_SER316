package net.sf.memoranda.psp.gui;

import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.util.Calendar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PSPProjectOverviewPanel extends JPanel {

	PSPProjectsPanel ProjectsPanel = new PSPProjectsPanel();
	JPanel PSPProjectsPanel = new JPanel();
	JPanel PSPSummaryPanel = new JPanel();
	JPanel PSPRequirementPanel = new JPanel();
	JPanel PSPDesignPanel = new JPanel();
	JPanel PSPTimeLogPanel = new JPanel();
	JPanel PSPDefectLogPanel = new JPanel();
	JPanel PSPCodePanel = new JPanel();
	JPanel PSPPostMortemPanel = new JPanel();

	JLabel SummaryLabel = new JLabel("Summary");
	JLabel DefectLabel = new JLabel("Defect Log");
	JLabel TimeLogLabel = new JLabel("Time Log");
	JLabel RequirmentLabel = new JLabel("Requirments");
	JLabel PostMortemLabel = new JLabel("Post Mortem");

	JTabbedPane tabbedPane = new JTabbedPane();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("New label");
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("New label");
	private final JXDatePicker startCalendar = new JXDatePicker();
	private final JLabel lblNewLabel_5 = new JLabel("New label");
	private final JXDatePicker endCalendar = new JXDatePicker();
	private final JToolBar defectToolBar = new JToolBar();
	private final JScrollPane defectScrollPane = new JScrollPane();
	private final JTable defectTable = new JTable();
	private final JButton btnNewDefectLog = new JButton("");
	private final JButton btnEditDefectLog = new JButton("");
	private final JButton btnDeleteDefectLog = new JButton("");
	private final JToolBar timeLogToolBar = new JToolBar();
	private final JButton btnNewTimeLog = new JButton("");
	private final JButton btnEditTimeLog = new JButton("");
	private final JButton btnDeleteTimeLog = new JButton("");
	private final JScrollPane timeLogScrollPane = new JScrollPane();
	private final JTable timeLogTable = new JTable();
	private final JToolBar requirmentToolBar = new JToolBar();
	private final JButton btnNewRequirment = new JButton("");
	private final JButton btnDeleteRequirment = new JButton("");
	private final JButton btnNewButton_2 = new JButton("");
	private final JScrollPane requirmentScrollPane = new JScrollPane();
	private final JTable requirmentTable = new JTable();
	private final JScrollPane projectsPanelScrollPane = new JScrollPane();
	private final JToolBar projectsPanelToolBar = new JToolBar();
	private final JTable projectsTable = new JTable();
	private final JButton btnNewProject = new JButton("");
	private final JButton btnEditProject = new JButton("");
	private final JButton btnDeleteProject = new JButton("");

	/**
	 * Create the panel.
	 */

	public PSPProjectOverviewPanel() {
		textField_3.setColumns(10);
		textField_2.setColumns(10);
		textField_1.setColumns(10);
		textField.setColumns(10);
		setLayout(new BorderLayout(0, 0));
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);

		tabbedPane.setBorder(null);	
		PSPProjectsPanel.setBorder(null);
		PSPProjectsPanel.setBackground(new Color(0, 0, 255));
		tabbedPane.addTab("Projects", PSPProjectsPanel);
		tabbedPane.add("Summary", PSPSummaryPanel);
		PSPRequirementPanel.setBorder(null);
		tabbedPane.add("Requirements", PSPRequirementPanel);
		tabbedPane.add("Design", PSPDesignPanel);
		tabbedPane.add("Time Log", PSPTimeLogPanel);
		PSPDefectLogPanel.setBorder(null);
		tabbedPane.add("Defect Log", PSPDefectLogPanel);
		tabbedPane.add("Code", PSPCodePanel);
		tabbedPane.add("Post Mortem", PSPPostMortemPanel);	


		PSPProjectsPanel.setLayout(new BorderLayout(0, 0));
		projectsPanelToolBar.setBackground(new Color(255, 0, 255));
		projectsPanelToolBar.setBorder(null);
		projectsPanelToolBar.setFloatable(false);

		PSPProjectsPanel.add(projectsPanelToolBar, BorderLayout.NORTH);
		btnNewProject.setToolTipText("New Project");
		btnNewProject.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));

		projectsPanelToolBar.add(btnNewProject);
		btnEditProject.setToolTipText("Edit Project");
		btnEditProject.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));

		projectsPanelToolBar.add(btnEditProject);
		btnDeleteProject.setToolTipText("Delete Project");
		btnDeleteProject.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));

		projectsPanelToolBar.add(btnDeleteProject);
		projectsPanelScrollPane.setBorder(null);
		projectsPanelScrollPane.setViewportBorder(null);
		projectsPanelScrollPane.setBackground(new Color(175, 238, 238));
		projectsPanelScrollPane.add(projectsTable);

		PSPProjectsPanel.add(projectsPanelScrollPane, BorderLayout.CENTER);
		projectsTable.setBackground(new Color(0, 100, 0));

		//PSPProjectsPanel.add(projectsTable, BorderLayout.CENTER);
		//PSPProjectsPanel.add(ProjectsPanel, BorderLayout.NORTH);

		FlowLayout fl_ProjectsPanel = new FlowLayout(FlowLayout.CENTER, 0, 0);
		fl_ProjectsPanel.setAlignOnBaseline(true);
		ProjectsPanel.setLayout(fl_ProjectsPanel);
		SpringLayout sl_PSPSummaryPanel = new SpringLayout();
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_1);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 4, SpringLayout.NORTH, startCalendar);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_3);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 8, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.EAST, lblNewLabel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, endCalendar, 55, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, endCalendar, 207, SpringLayout.WEST, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, startCalendar, 55, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, startCalendar, 62, SpringLayout.WEST, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, textField_3, 30, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, textField_3, 209, SpringLayout.WEST, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 33, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 158, SpringLayout.WEST, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 33, SpringLayout.NORTH, PSPSummaryPanel);
		sl_PSPSummaryPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 16, SpringLayout.WEST, PSPSummaryPanel);
		PSPSummaryPanel.setLayout(sl_PSPSummaryPanel);
		PSPSummaryPanel.add(lblNewLabel);
		PSPSummaryPanel.add(textField);
		PSPSummaryPanel.add(lblNewLabel_1);
		PSPSummaryPanel.add(textField_1);
		PSPSummaryPanel.add(lblNewLabel_2);
		PSPSummaryPanel.add(textField_2);
		PSPSummaryPanel.add(lblNewLabel_3);
		PSPSummaryPanel.add(textField_3);
		PSPSummaryPanel.add(lblNewLabel_4);
		PSPSummaryPanel.add(startCalendar);
		startCalendar.getEditor().setColumns(8);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		PSPSummaryPanel.add(lblNewLabel_5);
		endCalendar.getEditor().setColumns(8);
		PSPSummaryPanel.add(endCalendar);

		PSPDefectLogPanel.setLayout(new BorderLayout(0, 0));
		defectToolBar.setBorder(null);
		defectToolBar.setFloatable(false);
		defectToolBar.setPreferredSize(new Dimension(13, 25));
		PSPDefectLogPanel.add(defectToolBar, BorderLayout.NORTH);
		btnNewDefectLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewDefectLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		defectToolBar.add(btnNewDefectLog);
		btnEditDefectLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		defectToolBar.add(btnEditDefectLog);
		btnDeleteDefectLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		defectToolBar.add(btnDeleteDefectLog);
		defectScrollPane.setBorder(null);
		defectScrollPane.add(defectTable);
		PSPDefectLogPanel.add(defectScrollPane, BorderLayout.CENTER);

		PSPTimeLogPanel.setLayout(new BorderLayout(0, 0));
		timeLogToolBar.setBorder(null);
		timeLogToolBar.setFloatable(false);
		timeLogToolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		PSPTimeLogPanel.add(timeLogToolBar, BorderLayout.NORTH);
		btnNewTimeLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		timeLogToolBar.add(btnNewTimeLog);
		btnEditTimeLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		timeLogToolBar.add(btnEditTimeLog);
		btnDeleteTimeLog.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		timeLogToolBar.add(btnDeleteTimeLog);
		timeLogTable.setColumnSelectionAllowed(true);
		timeLogTable.setCellSelectionEnabled(true);
		timeLogTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		timeLogScrollPane.setBorder(null);
		timeLogScrollPane.add(timeLogTable);
		PSPTimeLogPanel.add(timeLogScrollPane, BorderLayout.CENTER);

		PSPRequirementPanel.setLayout(new BorderLayout(0, 0));
		requirmentToolBar.setBackground(Color.GREEN);
		requirmentToolBar.setBorder(null);
		requirmentToolBar.setFloatable(false);
		PSPRequirementPanel.add(requirmentToolBar, BorderLayout.NORTH);
		btnNewRequirment.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		requirmentToolBar.add(btnNewRequirment);
		btnDeleteRequirment.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		requirmentToolBar.add(btnDeleteRequirment);
		btnNewButton_2.setIcon(new ImageIcon(PSPProjectOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		requirmentToolBar.add(btnNewButton_2);
		requirmentScrollPane.setBorder(null);
		requirmentScrollPane.add(requirmentTable);
		PSPRequirementPanel.add(requirmentScrollPane);

		add(tabbedPane, BorderLayout.CENTER);

	}
}                                         