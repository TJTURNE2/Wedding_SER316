package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TasksControlPanel extends JPanel {
	BorderLayout borderLayout = new BorderLayout();
	JScrollPane scrollPane = new JScrollPane();
	JButton newTime = new JButton("Add New Time");
		
	public TasksControlPanel() {
		this.setLayout(borderLayout);
		
		newTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				createNewTimeRecording();
			}
		});
		
		this.add(newTime, BorderLayout.PAGE_START);
		this.add(scrollPane, BorderLayout.CENTER);
		//scrollPane.getViewport().add(null, null);
	}
	
	void createNewTimeRecording() {
		TimeRecordingDialog dialog = new TimeRecordingDialog(App.getFrame(), "New Time Recording");

		Dimension frameSize = App.getFrame().getSize();
        Point location = App.getFrame().getLocation();
        dialog.setLocation((frameSize.width - dialog.getSize().width) / 2 + location.x, (frameSize.height - dialog.getSize().height) / 2 + location.y);

		dialog.setVisible(true);
	}
}
