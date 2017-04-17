package net.sf.memoranda.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*$Id: NotesListPanel.java,v 1.5 2005/01/29 13:55:26 rawsushi Exp $*/
public class ReminderListPanel extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();
  JScrollPane scrollPane = new JScrollPane();
  public ReminderList reminderList = new ReminderList();

  public ReminderListPanel() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      new ExceptionDialog(ex);
    }
  }
  void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    this.add(scrollPane, BorderLayout.CENTER);
    scrollPane.getViewport().add(reminderList, null);
  }
}
