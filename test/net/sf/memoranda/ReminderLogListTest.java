package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReminderLogListTest {
	File testFile;

	@Before
	public void setUp() throws Exception {
		testFile = new File("nonexistantFile");
	}

	// Check constructor to confirm exception is thrown with a bad file
	@Test (expected = FileNotFoundException.class)
	public void rllBadFileTest() throws FileNotFoundException {
		ReminderLogList testList = new ReminderLogList(testFile);
	}
		
	@After
	public void tearDown() throws Exception {
	}
}
