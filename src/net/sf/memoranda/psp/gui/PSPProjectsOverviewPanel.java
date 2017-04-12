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

@SuppressWarnings("serial")
public class PSPProjectsOverviewPanel extends JPanel {

	private PSPProjectManager Manager = new PSPProjectManager();
	private static int ProjectID = -1;
	private static int requirementID;
	private JTable projectsTable;
	private JTable requirementTable;
	private JTable designTable;
	private JTable timeLogTable;
	private JTable defectLogTable;
	private ProjectTableModel pModel;
	private DefectTableModel dModel;
	private TimeLogTableModel tModel;
	private RequirementTableModel rModel;
	private PSPNewProjectDialog newProject;
	private PSPNewTimeEntryDialog newTimeLog;
	private PSPNewRequirementDialog newRequirement;
	private PSPNewDefectDialog newDefect;
	private JTabbedPane projectsTabbedPane;
	private JTabbedPane summarytabbedPane;
	private JPanel projectsPanel;
	private JPanel summaryPanel;
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
		btnDeleteProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				projectsTabbedPane.setEnabledAt(7, !isEnabled());
				projectsTabbedPane.setEnabledAt(6, !isEnabled());
				projectsTabbedPane.setEnabledAt(5, !isEnabled());
				projectsTabbedPane.setEnabledAt(4, !isEnabled());
				projectsTabbedPane.setEnabledAt(3, !isEnabled());
				projectsTabbedPane.setEnabledAt(2, !isEnabled());
				projectsTabbedPane.setEnabledAt(1, !isEnabled());
				ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				Manager.deleteProject(ProjectID);
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

				projectsTabbedPane.setEnabledAt(7, !isEnabled());
				projectsTabbedPane.setEnabledAt(6, !isEnabled());
				projectsTabbedPane.setEnabledAt(5, !isEnabled());
				projectsTabbedPane.setEnabledAt(4, !isEnabled());
				projectsTabbedPane.setEnabledAt(3, !isEnabled());
				projectsTabbedPane.setEnabledAt(2, !isEnabled());
				projectsTabbedPane.setEnabledAt(1, !isEnabled());
				
				ProjectID = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);
				
				switch((PSPProjectPhase)Manager.getProject(ProjectID).getPhase()){
				case POSTMORTEM:
					projectsTabbedPane.setEnabledAt(7, isEnabled());
				case TEST:
				case COMPILE:
				case CODEREVIEW:
				case CODE:
					projectsTabbedPane.setEnabledAt(5, isEnabled());
				case DESIGNREVIEW:
					projectsTabbedPane.setEnabledAt(6, isEnabled());
				case DESIGN:
					projectsTabbedPane.setEnabledAt(4, isEnabled());
					projectsTabbedPane.setEnabledAt(3, isEnabled());
					projectsTabbedPane.setEnabledAt(2, isEnabled());
				case PLANNING:
					projectsTabbedPane.setEnabledAt(1, isEnabled());
				}
				
			}
		});

		JScrollPane projectsScrollPane = new JScrollPane(projectsTable);
		projectsScrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		projectsScrollPane.setBackground(Color.WHITE);
		projectsPanel.add(projectsScrollPane, BorderLayout.CENTER);

		summaryPanel = new JPanel();
		projectsTabbedPane.addTab("Summary", null, summaryPanel, null);
		projectsTabbedPane.setEnabledAt(1, false);
		summaryPanel.setLayout(new BorderLayout(0, 0));

		JToolBar summaryToolBar = new JToolBar();
		summaryToolBar.setPreferredSize(new Dimension(13, 25));
		summaryToolBar.setFloatable(false);
		summaryPanel.add(summaryToolBar, BorderLayout.NORTH);

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
		//summaryPanel.add(summaryScrollPane, BorderLayout.CENTER);
		summaryLOCPanel = new JPanel();
		phaseTimePanel = new JPanel();
		phaseDefectsPanel = new JPanel();
		defectsRemovedPanel = new JPanel();
		programSummary = new JPanel();
		summarytabbedPane = new JTabbedPane(JTabbedPane.TOP);
		summaryPanel.add(summarytabbedPane, BorderLayout.CENTER);
		//summarytabbedPane.addTab("Program", null,programSummary,null);
		summarytabbedPane.addTab("Line of Code",null,summaryLOCPanel,null);
		summarytabbedPane.setEnabledAt(1, true);
		summarytabbedPane.setEnabledAt(0, true);
		GridBagLayout gbl_summaryLOCPanel = new GridBagLayout();
		gbl_summaryLOCPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_summaryLOCPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_summaryLOCPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_summaryLOCPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		summaryLOCPanel.setLayout(gbl_summaryLOCPanel);
		
		JLabel lblPlanSize = new JLabel("Plan Size");
		GridBagConstraints gbc_lblPlanSize = new GridBagConstraints();
		gbc_lblPlanSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanSize.gridx = 1;
		gbc_lblPlanSize.gridy = 0;
		summaryLOCPanel.add(lblPlanSize, gbc_lblPlanSize);
		
		JLabel lblAcutalSize = new JLabel("Acutal Size");
		GridBagConstraints gbc_lblAcutalSize = new GridBagConstraints();
		gbc_lblAcutalSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcutalSize.gridx = 3;
		gbc_lblAcutalSize.gridy = 0;
		summaryLOCPanel.add(lblAcutalSize, gbc_lblAcutalSize);
		
		JLabel lblNewLabel_10 = new JLabel("To Date");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 5;
		gbc_lblNewLabel_10.gridy = 0;
		summaryLOCPanel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblBase = new JLabel("Base(B)");
		lblBase.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBase = new GridBagConstraints();
		gbc_lblBase.anchor = GridBagConstraints.WEST;
		gbc_lblBase.insets = new Insets(0, 0, 5, 5);
		gbc_lblBase.gridx = 0;
		gbc_lblBase.gridy = 1;
		summaryLOCPanel.add(lblBase, gbc_lblBase);
		
		JSpinner basePlanSpinner = new JSpinner();
		GridBagConstraints gbc_basePlanSpinner = new GridBagConstraints();
		gbc_basePlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_basePlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_basePlanSpinner.gridx = 1;
		gbc_basePlanSpinner.gridy = 1;
		summaryLOCPanel.add(basePlanSpinner, gbc_basePlanSpinner);
		
		JSpinner baseActualSpinner = new JSpinner();
		GridBagConstraints gbc_baseActualSpinner = new GridBagConstraints();
		gbc_baseActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_baseActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_baseActualSpinner.gridx = 3;
		gbc_baseActualSpinner.gridy = 1;
		summaryLOCPanel.add(baseActualSpinner, gbc_baseActualSpinner);
		
		JLabel lblDeleted = new JLabel("Deleted(D)");
		lblDeleted.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDeleted.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDeleted = new GridBagConstraints();
		gbc_lblDeleted.anchor = GridBagConstraints.WEST;
		gbc_lblDeleted.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeleted.gridx = 0;
		gbc_lblDeleted.gridy = 2;
		summaryLOCPanel.add(lblDeleted, gbc_lblDeleted);
		
		JSpinner deletedPlanSpinner = new JSpinner();
		GridBagConstraints gbc_deletedPlanSpinner = new GridBagConstraints();
		gbc_deletedPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_deletedPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_deletedPlanSpinner.gridx = 1;
		gbc_deletedPlanSpinner.gridy = 2;
		summaryLOCPanel.add(deletedPlanSpinner, gbc_deletedPlanSpinner);
		
		JSpinner deletedActualSpinner = new JSpinner();
		GridBagConstraints gbc_deletedActualSpinner = new GridBagConstraints();
		gbc_deletedActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_deletedActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_deletedActualSpinner.gridx = 3;
		gbc_deletedActualSpinner.gridy = 2;
		summaryLOCPanel.add(deletedActualSpinner, gbc_deletedActualSpinner);
		
		JLabel lblModified = new JLabel("Modified(M)");
		lblModified.setHorizontalTextPosition(SwingConstants.LEFT);
		lblModified.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblModified = new GridBagConstraints();
		gbc_lblModified.anchor = GridBagConstraints.WEST;
		gbc_lblModified.insets = new Insets(0, 0, 5, 5);
		gbc_lblModified.gridx = 0;
		gbc_lblModified.gridy = 3;
		summaryLOCPanel.add(lblModified, gbc_lblModified);
		
		JSpinner modifiedPlanSpinner = new JSpinner();
		GridBagConstraints gbc_modifiedPlanSpinner = new GridBagConstraints();
		gbc_modifiedPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_modifiedPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_modifiedPlanSpinner.gridx = 1;
		gbc_modifiedPlanSpinner.gridy = 3;
		summaryLOCPanel.add(modifiedPlanSpinner, gbc_modifiedPlanSpinner);
		
		JSpinner modifiedActualSpinner = new JSpinner();
		GridBagConstraints gbc_modifiedActualSpinner = new GridBagConstraints();
		gbc_modifiedActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_modifiedActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_modifiedActualSpinner.gridx = 3;
		gbc_modifiedActualSpinner.gridy = 3;
		summaryLOCPanel.add(modifiedActualSpinner, gbc_modifiedActualSpinner);
		
		JLabel lblNewLabel_3 = new JLabel("Added(A)");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		summaryLOCPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSpinner addedPlanSpinner = new JSpinner();
		GridBagConstraints gbc_addedPlanSpinner = new GridBagConstraints();
		gbc_addedPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_addedPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_addedPlanSpinner.gridx = 1;
		gbc_addedPlanSpinner.gridy = 4;
		summaryLOCPanel.add(addedPlanSpinner, gbc_addedPlanSpinner);
		
		JSpinner addedActualSpinner = new JSpinner();
		GridBagConstraints gbc_addedActualSpinner = new GridBagConstraints();
		gbc_addedActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_addedActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_addedActualSpinner.gridx = 3;
		gbc_addedActualSpinner.gridy = 4;
		summaryLOCPanel.add(addedActualSpinner, gbc_addedActualSpinner);
		
		JLabel lblNewLabel_4 = new JLabel("Reused(R)");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		summaryLOCPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JSpinner reusedPlanSpinner = new JSpinner();
		GridBagConstraints gbc_reusedPlanSpinner = new GridBagConstraints();
		gbc_reusedPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_reusedPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_reusedPlanSpinner.gridx = 1;
		gbc_reusedPlanSpinner.gridy = 5;
		summaryLOCPanel.add(reusedPlanSpinner, gbc_reusedPlanSpinner);
		
		JSpinner reusedActualSpinner = new JSpinner();
		GridBagConstraints gbc_reusedActualSpinner = new GridBagConstraints();
		gbc_reusedActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_reusedActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_reusedActualSpinner.gridx = 3;
		gbc_reusedActualSpinner.gridy = 5;
		summaryLOCPanel.add(reusedActualSpinner, gbc_reusedActualSpinner);
		
		JSpinner reusedToDateSpinner = new JSpinner();
		GridBagConstraints gbc_reusedToDateSpinner = new GridBagConstraints();
		gbc_reusedToDateSpinner.fill = GridBagConstraints.BOTH;
		gbc_reusedToDateSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_reusedToDateSpinner.gridx = 5;
		gbc_reusedToDateSpinner.gridy = 5;
		summaryLOCPanel.add(reusedToDateSpinner, gbc_reusedToDateSpinner);
		
		JLabel lblAddedModified = new JLabel("(A) & (M)");
		GridBagConstraints gbc_lblAddedModified = new GridBagConstraints();
		gbc_lblAddedModified.anchor = GridBagConstraints.WEST;
		gbc_lblAddedModified.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddedModified.gridx = 0;
		gbc_lblAddedModified.gridy = 6;
		summaryLOCPanel.add(lblAddedModified, gbc_lblAddedModified);
		
		JSpinner aMPlanSpinner = new JSpinner();
		GridBagConstraints gbc_aMPlanSpinner = new GridBagConstraints();
		gbc_aMPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_aMPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_aMPlanSpinner.gridx = 1;
		gbc_aMPlanSpinner.gridy = 6;
		summaryLOCPanel.add(aMPlanSpinner, gbc_aMPlanSpinner);
		
		JSpinner aMActualSpinner = new JSpinner();
		GridBagConstraints gbc_aMActualSpinner = new GridBagConstraints();
		gbc_aMActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_aMActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_aMActualSpinner.gridx = 3;
		gbc_aMActualSpinner.gridy = 6;
		summaryLOCPanel.add(aMActualSpinner, gbc_aMActualSpinner);
		
		JSpinner aMToDateSpinner = new JSpinner();
		GridBagConstraints gbc_aMToDateSpinner = new GridBagConstraints();
		gbc_aMToDateSpinner.fill = GridBagConstraints.BOTH;
		gbc_aMToDateSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_aMToDateSpinner.gridx = 5;
		gbc_aMToDateSpinner.gridy = 6;
		summaryLOCPanel.add(aMToDateSpinner, gbc_aMToDateSpinner);
		
		JLabel lblTotal = new JLabel("Total(T)");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.WEST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 7;
		summaryLOCPanel.add(lblTotal, gbc_lblTotal);
		
		JSpinner totalPlanSpinner = new JSpinner();
		GridBagConstraints gbc_totalPlanSpinner = new GridBagConstraints();
		gbc_totalPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_totalPlanSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_totalPlanSpinner.gridx = 1;
		gbc_totalPlanSpinner.gridy = 7;
		summaryLOCPanel.add(totalPlanSpinner, gbc_totalPlanSpinner);
		
		JSpinner totalActualSpinner = new JSpinner();
		GridBagConstraints gbc_totalActualSpinner = new GridBagConstraints();
		gbc_totalActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_totalActualSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_totalActualSpinner.gridx = 3;
		gbc_totalActualSpinner.gridy = 7;
		summaryLOCPanel.add(totalActualSpinner, gbc_totalActualSpinner);
		
		JSpinner totalToDateSpinner = new JSpinner();
		GridBagConstraints gbc_totalToDateSpinner = new GridBagConstraints();
		gbc_totalToDateSpinner.fill = GridBagConstraints.BOTH;
		gbc_totalToDateSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_totalToDateSpinner.gridx = 5;
		gbc_totalToDateSpinner.gridy = 7;
		summaryLOCPanel.add(totalToDateSpinner, gbc_totalToDateSpinner);
		
		JLabel lblNewLabel_7 = new JLabel("(N) & (R)");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		summaryLOCPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JSpinner nRPlanSpinner = new JSpinner();
		GridBagConstraints gbc_nRPlanSpinner = new GridBagConstraints();
		gbc_nRPlanSpinner.fill = GridBagConstraints.BOTH;
		gbc_nRPlanSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_nRPlanSpinner.gridx = 1;
		gbc_nRPlanSpinner.gridy = 8;
		summaryLOCPanel.add(nRPlanSpinner, gbc_nRPlanSpinner);
		
		JSpinner nRActualSpinner = new JSpinner();
		GridBagConstraints gbc_nRActualSpinner = new GridBagConstraints();
		gbc_nRActualSpinner.fill = GridBagConstraints.BOTH;
		gbc_nRActualSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_nRActualSpinner.gridx = 3;
		gbc_nRActualSpinner.gridy = 8;
		summaryLOCPanel.add(nRActualSpinner, gbc_nRActualSpinner);
		
		JSpinner nRToDateSpinner = new JSpinner();
		GridBagConstraints gbc_nRToDateSpinner = new GridBagConstraints();
		gbc_nRToDateSpinner.fill = GridBagConstraints.BOTH;
		gbc_nRToDateSpinner.gridx = 5;
		gbc_nRToDateSpinner.gridy = 8;
		summaryLOCPanel.add(nRToDateSpinner, gbc_nRToDateSpinner);
		summarytabbedPane.addTab("Time In Phase",null,phaseTimePanel,null);
		summarytabbedPane.setEnabledAt(2, true);
		GridBagLayout gbl_phaseTimePanel = new GridBagLayout();
		gbl_phaseTimePanel.columnWidths = new int[]{2, 15, 2, 0, 0, 0, 0, 0, 2, 0};
		gbl_phaseTimePanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 30, 30};
		gbl_phaseTimePanel.columnWeights = new double[]{1.0, 0.0, 2.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_phaseTimePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		phaseTimePanel.setLayout(gbl_phaseTimePanel);
		
		JLabel lblPhase = new JLabel("Phase");
		GridBagConstraints gbc_lblPhase = new GridBagConstraints();
		gbc_lblPhase.fill = GridBagConstraints.BOTH;
		gbc_lblPhase.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhase.gridx = 0;
		gbc_lblPhase.gridy = 0;
		phaseTimePanel.add(lblPhase, gbc_lblPhase);
		
		JLabel lblNewLabel = new JLabel("Plan");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		phaseTimePanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Actual");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 0;
		phaseTimePanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To Date");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 0;
		phaseTimePanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("To Date%");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 8;
		gbc_lblNewLabel_5.gridy = 0;
		phaseTimePanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblTIPPlanPlan = new JLabel("PLAN");
		GridBagConstraints gbc_lblTIPPlanPlan = new GridBagConstraints();
		gbc_lblTIPPlanPlan.fill = GridBagConstraints.BOTH;
		gbc_lblTIPPlanPlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblTIPPlanPlan.gridx = 0;
		gbc_lblTIPPlanPlan.gridy = 1;
		phaseTimePanel.add(lblTIPPlanPlan, gbc_lblTIPPlanPlan);
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 1;
		phaseTimePanel.add(spinner, gbc_spinner);
		
		JSpinner spinner_6 = new JSpinner();
		GridBagConstraints gbc_spinner_6 = new GridBagConstraints();
		gbc_spinner_6.fill = GridBagConstraints.BOTH;
		gbc_spinner_6.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_6.gridx = 4;
		gbc_spinner_6.gridy = 1;
		phaseTimePanel.add(spinner_6, gbc_spinner_6);
		
		JSpinner spinner_12 = new JSpinner();
		GridBagConstraints gbc_spinner_12 = new GridBagConstraints();
		gbc_spinner_12.fill = GridBagConstraints.BOTH;
		gbc_spinner_12.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_12.gridx = 6;
		gbc_spinner_12.gridy = 1;
		phaseTimePanel.add(spinner_12, gbc_spinner_12);
		
		JSpinner spinner_18 = new JSpinner();
		GridBagConstraints gbc_spinner_18 = new GridBagConstraints();
		gbc_spinner_18.fill = GridBagConstraints.BOTH;
		gbc_spinner_18.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_18.gridx = 8;
		gbc_spinner_18.gridy = 1;
		phaseTimePanel.add(spinner_18, gbc_spinner_18);
		
		JLabel lblTIPDLD = new JLabel("DLD");
		GridBagConstraints gbc_lblTIPDLD = new GridBagConstraints();
		gbc_lblTIPDLD.fill = GridBagConstraints.BOTH;
		gbc_lblTIPDLD.insets = new Insets(0, 0, 5, 5);
		gbc_lblTIPDLD.gridx = 0;
		gbc_lblTIPDLD.gridy = 2;
		phaseTimePanel.add(lblTIPDLD, gbc_lblTIPDLD);
		
		JSpinner spinner_1 = new JSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.BOTH;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 2;
		gbc_spinner_1.gridy = 2;
		phaseTimePanel.add(spinner_1, gbc_spinner_1);
		
		JSpinner spinner_7 = new JSpinner();
		GridBagConstraints gbc_spinner_7 = new GridBagConstraints();
		gbc_spinner_7.fill = GridBagConstraints.BOTH;
		gbc_spinner_7.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_7.gridx = 4;
		gbc_spinner_7.gridy = 2;
		phaseTimePanel.add(spinner_7, gbc_spinner_7);
		
		JSpinner spinner_13 = new JSpinner();
		GridBagConstraints gbc_spinner_13 = new GridBagConstraints();
		gbc_spinner_13.fill = GridBagConstraints.BOTH;
		gbc_spinner_13.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_13.gridx = 6;
		gbc_spinner_13.gridy = 2;
		phaseTimePanel.add(spinner_13, gbc_spinner_13);
		
		JSpinner spinner_19 = new JSpinner();
		GridBagConstraints gbc_spinner_19 = new GridBagConstraints();
		gbc_spinner_19.fill = GridBagConstraints.BOTH;
		gbc_spinner_19.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_19.gridx = 8;
		gbc_spinner_19.gridy = 2;
		phaseTimePanel.add(spinner_19, gbc_spinner_19);
		
		JLabel lblNTIPCode = new JLabel("CODE");
		GridBagConstraints gbc_lblNTIPCode = new GridBagConstraints();
		gbc_lblNTIPCode.fill = GridBagConstraints.BOTH;
		gbc_lblNTIPCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblNTIPCode.gridx = 0;
		gbc_lblNTIPCode.gridy = 3;
		phaseTimePanel.add(lblNTIPCode, gbc_lblNTIPCode);
		
		JSpinner spinner_2 = new JSpinner();
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.fill = GridBagConstraints.BOTH;
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.gridx = 2;
		gbc_spinner_2.gridy = 3;
		phaseTimePanel.add(spinner_2, gbc_spinner_2);
		
		JSpinner spinner_8 = new JSpinner();
		GridBagConstraints gbc_spinner_8 = new GridBagConstraints();
		gbc_spinner_8.fill = GridBagConstraints.BOTH;
		gbc_spinner_8.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_8.gridx = 4;
		gbc_spinner_8.gridy = 3;
		phaseTimePanel.add(spinner_8, gbc_spinner_8);
		
		JSpinner spinner_14 = new JSpinner();
		GridBagConstraints gbc_spinner_14 = new GridBagConstraints();
		gbc_spinner_14.fill = GridBagConstraints.BOTH;
		gbc_spinner_14.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_14.gridx = 6;
		gbc_spinner_14.gridy = 3;
		phaseTimePanel.add(spinner_14, gbc_spinner_14);
		
		JSpinner spinner_20 = new JSpinner();
		GridBagConstraints gbc_spinner_20 = new GridBagConstraints();
		gbc_spinner_20.fill = GridBagConstraints.BOTH;
		gbc_spinner_20.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_20.gridx = 8;
		gbc_spinner_20.gridy = 3;
		phaseTimePanel.add(spinner_20, gbc_spinner_20);
		
		JLabel lblTIPCompile = new JLabel("Compile");
		GridBagConstraints gbc_lblTIPCompile = new GridBagConstraints();
		gbc_lblTIPCompile.fill = GridBagConstraints.BOTH;
		gbc_lblTIPCompile.insets = new Insets(0, 0, 5, 5);
		gbc_lblTIPCompile.gridx = 0;
		gbc_lblTIPCompile.gridy = 4;
		phaseTimePanel.add(lblTIPCompile, gbc_lblTIPCompile);
		
		JSpinner spinner_3 = new JSpinner();
		GridBagConstraints gbc_spinner_3 = new GridBagConstraints();
		gbc_spinner_3.fill = GridBagConstraints.BOTH;
		gbc_spinner_3.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_3.gridx = 2;
		gbc_spinner_3.gridy = 4;
		phaseTimePanel.add(spinner_3, gbc_spinner_3);
		
		JSpinner spinner_9 = new JSpinner();
		GridBagConstraints gbc_spinner_9 = new GridBagConstraints();
		gbc_spinner_9.fill = GridBagConstraints.BOTH;
		gbc_spinner_9.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_9.gridx = 4;
		gbc_spinner_9.gridy = 4;
		phaseTimePanel.add(spinner_9, gbc_spinner_9);
		
		JSpinner spinner_15 = new JSpinner();
		GridBagConstraints gbc_spinner_15 = new GridBagConstraints();
		gbc_spinner_15.fill = GridBagConstraints.BOTH;
		gbc_spinner_15.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_15.gridx = 6;
		gbc_spinner_15.gridy = 4;
		phaseTimePanel.add(spinner_15, gbc_spinner_15);
		
		JSpinner spinner_21 = new JSpinner();
		GridBagConstraints gbc_spinner_21 = new GridBagConstraints();
		gbc_spinner_21.fill = GridBagConstraints.BOTH;
		gbc_spinner_21.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_21.gridx = 8;
		gbc_spinner_21.gridy = 4;
		phaseTimePanel.add(spinner_21, gbc_spinner_21);
		
		JLabel lblTIPUT = new JLabel("UT");
		GridBagConstraints gbc_lblTIPUT = new GridBagConstraints();
		gbc_lblTIPUT.fill = GridBagConstraints.BOTH;
		gbc_lblTIPUT.insets = new Insets(0, 0, 5, 5);
		gbc_lblTIPUT.gridx = 0;
		gbc_lblTIPUT.gridy = 5;
		phaseTimePanel.add(lblTIPUT, gbc_lblTIPUT);
		
		JSpinner spinner_4 = new JSpinner();
		GridBagConstraints gbc_spinner_4 = new GridBagConstraints();
		gbc_spinner_4.fill = GridBagConstraints.BOTH;
		gbc_spinner_4.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_4.gridx = 2;
		gbc_spinner_4.gridy = 5;
		phaseTimePanel.add(spinner_4, gbc_spinner_4);
		
		JSpinner spinner_10 = new JSpinner();
		GridBagConstraints gbc_spinner_10 = new GridBagConstraints();
		gbc_spinner_10.fill = GridBagConstraints.BOTH;
		gbc_spinner_10.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_10.gridx = 4;
		gbc_spinner_10.gridy = 5;
		phaseTimePanel.add(spinner_10, gbc_spinner_10);
		
		JSpinner spinner_16 = new JSpinner();
		GridBagConstraints gbc_spinner_16 = new GridBagConstraints();
		gbc_spinner_16.fill = GridBagConstraints.BOTH;
		gbc_spinner_16.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_16.gridx = 6;
		gbc_spinner_16.gridy = 5;
		phaseTimePanel.add(spinner_16, gbc_spinner_16);
		
		JSpinner spinner_22 = new JSpinner();
		GridBagConstraints gbc_spinner_22 = new GridBagConstraints();
		gbc_spinner_22.fill = GridBagConstraints.BOTH;
		gbc_spinner_22.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_22.gridx = 8;
		gbc_spinner_22.gridy = 5;
		phaseTimePanel.add(spinner_22, gbc_spinner_22);
		
		JLabel lblTIPPM = new JLabel("PM");
		GridBagConstraints gbc_lblTIPPM = new GridBagConstraints();
		gbc_lblTIPPM.fill = GridBagConstraints.BOTH;
		gbc_lblTIPPM.insets = new Insets(0, 0, 5, 5);
		gbc_lblTIPPM.gridx = 0;
		gbc_lblTIPPM.gridy = 6;
		phaseTimePanel.add(lblTIPPM, gbc_lblTIPPM);
		
		JSpinner spinner_5 = new JSpinner();
		GridBagConstraints gbc_spinner_5 = new GridBagConstraints();
		gbc_spinner_5.fill = GridBagConstraints.BOTH;
		gbc_spinner_5.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_5.gridx = 2;
		gbc_spinner_5.gridy = 6;
		phaseTimePanel.add(spinner_5, gbc_spinner_5);
		
		JSpinner spinner_11 = new JSpinner();
		GridBagConstraints gbc_spinner_11 = new GridBagConstraints();
		gbc_spinner_11.fill = GridBagConstraints.BOTH;
		gbc_spinner_11.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_11.gridx = 4;
		gbc_spinner_11.gridy = 6;
		phaseTimePanel.add(spinner_11, gbc_spinner_11);
		
		JSpinner spinner_17 = new JSpinner();
		GridBagConstraints gbc_spinner_17 = new GridBagConstraints();
		gbc_spinner_17.fill = GridBagConstraints.BOTH;
		gbc_spinner_17.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_17.gridx = 6;
		gbc_spinner_17.gridy = 6;
		phaseTimePanel.add(spinner_17, gbc_spinner_17);
		
		JSpinner spinner_23 = new JSpinner();
		GridBagConstraints gbc_spinner_23 = new GridBagConstraints();
		gbc_spinner_23.fill = GridBagConstraints.BOTH;
		gbc_spinner_23.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_23.gridx = 8;
		gbc_spinner_23.gridy = 6;
		phaseTimePanel.add(spinner_23, gbc_spinner_23);
		
		JLabel lblTIPTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTIPTotal = new GridBagConstraints();
		gbc_lblTIPTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTIPTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTIPTotal.gridx = 0;
		gbc_lblTIPTotal.gridy = 8;
		phaseTimePanel.add(lblTIPTotal, gbc_lblTIPTotal);
		
		JSpinner spinner_24 = new JSpinner();
		GridBagConstraints gbc_spinner_24 = new GridBagConstraints();
		gbc_spinner_24.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_24.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_24.gridx = 2;
		gbc_spinner_24.gridy = 8;
		phaseTimePanel.add(spinner_24, gbc_spinner_24);
		
		JSpinner spinner_25 = new JSpinner();
		GridBagConstraints gbc_spinner_25 = new GridBagConstraints();
		gbc_spinner_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_25.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_25.gridx = 4;
		gbc_spinner_25.gridy = 8;
		phaseTimePanel.add(spinner_25, gbc_spinner_25);
		
		JSpinner spinner_26 = new JSpinner();
		GridBagConstraints gbc_spinner_26 = new GridBagConstraints();
		gbc_spinner_26.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_26.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_26.gridx = 6;
		gbc_spinner_26.gridy = 8;
		phaseTimePanel.add(spinner_26, gbc_spinner_26);
		summarytabbedPane.addTab("Defects Injected",null,phaseDefectsPanel,null);
		summarytabbedPane.setEnabledAt(3, true);
		GridBagLayout gbl_phaseDefectsPanel = new GridBagLayout();
		gbl_phaseDefectsPanel.columnWidths = new int[]{0, 0, 0, 0, 2, 0, 0, 0, 0, 0};
		gbl_phaseDefectsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_phaseDefectsPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_phaseDefectsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		phaseDefectsPanel.setLayout(gbl_phaseDefectsPanel);
		
		JLabel lblNewLabel_6 = new JLabel("Phase");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		phaseDefectsPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_15 = new JLabel("Actual");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 4;
		gbc_lblNewLabel_15.gridy = 0;
		phaseDefectsPanel.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("To Date");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 6;
		gbc_lblNewLabel_16.gridy = 0;
		phaseDefectsPanel.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("To Date%");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_17.gridx = 8;
		gbc_lblNewLabel_17.gridy = 0;
		phaseDefectsPanel.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		JLabel lblNewLabel_8 = new JLabel("PLAN");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 1;
		phaseDefectsPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JSpinner spinner_29 = new JSpinner();
		GridBagConstraints gbc_spinner_29 = new GridBagConstraints();
		gbc_spinner_29.fill = GridBagConstraints.BOTH;
		gbc_spinner_29.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_29.gridx = 4;
		gbc_spinner_29.gridy = 1;
		phaseDefectsPanel.add(spinner_29, gbc_spinner_29);
		
		JSpinner spinner_35 = new JSpinner();
		GridBagConstraints gbc_spinner_35 = new GridBagConstraints();
		gbc_spinner_35.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_35.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_35.gridx = 6;
		gbc_spinner_35.gridy = 1;
		phaseDefectsPanel.add(spinner_35, gbc_spinner_35);
		
		JSpinner spinner_46 = new JSpinner();
		GridBagConstraints gbc_spinner_46 = new GridBagConstraints();
		gbc_spinner_46.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_46.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_46.gridx = 8;
		gbc_spinner_46.gridy = 1;
		phaseDefectsPanel.add(spinner_46, gbc_spinner_46);
		
		JLabel lblNewLabel_9 = new JLabel("DLD");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 2;
		phaseDefectsPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JSpinner spinner_30 = new JSpinner();
		GridBagConstraints gbc_spinner_30 = new GridBagConstraints();
		gbc_spinner_30.fill = GridBagConstraints.BOTH;
		gbc_spinner_30.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_30.gridx = 4;
		gbc_spinner_30.gridy = 2;
		phaseDefectsPanel.add(spinner_30, gbc_spinner_30);
		
		JSpinner spinner_36 = new JSpinner();
		GridBagConstraints gbc_spinner_36 = new GridBagConstraints();
		gbc_spinner_36.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_36.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_36.gridx = 6;
		gbc_spinner_36.gridy = 2;
		phaseDefectsPanel.add(spinner_36, gbc_spinner_36);
		
		JSpinner spinner_45 = new JSpinner();
		GridBagConstraints gbc_spinner_45 = new GridBagConstraints();
		gbc_spinner_45.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_45.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_45.gridx = 8;
		gbc_spinner_45.gridy = 2;
		phaseDefectsPanel.add(spinner_45, gbc_spinner_45);
		
		JLabel lblNewLabel_11 = new JLabel("CODE");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 3;
		phaseDefectsPanel.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JSpinner spinner_31 = new JSpinner();
		GridBagConstraints gbc_spinner_31 = new GridBagConstraints();
		gbc_spinner_31.fill = GridBagConstraints.BOTH;
		gbc_spinner_31.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_31.gridx = 4;
		gbc_spinner_31.gridy = 3;
		phaseDefectsPanel.add(spinner_31, gbc_spinner_31);
		
		JSpinner spinner_37 = new JSpinner();
		GridBagConstraints gbc_spinner_37 = new GridBagConstraints();
		gbc_spinner_37.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_37.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_37.gridx = 6;
		gbc_spinner_37.gridy = 3;
		phaseDefectsPanel.add(spinner_37, gbc_spinner_37);
		
		JSpinner spinner_44 = new JSpinner();
		GridBagConstraints gbc_spinner_44 = new GridBagConstraints();
		gbc_spinner_44.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_44.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_44.gridx = 8;
		gbc_spinner_44.gridy = 3;
		phaseDefectsPanel.add(spinner_44, gbc_spinner_44);
		
		JLabel lblNewLabel_12 = new JLabel("COMPILE");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 4;
		phaseDefectsPanel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JSpinner spinner_32 = new JSpinner();
		GridBagConstraints gbc_spinner_32 = new GridBagConstraints();
		gbc_spinner_32.fill = GridBagConstraints.BOTH;
		gbc_spinner_32.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_32.gridx = 4;
		gbc_spinner_32.gridy = 4;
		phaseDefectsPanel.add(spinner_32, gbc_spinner_32);
		
		JSpinner spinner_38 = new JSpinner();
		GridBagConstraints gbc_spinner_38 = new GridBagConstraints();
		gbc_spinner_38.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_38.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_38.gridx = 6;
		gbc_spinner_38.gridy = 4;
		phaseDefectsPanel.add(spinner_38, gbc_spinner_38);
		
		JSpinner spinner_43 = new JSpinner();
		GridBagConstraints gbc_spinner_43 = new GridBagConstraints();
		gbc_spinner_43.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_43.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_43.gridx = 8;
		gbc_spinner_43.gridy = 4;
		phaseDefectsPanel.add(spinner_43, gbc_spinner_43);
		
		JLabel lblNewLabel_13 = new JLabel("UT");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 5;
		phaseDefectsPanel.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JSpinner spinner_33 = new JSpinner();
		GridBagConstraints gbc_spinner_33 = new GridBagConstraints();
		gbc_spinner_33.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_33.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_33.gridx = 4;
		gbc_spinner_33.gridy = 5;
		phaseDefectsPanel.add(spinner_33, gbc_spinner_33);
		
		JSpinner spinner_39 = new JSpinner();
		GridBagConstraints gbc_spinner_39 = new GridBagConstraints();
		gbc_spinner_39.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_39.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_39.gridx = 6;
		gbc_spinner_39.gridy = 5;
		phaseDefectsPanel.add(spinner_39, gbc_spinner_39);
		
		JSpinner spinner_42 = new JSpinner();
		GridBagConstraints gbc_spinner_42 = new GridBagConstraints();
		gbc_spinner_42.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_42.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_42.gridx = 8;
		gbc_spinner_42.gridy = 5;
		phaseDefectsPanel.add(spinner_42, gbc_spinner_42);
		
		JLabel lblNewLabel_14 = new JLabel("PM");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 6;
		phaseDefectsPanel.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JSpinner spinner_34 = new JSpinner();
		GridBagConstraints gbc_spinner_34 = new GridBagConstraints();
		gbc_spinner_34.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_34.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_34.gridx = 4;
		gbc_spinner_34.gridy = 6;
		phaseDefectsPanel.add(spinner_34, gbc_spinner_34);
		
		JSpinner spinner_40 = new JSpinner();
		GridBagConstraints gbc_spinner_40 = new GridBagConstraints();
		gbc_spinner_40.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_40.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_40.gridx = 6;
		gbc_spinner_40.gridy = 6;
		phaseDefectsPanel.add(spinner_40, gbc_spinner_40);
		
		JSpinner spinner_41 = new JSpinner();
		GridBagConstraints gbc_spinner_41 = new GridBagConstraints();
		gbc_spinner_41.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_41.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_41.gridx = 8;
		gbc_spinner_41.gridy = 6;
		phaseDefectsPanel.add(spinner_41, gbc_spinner_41);
		
		JLabel lblDI = new JLabel("Total");
		GridBagConstraints gbc_lblDI = new GridBagConstraints();
		gbc_lblDI.insets = new Insets(0, 0, 0, 5);
		gbc_lblDI.gridx = 0;
		gbc_lblDI.gridy = 8;
		phaseDefectsPanel.add(lblDI, gbc_lblDI);
		
		JSpinner spinner_27 = new JSpinner();
		GridBagConstraints gbc_spinner_27 = new GridBagConstraints();
		gbc_spinner_27.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_27.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_27.gridx = 4;
		gbc_spinner_27.gridy = 8;
		phaseDefectsPanel.add(spinner_27, gbc_spinner_27);
		
		JSpinner spinner_28 = new JSpinner();
		GridBagConstraints gbc_spinner_28 = new GridBagConstraints();
		gbc_spinner_28.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_28.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_28.gridx = 6;
		gbc_spinner_28.gridy = 8;
		phaseDefectsPanel.add(spinner_28, gbc_spinner_28);
		summarytabbedPane.addTab("Defects Removed",null,defectsRemovedPanel,null);
		GridBagLayout gbl_defectsRemovedPanel = new GridBagLayout();
		gbl_defectsRemovedPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_defectsRemovedPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 30};
		gbl_defectsRemovedPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_defectsRemovedPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		defectsRemovedPanel.setLayout(gbl_defectsRemovedPanel);
		
		JLabel lblNewLabel_18 = new JLabel("Phase");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 0;
		defectsRemovedPanel.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Actual");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 5;
		gbc_lblNewLabel_19.gridy = 0;
		defectsRemovedPanel.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("To-Date");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 7;
		gbc_lblNewLabel_20.gridy = 0;
		defectsRemovedPanel.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("To Date%");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_21.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_21.gridx = 9;
		gbc_lblNewLabel_21.gridy = 0;
		defectsRemovedPanel.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("PLAN");
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 0;
		gbc_lblNewLabel_22.gridy = 1;
		defectsRemovedPanel.add(lblNewLabel_22, gbc_lblNewLabel_22);
		
		JSpinner spinner_47 = new JSpinner();
		GridBagConstraints gbc_spinner_47 = new GridBagConstraints();
		gbc_spinner_47.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_47.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_47.gridx = 5;
		gbc_spinner_47.gridy = 1;
		defectsRemovedPanel.add(spinner_47, gbc_spinner_47);
		
		JSpinner spinner_56 = new JSpinner();
		GridBagConstraints gbc_spinner_56 = new GridBagConstraints();
		gbc_spinner_56.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_56.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_56.gridx = 7;
		gbc_spinner_56.gridy = 1;
		defectsRemovedPanel.add(spinner_56, gbc_spinner_56);
		
		JSpinner spinner_61 = new JSpinner();
		GridBagConstraints gbc_spinner_61 = new GridBagConstraints();
		gbc_spinner_61.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_61.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_61.gridx = 9;
		gbc_spinner_61.gridy = 1;
		defectsRemovedPanel.add(spinner_61, gbc_spinner_61);
		
		JLabel lblNewLabel_23 = new JLabel("DLD");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 0;
		gbc_lblNewLabel_23.gridy = 2;
		defectsRemovedPanel.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		JSpinner spinner_48 = new JSpinner();
		GridBagConstraints gbc_spinner_48 = new GridBagConstraints();
		gbc_spinner_48.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_48.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_48.gridx = 5;
		gbc_spinner_48.gridy = 2;
		defectsRemovedPanel.add(spinner_48, gbc_spinner_48);
		
		JSpinner spinner_55 = new JSpinner();
		GridBagConstraints gbc_spinner_55 = new GridBagConstraints();
		gbc_spinner_55.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_55.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_55.gridx = 7;
		gbc_spinner_55.gridy = 2;
		defectsRemovedPanel.add(spinner_55, gbc_spinner_55);
		
		JSpinner spinner_62 = new JSpinner();
		GridBagConstraints gbc_spinner_62 = new GridBagConstraints();
		gbc_spinner_62.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_62.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_62.gridx = 9;
		gbc_spinner_62.gridy = 2;
		defectsRemovedPanel.add(spinner_62, gbc_spinner_62);
		
		JLabel lblNewLabel_24 = new JLabel("CODE");
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_24.gridx = 0;
		gbc_lblNewLabel_24.gridy = 3;
		defectsRemovedPanel.add(lblNewLabel_24, gbc_lblNewLabel_24);
		
		JSpinner spinner_49 = new JSpinner();
		GridBagConstraints gbc_spinner_49 = new GridBagConstraints();
		gbc_spinner_49.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_49.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_49.gridx = 5;
		gbc_spinner_49.gridy = 3;
		defectsRemovedPanel.add(spinner_49, gbc_spinner_49);
		
		JSpinner spinner_57 = new JSpinner();
		GridBagConstraints gbc_spinner_57 = new GridBagConstraints();
		gbc_spinner_57.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_57.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_57.gridx = 7;
		gbc_spinner_57.gridy = 3;
		defectsRemovedPanel.add(spinner_57, gbc_spinner_57);
		
		JSpinner spinner_63 = new JSpinner();
		GridBagConstraints gbc_spinner_63 = new GridBagConstraints();
		gbc_spinner_63.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_63.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_63.gridx = 9;
		gbc_spinner_63.gridy = 3;
		defectsRemovedPanel.add(spinner_63, gbc_spinner_63);
		
		JLabel lblNewLabel_25 = new JLabel("COMPILE");
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_25.gridx = 0;
		gbc_lblNewLabel_25.gridy = 4;
		defectsRemovedPanel.add(lblNewLabel_25, gbc_lblNewLabel_25);
		
		JSpinner spinner_50 = new JSpinner();
		GridBagConstraints gbc_spinner_50 = new GridBagConstraints();
		gbc_spinner_50.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_50.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_50.gridx = 5;
		gbc_spinner_50.gridy = 4;
		defectsRemovedPanel.add(spinner_50, gbc_spinner_50);
		
		JSpinner spinner_58 = new JSpinner();
		GridBagConstraints gbc_spinner_58 = new GridBagConstraints();
		gbc_spinner_58.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_58.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_58.gridx = 7;
		gbc_spinner_58.gridy = 4;
		defectsRemovedPanel.add(spinner_58, gbc_spinner_58);
		
		JSpinner spinner_64 = new JSpinner();
		GridBagConstraints gbc_spinner_64 = new GridBagConstraints();
		gbc_spinner_64.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_64.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_64.gridx = 9;
		gbc_spinner_64.gridy = 4;
		defectsRemovedPanel.add(spinner_64, gbc_spinner_64);
		
		JLabel lblNewLabel_26 = new JLabel("UT");
		GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
		gbc_lblNewLabel_26.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_26.gridx = 0;
		gbc_lblNewLabel_26.gridy = 5;
		defectsRemovedPanel.add(lblNewLabel_26, gbc_lblNewLabel_26);
		
		JSpinner spinner_51 = new JSpinner();
		GridBagConstraints gbc_spinner_51 = new GridBagConstraints();
		gbc_spinner_51.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_51.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_51.gridx = 5;
		gbc_spinner_51.gridy = 5;
		defectsRemovedPanel.add(spinner_51, gbc_spinner_51);
		
		JSpinner spinner_59 = new JSpinner();
		GridBagConstraints gbc_spinner_59 = new GridBagConstraints();
		gbc_spinner_59.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_59.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_59.gridx = 7;
		gbc_spinner_59.gridy = 5;
		defectsRemovedPanel.add(spinner_59, gbc_spinner_59);
		
		JSpinner spinner_65 = new JSpinner();
		GridBagConstraints gbc_spinner_65 = new GridBagConstraints();
		gbc_spinner_65.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_65.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_65.gridx = 9;
		gbc_spinner_65.gridy = 5;
		defectsRemovedPanel.add(spinner_65, gbc_spinner_65);
		
		JLabel lblNewLabel_27 = new JLabel("PM");
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_27.gridx = 0;
		gbc_lblNewLabel_27.gridy = 6;
		defectsRemovedPanel.add(lblNewLabel_27, gbc_lblNewLabel_27);
		
		JSpinner spinner_52 = new JSpinner();
		GridBagConstraints gbc_spinner_52 = new GridBagConstraints();
		gbc_spinner_52.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_52.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_52.gridx = 5;
		gbc_spinner_52.gridy = 6;
		defectsRemovedPanel.add(spinner_52, gbc_spinner_52);
		
		JSpinner spinner_60 = new JSpinner();
		GridBagConstraints gbc_spinner_60 = new GridBagConstraints();
		gbc_spinner_60.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_60.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_60.gridx = 7;
		gbc_spinner_60.gridy = 6;
		defectsRemovedPanel.add(spinner_60, gbc_spinner_60);
		
		JSpinner spinner_66 = new JSpinner();
		GridBagConstraints gbc_spinner_66 = new GridBagConstraints();
		gbc_spinner_66.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_66.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_66.gridx = 9;
		gbc_spinner_66.gridy = 6;
		defectsRemovedPanel.add(spinner_66, gbc_spinner_66);
		
		JLabel lblNewLabel_28 = new JLabel("Total");
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_28.gridx = 0;
		gbc_lblNewLabel_28.gridy = 8;
		defectsRemovedPanel.add(lblNewLabel_28, gbc_lblNewLabel_28);
		
		JSpinner spinner_53 = new JSpinner();
		GridBagConstraints gbc_spinner_53 = new GridBagConstraints();
		gbc_spinner_53.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_53.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_53.gridx = 5;
		gbc_spinner_53.gridy = 8;
		defectsRemovedPanel.add(spinner_53, gbc_spinner_53);
		
		JSpinner spinner_54 = new JSpinner();
		GridBagConstraints gbc_spinner_54 = new GridBagConstraints();
		gbc_spinner_54.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_54.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_54.gridx = 7;
		gbc_spinner_54.gridy = 8;
		defectsRemovedPanel.add(spinner_54, gbc_spinner_54);
		

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
				Manager.getProject(ProjectID).removeRequirement(requirementID);
				try {
					Manager.saveProjects();
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

		designTable = new JTable();
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
				
				int timeID = (int) timeLogTable.getValueAt(timeLogTable.getSelectedRow(), 0);
				Manager.getProject(ProjectID).removeDefectEntry(timeID);
				timeLogTable.clearSelection();
				try {
					Manager.saveProjects();
					timeLogTable.repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				int defectID = (int) defectLogTable.getValueAt(defectLogTable.getSelectedRow(), 0);
				Manager.getProject(ProjectID).removeDefectEntry(defectID);
				try {
					Manager.saveProjects();
					defectLogTable.repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		projectsTabbedPane.setEnabledAt(7, false);
		postMortemPanel.setLayout(new BorderLayout(0, 0));

		JToolBar postMortemToolBar = new JToolBar();
		postMortemToolBar.setPreferredSize(new Dimension(13, 25));
		postMortemToolBar.setFloatable(false);
		postMortemPanel.add(postMortemToolBar, BorderLayout.NORTH);

		JScrollPane postMortemScrollPane = new JScrollPane();
		postMortemPanel.add(postMortemScrollPane);
		

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
