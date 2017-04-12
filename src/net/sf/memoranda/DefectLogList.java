/**
 * @file: DefectLogList.java
 * @author: Joseph Wicker
 * @date: April 11, 2017
 * 
 * @description: Creates a list for storing all Defect Logs that are created.
 * Manages all Defect Logs for a project, and supports loading a new list from
 * a file when switching projects.
 */
package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.util.Util;

/**
 * @class DefectLogList
 * 
 * @description: Defines a class for creating a Defect Log List. Has methods
 * for adding and retrieving logs, as well as a getter for the vector itself.
 */
public class DefectLogList {
	private Vector<DefectLog> _defectLogList = null;

	public DefectLogList() {
		_defectLogList = new Vector<DefectLog>();
	}

	public DefectLogList(File defectListDoc) {
		_defectLogList = new Vector<DefectLog>();

		try {
			Scanner fileScan = new Scanner(defectListDoc);

			while (fileScan.hasNextLine()) {
				String temp, date = CurrentDate.get().toString(), type = "None",  inject = "Default", remove = "Default", severity = "Low", description = "";
				int defectNum = 0, fixTime = 0, refNum = 0;
				boolean isActive = false;

				Scanner lineScan = new Scanner(fileScan.nextLine());
				if (lineScan.hasNext()) {
					date = lineScan.next();
				}
				if (lineScan.hasNext()) {
					temp = lineScan.next();
					defectNum = Integer.valueOf(temp);
				}
				if (lineScan.hasNext()) {
					type = lineScan.next();
				}
				if (lineScan.hasNext()) {
					inject = lineScan.next();
				}
				if (lineScan.hasNext()) {
					remove = lineScan.next();
				}
				if (lineScan.hasNext()) {
					severity = lineScan.next();
				}
				if (lineScan.hasNext()) {
					temp = lineScan.next();
					fixTime = Integer.valueOf(temp);
				}
				if (lineScan.hasNext()) {
					temp = lineScan.next();
					refNum = Integer.valueOf(temp);
				}
				if (lineScan.hasNext()) {
					temp = lineScan.next();
					isActive = Boolean.valueOf(temp);
				}
				if (lineScan.hasNext()) {
					lineScan.skip(" ");
					description = lineScan.nextLine();
				}

				_defectLogList.addElement(new DefectLog(date, defectNum, type, inject, remove, severity, fixTime, refNum, isActive, description));

				lineScan.close();
			}

			fileScan.close();
		} catch (FileNotFoundException e) {
			Util.debug("Unable to scan file at path " + defectListDoc.getPath());
		}
	}

	/**
	 * @method: getList
	 * @inputs: none
	 * @returns: The vector of defect logs
	 * 
	 * @description: This method returns the vector of defect logs to be
	 * used by the tasks control panel for displaying the list.
	 */
	public Vector<DefectLog> getList() {
		return _defectLogList;
	}

	/**
	 * @method: addLog
	 * @inputs: A single Defect Log
	 * @returns: void
	 * 
	 * @description: Takes a Defect Log as a parameter and inserts the log
	 * into the Vector of logs.
	*/
	public void addLog(DefectLog log) {
		_defectLogList.addElement(log);
	}

	/**
	 * @method: getLog
	 * @inputs: A single integer representing an index
	 * @returns: A Defect Log object
	 * 
	 * @description: Takes an integer as a parameter and returns the
	 * Defect Log located at that index in the vector of defects.
	*/
	public DefectLog getLog(int index) {
		return _defectLogList.elementAt(index);
	}
}
