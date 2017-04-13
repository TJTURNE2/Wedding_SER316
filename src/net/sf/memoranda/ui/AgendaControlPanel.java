package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.sf.memoranda.CurrentNote;
import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.Note;
import net.sf.memoranda.ReminderLog;
import net.sf.memoranda.ReminderLogList;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.NotesControlPanel.PopupListener;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.CurrentStorage;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.Util;

public class AgendaControlPanel extends JPanel {
	BorderLayout borderLayout = new BorderLayout();
	JButton newReminder = new JButton("Add New Reminder");


	
	static ReminderLogList reminderLogList = null;
	static JList logs = null;
	static JScrollPane scrollPane = null;

	public AgendaControlPanel() {
		newReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewReminderLog();
			}
		});

		buildGUI();
	
 
    }

 

	
	public void buildGUI() {
		this.setLayout(borderLayout);
		
		reminderLogList = CurrentProject.getReminderLogList();
		logs = new JList(reminderLogList.getList());
		scrollPane = new JScrollPane(logs);

		logs.setFont(new java.awt.Font("Dialog", 0, 11));
		logs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logs.addMouseListener(new LogEditListener());

		this.add(newReminder, BorderLayout.PAGE_START);
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
	
	ReminderLogDialog createNewReminderLogDialog(String title, String[] initValues) {
		ReminderLogDialog dialog;

		if (initValues == null)
			dialog = new ReminderLogDialog(App.getFrame(), title);
		else
			dialog = new ReminderLogDialog(App.getFrame(), title, initValues);

		Dimension frameSize = App.getFrame().getSize();
		Point location = App.getFrame().getLocation();
		dialog.setLocation((frameSize.width - dialog.getSize().width) / 2 + location.x, (frameSize.height - dialog.getSize().height) / 2 + location.y);

		dialog.setVisible(true);

		return dialog;
	}

	class LogEditListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2)
				editExistingReminderLog();
		}
	}

	private void addNewReminderLog() {
		ReminderLogDialog dialog = createNewReminderLogDialog("New Reminder", null);
		if (!dialog.isCancelled) {
			ReminderLog newLog = new ReminderLog(
					dialog.date.getText(),
					dialog.reminder.getText());

			reminderLogList.addLog(newLog);

			logs.updateUI();
		}
	}

	private void editExistingReminderLog() {
		ReminderLog log = reminderLogList.getLog(logs.getSelectedIndex());
		String[] initValues = log.getValuesArray();

		ReminderLogDialog dialog = createNewReminderLogDialog("Edit Reminder", initValues);

		if (!dialog.isCancelled) {
			log.setDate(dialog.date.getText());
			log.setReminder(dialog.reminder.getText());

			logs.updateUI();
		}
	}

}
