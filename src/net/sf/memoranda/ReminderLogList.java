/**
 * @file: ReminderLogList.java
 * @author: nathanwaitman
 * @date: April 14, 2017
 * 
 * @description: Creates a list for storing all Reminder Logs that are created.
 * 			     Manages all Reminder Logs for a project and supports loading a
 *               new list from file when switching projects.
 */

package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import net.sf.memoranda.util.Util;

/**
 * @class ReminderLogList
 * 
 * @description: Defines a class for creating a Reminder Log List. Has methods for 
 *               adding and retrieving logs, as well as a getter for the vector.
 */
public class ReminderLogList {
	private Vector<ReminderLog> reminderLogList = null;

	public ReminderLogList() {
		reminderLogList = new Vector<ReminderLog>();
	}

	public ReminderLogList(File reminderLogListDoc) throws FileNotFoundException {
		reminderLogList = new Vector<ReminderLog>();

		try {
			Scanner fileScan = new Scanner(reminderLogListDoc);

			while (fileScan.hasNextLine()) {
				String temp, date = "", reminder = "";

				Scanner lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter("\\*\\^\\*");
				while (lineScan.hasNext()) {
					temp = lineScan.next();
					switch (temp) {
					case "date":
						temp = lineScan.next();
						date = (temp.equals("null") ? "" : temp);
						break;
					case "reminder":
						temp = lineScan.next();
						reminder = (temp.equals("null") ? "" : temp);
						break;
					default:
						Util.debug("Unable to switch value " + temp + " in Reminder Log List constructor");
					}
				}
				
				reminderLogList.addElement(new ReminderLog(date, reminder));

				lineScan.close();
			}
			
			fileScan.close();
		} catch (FileNotFoundException e) {
			Util.debug("Unable to scan file at path " + reminderLogListDoc.getPath());
			throw e;
		}
	}

	/**
	 * @method: getList
	 * @inputs: none
	 * @return: The vector of reminder logs
	 * 
	 * @description: This method returns the vector of reminder logs to be 
	 *               used by the agenda control panel for displaying the list.
	 */
	
	public Vector<ReminderLog> getList() {
		return reminderLogList;
	}

	/**
	 * @method: addLog 
	 * @inputs: log
	 * @return: void
	 * 
	 * @description: Takes a reminder log as a parameter and inserts into the
	 *               vector of logs.
	 */
	public void addLog(ReminderLog log) {
		reminderLogList.addElement(log);
	}

	/**
	 * @method: getLog 
	 * @inputs: an integer representing an index
	 * @return: a Reminder Log object
	 * 
	 * @description: Takes an integer as a parameter and returns the
	 *               reminder log located at that index in the vector of defects.
	 */
	public ReminderLog getLog(int index) {
		return reminderLogList.elementAt(index);
	}
	
	public String toString() {
		return reminderLogList.toString();
	}
}

