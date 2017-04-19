package test.net.sf.memoranda.date;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.EventsManager;
import net.sf.memoranda.date.CalendarDate;

public class TestEventsManager {

	@Test
	public void testCreateSticker() {
		int startingStickers = EventsManager.getStickers().size();
		EventsManager.createSticker("Test", 1);
		assertEquals(EventsManager.getStickers().size(), startingStickers + 1);
		
		EventsManager.createSticker("Test2", 2);
		assertEquals(EventsManager.getStickers().size(), startingStickers + 2);
	}
	
	@Test
	public void testIsNREventsForDate() {
		CalendarDate cDate1 = new CalendarDate(2,3,2017);
		CalendarDate cDate3 = new CalendarDate(1,5,3343);
		CalendarDate cDate4 = new CalendarDate(6,2,1942);
		
		EventsManager.createEvent(cDate1,1,0,"JUnit");
		
		assertTrue(EventsManager.isNREventsForDate(cDate1));
		
		assertFalse(EventsManager.isNREventsForDate(cDate3));
		assertFalse(EventsManager.isNREventsForDate(cDate4));
	}

}
