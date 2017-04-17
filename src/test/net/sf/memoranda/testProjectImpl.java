package test.net.sf.memoranda;

import nu.xom.Element;


import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectImpl;
import net.sf.memoranda.date.CalendarDate;

public class testProjectImpl {
	Element el = new Element("project");
	ProjectImpl proj1 = new ProjectImpl(el);
	
	CalendarDate date1 = new CalendarDate(3,5,2017);	//May 3, 2017
	CalendarDate date2 = new CalendarDate(1,2,2016);	//February 1, 2016
	CalendarDate date3 = new CalendarDate(30,1,2018);	//January 30, 2018
	CalendarDate date4 = new CalendarDate(10,4,2015);	//April 10, 2015
	
	
	
	@Test
	public void testGetStatus() {
		proj1.setStartDate(date2);
		
		//test active
		proj1.setEndDate(date3);
		assertEquals(proj1.getStatus(), Project.ACTIVE);
		proj1.setStartDate(date3);
		assertNotEquals(proj1.getStatus(), Project.ACTIVE);
		
		//test completed
		
		//test failed
		
		
		//test scheduled
		proj1.setStartDate(date3);
		assertEquals(proj1.getStatus(), Project.SCHEDULED);
		
		//test frozen
		proj1.freeze();
		assertEquals(proj1.getStatus(), Project.FROZEN);
		//proj1.unfreeze();
		//assertNotEquals(proj1.getStatus(), Project.FROZEN);
		
		
		
	}

}
