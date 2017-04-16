/** @file: EventsLog.java
 *  @author: nathanwaitman
 *  @date: April 14, 2017
 *  
 *  @description: Instances of the Events Log class will store data relative
 *  			  to each events log created by the user. There is one events
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

	private String _date;
	private String _event;
	
	public EventsLog(String date, String event) {
		this._date = date;
		this._event = event;
	}

	public String getDate() {
		return _date;
	}

	public void setDate(String date) {
		this._date = date;
	}


	public String getEvent() {
		return _event;
	}

	public void setEvent(String event) {
		this._event = event;
	}
	
	public String[] getValuesArray() {
		String[] values = {_date, _event};
		return values;
	}
	
	public String toString() {
		return _date + " " + _event;
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
		return ("date*^*" + (_date.equals("") ? "null" : _date) +
				"*^*event*^*" + (_event.equals("") ? "null" : _event));
	}

}
