package net.sf.memoranda.ui;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;

import net.sf.memoranda.util.Local;

public class EventDialogTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	


	@Test
	public void jbInittest() {
		JLabel lblTest = new JLabel();
		JCheckBox enableTest= new JCheckBox();
		 
		lblTest.setText(Local.getString("Start Repeating"));
		
		enableTest.setText(Local.getString("Stop Repeating After"));
		
		assertEquals("Start Repeating", lblTest.getText());
		assertEquals("Stop Repeating After", enableTest.getText());
	}

}
