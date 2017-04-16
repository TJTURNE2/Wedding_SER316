/** @file: ReminderLog.java
 *  @author: nathanwaitman
 *  @date: April 14, 2017
 *  
 *  @description: Instances of the Reminder Log class will store data relative
 *  			  to each reminder log created by the user. There is one reminder
 *  			  log object for each reminder log created by the user.
 */
package net.sf.memoranda;

/**
 * 
 * @class ReminderLog
 *
 * @description: Defines a class for creating Reminder Logs, including getters and
 *               setters used for editing the Reminder Log, and a method used when 
 *               saving reminder log to a file.
 */

public class ReminderLog {

	String date;
	String reminder;
	
	public ReminderLog(String date, String reminder) {
		this.date = date;
		this.reminder = reminder;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	
	public String[] getValuesArray() {
		String[] values = {date, reminder};
		return values;
	}
	
	public String toString() {
		return date + " " + reminder;
	}

	/**
	 * @method: toFile
	 * @inputs: none
	 * @return: String to be written to a file
	 * 
	 * @description: Formats a string with all of the reminder log's attributes and 
	 *               prints it to a file. 
	 */
	public String toFile() {
		return ("date*^*" + (date.equals("") ? "null" : date) +
				"*^*reminder*^*" + (reminder.equals("") ? "null" : reminder));
	}

}
