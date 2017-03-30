package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import net.sf.memoranda.TimeLog;

public class TasksControlPanel extends JPanel {
	BorderLayout borderLayout = new BorderLayout();
	JButton newTime = new JButton("Add New Time");

	Vector<TimeLog> timeLogs = new Vector<TimeLog>();
	JList logs = new JList(timeLogs);
	JScrollPane scrollPane = new JScrollPane(logs);

	public TasksControlPanel() {
		this.setLayout(borderLayout);

		logs.setFont(new java.awt.Font("Dialog", 0, 11));
		logs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logs.addMouseListener(new LogEditListener());

		newTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewTimeRecording();
			}
		});

		this.add(newTime, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	TimeRecordingDialog createNewTimeRecordingDialog(String title, String[] initValues) {
		TimeRecordingDialog dialog;

		if (initValues == null)
			dialog = new TimeRecordingDialog(App.getFrame(), title);
		else
			dialog = new TimeRecordingDialog(App.getFrame(), title, initValues);

		Dimension frameSize = App.getFrame().getSize();
		Point location = App.getFrame().getLocation();
		dialog.setLocation((frameSize.width - dialog.getSize().width) / 2 + location.x, (frameSize.height - dialog.getSize().height) / 2 + location.y);

		dialog.setVisible(true);

		return dialog;
	}

	class LogEditListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2)
				editExistingTimeRecording();
		}
	}

	private void addNewTimeRecording() {
		TimeRecordingDialog dialog = createNewTimeRecordingDialog("New Time Recording", null);
		if (!dialog.isCancelled) {
			TimeLog newLog = new TimeLog(
					dialog.date.getText(),
					dialog.startTime.getText(),
					dialog.endTime.getText(),
					dialog.interrupts.getText(),
					dialog.phase.getText(),
					dialog.comments.getText());

			timeLogs.addElement(newLog);

			logs.updateUI();
		}
	}

	private void editExistingTimeRecording() {
		TimeLog log = timeLogs.elementAt(logs.getSelectedIndex());
		String[] initValues = log.getValuesArray();

		TimeRecordingDialog dialog = createNewTimeRecordingDialog("Edit Time Recording", initValues);

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
