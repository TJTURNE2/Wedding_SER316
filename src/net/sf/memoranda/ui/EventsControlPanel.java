package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
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
import java.util.List;

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
import net.sf.memoranda.EventsLog;
import net.sf.memoranda.EventsLogList;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.NotesControlPanel.PopupListener;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.CurrentStorage;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.Util;

public class EventsControlPanel extends JPanel {
	BorderLayout borderLayout = new BorderLayout();
	JButton newEvent = new JButton("Add New Event");

	static EventsLogList eventsLogList = null;
	static JList logs = null;
	static JScrollPane scrollPane = null;

	public EventsControlPanel() {
		newEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewEventLog();
			}
		});

		buildGUI();
    }
	
	public void buildGUI() {
		this.setLayout(borderLayout);
		
		eventsLogList = CurrentProject.getEventsLogList();
		logs = new JList(eventsLogList.getList());
		scrollPane = new JScrollPane(logs);

		logs.setFont(new java.awt.Font("Dialog", 0, 11));
		logs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		logs.addMouseListener(new LogEditListener());

		this.add(newEvent, BorderLayout.PAGE_START);
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
	
	EventsPanelDialog createNewEventsPanelDialog(String title, String[] initValues) {
		EventsPanelDialog dialog;

		if (initValues == null)
			dialog = new EventsPanelDialog(App.getFrame(), title);
		else
			dialog = new EventsPanelDialog(App.getFrame(), title, initValues);

		Dimension frameSize = App.getFrame().getSize();
		Point location = App.getFrame().getLocation();
		dialog.setLocation((frameSize.width - dialog.getSize().width) / 2 + location.x, (frameSize.height - dialog.getSize().height) / 2 + location.y);

		dialog.setVisible(true);

		return dialog;
	}

	class LogEditListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2)
				editExistingEventLog();
		}
	}

	public void addNewEventLog() {
		EventsPanelDialog dialog = createNewEventsPanelDialog("New Event", null);
		if (!dialog.isCancelled) {
			EventsLog newLog = new EventsLog(
					dialog.date.getText(),
					dialog.event.getText());

			eventsLogList.addLog(newLog);

			logs.updateUI();
		}
	}

	private void editExistingEventLog() {
		EventsLog log = eventsLogList.getLog(logs.getSelectedIndex());
		String[] initValues = log.getValuesArray();

		EventsPanelDialog dialog = createNewEventsPanelDialog("Edit Event", initValues);

		if (!dialog.isCancelled) {
			log.setDate(dialog.date.getText());
			log.setEvent(dialog.event.getText());

			logs.updateUI();
		}
	

	

	}
}
	
	
	

