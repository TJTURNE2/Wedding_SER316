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

import net.sf.memoranda.psp.PSPPlanSummary;
import net.sf.memoranda.psp.PSPProjectLOCSummary;
import net.sf.memoranda.psp.PSPProjectLogPhase;
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
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpringLayout;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class PSPProjectsOverviewPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PSPProjectManager Manager = new PSPProjectManager();
	private static int ProjectID = -1;
	private static int requirementID;
	private static int defectID;
	private static int timeID;
<<<<<<< HEAD
	private static int userTestID;
	private static int codeModuleID;
	private static int userReviewID;
=======
	private static int noteID;
	private static Date today;
>>>>>>> parent of 0874d8c... Updated Delete - Add on GUI
	private static JTable projectsTable;
	private static JTable requirementTable;
	private static JTable codeReviewTable;
	private static JTable timeLogTable;
	private static JTable defectLogTable;
	private static JTable notesTable;
	private static JTable componentsTable;
	private static JTable userTestTable;
	private static ProjectTableModel pModel;
	private static DefectTableModel dModel;
	private static TimeLogTableModel tModel;
	private static RequirementTableModel rModel;
	private static ComponentTableModel cModel;
	private static UserTestTableModel utModel;
	private PSPNewProjectDialog newProject;
	private PSPNewTimeEntryDialog newTimeLog;
	private PSPNewRequirementDialog newRequirement;
	private PSPNewDefectDialog newDefect;
	private JTabbedPane projectsTabbedPane;
	private JTabbedPane summarytabbedPane;
	private JPanel projectsPanel;
	private JPanel locPanel;
	private JPanel codeReviewPanel;
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
	private JTextField studenttextField;
	private JTextField instructorTextField;
	private JTextField programTextField;
	private JTextField languageTextField;

	private JSpinner startDateSpinner;
	private JSpinner endDateSpinner;
	private JSpinner basePlanSpinner;
	private JSpinner baseActualSpinner;
	private JSpinner deletedPlanSpinner;
	private JSpinner deletedActualSpinner;
	private JSpinner modifiedPlanSpinner;
	private JSpinner modifiedActualSpinner;
	private JSpinner addedPlanSpinner;
	private JSpinner addedActualSpinner;
	private JSpinner reusedPlanSpinner;
	private JSpinner reusedActualSpinner;
	private JSpinner reusedToDateSpinner;
	private JSpinner aMPlanSpinner;
	private JSpinner aMActualSpinner;
	private JSpinner aMToDateSpinner;
	private JSpinner totalPlanSpinner;
	private JSpinner totalActualSpinner;
	private JSpinner totalToDateSpinner;
	private JSpinner nRPlanSpinner;
	private JSpinner nRActualSpinner;
	private JSpinner nRToDateSpinner;
	private JSpinner tIPPlanPlanSpinner;
	private JSpinner tIPActualPlanSpinner;
	private JSpinner tIPToDatePlanSpinner;
	private JSpinner tIPToDatePerPlanSpinner;
	private JSpinner tIPPlanDLDSpinner;
	private JSpinner tIPActualDLDSpinner;
	private JSpinner tIPToDateDLDSpinner;
	private JSpinner tIPToDatePerDLDSpinner;
	private JSpinner tIPPlanCodeSpinner;
	private JSpinner tIPActualCodeSpinner;
	private JSpinner tIPToDateCodeSpinner;
	private JSpinner tIPToDatePerCodeSpinner;
	private JSpinner tIPPlanCompileSpinner;
	private JSpinner tIPActualCompileSpinner;
	private JSpinner tIPToDateCompileSpinner;
	private JSpinner tIPToDatePerCompileSpinner;
	private JSpinner tIPPlanUTSpinner;
	private JSpinner tIPActualUTSpinner;
	private JSpinner tIPToDateUTSpinner;
	private JSpinner tIPToDatePerUTSpinner;
	private JSpinner tIPPlanPMSpinner;
	private JSpinner tIPActualPMSpinner;
	private JSpinner tIPToDatePMSpinner;
	private JSpinner tIPToDatePerPMSpinner;
	private JSpinner tIPPlanTotalSpinner;
	private JSpinner tIPActualTotalSpinner;
	private JSpinner tIPToDateTotalSpinner;
	private JSpinner dIActualPlanSpinner;
	private JSpinner dIToDatePlanSpinner;
	private JSpinner dIToDatePerPlanSpinner;
	private JSpinner dIActualDLDSpinner;
	private JSpinner dIToDateDLDSpinner;
	private JSpinner dIToDatePerDLDSpinner;
	private JSpinner dIActualCodeSpinner;
	private JSpinner dIToDateCodeSpinner;
	private JSpinner dIToDatePerCodeSpinner;
	private JSpinner dIActualCompileSpinner;
	private JSpinner dIToDateCompileSpinner;
	private JSpinner dIToDatePerCompileSpinner;
	private JSpinner dIActualUTSpinner;
	private JSpinner dIToDateUTSpinner;
	private JSpinner dIToDatePerUTSpinner;
	private JSpinner dIActualPMSpinner;
	private JSpinner dIToDatePMSpinner;
	private JSpinner dIToDatePerPMSpinner;
	private JSpinner dIActualTotalSpinner;
	private JSpinner dIToDateTotalSpinner;
	private JSpinner drToActualPlanSpinner;
	private JSpinner drToDatePlanSpinner;
	private JSpinner drToDatePerPlanSpinner;
	private JSpinner drToActualDLDSpinner;
	private JSpinner drToDateDLDSpinner;
	private JSpinner drToDatePerDLDSpinner;
	private JSpinner drToActualCodeSpinner;
	private JSpinner drToDateCodeSpinner;
	private JSpinner drToDatePerCodeSpinner;
	private JSpinner drToActualCompileSpinner;
	private JSpinner drToDateCompileSpinner;
	private JSpinner drToDatePerCompileSpinner;
	private JSpinner drToActualUTSpinner;
	private JSpinner drToDateUTSpinner;
	private JSpinner drToDatePerUTSpinner;
	private JSpinner drToActualPMSpinner;
	private JSpinner drToDatePMSpinner;
	private JSpinner drToDatePerPMSpinner;
	private JSpinner drToActualTotalSpinner;
	private JSpinner drToDateTotalSpinner;
	private JPanel testPanel;
	private JToolBar testToolBar;
	private JScrollPane testScrollPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton button;

	/**
	 * Create the panel.
	 */
	public PSPProjectsOverviewPanel() {
		setBorder(null);
		setMinimumSize(new Dimension(500, 300));
		setSize(new Dimension(500, 300));

		// table models
		pModel = new ProjectTableModel();
		dModel = new DefectTableModel();
		tModel = new TimeLogTableModel();
		rModel = new RequirementTableModel();
		cModel = new ComponentTableModel();
		utModel = new UserTestTableModel();

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
		btnEditProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disablePanels();
			}
		});
		btnEditProject.setBorder(null);
		btnEditProject.setMaximumSize(new Dimension(25, 25));
		btnEditProject.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		projectsToolBar.add(btnEditProject);

		JButton btnDeleteProject = new JButton("");
		btnDeleteProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);			
				try{
				// ProjectID = (int)
				// projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				if (ProjectID > -1) {
					System.out.println("This is working kinda - delete " + ProjectID);
					Manager.deleteProject(ProjectID);
					pModel.fireTableDataChanged();
				}catch(Exception e){
					
				}
				disablePanels();
				ProjectID = -1;

			}

		});
		btnDeleteProject.setBorder(null);
		btnDeleteProject.setMaximumSize(new Dimension(25, 25));
		btnDeleteProject.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		projectsToolBar.add(btnDeleteProject);

		projectsTable = new JTable(pModel);
		projectsTable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				projectsTable.repaint();
			}
		});
		projectsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		btnsaveSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveSummary();
			}
		});
		btnsaveSum.setMaximumSize(new Dimension(25, 25));
		btnsaveSum.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		sumToolBar.add(btnsaveSum);

		JPanel sumPanel = new JPanel();
		summaryPanel.add(sumPanel, BorderLayout.CENTER);
		sumPanel.setLayout(new MigLayout("", "[55px,right][212px]", "[20px][20px][20px][20px][20px][20px]"));

		JLabel lblNewLabel_29 = new JLabel("Student");
		sumPanel.add(lblNewLabel_29, "cell 0 0,alignx right,aligny center");

		studenttextField = new JTextField();
		sumPanel.add(studenttextField, "cell 1 0,growx,aligny top");
		studenttextField.setColumns(10);

		JLabel lblNewLabel_30 = new JLabel("Instructor");
		sumPanel.add(lblNewLabel_30, "cell 0 1,alignx right,aligny center");

		instructorTextField = new JTextField();
		sumPanel.add(instructorTextField, "cell 1 1,growx,aligny top");
		instructorTextField.setColumns(10);

		JLabel lblNewLabel_31 = new JLabel("Program");
		sumPanel.add(lblNewLabel_31, "cell 0 2,alignx right,aligny center");

		programTextField = new JTextField();
		sumPanel.add(programTextField, "cell 1 2,growx,aligny top");
		programTextField.setColumns(10);

		JLabel lblNewLabel_34 = new JLabel("Language");
		sumPanel.add(lblNewLabel_34, "cell 0 3,alignx right,aligny center");

		languageTextField = new JTextField();
		sumPanel.add(languageTextField, "cell 1 3,growx,aligny top");
		languageTextField.setColumns(10);

		JLabel lblNewLabel_32 = new JLabel("Start Date");
		sumPanel.add(lblNewLabel_32, "cell 0 4,alignx right,aligny center");

		startDateSpinner = new JSpinner();
		startDateSpinner.setModel(new SpinnerDateModel(new Date(1484121600000L), null, null, Calendar.DAY_OF_YEAR));
		startDateSpinner.setEditor(new JSpinner.DateEditor(startDateSpinner, "MM/dd/yyyy"));
		// today = ((Date) startDateSpinner.getValue()); // save today

		sumPanel.add(startDateSpinner, "cell 1 4,alignx left,aligny top");

		JLabel lblNewLabel_33 = new JLabel("End Date");
		sumPanel.add(lblNewLabel_33, "cell 0 5,alignx right,aligny center");

		endDateSpinner = new JSpinner();
		endDateSpinner.setModel(new SpinnerDateModel(new Date(1483257600000L), null, null, Calendar.DAY_OF_YEAR));
		endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "MM/dd/yyyy"));
		sumPanel.add(endDateSpinner, "cell 1 5,alignx left,aligny top");

		locPanel = new JPanel();
		projectsTabbedPane.addTab("LOC", null, locPanel, null);
		projectsTabbedPane.setEnabledAt(1, false);
		locPanel.setLayout(new BorderLayout(0, 0));

		JToolBar summaryToolBar = new JToolBar();
		summaryToolBar.setPreferredSize(new Dimension(13, 25));
		summaryToolBar.setFloatable(false);
		locPanel.add(summaryToolBar, BorderLayout.NORTH);

		JButton btnSaveSummary = new JButton("");
		btnSaveSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveLOC();
			}
		});
		btnSaveSummary.setBorder(null);
		btnSaveSummary.setMaximumSize(new Dimension(25, 25));
		btnSaveSummary.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/export.png")));
		summaryToolBar.add(btnSaveSummary);

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
		// summarytabbedPane.addTab("Program", null,programSummary,null);
		summarytabbedPane.addTab("Line of Code", null, summaryLOCPanel, null);
		summarytabbedPane.setEnabledAt(0, true);
		summaryLOCPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]",
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px]"));

		JLabel lblPlanSize = new JLabel("Plan");
		summaryLOCPanel.add(lblPlanSize, "cell 1 0,alignx center,aligny center");

		JLabel lblAcutalSize = new JLabel("Acutal");
		summaryLOCPanel.add(lblAcutalSize, "cell 2 0,alignx center,aligny center");

		JLabel lblNewLabel_10 = new JLabel("To Date");
		summaryLOCPanel.add(lblNewLabel_10, "cell 3 0,alignx center,aligny center");

		JLabel lblBase = new JLabel("Base(B)");
		lblBase.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		summaryLOCPanel.add(lblBase, "cell 0 1,alignx left,aligny center");

		basePlanSpinner = new JSpinner();
		basePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(basePlanSpinner, "cell 1 1,grow");

		baseActualSpinner = new JSpinner();
		baseActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(baseActualSpinner, "cell 2 1,grow");

		JLabel lblDeleted = new JLabel("Deleted(D)");
		lblDeleted.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDeleted.setHorizontalAlignment(SwingConstants.LEFT);
		summaryLOCPanel.add(lblDeleted, "cell 0 2,alignx left,aligny center");

		deletedPlanSpinner = new JSpinner();
		deletedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(deletedPlanSpinner, "cell 1 2,grow");

		deletedActualSpinner = new JSpinner();
		deletedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(deletedActualSpinner, "cell 2 2,grow");

		JLabel lblModified = new JLabel("Modified(M)");
		lblModified.setHorizontalTextPosition(SwingConstants.LEFT);
		lblModified.setHorizontalAlignment(SwingConstants.LEFT);
		summaryLOCPanel.add(lblModified, "cell 0 3,alignx left,aligny center");

		modifiedPlanSpinner = new JSpinner();
		modifiedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(modifiedPlanSpinner, "cell 1 3,grow");

		modifiedActualSpinner = new JSpinner();
		modifiedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(modifiedActualSpinner, "cell 2 3,grow");

		JLabel lblNewLabel_3 = new JLabel("Added(A)");
		summaryLOCPanel.add(lblNewLabel_3, "cell 0 4,alignx left,aligny center");

		addedPlanSpinner = new JSpinner();
		addedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(addedPlanSpinner, "cell 1 4,grow");

		addedActualSpinner = new JSpinner();
		addedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(addedActualSpinner, "cell 2 4,grow");

		JLabel lblNewLabel_4 = new JLabel("Reused(R)");
		summaryLOCPanel.add(lblNewLabel_4, "cell 0 5,alignx left,aligny center");

		reusedPlanSpinner = new JSpinner();
		reusedPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedPlanSpinner, "cell 1 5,grow");

		reusedActualSpinner = new JSpinner();
		reusedActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedActualSpinner, "cell 2 5,grow");

		reusedToDateSpinner = new JSpinner();
		reusedToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(reusedToDateSpinner, "cell 3 5,grow");

		JLabel lblAddedModified = new JLabel("(A) & (M)");
		summaryLOCPanel.add(lblAddedModified, "cell 0 6,alignx left,aligny center");

		aMPlanSpinner = new JSpinner();
		aMPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMPlanSpinner, "cell 1 6,grow");

		aMActualSpinner = new JSpinner();
		aMActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMActualSpinner, "cell 2 6,grow");

		aMToDateSpinner = new JSpinner();
		aMToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(aMToDateSpinner, "cell 3 6,grow");

		JLabel lblTotal = new JLabel("Total(T)");
		summaryLOCPanel.add(lblTotal, "cell 0 7,alignx left,aligny center");

		totalPlanSpinner = new JSpinner();
		totalPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalPlanSpinner, "cell 1 7,grow");

		totalActualSpinner = new JSpinner();
		totalActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalActualSpinner, "cell 2 7,grow");

		totalToDateSpinner = new JSpinner();
		totalToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(totalToDateSpinner, "cell 3 7,grow");

		JLabel lblNewLabel_7 = new JLabel("(N) & (R)");
		summaryLOCPanel.add(lblNewLabel_7, "cell 0 8,alignx left,aligny center");

		nRPlanSpinner = new JSpinner();
		nRPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRPlanSpinner, "cell 1 8,grow");

		nRActualSpinner = new JSpinner();
		nRActualSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRActualSpinner, "cell 2 8,grow");

		nRToDateSpinner = new JSpinner();
		nRToDateSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		summaryLOCPanel.add(nRToDateSpinner, "cell 3 8,grow");
		summarytabbedPane.addTab("Time In Phase", null, phaseTimePanel, null);
		phaseTimePanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left][50px,left]",
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px]"));

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

		tIPPlanPlanSpinner = new JSpinner();
		tIPPlanPlanSpinner.setPreferredSize(new Dimension(40, 25));
		tIPPlanPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanPlanSpinner, "cell 1 1,grow");

		tIPActualPlanSpinner = new JSpinner();
		tIPActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualPlanSpinner, "cell 2 1,grow");

		tIPToDatePlanSpinner = new JSpinner();
		tIPToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDatePlanSpinner, "cell 3 1,grow");

		tIPToDatePerPlanSpinner = new JSpinner();
		tIPToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerPlanSpinner, "cell 4 1,grow");

		JLabel lblTIPDLD = new JLabel("DLD");
		phaseTimePanel.add(lblTIPDLD, "cell 0 2,grow");

		tIPPlanDLDSpinner = new JSpinner();
		tIPPlanDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanDLDSpinner, "cell 1 2,grow");

		tIPActualDLDSpinner = new JSpinner();
		tIPActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualDLDSpinner, "cell 2 2,grow");

		tIPToDateDLDSpinner = new JSpinner();
		tIPToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateDLDSpinner, "cell 3 2,grow");

		tIPToDatePerDLDSpinner = new JSpinner();
		tIPToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerDLDSpinner, "cell 4 2,grow");

		JLabel lblNTIPCode = new JLabel("CODE");
		phaseTimePanel.add(lblNTIPCode, "cell 0 3,grow");

		tIPPlanCodeSpinner = new JSpinner();
		tIPPlanCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanCodeSpinner, "cell 1 3,grow");

		tIPActualCodeSpinner = new JSpinner();
		tIPActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualCodeSpinner, "cell 2 3,grow");

		tIPToDateCodeSpinner = new JSpinner();
		tIPToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateCodeSpinner, "cell 3 3,grow");

		tIPToDatePerCodeSpinner = new JSpinner();
		tIPToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerCodeSpinner, "cell 4 3,grow");

		JLabel lblTIPCompile = new JLabel("COMPILE");
		phaseTimePanel.add(lblTIPCompile, "cell 0 4,grow");

		tIPPlanCompileSpinner = new JSpinner();
		tIPPlanCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanCompileSpinner, "cell 1 4,grow");

		tIPActualCompileSpinner = new JSpinner();
		tIPActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualCompileSpinner, "cell 2 4,grow");

		tIPToDateCompileSpinner = new JSpinner();
		tIPToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateCompileSpinner, "cell 3 4,grow");

		tIPToDatePerCompileSpinner = new JSpinner();
		tIPToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerCompileSpinner, "cell 4 4,grow");

		JLabel lblTIPUT = new JLabel("UT");
		phaseTimePanel.add(lblTIPUT, "cell 0 5,grow");

		tIPPlanUTSpinner = new JSpinner();
		tIPPlanUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPPlanUTSpinner, "cell 1 5,grow");

		tIPActualUTSpinner = new JSpinner();
		tIPActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualUTSpinner, "cell 2 5,grow");

		tIPToDateUTSpinner = new JSpinner();
		tIPToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateUTSpinner, "cell 3 5,grow");

		tIPToDatePerUTSpinner = new JSpinner();
		tIPToDatePerUTSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerUTSpinner, "cell 4 5,grow");

		JLabel lblTIPPM = new JLabel("PM");
		phaseTimePanel.add(lblTIPPM, "cell 0 6,grow");

		tIPPlanPMSpinner = new JSpinner();
		phaseTimePanel.add(tIPPlanPMSpinner, "cell 1 6,grow");

		tIPActualPMSpinner = new JSpinner();
		tIPActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualPMSpinner, "cell 2 6,grow");

		tIPToDatePMSpinner = new JSpinner();
		tIPToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDatePMSpinner, "cell 3 6,grow");

		tIPToDatePerPMSpinner = new JSpinner();
		tIPToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseTimePanel.add(tIPToDatePerPMSpinner, "cell 4 6,grow");

		JLabel lblTIPTotal = new JLabel("Total");
		phaseTimePanel.add(lblTIPTotal, "cell 0 8,alignx right,growy");

		tIPPlanTotalSpinner = new JSpinner();
		phaseTimePanel.add(tIPPlanTotalSpinner, "cell 1 8,grow");

		tIPActualTotalSpinner = new JSpinner();
		tIPActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPActualTotalSpinner, "cell 2 8,grow");

		tIPToDateTotalSpinner = new JSpinner();
		tIPToDateTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseTimePanel.add(tIPToDateTotalSpinner, "cell 3 8,grow");
		summarytabbedPane.addTab("Defects Injected", null, phaseDefectsPanel, null);
		phaseDefectsPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]",
				"[20px][20px][20px][20px][20px][20px][20px][20px]"));

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

		dIActualPlanSpinner = new JSpinner();
		dIActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualPlanSpinner, "cell 1 1,grow");

		dIToDatePlanSpinner = new JSpinner();
		dIToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDatePlanSpinner, "cell 2 1,growx,aligny center");

		dIToDatePerPlanSpinner = new JSpinner();
		dIToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerPlanSpinner, "cell 3 1,growx,aligny center");

		JLabel lblNewLabel_9 = new JLabel("DLD");
		phaseDefectsPanel.add(lblNewLabel_9, "cell 0 2,alignx left,aligny center");

		dIActualDLDSpinner = new JSpinner();
		dIActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualDLDSpinner, "cell 1 2,grow");

		dIToDateDLDSpinner = new JSpinner();
		dIToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateDLDSpinner, "cell 2 2,growx,aligny center");

		dIToDatePerDLDSpinner = new JSpinner();
		dIToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerDLDSpinner, "cell 3 2,growx,aligny center");

		JLabel lblNewLabel_11 = new JLabel("CODE");
		phaseDefectsPanel.add(lblNewLabel_11, "cell 0 3,alignx left,aligny center");

		dIActualCodeSpinner = new JSpinner();
		dIActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualCodeSpinner, "cell 1 3,grow");

		dIToDateCodeSpinner = new JSpinner();
		dIToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateCodeSpinner, "cell 2 3,growx,aligny center");

		dIToDatePerCodeSpinner = new JSpinner();
		dIToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerCodeSpinner, "cell 3 3,growx,aligny center");

		JLabel lblNewLabel_12 = new JLabel("COMPILE");
		phaseDefectsPanel.add(lblNewLabel_12, "cell 0 4,alignx left,aligny center");

		dIActualCompileSpinner = new JSpinner();
		dIActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualCompileSpinner, "cell 1 4,grow");

		dIToDateCompileSpinner = new JSpinner();
		dIToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateCompileSpinner, "cell 2 4,growx,aligny center");

		dIToDatePerCompileSpinner = new JSpinner();
		dIToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerCompileSpinner, "cell 3 4,growx,aligny center");

		JLabel lblNewLabel_13 = new JLabel("UT");
		phaseDefectsPanel.add(lblNewLabel_13, "cell 0 5,alignx left,aligny center");

		dIActualUTSpinner = new JSpinner();
		dIActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualUTSpinner, "cell 1 5,growx,aligny center");

		dIToDateUTSpinner = new JSpinner();
		dIToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateUTSpinner, "cell 2 5,growx,aligny center");

		dIToDatePerUTSpinner = new JSpinner();
		phaseDefectsPanel.add(dIToDatePerUTSpinner, "cell 3 5,growx,aligny center");

		JLabel lblNewLabel_14 = new JLabel("PM");
		phaseDefectsPanel.add(lblNewLabel_14, "cell 0 6,alignx left,aligny center");

		dIActualPMSpinner = new JSpinner();
		dIActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualPMSpinner, "cell 1 6,growx,aligny center");

		dIToDatePMSpinner = new JSpinner();
		dIToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDatePMSpinner, "cell 2 6,growx,aligny center");

		dIToDatePerPMSpinner = new JSpinner();
		dIToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		phaseDefectsPanel.add(dIToDatePerPMSpinner, "cell 3 6,growx,aligny center");

		JLabel lblDI = new JLabel("Total");
		phaseDefectsPanel.add(lblDI, "cell 0 7,alignx right,aligny center");

		dIActualTotalSpinner = new JSpinner();
		dIActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIActualTotalSpinner, "cell 1 7,growx,aligny center");

		dIToDateTotalSpinner = new JSpinner();
		dIToDateTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		phaseDefectsPanel.add(dIToDateTotalSpinner, "cell 2 7,growx,aligny center");
		summarytabbedPane.addTab("Defects Removed", null, defectsRemovedPanel, null);
		defectsRemovedPanel.setLayout(new MigLayout("", "[60px][50px,left][50px,left][50px,left]",
				"[20px][20px][20px][20px][20px][20px][20px][20px]"));

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

		drToActualPlanSpinner = new JSpinner();
		drToActualPlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualPlanSpinner, "cell 1 1,growx,aligny center");

		drToDatePlanSpinner = new JSpinner();
		drToDatePlanSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDatePlanSpinner, "cell 2 1,growx,aligny center");

		drToDatePerPlanSpinner = new JSpinner();
		drToDatePerPlanSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerPlanSpinner, "cell 3 1,growx,aligny center");

		JLabel lblNewLabel_23 = new JLabel("DLD");
		defectsRemovedPanel.add(lblNewLabel_23, "cell 0 2,alignx left,aligny center");

		drToActualDLDSpinner = new JSpinner();
		drToActualDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualDLDSpinner, "cell 1 2,growx,aligny center");

		drToDateDLDSpinner = new JSpinner();
		drToDateDLDSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateDLDSpinner, "cell 2 2,growx,aligny center");

		drToDatePerDLDSpinner = new JSpinner();
		drToDatePerDLDSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerDLDSpinner, "cell 3 2,growx,aligny center");

		JLabel lblNewLabel_24 = new JLabel("CODE");
		defectsRemovedPanel.add(lblNewLabel_24, "cell 0 3,alignx left,aligny center");

		drToActualCodeSpinner = new JSpinner();
		drToActualCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualCodeSpinner, "cell 1 3,growx,aligny center");

		drToDateCodeSpinner = new JSpinner();
		drToDateCodeSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateCodeSpinner, "cell 2 3,growx,aligny center");

		drToDatePerCodeSpinner = new JSpinner();
		drToDatePerCodeSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerCodeSpinner, "cell 3 3,growx,aligny center");

		JLabel lblNewLabel_25 = new JLabel("COMPILE");
		defectsRemovedPanel.add(lblNewLabel_25, "cell 0 4,alignx left,aligny center");

		drToActualCompileSpinner = new JSpinner();
		drToActualCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualCompileSpinner, "cell 1 4,growx,aligny center");

		drToDateCompileSpinner = new JSpinner();
		drToDateCompileSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateCompileSpinner, "cell 2 4,growx,aligny center");

		drToDatePerCompileSpinner = new JSpinner();
		drToDatePerCompileSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerCompileSpinner, "cell 3 4,growx,aligny center");

		JLabel lblNewLabel_26 = new JLabel("UT");
		defectsRemovedPanel.add(lblNewLabel_26, "cell 0 5,alignx left,aligny center");

		drToActualUTSpinner = new JSpinner();
		drToActualUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualUTSpinner, "cell 1 5,growx,aligny center");

		drToDateUTSpinner = new JSpinner();
		drToDateUTSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDateUTSpinner, "cell 2 5,growx,aligny center");

		drToDatePerUTSpinner = new JSpinner();
		drToDatePerUTSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerUTSpinner, "cell 3 5,growx,aligny center");

		JLabel lblNewLabel_27 = new JLabel("PM");
		defectsRemovedPanel.add(lblNewLabel_27, "cell 0 6,alignx left,aligny center");

		drToActualPMSpinner = new JSpinner();
		drToActualPMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualPMSpinner, "cell 1 6,growx,aligny center");

		drToDatePMSpinner = new JSpinner();
		drToDatePMSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToDatePMSpinner, "cell 2 6,growx,aligny center");

		drToDatePerPMSpinner = new JSpinner();
		drToDatePerPMSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		defectsRemovedPanel.add(drToDatePerPMSpinner, "cell 3 6,growx,aligny center");

		JLabel lblNewLabel_28 = new JLabel("Total");
		defectsRemovedPanel.add(lblNewLabel_28, "cell 0 7,alignx right,aligny center");

		drToActualTotalSpinner = new JSpinner();
		drToActualTotalSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		defectsRemovedPanel.add(drToActualTotalSpinner, "cell 1 7,growx,aligny center");

		drToDateTotalSpinner = new JSpinner();
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
				try {
					if (Manager.getProject(ProjectID).getRequirements().size() > 0
							&& Manager.getProject(ProjectID).getPhase().equals(PSPProjectPhase.DESIGN)) {
						Manager.getProject(ProjectID).setPhase(PSPProjectPhase.CODE);
						Manager.saveProjects();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

		codePanel = new JPanel();
		projectsTabbedPane.addTab("Code", null, codePanel, null);
		projectsTabbedPane.setEnabledAt(4, false);
		codePanel.setLayout(new BorderLayout(0, 0));

		JToolBar codeToolBar = new JToolBar();
		codeToolBar.setBorder(null);
		codeToolBar.setFloatable(false);
		codeToolBar.setPreferredSize(new Dimension(13, 25));
		codePanel.add(codeToolBar, BorderLayout.NORTH);

		btnNewButton_2 = new JButton("");
		btnNewButton_2.setMaximumSize(new Dimension(25, 25));
		btnNewButton_2.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		btnNewButton_2.setPreferredSize(new Dimension(25, 25));
		btnNewButton_2.setBorder(null);
		codeToolBar.add(btnNewButton_2);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setMaximumSize(new Dimension(25, 25));
		btnNewButton_3.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		btnNewButton_3.setBorder(null);
		codeToolBar.add(btnNewButton_3);

		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		btnNewButton_4.setMaximumSize(new Dimension(25, 25));
		codeToolBar.add(btnNewButton_4);

		componentsTable = new JTable(cModel);
		componentsTable.setFillsViewportHeight(true);

		JScrollPane codeScrollPane = new JScrollPane(componentsTable);
		codePanel.add(codeScrollPane);
		projectsTabbedPane.setEnabledAt(3, false);

		codeReviewPanel = new JPanel();
		projectsTabbedPane.addTab("Code Review", null, codeReviewPanel, null);
		projectsTabbedPane.setEnabledAt(5, false);
		codeReviewPanel.setLayout(new BorderLayout(0, 0));

		JToolBar codeReviewToolBar = new JToolBar();
		codeReviewToolBar.setPreferredSize(new Dimension(13, 25));
		codeReviewToolBar.setFloatable(false);
		codeReviewPanel.add(codeReviewToolBar, BorderLayout.NORTH);

		JButton btnNewCodeReview = new JButton("");
		btnNewCodeReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewCodeReview.setMaximumSize(new Dimension(25, 25));
		btnNewCodeReview.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		btnNewCodeReview.setBorder(null);
		codeReviewToolBar.add(btnNewCodeReview);

		JButton btnEditCodeReview = new JButton("");
		btnEditCodeReview.setMaximumSize(new Dimension(25, 25));
		btnEditCodeReview.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		btnEditCodeReview.setBorder(null);
		codeReviewToolBar.add(btnEditCodeReview);

		JButton btnDeleteCodeReview = new JButton("");
		btnDeleteCodeReview.setMaximumSize(new Dimension(25, 25));
		btnDeleteCodeReview.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		btnDeleteCodeReview.setBorder(null);
		codeReviewToolBar.add(btnDeleteCodeReview);

		codeReviewTable = new JTable(cModel);
		codeReviewTable.setFillsViewportHeight(true);

		JScrollPane codeReviewScrollPane = new JScrollPane(codeReviewTable);
		codeReviewPanel.add(codeReviewScrollPane);

		testPanel = new JPanel();
		projectsTabbedPane.addTab("User Test", null, testPanel, null);
		projectsTabbedPane.setEnabledAt(6, false);
		testPanel.setLayout(new BorderLayout(0, 0));

		testToolBar = new JToolBar();
		testToolBar.setFloatable(false);
		testToolBar.setPreferredSize(new Dimension(13, 25));
		testPanel.add(testToolBar, BorderLayout.NORTH);

		btnNewButton = new JButton("");
		btnNewButton.setMaximumSize(new Dimension(25, 25));
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/filenew.png")));
		testToolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setMaximumSize(new Dimension(25, 25));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editproject.png")));
		testToolBar.add(btnNewButton_1);

		btnDeleteUserTest = new JButton("");
		btnDeleteUserTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTestID = (int) userTestTable.getValueAt(userTestTable.getSelectedRow(), 0);
				try {
					Manager.getProject(ProjectID).removeUserTests(userTestID);
					Manager.saveProjects();
					utModel.fireTableDataChanged();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				userTestID = -1;
			}
		});
		btnDeleteUserTest.setBorder(null);
		btnDeleteUserTest.setIcon(new ImageIcon(
				PSPProjectsOverviewPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
		button.setMaximumSize(new Dimension(25, 25));
		testToolBar.add(button);

		userTestTable = new JTable(utModel);
		userTestTable.setFillsViewportHeight(true);

		testScrollPane = new JScrollPane(userTestTable);
		testPanel.add(testScrollPane, BorderLayout.CENTER);

		timeLogPanel = new JPanel();
		projectsTabbedPane.addTab("Time Log", null, timeLogPanel, null);
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
					System.out.println("Deleting a time entry " + timeID);
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
		projectsTabbedPane.setEnabledAt(7, false);

		defectLogPanel = new JPanel();
		notesTable = new JTable();
		projectsTabbedPane.addTab("Defect Log", null, defectLogPanel, null);
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
					// pModel.fireTableDataChanged();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
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
		projectsTabbedPane.setEnabledAt(9, false);
		projectsTabbedPane.setEnabledAt(8, false);
		postMortemPanel.setLayout(new BorderLayout(0, 0));

		JToolBar postMortemToolBar = new JToolBar();
		postMortemToolBar.setPreferredSize(new Dimension(13, 25));
		postMortemToolBar.setFloatable(false);
		postMortemPanel.add(postMortemToolBar, BorderLayout.NORTH);

		JScrollPane postMortemScrollPane = new JScrollPane();
		postMortemPanel.add(postMortemScrollPane);

		projectsTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
	}

	public void saveLOC() {
		try {

			PSPProjectLOCSummary LOC = Manager.getProject(ProjectID).getSummary().getProgramSize();
			PSPProjectLogPhase phaseTime = Manager.getProject(ProjectID).getSummary().getPhaseTime();
			PSPProjectLogPhase PhaseDefects = Manager.getProject(ProjectID).getSummary().getPhaseDefects();
			PSPProjectLogPhase DefectsRemoved = Manager.getProject(ProjectID).getSummary().getDefectsRemoved();

			{
				LOC.getBase().setPlanSize((int) basePlanSpinner.getValue());
				LOC.getBase().setActualSize((int) baseActualSpinner.getValue());
				LOC.getDeleted().setPlanSize((int) deletedPlanSpinner.getValue());
				LOC.getDeleted().setActualSize((int) deletedActualSpinner.getValue());
				LOC.getModified().setPlanSize((int) modifiedPlanSpinner.getValue());
				LOC.getModified().setActualSize((int) modifiedActualSpinner.getValue());
				LOC.getAdded().setPlanSize((int) addedPlanSpinner.getValue());
				LOC.getAdded().setActualSize((int) addedActualSpinner.getValue());
				LOC.getReused().setPlanSize((int) reusedPlanSpinner.getValue());
				LOC.getReused().setActualSize((int) reusedActualSpinner.getValue());
				LOC.getReused().setToDateSize((int) reusedToDateSpinner.getValue());
				LOC.getAddedModified().setPlanSize((int) aMPlanSpinner.getValue());
				LOC.getAddedModified().setActualSize((int) aMActualSpinner.getValue());
				LOC.getAddedModified().setToDateSize((int) aMToDateSpinner.getValue());
				LOC.getTotal().setPlanSize((int) totalPlanSpinner.getValue());
				LOC.getTotal().setActualSize((int) totalActualSpinner.getValue());
				LOC.getTotal().setToDateSize((int) totalToDateSpinner.getValue());
				LOC.getNewReused().setPlanSize((int) nRPlanSpinner.getValue());
				LOC.getNewReused().setActualSize((int) nRActualSpinner.getValue());
				LOC.getNewReused().setToDateSize((int) nRToDateSpinner.getValue());
			}

			{
				phaseTime.getPlanning().setPlanSize((int) tIPPlanPlanSpinner.getValue());
				phaseTime.getPlanning().setActualSize((int) tIPActualPlanSpinner.getValue());
				phaseTime.getPlanning().setToDateSize((int) tIPToDatePlanSpinner.getValue());
				phaseTime.getPlanning().setToDatePercent((double) tIPToDatePerPlanSpinner.getValue());
				phaseTime.getDesign().setPlanSize((int) tIPPlanDLDSpinner.getValue());
				phaseTime.getDesign().setActualSize((int) tIPActualDLDSpinner.getValue());
				phaseTime.getDesign().setToDateSize((int) tIPToDateDLDSpinner.getValue());
				phaseTime.getDesign().setToDatePercent((double) tIPToDatePerDLDSpinner.getValue());
				phaseTime.getCode().setPlanSize((int) tIPPlanCodeSpinner.getValue());
				phaseTime.getCode().setActualSize((int) tIPActualCodeSpinner.getValue());
				phaseTime.getCode().setToDateSize((int) tIPToDateCodeSpinner.getValue());
				phaseTime.getCode().setToDatePercent((double) tIPToDatePerCodeSpinner.getValue());
				phaseTime.getCompile().setPlanSize((int) tIPPlanCompileSpinner.getValue());
				phaseTime.getCompile().setActualSize((int) tIPActualCompileSpinner.getValue());
				phaseTime.getCompile().setToDateSize((int) tIPToDateCompileSpinner.getValue());
				phaseTime.getCompile().setToDatePercent((double) tIPToDatePerCompileSpinner.getValue());
				phaseTime.getTesting().setPlanSize((int) tIPPlanUTSpinner.getValue());
				phaseTime.getTesting().setActualSize((int) tIPActualUTSpinner.getValue());
				phaseTime.getTesting().setToDateSize((int) tIPToDateUTSpinner.getValue());
				phaseTime.getTesting().setToDatePercent((double) tIPToDatePerUTSpinner.getValue());
				phaseTime.getPostmortem().setPlanSize((int) tIPPlanPMSpinner.getValue());
				phaseTime.getPostmortem().setActualSize((int) tIPActualPMSpinner.getValue());
				phaseTime.getPostmortem().setToDateSize((int) tIPToDatePMSpinner.getValue());
				phaseTime.getPostmortem().setToDatePercent((double) tIPToDatePerPMSpinner.getValue());
				phaseTime.setTotalPlan((int) tIPPlanTotalSpinner.getValue());
				phaseTime.setTotalAcutal((int) tIPActualTotalSpinner.getValue());
				phaseTime.setTotalTodate((int) tIPToDateTotalSpinner.getValue());

			}
			{
				PhaseDefects.getPlanning().setActualSize((int) dIActualPlanSpinner.getValue());
				PhaseDefects.getPlanning().setToDateSize((int) dIToDatePlanSpinner.getValue());
				PhaseDefects.getPlanning().setToDatePercent((double) dIToDatePerPlanSpinner.getValue());
				PhaseDefects.getDesign().setActualSize((int) dIActualDLDSpinner.getValue());
				PhaseDefects.getDesign().setToDateSize((int) dIToDateDLDSpinner.getValue());
				PhaseDefects.getDesign().setToDatePercent((double) dIToDatePerDLDSpinner.getValue());
				PhaseDefects.getCode().setActualSize((int) dIActualCodeSpinner.getValue());
				PhaseDefects.getCode().setToDateSize((int) dIToDateCodeSpinner.getValue());
				PhaseDefects.getCode().setToDatePercent((double) dIToDatePerCodeSpinner.getValue());
				PhaseDefects.getCompile().setToDateSize((int) dIActualCompileSpinner.getValue());
				PhaseDefects.getCompile().setActualSize((int) dIToDateCompileSpinner.getValue());
				PhaseDefects.getCompile().setToDatePercent((double) dIToDatePerCompileSpinner.getValue());
				PhaseDefects.getTesting().setActualSize((int) dIActualUTSpinner.getValue());
				PhaseDefects.getTesting().setToDateSize((int) dIToDateUTSpinner.getValue());
				PhaseDefects.getTesting().setToDatePercent((double) dIToDatePerUTSpinner.getValue());
				PhaseDefects.getPostmortem().setActualSize((int) dIActualPMSpinner.getValue());
				PhaseDefects.getPostmortem().setToDateSize((int) dIToDatePMSpinner.getValue());
				PhaseDefects.getPostmortem().setToDatePercent((double) dIToDatePerPMSpinner.getValue());
				PhaseDefects.setTotalAcutal((int) dIActualTotalSpinner.getValue());
				PhaseDefects.setTotalTodate((int) dIToDateTotalSpinner.getValue());

			}

			{
				DefectsRemoved.getPlanning().setActualSize((int) drToActualPlanSpinner.getValue());
				DefectsRemoved.getPlanning().setToDateSize((int) drToDatePlanSpinner.getValue());
				DefectsRemoved.getPlanning().setToDatePercent((double) drToDatePerPlanSpinner.getValue());
				DefectsRemoved.getDesign().setActualSize((int) drToActualDLDSpinner.getValue());
				DefectsRemoved.getDesign().setToDateSize((int) drToDatePerDLDSpinner.getValue());
				DefectsRemoved.getDesign().setToDatePercent((double) drToDatePerDLDSpinner.getValue());
				DefectsRemoved.getCode().setActualSize((int) drToActualCodeSpinner.getValue());
				DefectsRemoved.getCode().setToDateSize((int) drToDateCodeSpinner.getValue());
				DefectsRemoved.getCode().setToDatePercent((double) drToDatePerCodeSpinner.getValue());
				DefectsRemoved.getCompile().setActualSize((int) drToActualCompileSpinner.getValue());
				DefectsRemoved.getCompile().setToDateSize((int) drToDateCompileSpinner.getValue());
				DefectsRemoved.getCompile().setToDatePercent((double) drToDatePerCompileSpinner.getValue());
				DefectsRemoved.getTesting().setActualSize((int) drToActualUTSpinner.getValue());
				DefectsRemoved.getTesting().setToDateSize((int) drToDateUTSpinner.getValue());
				DefectsRemoved.getTesting().setToDatePercent((double) drToDatePerUTSpinner.getValue());
				DefectsRemoved.getPostmortem().setActualSize((int) drToActualPMSpinner.getValue());
				DefectsRemoved.getPostmortem().setToDateSize((int) drToDatePMSpinner.getValue());
				DefectsRemoved.getPostmortem().setToDatePercent((double) drToDatePerPMSpinner.getValue());
				DefectsRemoved.setTotalAcutal((int) drToActualTotalSpinner.getValue());
				DefectsRemoved.setTotalTodate((int) drToDateTotalSpinner.getValue());
			}

			Manager.saveProjects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	public void setLOC() {

		try {

			PSPProjectLOCSummary LOC = Manager.getProject(ProjectID).getSummary().getProgramSize();
			PSPProjectLogPhase phaseTime = Manager.getProject(ProjectID).getSummary().getPhaseTime();
			PSPProjectLogPhase PhaseDefects = Manager.getProject(ProjectID).getSummary().getPhaseDefects();
			PSPProjectLogPhase DefectsRemoved = Manager.getProject(ProjectID).getSummary().getDefectsRemoved();

			
				basePlanSpinner.setValue(LOC.getBase().getPlanSize());
				baseActualSpinner.setValue(LOC.getBase().getActualSize());
				deletedPlanSpinner.setValue(LOC.getDeleted().getPlanSize());
				deletedActualSpinner.setValue(LOC.getDeleted().getActualSize());
				modifiedPlanSpinner.setValue(LOC.getModified().getPlanSize());
				modifiedActualSpinner.setValue(LOC.getModified().getActualSize());
				addedPlanSpinner.setValue(LOC.getAdded().getPlanSize());
				addedActualSpinner.setValue(LOC.getAdded().getActualSize());
				reusedPlanSpinner.setValue(LOC.getReused().getPlanSize());
				reusedActualSpinner.setValue(LOC.getReused().getActualSize());
				reusedToDateSpinner.setValue(LOC.getReused().getToDateSize());
				aMPlanSpinner.setValue(LOC.getAddedModified().getPlanSize());
				aMActualSpinner.setValue(LOC.getAddedModified().getActualSize());
				aMToDateSpinner.setValue(LOC.getAddedModified().getToDateSize());
				totalPlanSpinner.setValue(LOC.getTotal().getPlanSize());
				totalActualSpinner.setValue(LOC.getTotal().getActualSize());
				totalToDateSpinner.setValue(LOC.getTotal().getToDateSize());
				nRPlanSpinner.setValue(LOC.getNewReused().getPlanSize());
				nRActualSpinner.setValue(LOC.getNewReused().getActualSize());
				nRToDateSpinner.setValue(LOC.getNewReused().getToDateSize());
			
			
				tIPPlanPlanSpinner.setValue(phaseTime.getPlanning().getPlanSize());
				tIPActualPlanSpinner.setValue(phaseTime.getPlanning().getActualSize());
				tIPToDatePlanSpinner.setValue(phaseTime.getPlanning().getToDateSize());
				tIPToDatePerPlanSpinner.setValue(phaseTime.getPlanning().getToDatePercent());
				tIPPlanDLDSpinner.setValue(phaseTime.getDesign().getPlanSize());
				tIPActualDLDSpinner.setValue(phaseTime.getDesign().getActualSize());
				tIPToDateDLDSpinner.setValue(phaseTime.getDesign().getToDateSize());
				tIPToDatePerDLDSpinner.setValue(phaseTime.getDesign().getToDatePercent());
				tIPPlanCodeSpinner.setValue(phaseTime.getCode().getPlanSize());
				tIPActualCodeSpinner.setValue(phaseTime.getCode().getActualSize());
				tIPToDateCodeSpinner.setValue(phaseTime.getCode().getToDateSize());
				tIPToDatePerCodeSpinner.setValue(phaseTime.getCode().getToDatePercent());
				tIPPlanCompileSpinner.setValue(phaseTime.getCompile().getPlanSize());
				tIPActualCompileSpinner.setValue(phaseTime.getCompile().getActualSize());
				tIPToDateCompileSpinner.setValue(phaseTime.getCompile().getToDateSize());
				tIPToDatePerCompileSpinner.setValue(phaseTime.getCompile().getToDatePercent());
				tIPPlanUTSpinner.setValue(phaseTime.getTesting().getPlanSize());
				tIPActualUTSpinner.setValue(phaseTime.getTesting().getActualSize());
				tIPToDateUTSpinner.setValue(phaseTime.getTesting().getToDateSize());
				tIPToDatePerUTSpinner.setValue(phaseTime.getTesting().getToDatePercent());
				tIPPlanPMSpinner.setValue(phaseTime.getPostmortem().getPlanSize());
				tIPActualPMSpinner.setValue(phaseTime.getPostmortem().getActualSize());
				tIPToDatePMSpinner.setValue(phaseTime.getPostmortem().getToDateSize());
				tIPToDatePerPMSpinner.setValue(phaseTime.getPostmortem().getToDatePercent());
				tIPPlanTotalSpinner.setValue(phaseTime.getTotalPlan());
				tIPActualTotalSpinner.setValue(phaseTime.getTotalAcutal());
				tIPToDateTotalSpinner.setValue(phaseTime.getTotalTodate());
			
			
				dIActualPlanSpinner.setValue(PhaseDefects.getPlanning().getActualSize());
				dIToDatePlanSpinner.setValue(PhaseDefects.getPlanning().getToDateSize());
				dIToDatePerPlanSpinner.setValue(PhaseDefects.getPlanning().getToDatePercent());
				dIActualDLDSpinner.setValue(PhaseDefects.getDesign().getActualSize());
				dIToDateDLDSpinner.setValue(PhaseDefects.getDesign().getToDateSize());
				dIToDatePerDLDSpinner.setValue(PhaseDefects.getDesign().getToDatePercent());
				dIActualCodeSpinner.setValue(PhaseDefects.getCode().getActualSize());
				dIToDateCodeSpinner.setValue(PhaseDefects.getCode().getToDateSize());
				dIToDatePerCodeSpinner.setValue(PhaseDefects.getCode().getToDatePercent());
				dIActualCompileSpinner.setValue(PhaseDefects.getCompile().getToDateSize());
				dIToDateCompileSpinner.setValue(PhaseDefects.getCompile().getActualSize());
				
				dIToDatePerCompileSpinner.setValue(PhaseDefects.getCompile().getToDatePercent());
				dIActualUTSpinner.setValue(PhaseDefects.getTesting().getActualSize());
				dIToDateUTSpinner.setValue(PhaseDefects.getTesting().getToDateSize());
				dIToDatePerUTSpinner.setValue(PhaseDefects.getTesting().getToDatePercent());
				dIActualPMSpinner.setValue(PhaseDefects.getPostmortem().getActualSize());
				dIToDatePMSpinner.setValue(PhaseDefects.getPostmortem().getToDateSize());
				dIToDatePerPMSpinner.setValue(PhaseDefects.getPostmortem().getToDatePercent());
				dIActualTotalSpinner.setValue(PhaseDefects.getTotalAcutal());
				dIToDateTotalSpinner.setValue(PhaseDefects.getTotalTodate());
			
			
				drToActualPlanSpinner.setValue(DefectsRemoved.getPlanning().getActualSize());
				drToDatePlanSpinner.setValue(DefectsRemoved.getPlanning().getToDateSize());
				drToDatePerPlanSpinner.setValue(DefectsRemoved.getPlanning().getToDatePercent());
				drToActualDLDSpinner.setValue(DefectsRemoved.getDesign().getActualSize());
				drToDatePerDLDSpinner.setValue(DefectsRemoved.getDesign().getToDateSize());
				drToDatePerDLDSpinner.setValue(DefectsRemoved.getDesign().getToDatePercent());
				drToActualCodeSpinner.setValue(DefectsRemoved.getCode().getActualSize());
				drToDateCodeSpinner.setValue(DefectsRemoved.getCode().getToDateSize());
				drToDatePerCodeSpinner.setValue(DefectsRemoved.getCode().getToDatePercent());
				drToActualCompileSpinner.setValue(DefectsRemoved.getCompile().getActualSize());
				drToDateCompileSpinner.setValue(DefectsRemoved.getCompile().getToDateSize());
				drToDatePerCompileSpinner.setValue(DefectsRemoved.getCompile().getToDatePercent());
				drToActualUTSpinner.setValue(DefectsRemoved.getTesting().getActualSize());
				drToDateUTSpinner.setValue(DefectsRemoved.getTesting().getToDateSize());
				drToDatePerUTSpinner.setValue(DefectsRemoved.getTesting().getToDatePercent());
				drToActualPMSpinner.setValue(DefectsRemoved.getPostmortem().getActualSize());
				drToDatePMSpinner.setValue(DefectsRemoved.getPostmortem().getToDateSize());
				drToDatePerPMSpinner.setValue(DefectsRemoved.getPostmortem().getToDatePercent());
				drToActualTotalSpinner.setValue(DefectsRemoved.getTotalAcutal());
				drToDateTotalSpinner.setValue(DefectsRemoved.getTotalTodate());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	public void saveSummary() {

		PSPPlanSummary summary = Manager.getProject(ProjectID).getSummary();
		summary.setStudent(studenttextField.getText());
		summary.setLanguage(languageTextField.getText());
		summary.setInstructor(instructorTextField.getText());
		summary.setProgram(programTextField.getText());
		summary.setStartDate((Date) startDateSpinner.getValue());
		summary.setEndDate((Date) endDateSpinner.getValue());

		// chnagephase
		if (summary.getStudent().isEmpty() != true && summary.getInstructor().isEmpty() != true
				&& summary.getProgram().isEmpty() != true
				&& Manager.getProject(ProjectID).getPhase().equals(PSPProjectPhase.PLANNING)) {
			Manager.getProject(ProjectID).setPhase(PSPProjectPhase.DESIGN);
		}

		try {
			Manager.saveProjects();
			System.out.println("Saving summary");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		resetPanels();

	}

	public void setSummary() {
		try {
			if (ProjectID >= 0) {
				PSPPlanSummary summary = Manager.getProject(ProjectID).getSummary();
				studenttextField.setText((summary.getStudent() == null) ? " " : summary.getStudent());
				languageTextField.setText((summary.getLanguage() == null) ? " " : summary.getLanguage());
				instructorTextField.setText((summary.getInstructor() == null) ? " " : summary.getInstructor());
				programTextField.setText((summary.getProgram() == null) ? " " : summary.getProgram());
				if (summary.getStartDate() == null) {
					startDateSpinner.setValue(null);
					// startDateSpinner.setValue((SpinnerDateModel) today);
				} else {
					startDateSpinner.setValue(summary.getStartDate());
				}
				if (summary.getEndDate() == null) {
					// endDateSpinner = new JSpinner();
					// startDateSpinner.setModel(new SpinnerDateModel(new
					// Date(1491980400000L), new Date(1491980400000L), null,
					// Calendar.DAY_OF_YEAR));
					// startDateSpinner.setEditor(new
					// JSpinner.DateEditor(startDateSpinner, "MM/dd/yyyy"));
					// endDateSpinner.setValue(null);
				} else {
					endDateSpinner.setValue(summary.getEndDate());
				}
			}
			setLOC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	public void disablePanels() {
		// disable all
		projectsTabbedPane.setEnabledAt(8, !isEnabled());
		projectsTabbedPane.setEnabledAt(7, !isEnabled());
		projectsTabbedPane.setEnabledAt(6, !isEnabled());
		projectsTabbedPane.setEnabledAt(5, !isEnabled());
		projectsTabbedPane.setEnabledAt(4, !isEnabled());
		projectsTabbedPane.setEnabledAt(3, !isEnabled());
		projectsTabbedPane.setEnabledAt(2, !isEnabled());
		projectsTabbedPane.setEnabledAt(1, !isEnabled());

	}

	public void resetPanels() {
		Manager.updateProject();
		// eneable panels based off phase
		disablePanels();
		switch ((PSPProjectPhase) Manager.getProject(ProjectID).getPhase()) {
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
		setLOC();
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

	protected class ComponentTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "ID", "Module", "Type", "Purpose", "Fuction" };

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
			try {
				return Manager.Projects.get(ProjectID).getComponents().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {

			if (col == 0) {
				return Manager.Projects.get(ProjectID).getComponents().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getComponents().get(row).getModule();
			}
			if (col == 2) {
				return Manager.Projects.get(ProjectID).getComponents().get(row).getType();
			}
			if (col == 3) {
				return Manager.Projects.get(ProjectID).getComponents().get(row).getPurpose();
			}
			if (col == 4) {
				return Manager.Projects.get(ProjectID).getComponents().get(row).getFunction();
			}

			return "NAN";
		}
	}

	protected class UserTestTableModel extends AbstractTableModel {
		protected String[] columnNames = new String[] { "ID", "Module", "Title", "Expected Results", "Actual Results",
				"Status" };

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
				return Manager.Projects.get(ProjectID).getUserTests().size();
			} catch (Exception e) {
				return 0;
			}

		}

		@Override
		public Object getValueAt(int row, int col) {
			if (col == 0) {
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getID();
			}
			if (col == 1) {
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getModuleName();
			}
			if (col == 2) {
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getTestTitle();
			}
			if (col == 8) {
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getExpectedResults();
			}
			if (col == 9) {
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getActualResults();
			}
			{
				return Manager.Projects.get(ProjectID).getUserTests().get(row).getStatus();
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
