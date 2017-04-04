/**
 * 
 */
package net.sf.memoranda.psp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sf.memoranda.ui.ExceptionDialog;

/**
 * @author Terry Turner TJTURNE2
 *
 */
public class PSPNewDialog extends JDialog {

	public PSPNewDialog(Frame frame, String title) {
		super(frame, title, true);
		try {
			PSPInit();
			pack();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
		}
	}
	
	void PSPInit() throws Exception{
		
	}

	public static void newPSPProject() {

	}

}
