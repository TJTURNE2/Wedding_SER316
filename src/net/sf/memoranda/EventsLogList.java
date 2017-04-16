/**
 * @file: EventsLogList.java
 * @author: nathanwaitman
 * @date: April 14, 2017
 * 
 * @description: Creates a list for storing all Event Logs that are created.
 * 			     Manages all Event Logs for a project and supports loading a
 *               new list from file when switching projects.
 */

package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import net.sf.memoranda.util.Util;

/**
 * @class EventsLogList
 * 
 * @description: Defines a class for creating a Event Log List. Has methods for 
 *               adding and retrieving logs, as well as a getter for the vector.
 */
public class EventsLogList {
	private Vector<EventsLog> eventsLogList = null;

	public EventsLogList() {
		eventsLogList = new Vector<EventsLog>();
	}

	public EventsLogList(File EventsLogListDoc) throws FileNotFoundException {
		eventsLogList = new Vector<EventsLog>();

		try {
			Scanner fileScan = new Scanner(EventsLogListDoc);
			int line = 0;

			while (fileScan.hasNextLine()) {
				String temp, date = "", event = "";
				line++;

				Scanner lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter("\\*\\^\\*");
				while (lineScan.hasNext()) {
					temp = lineScan.next();
					switch (temp) {
					case "date":
						temp = lineScan.next();
						date = (temp.equals("null") ? "" : temp);
						break;
					case "event":
						temp = lineScan.next();
						event = (temp.equals("null") ? "" : temp);
						break;
					default:
						Util.debug("Unable to switch value " + temp + " in event Log List constructor");
						Util.debug("Line " + line + " not properly loaded.");
					}
				}
				
				eventsLogList.addElement(new EventsLog(date, event));

				lineScan.close();
			}
			
			fileScan.close();
		} catch (FileNotFoundException e) {
			Util.debug("Unable to scan file at path " + EventsLogListDoc.getPath());
			throw e;
		}
	}

	/**
	 * @method: getList
	 * @inputs: none
	 * @return: The vector of event logs
	 * 
	 * @description: This method returns the vector of event logs to be 
	 *               used by the agenda control panel for displaying the list.
	 */
	
	public Vector<EventsLog> getList() {
		return eventsLogList;
	}
	
	/**
	 * @method: deleteLog 
	 * @inputs: log
	 * @return: void
	 * 
	 * @description: Removes a log from the vector of logs.
	 */
	public void deleteLog(EventsLog log) {
		eventsLogList.remove(log);
	}

	/**
	 * @method: addLog 
	 * @inputs: log
	 * @return: void
	 * 
	 * @description: Takes a event log as a parameter and inserts into the
	 *               vector of logs.
	 */
	public void addLog(EventsLog log) {
		eventsLogList.addElement(log);
	}

	/**
	 * @method: getLog 
	 * @inputs: an integer representing an index
	 * @return: a event Log object
	 * 
	 * @description: Takes an integer as a parameter and returns the
	 *               event log located at that index in the vector of defects.
	 */
	public EventsLog getLog(int index) {
		return eventsLogList.elementAt(index);
	}
	
	public String toString() {
		return eventsLogList.toString();
	}
}
