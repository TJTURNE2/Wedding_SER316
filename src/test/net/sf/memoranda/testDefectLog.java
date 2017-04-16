/**
 * @file: testDefectLog.java
 * @author Andrew Steinmetz
 * @date April 15 2017
 * 
 * @description test class DefectLog.java methods
 */

package test.net.sf.memoranda;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.DefectLog;

public class testDefectLog {
	private static DefectLog dl = new DefectLog("4/15/2017",1, "Build","DESIGN", "TEST","BLOCKER",0,0,false,"This is a test description");
	private static DefectLog invalidDL;
	
	@Test 
	public void testDefectLogConstructor(){
		assertNotNull(dl);
	}
	@Test
	public void testToString() {
		
		String actual = dl.toString();
		String expected = "1 4/15/2017 Build Fixed";
		assertTrue(actual.equals(expected));
		
	}
	
	@Test 
	public void testToFile(){
		String actual = dl.toFile();
		String expected = "4/15/2017 1 BUILD DESIGN TEST BLOCKER 0 0 false This is a test description";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetValuesArray(){
		String[] actual = dl.getValuesArray();
		String[] expected = {"4/15/2017", "1", "Build", "Design", "Test", "Blocker", "0", "0", "This is a test description", "false"};
		assertEquals(expected, actual);
	}
}
