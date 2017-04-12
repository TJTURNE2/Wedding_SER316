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

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Component;

@SuppressWarnings("serial")
public class PSPProjectsOverviewPanel extends JPanel {

	private PSPProjectManager Manager = new PSPProjectManager();
	//static JFrame pFrame;
	private JTable projectsTable;
	private JTable requirementTable;
	private JTable designTable;
	private JTable timeLogTable;
	private JTable defectLogTable;
	private ProjectTableModel pModel;
	
	/**
	 * Create the panel.
	 */
	public PSPProjectsOverviewPanel() {
		
		setMinimumSize(new Dimension(500, 300));
		setSize(new Dimension(500, 300));
		pModel = new ProjectTableModel();
		
		setLayout(new BorderLayout(0, 0));

		JTabbedPane projectsTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		projectsTabbedPane.setSize(new Dimension(600, 500));
		projectsTabbedPane.setBackground(Color.WHITE);
		add(projectsTabbedPane, BorderLayout.CENTER);

		JPanel projectsPanel = new JPanel();
		projectsTabbedPane.addTab("Projects", null, projectsPanel, null);
		projectsPanel.setLayout(new BorderLayout(0, 0));

		JToolBar projectsToolBar = new JToolBar();
		projectsToolBar.setSize(new Dimension(0, 25));
		projectsToolBar.setPreferredSize(new Dimension(13, 25));
		projectsToolBar.setFloatable(false);
		projectsPanel.add(projectsToolBar, BorderLayout.NORTH);

		projectsTable = new JTable(pModel);
		projectsTable.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		projectsTable.setFillsViewportHeight(true);
		projectsTable.setBorder(null);		
		
		JScrollPane projectsScrollPane = new JScrollPane(projectsTable);
		projectsScrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		projectsScrollPane.setBackground(Color.WHITE);
		projectsPanel.add(projectsScrollPane, BorderLayout.CENTER);
		

		JPanel summaryPanel = new JPanel();
		projectsTabbedPane.addTab("Summary", null, summaryPanel, null);
		summaryPanel.setLayout(new BorderLayout(0, 0));

		JToolBar summaryToolBar = new JToolBar();
		summaryToolBar.setPreferredSize(new Dimension(13, 25));
		summaryToolBar.setFloatable(false);
		summaryPanel.add(summaryToolBar, BorderLayout.NORTH);

		JScrollPane summaryScrollPane = new JScrollPane();
		summaryPanel.add(summaryScrollPane, BorderLayout.CENTER);

		JPanel requirementPanel = new JPanel();
		projectsTabbedPane.addTab("Requirements", null, requirementPanel, null);
		requirementPanel.setLayout(new BorderLayout(0, 0));

		JToolBar requirementToolBar = new JToolBar();
		requirementToolBar.setPreferredSize(new Dimension(13, 25));
		requirementToolBar.setFloatable(false);
		requirementPanel.add(requirementToolBar, BorderLayout.NORTH);
		
		requirementTable = new JTable();
		requirementTable.setFillsViewportHeight(true);
		
		JScrollPane requirementScrollPane = new JScrollPane(requirementTable);
		requirementPanel.add(requirementScrollPane, BorderLayout.CENTER);

		JPanel designPanel = new JPanel();
		projectsTabbedPane.addTab("Design", null, designPanel, null);
		designPanel.setLayout(new BorderLayout(0, 0));

		JToolBar designToolBar = new JToolBar();
		designToolBar.setPreferredSize(new Dimension(13, 25));
		designToolBar.setFloatable(false);
		designPanel.add(designToolBar, BorderLayout.NORTH);

		designTable = new JTable();
		designTable.setFillsViewportHeight(true);
		
		JScrollPane designScrollPane = new JScrollPane(designTable);
		designPanel.add(designScrollPane);

		JPanel timeLogPanel = new JPanel();
		projectsTabbedPane.addTab("Time Log", null, timeLogPanel, null);
		timeLogPanel.setLayout(new BorderLayout(0, 0));

		JToolBar timeLogToolBar = new JToolBar();
		timeLogToolBar.setPreferredSize(new Dimension(13, 25));
		timeLogToolBar.setFloatable(false);
		timeLogPanel.add(timeLogToolBar, BorderLayout.NORTH);

		timeLogTable = new JTable();
		timeLogTable.setFillsViewportHeight(true);
		
		JScrollPane timeLogScrollPane = new JScrollPane(timeLogTable);
		timeLogPanel.add(timeLogScrollPane, BorderLayout.CENTER);

		JPanel codePanel = new JPanel();
		projectsTabbedPane.addTab("Code", null, codePanel, null);
		codePanel.setLayout(new BorderLayout(0, 0));

		JToolBar codeToolBar = new JToolBar();
		codeToolBar.setFloatable(false);
		codeToolBar.setPreferredSize(new Dimension(13, 25));
		codePanel.add(codeToolBar, BorderLayout.NORTH);

		JScrollPane codeScrollPane = new JScrollPane();
		codePanel.add(codeScrollPane);

		JPanel defectLogPanel = new JPanel();
		projectsTabbedPane.addTab("Defect Log", null, defectLogPanel, null);
		defectLogPanel.setLayout(new BorderLayout(0, 0));

		JToolBar defectLogToolBar = new JToolBar();
		defectLogToolBar.setFloatable(false);
		defectLogToolBar.setPreferredSize(new Dimension(13, 25));
		defectLogPanel.add(defectLogToolBar, BorderLayout.NORTH);

		defectLogTable = new JTable();
		defectLogTable.setFillsViewportHeight(true);
		
		JScrollPane defectLogScrollPane = new JScrollPane(defectLogTable);
		defectLogPanel.add(defectLogScrollPane);

		JPanel postMortemPanel = new JPanel();
		projectsTabbedPane.addTab("Post Mortem", null, postMortemPanel, null);
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
		public String getColumnName(int col){
			
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
