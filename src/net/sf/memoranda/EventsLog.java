/** @file: EventsLog.java
 *  @author: nathanwaitman
 *  @date: April 14, 2017
 *  
 *  @description: Instances of the Events Log class will store data relative
 *  			  to each reminder log created by the user. There is one events
 *  			  log object for each events log created by the user.
 */
package net.sf.memoranda;

/**
 * 
 * @class EventsLog
 *
 * @description: Defines a class for creating Events Logs, including getters and
 *               setters used for editing the Events Log, and a method used when 
 *               saving events log to a file.
 */

public class EventsLog {

	String date;
	String event;
	
	public EventsLog(String date, String event) {
		this.date = date;
		this.event = event;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public String[] getValuesArray() {
		String[] values = {date, event};
		return values;
	}
	
	public String toString() {
		return date + " " + event;
	}

	/**
	 * @method: toFile
	 * @inputs: none
	 * @return: String to be written to a file
	 * 
	 * @description: Formats a string with all of the event log's attributes and 
	 *               prints it to a file. 
	 */
	public String toFile() {
		return ("date*^*" + (date.equals("") ? "null" : date) +
				"*^*event*^*" + (event.equals("") ? "null" : event));
	}

}
