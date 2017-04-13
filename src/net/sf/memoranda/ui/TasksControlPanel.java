package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.DefectLog;
import net.sf.memoranda.DefectLogList;
import net.sf.memoranda.TimeLog;
import net.sf.memoranda.TimeLogList;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.Local;

public class TasksControlPanel extends JPanel {
    
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel timePane = new JPanel(new BorderLayout());
	JPanel defectPane = new JPanel(new BorderLayout());

	JButton newTime = new JButton("Add New Time");
	JButton newDefect = new JButton("Add New Defect"); // EDIT #51

	static TimeLogList timeLogList = null;
	static JList<TimeLog> timeLogs = null;
	static JScrollPane timeScrollPane = new JScrollPane();

	static DefectLogList defectLogList = null;
	static JList<DefectLog> defectLogs = null;
	static JScrollPane defectScrollPane = new JScrollPane();

	public TasksControlPanel() {
		newTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewTimeLog();
			}
		});
		
		newDefect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewDefectLog();
			}
		});
		
		buildGUI();
	}

	public void buildGUI() {
		this.setLayout(new BorderLayout());

		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

		timeLogList = CurrentProject.getTimeLogList();
		timeLogs = new JList<TimeLog>(timeLogList.getList());
		timeScrollPane.getViewport().setView(timeLogs);

		timeLogs.setFont(new java.awt.Font("Dialog", 0, 11));
		timeLogs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		timeLogs.addMouseListener(new LogEditListener());

		timePane.add(newTime, BorderLayout.PAGE_START);
		timePane.add(timeScrollPane, BorderLayout.CENTER);

		defectLogList = CurrentProject.getDefectLogList();
		defectLogs = new JList<DefectLog>(defectLogList.getList());
		defectScrollPane.getViewport().setView(defectLogs);

		defectLogs.setFont(new java.awt.Font("Dialog", 0, 11));
		defectLogs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		defectLogs.addMouseListener(new DefectEditListener());
		
		defectPane.add(newDefect, BorderLayout.PAGE_START); // EDIT #51
		defectPane.add(defectScrollPane, BorderLayout.CENTER);

		tabbedPane.setFont(new java.awt.Font("Dialog", 1, 10));
		tabbedPane.add(timePane, "Time Logs");
		tabbedPane.add(defectPane, "Defect Logs");

		this.add(tabbedPane, BorderLayout.CENTER);
	}

	public void refresh() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				removeAll();
				revalidate();
				buildGUI();
				repaint();
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
	
	class DefectEditListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				editExistingDefectLog();
			}
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

			timeLogs.updateUI();
		}
	}
	
	/**
	 * @method: addNewDefectLog
	 * @returns: void
	 * 
	 * @description: Adds a new defect log
	*/
	private void addNewDefectLog() {
		DefectLog l = new DefectLog();
    	DefectLogDialog dlg = new DefectLogDialog(App.getFrame(), Local.getString("New Defect Log"), CurrentProject.getDefectLogList().getList().size() + 1);
  
    	Dimension frmSize = App.getFrame().getSize();
    	Point loc = App.getFrame().getLocation();	    
    	dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x, (frmSize.height - dlg.getSize().height) / 2 + loc.y);
    	
    	
        // dlg.descriptionField.setText(l.getDescription());
       // dlg.date.setValue(CurrentProject.get().getStartDate());
    	
        dlg.typeCB.setSelectedItem(Local.getString("None")); 
        dlg.severityCB.setSelectedItem(Local.getString("Low"));
        dlg.injectCB.setSelectedItem(Local.getString("None"));
        dlg.removeCB.setSelectedItem(Local.getString("None"));
		
		dlg.chkActive_actionPerformed(null);	
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return;
        CalendarDate d = new CalendarDate((Date) dlg.date.getModel().getValue());

 		if(dlg.chkActive.isSelected())
 			l.setIsActive(true);
 		else
 			l.setIsActive(false);
 		l.setDefectNum(dlg.defectNum);
        l.setDate(d.toString());
        l.setDescription(dlg.descriptionField.getText());
        l.setType(dlg.typeCB.getSelectedItem().toString());
        l.setSeverity(dlg.severityCB.getSelectedItem().toString());
        l.setInject(dlg.injectCB.getSelectedItem().toString());
        l.setRemove(dlg.removeCB.getSelectedItem().toString());
        CurrentProject.getDefectLogList().addLog(l);
        defectLogs.updateUI();
		
	}
	

	private void editExistingTimeLog() {
		TimeLog log = timeLogList.getLog(timeLogs.getSelectedIndex());
		String[] initValues = log.getValuesArray();

		TimeLogDialog dialog = createNewTimeLogDialog("Edit Time Log", initValues);

		if (!dialog.isCancelled) {
			log.setDate(dialog.date.getText());
			log.setStartTime(dialog.startTime.getText());
			log.setEndTime(dialog.endTime.getText());
			log.setInterruptTime(dialog.interrupts.getText());
			log.setPhase(dialog.phase.getText());
			log.setComments(dialog.comments.getText());

			timeLogs.updateUI();
		}
	}
	
	/**
	 * @method: editExistingDefectLog
	 * @returns: void
	 * 
	 * @description: Edits an existing defect log
	*/
	private void editExistingDefectLog() {
		DefectLog l = defectLogList.getLog(defectLogs.getSelectedIndex());
		
    	DefectLogDialog dlg = new DefectLogDialog(App.getFrame(), Local.getString("New Defect Log"), l.getDefectNum());
    	Dimension frmSize = App.getFrame().getSize();
    	Point loc = App.getFrame().getLocation();	    
    	dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x, (frmSize.height - dlg.getSize().height) / 2 + loc.y);
    	
    	
        dlg.descriptionField.setText(l.getDescription());
       // dlg.date.setValue(CurrentProject.get().getStartDate());
        dlg.typeCB.setSelectedItem(l.getType()); 
        dlg.severityCB.setSelectedItem(l.getSeverity());
        dlg.injectCB.setSelectedItem(l.getInject());
        dlg.removeCB.setSelectedItem(l.getRemove());
        dlg.chkActive.setSelected(l.isActive());
		
		dlg.chkActive_actionPerformed(null);	
        dlg.setVisible(true);
        if (dlg.CANCELLED)
            return;
        CalendarDate d = new CalendarDate((Date) dlg.date.getModel().getValue());

 		if(dlg.chkActive.isSelected())
 			l.setIsActive(true);
 		else
 			l.setIsActive(false);
 		l.setDefectNum(dlg.defectNum);
        l.setDate(d.toString());
        l.setDescription(dlg.descriptionField.getText());
        l.setType(dlg.typeCB.getSelectedItem().toString());
        l.setSeverity(dlg.severityCB.getSelectedItem().toString());
        l.setInject(dlg.injectCB.getSelectedItem().toString());
        l.setRemove(dlg.removeCB.getSelectedItem().toString());
        CurrentProject.getDefectLogList().replaceLog(l,defectLogs.getSelectedIndex() );
        defectLogs.updateUI();
	}
}
