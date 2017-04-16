package net.sf.memoranda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReminderLogTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	private static ReminderLog test = new ReminderLog("4/16/17", "This is a test");
	private static ReminderLog invalidTest;
	
	@Test
	public void ReminderLogTestConstructor() {
		assertNotNull(test);
		assertNull(invalidTest);
	}
	
	public void GetValuesArrayTest() {
		String[] a = test.getValuesArray();
		String[] e = {"4/16/17", "This is a test"};
		assertEquals(e, a);
	}

	public void ToStringTest() {
		
		String a = test.toString();
		String e = "4/16/17 This is a test";
		assertEquals(e, a);
		assertNotEquals("invalid input", a);
	}
	
	public void ToFileTest() {
		String a = test.toFile();
		String e = "4/16/17 This is a test";
		assertEquals(e, a);
		assertNotEquals("invalid input", a);
	}
	
}