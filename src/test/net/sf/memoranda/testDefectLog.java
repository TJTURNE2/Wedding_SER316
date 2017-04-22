/**
 * @file: testDefectLog.java
 * @author Andrew Steinmetz
 * @date April 15 2017
 * 
 * @description test class DefectLog.java methods
 */

package test.net.sf.memoranda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.sf.memoranda.DefectLog;
import net.sf.memoranda.date.CalendarDate;

public class testDefectLog {
	private static CalendarDate cd = new CalendarDate("15/3/2017"); // Month starts at 0.
	private static DefectLog dl = new DefectLog(cd,1, "Build","DESIGN", "TEST","BLOCKER",0,0,false,"This is a test description");
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
		// CalendarDate toString() returns formatted d/m/y, where month is off by 1 (Month index starts at 0)
		String expected = "15/3/2017 1 BUILD DESIGN TEST BLOCKER 0 0 false This is a test description";
		assertEquals(expected, actual);
	}
}
