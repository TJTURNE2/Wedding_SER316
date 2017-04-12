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
	private JPanel projectsPanel;
	private JPanel summaryPanel;
	private JPanel designPanel;
	private JPanel timeLogPanel;
	private JPanel codePanel;
	private JPanel defectLogPanel;
	private JPanel postMortemPanel;

	/**
	 * Create the panel.
	 */
	public PSPProjectsOverviewPanel() {

		setMinimumSize(new Dimension(500, 300));
		setSize(new Dimension(500, 300));
		pModel = new ProjectTableModel();
		dModel = new DefectTableModel();
		tModel = new TimeLogTableModel();
		rModel = new RequirementTableModel();

		setLayout(new BorderLayout(0, 0));

		projectsTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		projectsTabbedPane.setSize(new Dimension(600, 500));
		projectsTabbedPane.setBackground(Color.WHITE);
		add(projectsTabbedPane, BorderLayout.CENTER);

		projectsPanel = new JPanel();
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

		JScrollPane summaryScrollPane = new JScrollPane();
		summaryPanel.add(summaryScrollPane, BorderLayout.CENTER);

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
