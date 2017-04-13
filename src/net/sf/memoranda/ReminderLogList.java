package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import net.sf.memoranda.util.Util;

public class ReminderLogList {
	private Vector<ReminderLog> reminderLogList = null;

	public ReminderLogList() {
		reminderLogList = new Vector<ReminderLog>();
	}

	public ReminderLogList(File reminderLogListDoc) {
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
		}
	}

	public Vector<ReminderLog> getList() {
		return reminderLogList;
	}

	public void addLog(ReminderLog log) {
		reminderLogList.addElement(log);
	}

	public ReminderLog getLog(int index) {
		return reminderLogList.elementAt(index);
	}
	
	public String toString() {
		return reminderLogList.toString();
	}
}

