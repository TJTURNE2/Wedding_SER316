package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Local;
import sun.tools.jar.resources.jar;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;


/*$Id: EventNotificationDialog.java,v 1.8 2004/10/18 19:08:56 ivanrise Exp $*/
public class EventNotificationDialog extends JFrame {
  JPanel jpanel = new JPanel();
  JButton jButton1 = new JButton();
  JLabel eventTitleLabel = new JLabel();
  JLabel whereLabel = new JLabel();
  JLabel descriptionLabel = new JLabel();
  JLabel timeLabel = new JLabel();
  JLabel timeIcon = new JLabel();

  public EventNotificationDialog(String title, String time, String eventTitle, String where, String description) {
    super();
    this.setTitle(title);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      new ExceptionDialog(ex);
    }
    timeLabel.setText(time);
    timeIcon.setIcon(new ImageIcon(net.sf.memoranda.ui.TaskDialog.class.getResource(
            "resources/icons/event48.png")));
    eventTitleLabel.setText(eventTitle);
    whereLabel.setText("at " + where);
    descriptionLabel.setText(description);
    
    this.setSize(300,250);
    this.setLocationRelativeTo(null);
    this.setVisible(true);    
    this.toFront();
    this.requestFocus();
    //jButton1.requestFocus();
  }

  public EventNotificationDialog() {
    this("", "", "","","");
  }
  void jbInit() throws Exception {
    this.setResizable(false);
    this.setIconImage(new ImageIcon(EventNotificationDialog.class.getResource("resources/icons/jnotes16.png")).getImage());
    this.getContentPane().setBackground(new Color(251, 197, 63));
    jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
    jpanel.setBackground(new Color(251, 197, 63));
    
    jButton1.setText(Local.getString("Ok"));
    jButton1.setBounds(150, 415, 95, 30);
    jButton1.setPreferredSize(new Dimension(95, 30));
    jButton1.setBackground(new Color(69, 125, 186));
    jButton1.setForeground(Color.white);
    jButton1.setDefaultCapable(true);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jpanel.setMinimumSize(new Dimension(300, 250));
    jpanel.setPreferredSize(new Dimension(300, 250));
    timeLabel.setFont(new java.awt.Font("Dialog", 0, 20));
    timeLabel.setAlignmentX(CENTER_ALIGNMENT);
    timeIcon.setAlignmentX(CENTER_ALIGNMENT);
    eventTitleLabel.setFont(new java.awt.Font("Dialog", 0, 20));
    eventTitleLabel.setAlignmentX(CENTER_ALIGNMENT);
    whereLabel.setAlignmentX(CENTER_ALIGNMENT);
    descriptionLabel.setAlignmentX(CENTER_ALIGNMENT);
    
    jButton1.setAlignmentX(CENTER_ALIGNMENT);
    getContentPane().add(jpanel);
    
    jpanel.add(timeIcon);
    jpanel.add(timeLabel);
    jpanel.add(Box.createRigidArea(new Dimension(0, 10)));
    jpanel.add(eventTitleLabel);
    jpanel.add(whereLabel);
    jpanel.add(Box.createRigidArea(new Dimension(0, 10)));
    jpanel.add(descriptionLabel);
    jpanel.add(Box.createRigidArea(new Dimension(0, 15)));
    jpanel.add(jButton1);
    playSoundNotification();
  }

  void jButton1_actionPerformed(ActionEvent e) {
       this.dispose();
  }
  
  private void playSoundNotification() {
		if (Configuration.get("NOTIFY_SOUND").equals("DISABLED"))
			return;
		if (Configuration.get("NOTIFY_SOUND").equals("BEEP")) {
			java.awt.Toolkit.getDefaultToolkit().beep();
			return;
		}
		if (Configuration.get("NOTIFY_SOUND").equals("")) {
			Configuration.put("NOTIFY_SOUND", "DEFAULT");
			Configuration.saveConfig();
		}
		URL url;
		if (Configuration.get("NOTIFY_SOUND").equals("DEFAULT"))
			url =
				EventNotificationDialog.class.getResource(
					"resources/beep.wav");
		else
			try {
				url =
					new File(Configuration.get("NOTIFY_SOUND").toString())
						.toURL();
			} catch (Exception ex) {
				url =
					EventNotificationDialog.class.getResource(
						"resources/beep.wav");
			}
		try {
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		} catch (Exception ex) {
			new ExceptionDialog(ex, "Error loading audioclip from "+url, "Check the location and type of audioclip file.");
		}
	}
}