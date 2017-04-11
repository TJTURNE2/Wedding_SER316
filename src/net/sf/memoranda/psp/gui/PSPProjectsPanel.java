package net.sf.memoranda.psp.gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import net.sf.memoranda.psp.PSPProjectManager;
import net.sf.memoranda.psp.PSPProject;
import net.sf.memoranda.psp.PSPProject.PSPType;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class PSPProjectsPanel extends JPanel {
	private JTable table;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		// PSPProjectsPanel paneltest = new PSPProjectsPanel();
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		PSPProjectsPanel newContentPane = new PSPProjectsPanel();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public PSPProjectsPanel() {
		tableData data = new tableData();
		
		setBorder(null);
				setLayout(new BorderLayout(0, 0));
				
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBorder(null);
						scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
						add(scrollPane);
						table = new JTable(data);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setPreferredScrollableViewportSize(new Dimension(500, 275));
						table.setFillsViewportHeight(true);
						table.setBorder(null);
						
						// table.setModel(new DefaultTableModel(new Object[][] {},
						// new String[] { "Project Name", "Project Description", "Project Type",
						// "Project Status" }) {
						// boolean[] columnEditables = new boolean[] { false, false, false,
						// false };
						// });

						scrollPane.setViewportView(table);
		
				JToolBar toolBar = new JToolBar();
				add(toolBar, BorderLayout.NORTH);
				toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
				toolBar.setMaximumSize(new Dimension(800, 25));
				toolBar.setFloatable(false);
				toolBar.setMinimumSize(new Dimension(800, 25));
				toolBar.setPreferredSize(new Dimension(18, 20));
				
						JButton btnEditProject = new JButton("");
						btnEditProject.setAlignmentX(0.5f);
						btnEditProject.setBorder(null);
						btnEditProject.setHorizontalTextPosition(SwingConstants.LEFT);
						btnEditProject.setVerticalAlignment(SwingConstants.TOP);
						btnEditProject.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								table.getSelectedRow();
							}
						});
						btnEditProject.setIcon(
								new ImageIcon(PSPProjectsPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/export.png")));
						btnEditProject.setSize(new Dimension(25, 25));
						btnEditProject.setPreferredSize(new Dimension(25, 25));
						btnEditProject.setMinimumSize(new Dimension(25, 25));
						btnEditProject.setMaximumSize(new Dimension(18, 25));
						btnEditProject.setHorizontalAlignment(SwingConstants.LEFT);
						toolBar.add(btnEditProject);
						
								JButton btnNewProject = new JButton("");
								btnNewProject.setBorder(null);
								toolBar.add(btnNewProject);
								btnNewProject.setVerticalAlignment(SwingConstants.TOP);
								btnNewProject.setBorderPainted(false);
								btnNewProject.setHorizontalTextPosition(SwingConstants.LEFT);
								btnNewProject.setSize(new Dimension(25, 25));
								btnNewProject.setMinimumSize(new Dimension(25, 25));
								btnNewProject.setMaximumSize(new Dimension(18, 25));
								btnNewProject.setPreferredSize(new Dimension(25, 25));
								btnNewProject.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										PSPNewProjectDialog NewPRoject = new PSPNewProjectDialog();
										try {
											NewPRoject.NewDialog();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								});
								btnNewProject.setIcon(new ImageIcon(
										PSPProjectsPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/newproject.png")));
								btnNewProject.setHorizontalAlignment(SwingConstants.LEFT);
								
										JButton btnDeleteproject = new JButton("");
										btnDeleteproject.setAlignmentX(0.5f);
										toolBar.add(btnDeleteproject);
										btnDeleteproject.setBorder(null);
										btnDeleteproject.setHorizontalTextPosition(SwingConstants.LEFT);
										btnDeleteproject.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												table.getSelectedRow();
												
											}
										});
										btnDeleteproject.setMinimumSize(new Dimension(25, 25));
										btnDeleteproject.setMaximumSize(new Dimension(18, 25));
										btnDeleteproject.setSize(new Dimension(25, 25));
										btnDeleteproject.setPreferredSize(new Dimension(25, 25));
										btnDeleteproject.setVerticalAlignment(SwingConstants.TOP);
										btnDeleteproject.setIcon(new ImageIcon(
												PSPProjectsPanel.class.getResource("/net/sf/memoranda/ui/resources/icons/editdelete.png")));
										btnDeleteproject.setHorizontalAlignment(SwingConstants.LEFT);

		

	}

	protected class tableData extends AbstractTableModel {

		private PSPProjectManager Projects = new PSPProjectManager(); // get
																		// projects
																		// from
																		// file
																		// to
																		// display

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		public tableData() {

		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return Projects.getAllProjects().size();
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub

			if (arg1 == 0)
				return Projects.getAllProjects().get(arg0).getProjectName().toString();
			else if (arg1 == 1)
				return Projects.getAllProjects().get(arg0).getDescription().toString();
			else if (arg1 == 2)
				return Projects.getAllProjects().get(arg0).getPSP().toString();
			else
				return Projects.getAllProjects().get(arg0).getPhase().toString();
		}

	}

}
