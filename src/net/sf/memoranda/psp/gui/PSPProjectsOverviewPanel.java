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
import java.awt.Color;

@SuppressWarnings("serial")
public class PSPProjectsOverviewPanel extends JPanel {

	JFrame pFrame;
	private JTable projectsTable;
	private JTable requirementTable;
	private JTable designTable;
	private JTable timeLogTable;
	private JTable defectLogTable;

	/**
	 * Create the panel.
	 */
	public PSPProjectsOverviewPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane projectsTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		projectsTabbedPane.setBackground(Color.BLACK);
		add(projectsTabbedPane, BorderLayout.CENTER);
		
		JPanel projectsPanel = new JPanel();
		projectsTabbedPane.addTab("Projects", null, projectsPanel, null);
		projectsPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar projectsToolBar = new JToolBar();
		projectsToolBar.setPreferredSize(new Dimension(13, 25));
		projectsToolBar.setFloatable(false);
		projectsPanel.add(projectsToolBar, BorderLayout.NORTH);
		
		JScrollPane projectsScrollPane = new JScrollPane();
		projectsScrollPane.setBackground(Color.WHITE);
		projectsPanel.add(projectsScrollPane, BorderLayout.CENTER);
		
		projectsTable = new JTable();
		projectsScrollPane.add(projectsTable, BorderLayout.CENTER);
		
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
		
		JScrollPane requirementScrollPane = new JScrollPane();
		requirementPanel.add(requirementScrollPane, BorderLayout.CENTER);
		
		requirementTable = new JTable();
		requirementScrollPane.add(requirementTable, BorderLayout.CENTER);
		
		JPanel designPanel = new JPanel();
		projectsTabbedPane.addTab("Design", null, designPanel, null);
		designPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar designToolBar = new JToolBar();
		designToolBar.setPreferredSize(new Dimension(13, 25));
		designToolBar.setFloatable(false);
		designPanel.add(designToolBar, BorderLayout.NORTH);
		
		JScrollPane designScrollPane = new JScrollPane();
		designPanel.add(designScrollPane);
		
		designTable = new JTable();
		designScrollPane.add(designTable);
		
		JPanel timeLogPanel = new JPanel();
		projectsTabbedPane.addTab("Time Log", null, timeLogPanel, null);
		timeLogPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar timeLogToolBar = new JToolBar();
		timeLogToolBar.setPreferredSize(new Dimension(13, 25));
		timeLogToolBar.setFloatable(false);
		timeLogPanel.add(timeLogToolBar, BorderLayout.NORTH);
		
		JScrollPane timeLogScrollPane = new JScrollPane();
		timeLogPanel.add(timeLogScrollPane, BorderLayout.CENTER);
		
		timeLogTable = new JTable();
		timeLogScrollPane.add(timeLogTable);
		
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
		
		JScrollPane defectLogScrollPane = new JScrollPane();
		defectLogPanel.add(defectLogScrollPane);
		
		defectLogTable = new JTable();
		defectLogScrollPane.add(defectLogTable);
		
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

	public static void main(String[] args) {
		new PSPProjectsOverviewPanel();
	}

}
