package net.sf.memoranda.ui;

import static org.junit.Assert.*;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.CurrentProject;
import net.sf.memoranda.ui.AgendaControlPanel.LogEditListener;

public class AgendaControlPanelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testbuildGUI() {
		AgendaControlPanel test = new AgendaControlPanel();
		test.buildGUI();
		
		
		
	}

	public void testrefresh() {
		
	}
	
	public void testaddNewReminderLog() {
		
	}
	
	public void testeditExistingReminderLog() {
		
	}
	
}
