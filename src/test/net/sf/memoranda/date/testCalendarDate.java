/**
 * @file: testCalendarDate.java
 * @author Andrew Steinmetz
 * 
 * @description: testCalendarDate.java contains the unit tests for the java class CalendarDate.java
 * 
 */

package test.net.sf.memoranda.date;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;

public class testCalendarDate {
	CalendarDate cDate1 = new CalendarDate(2,3,2017);
	CalendarDate cDate2 = new CalendarDate(2,3,2017);
	CalendarDate cDate3 = new CalendarDate(1,5,3343);
	CalendarDate cDate4 = new CalendarDate(6,2,1942);
	
	@Test
	public void testEqualsCalendarDate() {
		assertTrue(cDate1.equals(cDate2));
		assertFalse(cDate1.equals(cDate3));
	}

	@Test
	public void testBefore() {
		assertTrue(cDate1.before(cDate3));
		assertFalse(cDate1.before(cDate4));
	}

	@Test
	public void testAfter() {
		assertTrue(cDate1.after(cDate4));
		assertFalse(cDate1.after(cDate3));
	}

	@Test
	public void testInPeriod() {
		assertTrue(cDate1.inPeriod(cDate4, cDate3));
		assertFalse(cDate3.inPeriod(cDate4, cDate1));

	}

}
