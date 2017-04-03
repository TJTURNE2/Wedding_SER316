package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.TimeLog;
import net.sf.memoranda.TimeLogList;
import net.sf.memoranda.util.Util;

public class TasksControlPanel extends JPanel {
	BorderLayout borderLayout = new BorderLayout();
	JButton newTime = new JButton("Add New Time");

	static TimeLogList timeLogList = null;
	static JList logs = null;
	static JScrollPane scrollPane = null;

	public TasksControlPanel() {
		newTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewTimeLog();
			}
		});

		buildGUI();
	}
	
	public void buildGUI() {
		this.setLayout(borderLayout);
		
		timeLogList = CurrentProject.getTimeLogList();
		logs = new JList(timeLogList.getList());
		scrollPane = new JScrollPane(logs);

		logs.setFont(new java.awt.Font("Dialog", 0, 11));
		logs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logs.addMouseListener(new LogEditListener());

		this.add(newTime, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void refresh() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				removeAll();
				revalidate();
				buildGUI();
			}
		});
	}
	
	TimeLogDialog createNewTimeLogDialog(String title, String[] initValues) {
		TimeLogDialog dialog;

		if (initValues == null)
			dialog = new TimeLogDialog(App.getFrame(), title);
		else
			dialog = new TimeLogDialog(App.getFrame(), title, initValues);

		Dimension frameSize = App.getFrame().getSize();
		Point location = App.getFrame().getLocation();
		dialog.setLocation((frameSize.width - dialog.getSize().width) / 2 + location.x, (frameSize.height - dialog.getSize().height) / 2 + location.y);

		dialog.setVisible(true);

		return dialog;
	}

	class LogEditListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2)
				editExistingTimeLog();
		}
	}

	private void addNewTimeLog() {
		TimeLogDialog dialog = createNewTimeLogDialog("New Time Log", null);
		if (!dialog.isCancelled) {
			TimeLog newLog = new TimeLog(
					dialog.date.getText(),
					dialog.startTime.getText(),
					dialog.endTime.getText(),
					dialog.interrupts.getText(),
					dialog.phase.getText(),
					dialog.comments.getText());

			timeLogList.addLog(newLog);

			logs.updateUI();
		}
	}

	private void editExistingTimeLog() {
		TimeLog log = timeLogList.getLog(logs.getSelectedIndex());
		String[] initValues = log.getValuesArray();

		TimeLogDialog dialog = createNewTimeLogDialog("Edit Time Log", initValues);

		if (!dialog.isCancelled) {
			log.setDate(dialog.date.getText());
			log.setStartTime(dialog.startTime.getText());
			log.setEndTime(dialog.endTime.getText());
			log.setInterruptTime(dialog.interrupts.getText());
			log.setPhase(dialog.phase.getText());
			log.setComments(dialog.comments.getText());

			logs.updateUI();
		}
	}

}
