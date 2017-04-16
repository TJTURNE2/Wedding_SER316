/*
  File:	CreateUserDialog.java
  Author:	Tomas Vartija
  Date:	4/16/2017
  
  Description:  Creates the dialog window for creating a user.
*/

package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.sf.memoranda.UserProfile;
import net.sf.memoranda.util.CurrentStorage;

/**
Class: CreateUserDialog

Description: Creates the JDialog window for creating a user.
*/
public class CreateUserDialog extends JDialog {
	private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnCreate;
    private JButton btnCancel;
    private boolean succeeded;
	
    /**
    Constructor: CreateUserDialog	
    
    Description: Constructor for CreateUserDialog Class
    */
	public CreateUserDialog(Frame frame, String title) {
		super(frame, title, true);
        try {
            jbInit();
            pack();
        }
        catch(Exception ex) {
            new ExceptionDialog(ex);
        }
	}
	
	/**
	  Method: jbInit

	  Description: Initializes the JDialog window setting up the GUI.
	*/
	void jbInit() throws Exception {
		this.setResizable(false);
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnCreate = new JButton("Create");
        
        btnCreate.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                if (UserProfile.createUser(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(CreateUserDialog.this,
                            "Hi " + getUsername() + "! You have successfully created this user.",
                            "Create User",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    CurrentStorage.get().storeUserProfileManager();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CreateUserDialog.this,
                            "Something went wrong.",
                            "Create User",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
 
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnCreate);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
		
	}
	
	/**
	  Method: getUserName
	  Returns: String - current username in text field

	  Description: Returns the current text in the username field.
	*/
	public String getUsername() {
        return tfUsername.getText().trim();
    }
	
	/**
	  Method: getPassword
	  Returns: String - current password in text field

	  Description: Returns the current text in the password field.
	*/
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
    
    /**
    Method: isSucceeded 
    Returns: Boolean - successful login

    Description: Returns true if the user was created.
    */
    public boolean isSucceeded() {
        return succeeded;
    }
}
