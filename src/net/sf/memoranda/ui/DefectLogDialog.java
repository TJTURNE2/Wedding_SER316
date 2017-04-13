package net.sf.memoranda.ui;

/**
 * @class DefectLogDialog
 * 
 * @description: Defines a class for creating a Defect Log Defect Box that allows 
 * 				User to complete a new defect log
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.util.Local;

public class DefectLogDialog extends JDialog {
	JPanel mPanel = new JPanel(new BorderLayout());
    JPanel areaPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton cancelB = new JButton();
    JButton okB = new JButton();
    Border border1;
    Border border2;
    JPanel dialogTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel header = new JLabel();
    public boolean CANCELLED = true;
    JPanel jPanel8 = new JPanel(new GridBagLayout());
    Border border3;
    Border border4;
//    Border border5;
//    Border border6;
    JPanel jPanel2 = new JPanel(new GridLayout(4, 2));
    int defectNum;
    
    //JTextArea descriptionField = new JTextArea();
    JTextField descriptionField = new JTextField();
   // JScrollPane descriptionScrollPane = new JScrollPane(descriptionField);
    
//  Border border7;
  Border border8;
  CalendarFrame dateCalFrame = new CalendarFrame();
  String[] type = {Local.getString("None"), Local.getString("Documentation"),
	        Local.getString("Syntax"), Local.getString("Build"),
	        Local.getString("Assignment"), Local.getString("Interface"), 
	        Local.getString("Checking"), Local.getString("Data"),
	        Local.getString("Function"), Local.getString("System"),
	        Local.getString("Environment")};
  String[] phase = {Local.getString("None"), Local.getString("Plan"), 
		  Local.getString("Design"), Local.getString("Code"),
		  Local.getString("Compile"), Local.getString("Test"),
		  Local.getString("Post Mortem")};
  String[] severity = {Local.getString("Low"), Local.getString("Major"),
		  Local.getString("Blocker")};
  boolean ignoreDateChanged = false;
  JPanel jPanel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
  JPanel jPanel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JLabel jLabel6 = new JLabel();
  JButton setDateB = new JButton();
  JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
  JLabel jLabel2 = new JLabel();
  JSpinner date;
  JPanel jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
  JComboBox typeCB = new JComboBox(type);
  JComboBox injectCB = new JComboBox(phase);
  JComboBox removeCB = new JComboBox(phase);
  JComboBox severityCB = new JComboBox(severity);
  JLabel typeLabel = new JLabel();
  JLabel injectLabel = new JLabel();
  JLabel removeLabel = new JLabel();
  JLabel severityLabel = new JLabel();
  JLabel jLabelDescription = new JLabel();
  JCheckBox chkActive = new JCheckBox();
  JLabel blankLabel = new JLabel(); // EDIT
  
  CalendarDate dateMin = CurrentProject.get().getStartDate();
  CalendarDate dateMax = CurrentProject.get().getEndDate();
    
  public DefectLogDialog(Frame frame, String title) {
      super(frame, title, true);
      try {
          jbInit();            
          pack();
      }
      catch (Exception ex) {
          new ExceptionDialog(ex);
      }
  }
  
  
  public DefectLogDialog(Frame frame, String title, int num) {
      super(frame, title, true);
      try {
    	  defectNum = num;
          jbInit();            
          pack();
      }
      catch (Exception ex) {
          new ExceptionDialog(ex);
      }
  }
  
  void jbInit() throws Exception {

		this.setResizable(false);
		this.setSize(new Dimension(430,300));
	        border1 = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	        border2 = BorderFactory.createEtchedBorder(Color.white, 
	            new Color(142, 142, 142));
	       // defectNum = CurrentProject.getDefectLogList().getList().size() + 1; // TODO - pull next defect number from list needs Task #54
	        border3 = new TitledBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), 
	        Local.getString("Defect #" + defectNum), TitledBorder.LEFT, TitledBorder.BELOW_TOP);
	        border4 = BorderFactory.createEmptyBorder(0, 5, 0, 5);
//	        border5 = BorderFactory.createEmptyBorder();
//	        border6 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
//	            Color.white, Color.white, new Color(178, 178, 178),
//	            new Color(124, 124, 124));
//	        border7 = BorderFactory.createLineBorder(Color.white, 2);
	        border8 = BorderFactory.createEtchedBorder(Color.white, 
	            new Color(178, 178, 178));
	        cancelB.setMaximumSize(new Dimension(100, 26));
	        cancelB.setMinimumSize(new Dimension(100, 26));
	        cancelB.setPreferredSize(new Dimension(100, 26));
	        cancelB.setText(Local.getString("Cancel"));
	        cancelB.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                cancelB_actionPerformed(e);
	            }
	        });

	        date = new JSpinner(new SpinnerDateModel(new Date(),null,null,Calendar.DAY_OF_WEEK));
			
	        chkActive.setSelected(false);
	        chkActive_actionPerformed(null);
	        chkActive.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chkActive_actionPerformed(e);
				}
			});
	        okB.setMaximumSize(new Dimension(100, 26));
	        okB.setMinimumSize(new Dimension(100, 26));
	        okB.setPreferredSize(new Dimension(100, 26));
	        okB.setText(Local.getString("Ok"));
	        okB.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                okB_actionPerformed(e);
	            }
	        });
	        
	        this.getRootPane().setDefaultButton(okB);
	        mPanel.setBorder(border1);
	        areaPanel.setBorder(border2);
	        dialogTitlePanel.setBackground(Color.WHITE);
	        dialogTitlePanel.setBorder(border4);
	        //dialogTitlePanel.setMinimumSize(new Dimension(159, 52));
	        //dialogTitlePanel.setPreferredSize(new Dimension(159, 52));
	        header.setFont(new java.awt.Font("Dialog", 0, 20));
	        header.setForeground(new Color(0, 0, 124));
	        header.setText(Local.getString("Defect Log"));
	        header.setIcon(new ImageIcon(net.sf.memoranda.ui.TaskDialog.class.getResource(
	            "resources/icons/defectLarge.png")));
	        
	        GridBagLayout gbLayout = (GridBagLayout) jPanel8.getLayout();
	        jPanel8.setBorder(border3);
			
	        
	       // todoField.setBorder(border8);
	      //  todoField.setPreferredSize(new Dimension(375, 24));
	       // GridBagConstraints gbCon = new GridBagConstraints();
	     //   gbCon.gridwidth = GridBagConstraints.REMAINDER;
	    //    gbCon.weighty = 1;
	       // gbLayout.setConstraints(todoField,gbCon);
	        
	        
	        jLabelDescription.setMaximumSize(new Dimension(100, 16));
	        jLabelDescription.setMinimumSize(new Dimension(60, 16));
	        jLabelDescription.setText(Local.getString("Description"));
	        GridBagConstraints  gbCon = new GridBagConstraints();
	          gbCon.gridwidth = GridBagConstraints.REMAINDER;
	          gbCon.weighty = 1;
	         gbCon.anchor = GridBagConstraints.WEST;
	         gbLayout.setConstraints(jLabelDescription,gbCon);
	        
	        descriptionField.setBorder(border8);
	        descriptionField.setPreferredSize(new Dimension(375, 24));
	       // descriptionField.setPreferredSize(new Dimension(375, 387)); // 3 additional pixels from 384 so that the last line is not cut off
	      //  descriptionField.setLineWrap(true);
	       // descriptionField.setWrapStyleWord(true);
	            gbCon = new GridBagConstraints();
	           gbCon.gridwidth = GridBagConstraints.REMAINDER;
	           gbCon.weighty = 1;
	     //   descriptionScrollPane.setPreferredSize(new Dimension(375,96));
	           gbLayout.setConstraints(descriptionField,gbCon);

	        /*
	        jLabelEffort.setMaximumSize(new Dimension(100, 16));
	        jLabelEffort.setMinimumSize(new Dimension(60, 16));
	        jLabelEffort.setText(Local.getString("Est Effort(hrs)"));
	        effortField.setBorder(border8);
	        effortField.setPreferredSize(new Dimension(30, 24));
	        */

	        date.setBorder(border8);
	        date.setPreferredSize(new Dimension(80, 24));                
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.SHORT);
			// //Added by (jcscoobyrs) on 14-Nov-2003 at 10:45:16 PM
			date.setEditor(new JSpinner.DateEditor(date, sdf.toPattern()));

			date.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	            	// it's an ugly hack so that the spinner can increase day by day
	            	SpinnerDateModel dm = new SpinnerDateModel((Date)date.getModel().getValue(),null,null,Calendar.DAY_OF_WEEK);
	            	date.setModel(dm);

	                if (ignoreDateChanged)
	                    return;
	                ignoreDateChanged = true;
	                Date d = (Date) date.getModel().getValue();
	                /*
	                if (sd.after(ed) && chkEndDate.isSelected()) {
	                    date.getModel().setValue(ed);
	                    sd = ed;
	                }
					if ((startDateMax != null) && sd.after(startDateMax.getDate())) {
						date.getModel().setValue(startDateMax.getDate());
	                    sd = startDateMax.getDate();
					}
	                if ((startDateMin != null) && sd.before(startDateMin.getDate())) {
	                    date.getModel().setValue(startDateMin.getDate());
	                    sd = startDateMin.getDate();
	                }
	                */
	                dateCalFrame.cal.set(new CalendarDate(d));
	                ignoreDateChanged = false;
	            }
	        });

	        jLabel6.setText(Local.getString("Date Found"));
	        //jLabel6.setPreferredSize(new Dimension(60, 16));
	        jLabel6.setMinimumSize(new Dimension(60, 16));
	        jLabel6.setMaximumSize(new Dimension(100, 16));
	        setDateB.setMinimumSize(new Dimension(24, 24));
	        setDateB.setPreferredSize(new Dimension(24, 24));
	        setDateB.setText("");
	        setDateB.setIcon(
	            new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/calendar.png")));
	        setDateB.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                setDateB_actionPerformed(e);
	            }
	        });
	        jLabel2.setMaximumSize(new Dimension(270, 16));
	        //jLabel2.setPreferredSize(new Dimension(60, 16));
	        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	        jLabel2.setText(Local.getString("Active?"));
	        
	        blankLabel.setText(Local.getString("\n"));
	      
	        
	        
	       
	        typeLabel.setMaximumSize(new Dimension(100, 16));
	        typeLabel.setMinimumSize(new Dimension(60, 16));
	        //typeLabel.setPreferredSize(new Dimension(60, 16));
	        typeLabel.setText(Local.getString("Type"));
	        
	        injectLabel.setMaximumSize(new Dimension(100, 16));
	        injectLabel.setMinimumSize(new Dimension(60, 16));
	        //typeLabel.setPreferredSize(new Dimension(60, 16));
	        injectLabel.setText(Local.getString("Inject"));
	        
	        removeLabel.setMaximumSize(new Dimension(100, 16));
	        removeLabel.setMinimumSize(new Dimension(60, 16));
	        //typeLabel.setPreferredSize(new Dimension(60, 16));
	        removeLabel.setText(Local.getString("Remove"));
	        
	        severityLabel.setMaximumSize(new Dimension(100, 16));
	        severityLabel.setMinimumSize(new Dimension(60, 16));
	        //typeLabel.setPreferredSize(new Dimension(60, 16));
	        severityLabel.setText(Local.getString("Severity"));

	        typeCB.setFont(new java.awt.Font("Dialog", 0, 11));
	        injectCB.setFont(new java.awt.Font("Dialog", 0, 11));
	        removeCB.setFont(new java.awt.Font("Dialog", 0, 11));
	        severityCB.setFont(new java.awt.Font("Dialog", 0, 11));
	        jPanel4.add(typeLabel, null);
	        getContentPane().add(mPanel);
	        mPanel.add(areaPanel, BorderLayout.CENTER);
	        mPanel.add(buttonsPanel, BorderLayout.SOUTH);
	        buttonsPanel.add(okB, null);
	        buttonsPanel.add(cancelB, null);
	        this.getContentPane().add(dialogTitlePanel, BorderLayout.NORTH);
	        dialogTitlePanel.add(header, null);
	        areaPanel.add(jPanel8, BorderLayout.NORTH);
	        // jPanel8.add(todoField, null);
	        jPanel8.add(jLabelDescription);
	        //jPanel8.add(descriptionScrollPane, null);
	        jPanel8.add(descriptionField);
	        areaPanel.add(jPanel2, BorderLayout.CENTER);
	        jPanel2.add(jPanel6, null);
	        jPanel6.add(jLabel6, null);
	        jPanel6.add(date, null);
	        jPanel6.add(setDateB, null);
	        jPanel2.add(jPanel1, null);
	        jPanel1.add(jLabel2, null);
			jPanel1.add(chkActive, null);
	        // added by rawsushi

	        jPanel2.add(jPanel4, null);
	        jPanel4.add(typeCB, null);
	        
	        jPanel4.add(severityLabel,null);
	        jPanel4.add(severityCB, null);
	        jPanel4.add(injectLabel,null);
	        jPanel4.add(injectCB, null);
	        jPanel4.add(removeLabel,null);
	        jPanel4.add(removeCB, null);
	        jPanel2.add(jPanel3, null);

	        typeCB.setSelectedItem(Local.getString("None"));
	        dateCalFrame.cal.addSelectionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (ignoreDateChanged)
	                    return;
	                date.getModel().setValue(dateCalFrame.cal.get().getCalendar().getTime());
	            }
	        });
	        
	    
  }
  
  public void setDate(CalendarDate d) {
		this.date.getModel().setValue(d.getDate());
	}
  
  public void setDateLimit(CalendarDate min, CalendarDate max) {
		this.dateMin = min;
		this.dateMax = max;
	}
  
  void okB_actionPerformed(ActionEvent e) {
		CANCELLED = false;
	        this.dispose();
	    }

  void cancelB_actionPerformed(ActionEvent e) {
	    this.dispose();
	    }
  
  void chkActive_actionPerformed(ActionEvent e) {
		// endDate.setEnabled(chkActive.isSelected());
		// setEndDateB.setEnabled(chkActive.isSelected());
		jLabel2.setEnabled(chkActive.isSelected());
		if(chkActive.isSelected()) {
			Date currentDate = (Date) date.getModel().getValue();
	//		if(currentEndDate.getTime() < currentStartDate.getTime()) {
	//			endDate.getModel().setValue(currentStartDate);
			//}
		}
	}
  void setDateB_actionPerformed(ActionEvent e) {
      dateCalFrame.setLocation(setDateB.getLocation());
      dateCalFrame.setSize(200, 200);
      this.getLayeredPane().add(dateCalFrame);
      dateCalFrame.show();

  }
}
