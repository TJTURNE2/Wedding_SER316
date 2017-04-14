package net.sf.memoranda.psp.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.PSPProjectPhase;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpringLayout;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PSPProjectsOverviewPanel extends JPanel {

	private static PSPProjectManager Manager = new PSPProjectManager();
	private static int ProjectID = -1;
	private static int requirementID;
	private static int defectID;
	private static int timeID;
	private static int noteID;
	private static JTable projectsTable;
	private static JTable requirementTable;
	private static JTable designTable;
	private static JTable timeLogTable;
	private static JTable defectLogTable;
	private static JTable notesTable;
	private static ProjectTableModel pModel;
	private static DefectTableModel dModel;
	private static TimeLogTableModel tModel;
	private static RequirementTableModel rModel;
	private static NoteTableModel nModel;
	private PSPNewProjectDialog newProject;
	private PSPNewTimeEntryDialog newTimeLog;
	private PSPNewRequirementDialog newRequirement;
	private PSPNewDefectDialog newDefect;
	private JTabbedPane projectsTabbedPane;
	private JTabbedPane summarytabbedPane;
	private JPanel projectsPanel;
	private JPanel projectSummaryPanel;
	private JPanel locPanel;
	private JPanel designPanel;
	private JPanel timeLogPanel;
	private JPanel codePanel;
	private JPanel defectLogPanel;
	private JPanel postMortemPanel;
	private JPanel summaryLOCPanel;
	private JPanel phaseTimePanel;
	private JPanel phaseDefectsPanel;
	private JPanel defectsRemovedPanel;
	private JPanel programSummary;
	private JPanel summaryPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public PSPProjectsOverviewPanel() {
		setBorder(null);

		setMinimumSize(new Dimension(500, 300));
		setSize(new Dimension(500, 300));
		pModel = new ProjectTableModel();
		dModel = new DefectTableModel();
		tModel = new TimeLogTableModel();
		rModel = new RequirementTableModel();
		nModel = new NoteTableModel();

		setLayout(new BorderLayout(0, 0));
		
		projectsTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		projectsTabbedPane.setBorder(null);
		projectsTabbedPane.setSize(new Dimension(600, 500));
		projectsTabbedPane.setBackground(Color.WHITE);
		add(projectsTabbedPane, BorderLayout.CENTER);

		projectsPanel = new JPanel();
		projectsPanel.setBorder(null);
		projectsTabbedPane.addTab("Projects", null, projectsPanel, null);
		projectsPanel.setLayout(new BorderLayout(0, 0));

		JToolBar projectsToolBar = new JToolBar();
		projectsToolBar.setSize(new Dimension(0, 25));
		projectsToolBar.setPreferredSize(new Dimension(13, 25));
		projectsToolBar.setFloatable(false);
		projectsPanel.add(projectsToolBar, BorderLayout.NORTH);

		JButton btnNewProject = new JButton("");
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProject = new PSPNewProjectDialog();
				newProject.setVisible(true);
			}
		});
		btnNewProject.setMaximumSize(new Dimension(25, 25));
		btnNewProject.setBorder(null);
		btnNewProject.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		projectsToolBar.add(btnNewProject);

		JButton btnEditProject = new JButton("");
		btnEditProject.setBorder(null);
		btnEditProject.setMaximumSize(new Dimension(25, 25));
		btnEditProject.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		projectsToolBar.add(btnEditProject);

		JButton btnDeleteProject = new JButton("");
		btnDeleteProject.setMultiClickThreshhold(200);
		btnDeleteProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetPanels();
				ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				//ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				if(ProjectID > -1){
				System.out.println("This is working kinda - delete "+ ProjectID);
				Manager.deleteProject(ProjectID);
				pModel.fireTableDataChanged();
				}
				ProjectID = -1;
			}
			
		});
		btnDeleteProject.setBorder(null);
		btnDeleteProject.setMaximumSize(new Dimension(25, 25));
		btnDeleteProject.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		projectsToolBar.add(btnDeleteProject);

		projectsTable = new JTable(pModel);
		projectsTable.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		projectsTable.setFillsViewportHeight(true);
		projectsTable.setBorder(null);
		projectsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				btnDeleteProject.setEnabled(true);
				ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				resetPanels();
			}
		});

		JScrollPane projectsScrollPane = new JScrollPane(projectsTable);
		projectsScrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		projectsScrollPane.setBackground(Color.WHITE);
		projectsPanel.add(projectsScrollPane, BorderLayout.CENTER);

		summaryPanel = new JPanel();
		projectsTabbedPane.addTab("Summary", null, summaryPanel, null);
		summaryPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar sumToolBar = new JToolBar();
		sumToolBar.setPreferredSize(new Dimension(13, 25));
		sumToolBar.setBorder(null);
		sumToolBar.setFloatable(false);
		summaryPanel.add(sumToolBar, BorderLayout.NORTH);
		
		JButton btnsaveSum = new JButton("");
		btnsaveSum.setMaximumSize(new Dimension(25, 25));
		btnsaveSum.setIcon(new ImageIcon(PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		sumToolBar.add(btnsaveSum);
		
		JPanel panel = new JPanel();
		summaryPanel.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_29 = new JLabel("Student");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_29, 33, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_29, 44, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_29);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 30, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 305, SpringLayout.WEST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_30 = new JLabel("Instructor");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_30, 60, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_30, 33, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_30);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 57, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 305, SpringLayout.WEST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_31 = new JLabel("Program");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_31, 87, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_31, 39, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_31);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 84, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, 305, SpringLayout.WEST, panel);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_34 = new JLabel("Language");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_34, 114, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_34, 33, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_34);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 111, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 305, SpringLayout.WEST, panel);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_32 = new JLabel("Start Date");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_32, 171, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_32, 30, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_32);
		
		JSpinner spinner_67 = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, spinner_67, 168, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, spinner_67, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, spinner_67, 215, SpringLayout.WEST, panel);
		spinner_67.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
		panel.add(spinner_67);
		
		JLabel lblNewLabel_33 = new JLabel("End Date");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_33, 198, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_33, 33, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_33);
		
		JSpinner spinner_68 = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, spinner_68, 195, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, spinner_68, 93, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, spinner_68, 215, SpringLayout.WEST, panel);
		spinner_68.setModel(new SpinnerDateModel(new Date(1491980400000L), null, null, Calendar.DAY_OF_YEAR));
		panel.add(spinner_68);
		
		locPanel = new JPanel();
		projectsTabbedPane.addTab("LOC", null, locPanel, null);
		projectsTabbedPane.setEnabledAt(1, false);
		locPanel.setLayout(new BorderLayout(0, 0));

		JToolBar summaryToolBar = new JToolBar();
		summaryToolBar.setPreferredSize(new Dimension(13, 25));
		summaryToolBar.setFloatable(false);
		locPanel.add(summaryToolBar, BorderLayout.NORTH);

		JButton btnEditSummary = new JButton("");
		btnEditSummary.setBorder(null);
		btnEditSummary.setMaximumSize(new Dimension(25, 25));
		btnEditSummary.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		summaryToolBar.add(btnEditSummary);

		JButton btnSaveSummary = new JButton("");
		btnSaveSummary.setBorder(null);
		btnSaveSummary.setMaximumSize(new Dimension(25, 25));
		btnSaveSummary.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/export.png")));
		summaryToolBar.add(btnSaveSummary);

		//JScrollPane summaryScrollPane = new JScrollPane();
		//locPanel.add(summaryScrollPane, BorderLayout.CENTER);
		summaryLOCPanel = new JPanel();
		summaryLOCPanel.setBackground(Color.WHITE);
		phaseTimePanel = new JPanel();
		phaseTimePanel.setBackground(Color.WHITE);
		phaseDefectsPanel = new JPanel();
		phaseDefectsPanel.setBackground(Color.WHITE);
		defectsRemovedPanel = new JPanel();
		defectsRemovedPanel.setBackground(Color.WHITE);
		programSummary = new JPanel();
		summarytabbedPane = new JTabbedPane(JTabbedPane.TOP);
		locPanel.add(summarytabbedPane, BorderLayout.CENTER);
		//summarytabbedPane.addTab("Program", null,programSummary,null);
		summarytabbedPane.addTab("Line of Code",null,summaryLOCPanel,null);
		summarytabbedPane.setEnabledAt(0, true);
		summaryLOCPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]", "[20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblPlanSize = new JLabel("Plan Size");
		summaryLOCPanel.add(lblPlanSize, "cell 1 0,alignx center,aligny center");
		
		JLabel lblAcutalSize = new JLabel("Acutal Size");
		summaryLOCPanel.add(lblAcutalSize, "cell 2 0,alignx center,aligny center");
		
		JLabel lblNewLabel_10 = new JLabel("To Date");
		summaryLOCPanel.add(lblNewLabel_10, "cell 3 0,alignx center,aligny center");
		
		JLabel lblBase = new JLabel("Base(B)");
		lblBase.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		summaryLOCPanel.add(lblBase, "cell 0 1,alignx left,aligny center");
		
		JSpinner basePlanSpinner = new JSpinner();
		basePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(basePlanSpinner, "cell 1 1,grow");
		
		JSpinner baseActualSpinner = new JSpinner();
		baseActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(baseActualSpinner, "cell 2 1,grow");
		
		JLabel lblDeleted = new JLabel("Deleted(D)");
		lblDeleted.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDeleted.setHorizontalAlignment(SwingConstants.LEFT);
		summaryLOCPanel.add(lblDeleted, "cell 0 2,alignx left,aligny center");
		
		JSpinner deletedPlanSpinner = new JSpinner();
		deletedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(deletedPlanSpinner, "cell 1 2,grow");
		
		JSpinner deletedActualSpinner = new JSpinner();
		deletedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(deletedActualSpinner, "cell 2 2,grow");
		
		JLabel lblModified = new JLabel("Modified(M)");
		lblModified.setHorizontalTextPosition(SwingConstants.LEFT);
		lblModified.setHorizontalAlignment(SwingConstants.LEFT);
		summaryLOCPanel.add(lblModified, "cell 0 3,alignx left,aligny center");
		
		JSpinner modifiedPlanSpinner = new JSpinner();
		modifiedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(modifiedPlanSpinner, "cell 1 3,grow");
		
		JSpinner modifiedActualSpinner = new JSpinner();
		modifiedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(modifiedActualSpinner, "cell 2 3,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Added(A)");
		summaryLOCPanel.add(lblNewLabel_3, "cell 0 4,alignx left,aligny center");
		
		JSpinner addedPlanSpinner = new JSpinner();
		addedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(addedPlanSpinner, "cell 1 4,grow");
		
		JSpinner addedActualSpinner = new JSpinner();
		addedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(addedActualSpinner, "cell 2 4,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Reused(R)");
		summaryLOCPanel.add(lblNewLabel_4, "cell 0 5,alignx left,aligny center");
		
		JSpinner reusedPlanSpinner = new JSpinner();
		reusedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedPlanSpinner, "cell 1 5,grow");
		
		JSpinner reusedActualSpinner = new JSpinner();
		reusedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedActualSpinner, "cell 2 5,grow");
		
		JSpinner reusedToDateSpinner = new JSpinner();
		reusedToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedToDateSpinner, "cell 3 5,grow");
		
		JLabel lblAddedModified = new JLabel("(A) & (M)");
		summaryLOCPanel.add(lblAddedModified, "cell 0 6,alignx left,aligny center");
		
		JSpinner aMPlanSpinner = new JSpinner();
		aMPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMPlanSpinner, "cell 1 6,grow");
		
		JSpinner aMActualSpinner = new JSpinner();
		aMActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMActualSpinner, "cell 2 6,grow");
		
		JSpinner aMToDateSpinner = new JSpinner();
		aMToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMToDateSpinner, "cell 3 6,grow");
		
		JLabel lblTotal = new JLabel("Total(T)");
		summaryLOCPanel.add(lblTotal, "cell 0 7,alignx left,aligny center");
		
		JSpinner totalPlanSpinner = new JSpinner();
		totalPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalPlanSpinner, "cell 1 7,grow");
		
		JSpinner totalActualSpinner = new JSpinner();
		totalActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalActualSpinner, "cell 2 7,grow");
		
		JSpinner totalToDateSpinner = new JSpinner();
		totalToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalToDateSpinner, "cell 3 7,grow");
		
		JLabel lblNewLabel_7 = new JLabel("(N) & (R)");
		summaryLOCPanel.add(lblNewLabel_7, "cell 0 8,alignx left,aligny center");
		
		JSpinner nRPlanSpinner = new JSpinner();
		nRPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRPlanSpinner, "cell 1 8,grow");
		
		JSpinner nRActualSpinner = new JSpinner();
		nRActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRActualSpinner, "cell 2 8,grow");
		
		JSpinner nRToDateSpinner = new JSpinner();
		nRToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRToDateSpinner, "cell 3 8,grow");
		summarytabbedPane.addTab("Time In Phase",null,phaseTimePanel,null);
		phaseTimePanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left][50px,left]", "[20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblPhase = new JLabel("Phase");
		phaseTimePanel.add(lblPhase, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Plan");
		phaseTimePanel.add(lblNewLabel, "cell 1 0,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Actual");
		phaseTimePanel.add(lblNewLabel_1, "cell 2 0,grow");
		
		JLabel lblNewLabel_2 = new JLabel("To Date");
		phaseTimePanel.add(lblNewLabel_2, "cell 3 0,grow");
		
		JLabel lblNewLabel_5 = new JLabel("To Date%");
		phaseTimePanel.add(lblNewLabel_5, "cell 4 0,grow");
		
		JLabel lblTIPPlanPlan = new JLabel("PLAN");
		phaseTimePanel.add(lblTIPPlanPlan, "cell 0 1,grow");
		
		JSpinner tIPPlanPlanSpinner = new JSpinner();
		tIPPlanPlanSpinner.setPreferredSize(new Dimension(40, 25));
		tIPPlanPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanPlanSpinner, "cell 1 1,grow");
		
		JSpinner tIPActualPlanSpinner = new JSpinner();
		tIPActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualPlanSpinner, "cell 2 1,grow");
		
		JSpinner tIPToDatePlanSpinner = new JSpinner();
		tIPToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDatePlanSpinner, "cell 3 1,grow");
		
		JSpinner tIPToDatePerPlanSpinner = new JSpinner();
		tIPToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerPlanSpinner, "cell 4 1,grow");
		
		JLabel lblTIPDLD = new JLabel("DLD");
		phaseTimePanel.add(lblTIPDLD, "cell 0 2,grow");
		
		JSpinner tIPPlanDLDSpinner = new JSpinner();
		tIPPlanDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanDLDSpinner, "cell 1 2,grow");
		
		JSpinner tIPActualDLDSpinner = new JSpinner();
		tIPActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualDLDSpinner, "cell 2 2,grow");
		
		JSpinner tIPToDateDLDSpinner = new JSpinner();
		tIPToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateDLDSpinner, "cell 3 2,grow");
		
		JSpinner tIPToDatePerDLDSpinner = new JSpinner();
		tIPToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerDLDSpinner, "cell 4 2,grow");
		
		JLabel lblNTIPCode = new JLabel("CODE");
		phaseTimePanel.add(lblNTIPCode, "cell 0 3,grow");
		
		JSpinner tIPPlanCodeSpinner = new JSpinner();
		tIPPlanCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanCodeSpinner, "cell 1 3,grow");
		
		JSpinner tIPActualCodeSpinner = new JSpinner();
		tIPActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualCodeSpinner, "cell 2 3,grow");
		
		JSpinner tIPToDateCodeSpinner = new JSpinner();
		tIPToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateCodeSpinner, "cell 3 3,grow");
		
		JSpinner tIPToDatePerCodeSpinner = new JSpinner();
		tIPToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerCodeSpinner, "cell 4 3,grow");
		
		JLabel lblTIPCompile = new JLabel("COMPILE");
		phaseTimePanel.add(lblTIPCompile, "cell 0 4,grow");
		
		JSpinner tIPPlanCompileSpinner = new JSpinner();
		tIPPlanCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanCompileSpinner, "cell 1 4,grow");
		
		JSpinner tIPActualCompileSpinner = new JSpinner();
		tIPActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualCompileSpinner, "cell 2 4,grow");
		
		JSpinner tIPToDateCompileSpinner = new JSpinner();
		tIPToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateCompileSpinner, "cell 3 4,grow");
		
		JSpinner tIPToDatePerCompileSpinner = new JSpinner();
		tIPToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerCompileSpinner, "cell 4 4,grow");
		
		JLabel lblTIPUT = new JLabel("UT");
		phaseTimePanel.add(lblTIPUT, "cell 0 5,grow");
		
		JSpinner tIPPlanUTSpinner = new JSpinner();
		tIPPlanUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanUTSpinner, "cell 1 5,grow");
		
		JSpinner tIPActualUTSpinner = new JSpinner();
		tIPActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualUTSpinner, "cell 2 5,grow");
		
		JSpinner tIPToDateUTSpinner = new JSpinner();
		tIPToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateUTSpinner, "cell 3 5,grow");
		
		JSpinner tIPToDatePerUTSpinner = new JSpinner();
		tIPToDatePerUTSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerUTSpinner, "cell 4 5,grow");
		
		JLabel lblTIPPM = new JLabel("PM");
		phaseTimePanel.add(lblTIPPM, "cell 0 6,grow");
		
		JSpinner tIPPlanPMSpinner = new JSpinner();
		phaseTimePanel.add(tIPPlanPMSpinner, "cell 1 6,grow");
		
		JSpinner tIPActualPMSpinner = new JSpinner();
		tIPActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualPMSpinner, "cell 2 6,grow");
		
		JSpinner tIPToDatePMSpinner = new JSpinner();
		tIPToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDatePMSpinner, "cell 3 6,grow");
		
		JSpinner tIPToDatePerPMSpinner = new JSpinner();
		tIPToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerPMSpinner, "cell 4 6,grow");
		
		JLabel lblTIPTotal = new JLabel("Total");
		phaseTimePanel.add(lblTIPTotal, "cell 0 8,alignx right,growy");
		
		JSpinner tIPPlanTotalSpinner = new JSpinner();
		phaseTimePanel.add(tIPPlanTotalSpinner, "cell 1 8,grow");
		
		JSpinner tIPActualTotalSpinner = new JSpinner();
		tIPActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualTotalSpinner, "cell 2 8,grow");
		
		JSpinner tIPToDateTotalSpinner = new JSpinner();
		tIPToDateTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateTotalSpinner, "cell 3 8,grow");
		summarytabbedPane.addTab("Defects Injected",null,phaseDefectsPanel,null);
		phaseDefectsPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]", "[20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblNewLabel_6 = new JLabel("Phase");
		phaseDefectsPanel.add(lblNewLabel_6, "cell 0 0,alignx left,aligny center");
		
		JLabel lblNewLabel_15 = new JLabel("Actual");
		phaseDefectsPanel.add(lblNewLabel_15, "cell 1 0,alignx left,aligny center");
		
		JLabel lblNewLabel_16 = new JLabel("To Date");
		phaseDefectsPanel.add(lblNewLabel_16, "cell 2 0,alignx left,growy");
		
		JLabel lblNewLabel_17 = new JLabel("To Date%");
		phaseDefectsPanel.add(lblNewLabel_17, "cell 3 0,growx,aligny center");
		
		JLabel lblNewLabel_8 = new JLabel("PLAN");
		phaseDefectsPanel.add(lblNewLabel_8, "cell 0 1,alignx left,aligny center");
		
		JSpinner dIActualPlanSpinner = new JSpinner();
		dIActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualPlanSpinner, "cell 1 1,grow");
		
		JSpinner dIToDatePlanSpinner = new JSpinner();
		dIToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDatePlanSpinner, "cell 2 1,growx,aligny center");
		
		JSpinner dIToDatePerPlanSpinner = new JSpinner();
		dIToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerPlanSpinner, "cell 3 1,growx,aligny center");
		
		JLabel lblNewLabel_9 = new JLabel("DLD");
		phaseDefectsPanel.add(lblNewLabel_9, "cell 0 2,alignx left,aligny center");
		
		JSpinner dIActualDLDSpinner = new JSpinner();
		dIActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualDLDSpinner, "cell 1 2,grow");
		
		JSpinner dIToDateDLDSpinner = new JSpinner();
		dIToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateDLDSpinner, "cell 2 2,growx,aligny center");
		
		JSpinner dIToDatePerDLDSpinner = new JSpinner();
		dIToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerDLDSpinner, "cell 3 2,growx,aligny center");
		
		JLabel lblNewLabel_11 = new JLabel("CODE");
		phaseDefectsPanel.add(lblNewLabel_11, "cell 0 3,alignx left,aligny center");
		
		JSpinner dIActualCodeSpinner = new JSpinner();
		dIActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualCodeSpinner, "cell 1 3,grow");
		
		JSpinner dIToDateCodeSpinner = new JSpinner();
		dIToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateCodeSpinner, "cell 2 3,growx,aligny center");
		
		JSpinner dIToDatePerCodeSpinner = new JSpinner();
		dIToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerCodeSpinner, "cell 3 3,growx,aligny center");
		
		JLabel lblNewLabel_12 = new JLabel("COMPILE");
		phaseDefectsPanel.add(lblNewLabel_12, "cell 0 4,alignx left,aligny center");
		
		JSpinner dIActualCompileSpinner = new JSpinner();
		dIActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualCompileSpinner, "cell 1 4,grow");
		
		JSpinner dIToDateCompileSpinner = new JSpinner();
		dIToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateCompileSpinner, "cell 2 4,growx,aligny center");
		
		JSpinner dIToDatePerCompileSpinner = new JSpinner();
		dIToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerCompileSpinner, "cell 3 4,growx,aligny center");
		
		JLabel lblNewLabel_13 = new JLabel("UT");
		phaseDefectsPanel.add(lblNewLabel_13, "cell 0 5,alignx left,aligny center");
		
		JSpinner dIActualUTSpinner = new JSpinner();
		dIActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualUTSpinner, "cell 1 5,growx,aligny center");
		
		JSpinner dIToDateUTSpinner = new JSpinner();
		dIToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateUTSpinner, "cell 2 5,growx,aligny center");
		
		JSpinner dIToDatePerUTSpinner = new JSpinner();
		phaseDefectsPanel.add(dIToDatePerUTSpinner, "cell 3 5,growx,aligny center");
		
		JLabel lblNewLabel_14 = new JLabel("PM");
		phaseDefectsPanel.add(lblNewLabel_14, "cell 0 6,alignx left,aligny center");
		
		JSpinner dIActualPMSpinner = new JSpinner();
		dIActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualPMSpinner, "cell 1 6,growx,aligny center");
		
		JSpinner dIToDatePMSpinner = new JSpinner();
		dIToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDatePMSpinner, "cell 2 6,growx,aligny center");
		
		JSpinner dIToDatePerPMSpinner = new JSpinner();
		dIToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerPMSpinner, "cell 3 6,growx,aligny center");
		
		JLabel lblDI = new JLabel("Total");
		phaseDefectsPanel.add(lblDI, "cell 0 7,alignx right,aligny center");
		
		JSpinner dIActualTotalSpinner = new JSpinner();
		dIActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualTotalSpinner, "cell 1 7,growx,aligny center");
		
		JSpinner dIToDateTotalSpinner = new JSpinner();
		dIToDateTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateTotalSpinner, "cell 2 7,growx,aligny center");
		summarytabbedPane.addTab("Defects Removed",null,defectsRemovedPanel,null);
		defectsRemovedPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]", "[20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		JLabel lblNewLabel_18 = new JLabel("Phase");
		defectsRemovedPanel.add(lblNewLabel_18, "cell 0 0,alignx left,aligny center");
		
		JLabel lblNewLabel_19 = new JLabel("Actual");
		defectsRemovedPanel.add(lblNewLabel_19, "cell 1 0,growx,aligny center");
		
		JLabel lblNewLabel_20 = new JLabel("To-Date");
		defectsRemovedPanel.add(lblNewLabel_20, "cell 2 0,growx,aligny center");
		
		JLabel lblNewLabel_21 = new JLabel("To Date%");
		defectsRemovedPanel.add(lblNewLabel_21, "cell 3 0,growx,aligny center");
		
		JLabel lblNewLabel_22 = new JLabel("PLAN");
		defectsRemovedPanel.add(lblNewLabel_22, "cell 0 1,alignx left,aligny center");
		
		JSpinner drToActualPlanSpinner = new JSpinner();
		drToActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualPlanSpinner, "cell 1 1,growx,aligny center");
		
		JSpinner drToDatePlanSpinner = new JSpinner();
		drToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDatePlanSpinner, "cell 2 1,growx,aligny center");
		
		JSpinner drToDatePerPlanSpinner = new JSpinner();
		drToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerPlanSpinner, "cell 3 1,growx,aligny center");
		
		JLabel lblNewLabel_23 = new JLabel("DLD");
		defectsRemovedPanel.add(lblNewLabel_23, "cell 0 2,alignx left,aligny center");
		
		JSpinner drToActualDLDSpinner = new JSpinner();
		drToActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualDLDSpinner, "cell 1 2,growx,aligny center");
		
		JSpinner drToDateDLDSpinner = new JSpinner();
		drToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateDLDSpinner, "cell 2 2,growx,aligny center");
		
		JSpinner drToDatePerDLDSpinner = new JSpinner();
		drToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerDLDSpinner, "cell 3 2,growx,aligny center");
		
		JLabel lblNewLabel_24 = new JLabel("CODE");
		defectsRemovedPanel.add(lblNewLabel_24, "cell 0 3,alignx left,aligny center");
		
		JSpinner drToActualCodeSpinner = new JSpinner();
		drToActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualCodeSpinner, "cell 1 3,growx,aligny center");
		
		JSpinner drToDateCodeSpinner = new JSpinner();
		drToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateCodeSpinner, "cell 2 3,growx,aligny center");
		
		JSpinner drToDatePerCodeSpinner = new JSpinner();
		drToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerCodeSpinner, "cell 3 3,growx,aligny center");
		
		JLabel lblNewLabel_25 = new JLabel("COMPILE");
		defectsRemovedPanel.add(lblNewLabel_25, "cell 0 4,alignx left,aligny center");
		
		JSpinner drToActualCompileSpinner = new JSpinner();
		drToActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualCompileSpinner, "cell 1 4,growx,aligny center");
		
		JSpinner drToDateCompileSpinner = new JSpinner();
		drToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateCompileSpinner, "cell 2 4,growx,aligny center");
		
		JSpinner drToDatePerCompileSpinner = new JSpinner();
		drToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerCompileSpinner, "cell 3 4,growx,aligny center");
		
		JLabel lblNewLabel_26 = new JLabel("UT");
		defectsRemovedPanel.add(lblNewLabel_26, "cell 0 5,alignx left,aligny center");
		
		JSpinner drToActualUTSpinner = new JSpinner();
		drToActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualUTSpinner, "cell 1 5,growx,aligny center");
		
		JSpinner drToDateUTSpinner = new JSpinner();
		drToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateUTSpinner, "cell 2 5,growx,aligny center");
		
		JSpinner drToDatePerUTSpinner = new JSpinner();
		drToDatePerUTSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerUTSpinner, "cell 3 5,growx,aligny center");
		
		JLabel lblNewLabel_27 = new JLabel("PM");
		defectsRemovedPanel.add(lblNewLabel_27, "cell 0 6,alignx left,aligny center");
		
		JSpinner drToActualPMSpinner = new JSpinner();
		drToActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualPMSpinner, "cell 1 6,growx,aligny center");
		
		JSpinner drToDatePMSpinner = new JSpinner();
		drToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDatePMSpinner, "cell 2 6,growx,aligny center");
		
		JSpinner drToDatePerPMSpinner = new JSpinner();
		drToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerPMSpinner, "cell 3 6,growx,aligny center");
		
		JLabel lblNewLabel_28 = new JLabel("Total");
		defectsRemovedPanel.add(lblNewLabel_28, "cell 0 7,alignx right,aligny center");
		
		JSpinner drToActualTotalSpinner = new JSpinner();
		drToActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualTotalSpinner, "cell 1 7,growx,aligny center");
		
		JSpinner drToDateTotalSpinner = new JSpinner();
		drToDateTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateTotalSpinner, "cell 2 7,growx,aligny center");
		

		JPanel requirementPanel = new JPanel();
		projectsTabbedPane.addTab("Requirements", null, requirementPanel, null);
		projectsTabbedPane.setEnabledAt(2, false);
		requirementPanel.setLayout(new BorderLayout(0, 0));

		JToolBar requirementToolBar = new JToolBar();
		requirementToolBar.setPreferredSize(new Dimension(13, 25));
		requirementToolBar.setFloatable(false);
		requirementPanel.add(requirementToolBar, BorderLayout.NORTH);

		JButton btnNewRequirement = new JButton("");
		btnNewRequirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newRequirement = new PSPNewRequirementDialog(ProjectID);
				newRequirement.setVisible(true);
			}
		});
		btnNewRequirement.setMaximumSize(new Dimension(25, 25));
		btnNewRequirement.setBorder(null);
		btnNewRequirement.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		requirementToolBar.add(btnNewRequirement);

		JButton btnEditRequirement = new JButton("");
		btnEditRequirement.setBorder(null);
		btnEditRequirement.setMaximumSize(new Dimension(25, 25));
		btnEditRequirement.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		requirementToolBar.add(btnEditRequirement);

		JButton btnDeleteRequirement = new JButton("");
		btnDeleteRequirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requirementID = (int) requirementTable.getValueAt(requirementTable.getSelectedRow(), 0);
				try {				
				Manager.getProject(ProjectID).removeRequirement(requirementID);
					Manager.saveProjects();
					rModel.fireTableDataChanged();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeleteRequirement.setMaximumSize(new Dimension(25, 25));
		btnDeleteRequirement.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		btnDeleteRequirement.setBorder(null);
		requirementToolBar.add(btnDeleteRequirement);

		requirementTable = new JTable(rModel);
		requirementTable.setFillsViewportHeight(true);

		JScrollPane requirementScrollPane = new JScrollPane(requirementTable);
		requirementPanel.add(requirementScrollPane, BorderLayout.CENTER);

		designPanel = new JPanel();
		projectsTabbedPane.addTab("Design", null, designPanel, null);
		projectsTabbedPane.setEnabledAt(3, false);
		designPanel.setLayout(new BorderLayout(0, 0));

		JToolBar designToolBar = new JToolBar();
		designToolBar.setPreferredSize(new Dimension(13, 25));
		designToolBar.setFloatable(false);
		designPanel.add(designToolBar, BorderLayout.NORTH);
		
		JButton btnNewDesignNote = new JButton("");
		btnNewDesignNote.setMaximumSize(new Dimension(25, 25));
		btnNewDesignNote.setIcon(new ImageIcon(PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		btnNewDesignNote.setBorder(null);
		designToolBar.add(btnNewDesignNote);
		
		JButton btnEditDesignNote = new JButton("");
		btnEditDesignNote.setMaximumSize(new Dimension(25, 25));
		btnEditDesignNote.setIcon(new ImageIcon(PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		btnEditDesignNote.setBorder(null);
		designToolBar.add(btnEditDesignNote);
		
		JButton btnDeleteDesignNote = new JButton("");
		btnDeleteDesignNote.setMaximumSize(new Dimension(25, 25));
		btnDeleteDesignNote.setIcon(new ImageIcon(PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		btnDeleteDesignNote.setBorder(null);
		designToolBar.add(btnDeleteDesignNote);

		designTable = new JTable(nModel);
		designTable.setFillsViewportHeight(true);

		JScrollPane designScrollPane = new JScrollPane(designTable);
		designPanel.add(designScrollPane);

		timeLogPanel = new JPanel();
		projectsTabbedPane.addTab("Time Log", null, timeLogPanel, null);
		projectsTabbedPane.setEnabledAt(4, false);
		timeLogPanel.setLayout(new BorderLayout(0, 0));

		JToolBar timeLogToolBar = new JToolBar();
		timeLogToolBar.setPreferredSize(new Dimension(13, 25));
		timeLogToolBar.setFloatable(false);
		timeLogPanel.add(timeLogToolBar, BorderLayout.NORTH);

		JButton btnNewTimeEntry = new JButton("");
		btnNewTimeEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newTimeLog = new PSPNewTimeEntryDialog(ProjectID);
				newTimeLog.setVisible(true);
			}
		});
		btnNewTimeEntry.setBorder(null);
		btnNewTimeEntry.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		btnNewTimeEntry.setMaximumSize(new Dimension(25, 25));
		timeLogToolBar.add(btnNewTimeEntry);

		JButton btnEditTimeEntry = new JButton("");
		btnEditTimeEntry.setBorder(null);
		btnEditTimeEntry.setMaximumSize(new Dimension(25, 25));
		btnEditTimeEntry.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		timeLogToolBar.add(btnEditTimeEntry);

		JButton btnDeleteTimeEntry = new JButton("");
		btnDeleteTimeEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timeID = (int) timeLogTable.getValueAt(timeLogTable.getSelectedRow(), 0);
				try {
				System.out.println("Deleting a time entry " +timeID);
				Manager.getProject(ProjectID).removeTimeEntry(timeID);
				Manager.saveProjects();
				tModel.fireTableDataChanged();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				timeID = -1;
				
			}
		});
		btnDeleteTimeEntry.setBorder(null);
		btnDeleteTimeEntry.setMaximumSize(new Dimension(25, 25));
		btnDeleteTimeEntry.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		timeLogToolBar.add(btnDeleteTimeEntry);

		timeLogTable = new JTable(tModel);
		timeLogTable.setFillsViewportHeight(true);

		JScrollPane timeLogScrollPane = new JScrollPane(timeLogTable);
		timeLogPanel.add(timeLogScrollPane, BorderLayout.CENTER);

		codePanel = new JPanel();
		projectsTabbedPane.addTab("Code", null, codePanel, null);
		projectsTabbedPane.setEnabledAt(5, false);
		codePanel.setLayout(new BorderLayout(0, 0));

		JToolBar codeToolBar = new JToolBar();
		codeToolBar.setFloatable(false);
		codeToolBar.setPreferredSize(new Dimension(13, 25));
		codePanel.add(codeToolBar, BorderLayout.NORTH);

		JScrollPane codeScrollPane = new JScrollPane();
		codePanel.add(codeScrollPane);

		defectLogPanel = new JPanel();
		notesTable = new JTable();
		projectsTabbedPane.addTab("Defect Log", null, defectLogPanel, null);
		projectsTabbedPane.setEnabledAt(6, false);
		defectLogPanel.setLayout(new BorderLayout(0, 0));

		JToolBar defectLogToolBar = new JToolBar();
		defectLogToolBar.setFloatable(false);
		defectLogToolBar.setPreferredSize(new Dimension(13, 25));
		defectLogPanel.add(defectLogToolBar, BorderLayout.NORTH);

		JButton btnNewDefect = new JButton("");
		btnNewDefect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newDefect = new PSPNewDefectDialog(ProjectID);
				newDefect.setVisible(true);
				newDefect.setAlwaysOnTop(true);
			}
		});
		btnNewDefect.setMaximumSize(new Dimension(25, 25));
		btnNewDefect.setBorder(null);
		btnNewDefect.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		defectLogToolBar.add(btnNewDefect);

		JButton btnEditDefect = new JButton("");
		btnEditDefect.setMaximumSize(new Dimension(25, 25));
		btnEditDefect.setBorder(null);
		btnEditDefect.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		defectLogToolBar.add(btnEditDefect);

		JButton btnDeleteDefect = new JButton("");
		btnDeleteDefect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				defectID = (int) defectLogTable.getValueAt(defectLogTable.getSelectedRow(), 0);
				System.out.println("Try to remove a defect " + defectID);
				Manager.getProject(ProjectID).removeDefectEntry(defectID);
				Manager.saveProjects();
				dModel.fireTableDataChanged();
				//pModel.fireTableDataChanged();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				defectID = -1;
				
			}
		});
		btnDeleteDefect.setMaximumSize(new Dimension(25, 25));
		btnDeleteDefect.setBorder(null);
		btnDeleteDefect.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		defectLogToolBar.add(btnDeleteDefect);

		defectLogTable = new JTable(dModel);
		defectLogTable.setFillsViewportHeight(true);

		JScrollPane defectLogScrollPane = new JScrollPane(defectLogTable);
		defectLogPanel.add(defectLogScrollPane);

		postMortemPanel = new JPanel();
		projectsTabbedPane.addTab("Post Mortem", null, postMortemPanel, null);
		projectsTabbedPane.setEnabledAt(8, false);
		projectsTabbedPane.setEnabledAt(7, false);
		postMortemPanel.setLayout(new BorderLayout(0, 0));

		JToolBar postMortemToolBar = new JToolBar();
		postMortemToolBar.setPreferredSize(new Dimension(13, 25));
		postMortemToolBar.setFloatable(false);
		postMortemPanel.add(postMortemToolBar, BorderLayout.NORTH);

		JScrollPane postMortemScrollPane = new JScrollPane();
		postMortemPanel.add(postMortemScrollPane);
		

	}
	
	public void resetPanels(){
		//update tables?
//		pModel.fireTableDataChanged();
//		dModel.fireTableDataChanged();
//		tModel.fireTableDataChanged();
//		rModel.fireTableDataChanged();
		Manager.updateProject();
		//disable all
		projectsTabbedPane.setEnabledAt(8, !isEnabled());
		projectsTabbedPane.setEnabledAt(7, !isEnabled());
		projectsTabbedPane.setEnabledAt(6, !isEnabled());
		projectsTabbedPane.setEnabledAt(5, !isEnabled());
		projectsTabbedPane.setEnabledAt(4, !isEnabled());
		projectsTabbedPane.setEnabledAt(3, !isEnabled());
		projectsTabbedPane.setEnabledAt(2, !isEnabled());
		projectsTabbedPane.setEnabledAt(1, !isEnabled());
		
		//eneable panels based off phase
		switch((PSPProjectPhase)Manager.getProject(ProjectID).getPhase()){
		case POSTMORTEM:
			projectsTabbedPane.setEnabledAt(8, isEnabled());
		case TEST:
		case COMPILE:
		case CODEREVIEW:
		case CODE:
			projectsTabbedPane.setEnabledAt(6, isEnabled());
		case DESIGNREVIEW:
			projectsTabbedPane.setEnabledAt(7, isEnabled());
		case DESIGN:
			projectsTabbedPane.setEnabledAt(5, isEnabled());
			projectsTabbedPane.setEnabledAt(4, isEnabled());
			projectsTabbedPane.setEnabledAt(3, isEnabled());
		case PLANNING:
			projectsTabbedPane.setEnabledAt(2, isEnabled());
			projectsTabbedPane.setEnabledAt(1, isEnabled());
		}
		
	}

	protected class ProjectTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "Project ID", " Project Name", "Description", "Type", "Phase" };

		@Override
		public String getColumnName(int col) {

			return columnNames[col];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return Manager.Projects.size();
		}

		@Override
		public Object getValueAt(int row, int col) {

			if (col == 0) {
				return Manager.Projects.get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(row).getProjectName();
			}
			if (col == 2) {
				return Manager.Projects.get(row).getDescription();
			}
			if (col == 3) {
				return Manager.Projects.get(row).getPSP();
			}

			return Manager.Projects.get(row).getPhase();
		}
	}

	protected class RequirementTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "ID", "Type", "Description", "Priority" };

		@Override
		public String getColumnName(int col) {

			return columnNames[col];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub

			try {
				return Manager.Projects.get(ProjectID).getRequirements().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {
			if (col == 0) {
				return Manager.Projects.get(ProjectID).getRequirements().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getRequirements().get(row).getRequirmentType();
			}
			if (col == 2) {
				return Manager.Projects.get(ProjectID).getRequirements().get(row).getDescription();
			}
			{
				return Manager.Projects.get(ProjectID).getRequirements().get(row).getPriority();
			}

		}
	}

	protected class TimeLogTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "ID", "Entry Date", "Comments", "Phase", "Start Time",
				"Stopping Time" };

		@Override
		public String getColumnName(int col) {

			return columnNames[col];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub;
			try {
				return Manager.Projects.get(ProjectID).getTimeLog().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {

			if (col == 0) {
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getEntryDate();
			}
			if (col == 2) {
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getComments();
			}
			if (col == 3) {
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getPhase();
			}
			if (col == 4) {
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getStartingTime();
			}
			{
				return Manager.Projects.get(ProjectID).getTimeLog().get(row).getStoppingTime();
			}
		}
	}

	protected class DefectTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "Defect ID", "Date Found", "Type", "Phase Injected",
				"Description", "Severity" };

		@Override
		public String getColumnName(int col) {

			return columnNames[col];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			try {
				return Manager.Projects.get(ProjectID).getDefectLog().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {

			if (col == 0) {
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getDateFound();
			}
			if (col == 2) {
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getDefectType();
			}
			if (col == 3) {
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getPhaseInjected();
			}
			if (col == 4) {
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getDescription();
			}
			{
				return Manager.Projects.get(ProjectID).getDefectLog().get(row).getSeverity();
			}
		}
	}
	
	protected class NoteTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "Note ID", "Note", "Priority"};

		@Override
		public String getColumnName(int col) {

			return columnNames[col];
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			try {
				return Manager.Projects.get(ProjectID).getNotes().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {

			if (col == 0) {
				return Manager.Projects.get(ProjectID).getNotes().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getNotes().get(row).getDescription();
			}
			{
				return Manager.Projects.get(ProjectID).getNotes().get(row).getPriority();
			}

		}
	}

	public static void main(String[] args) {
		// Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		PSPProjectsOverviewPanel newContentPane = new PSPProjectsOverviewPanel();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.setSize(600, 500);
		frame.pack();
		frame.setVisible(true);
	}

}
