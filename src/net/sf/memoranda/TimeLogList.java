package net.sf.memoranda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import net.sf.memoranda.util.Util;

public class TimeLogList {
	private Vector<TimeLog> timeLogList = null;

	public TimeLogList() {
		timeLogList = new Vector<TimeLog>();
	}

	public TimeLogList(File timeLogListDoc) {
		timeLogList = new Vector<TimeLog>();

		try {
			Scanner fileScan = new Scanner(timeLogListDoc);

			while (fileScan.hasNextLine()) {
				String temp, date = "", start = "", end = "", interrupt = "", phase = "", comments = "";

				Scanner lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter("\\*\\^\\*");
				while (lineScan.hasNext()) {
					temp = lineScan.next();
					switch (temp) {
					case "date":
						temp = lineScan.next();
						date = (temp.equals("null") ? "" : temp);
						break;
					case "start":
						temp = lineScan.next();
						start = (temp.equals("null") ? "" : temp);
						break;
					case "end":
						temp = lineScan.next();
						end = (temp.equals("null") ? "" : temp);
						break;
					case "interrupt":
						temp = lineScan.next();
						interrupt = (temp.equals("null") ? "" : temp);
						break;
					case "phase":
						temp = lineScan.next();
						phase = (temp.equals("null") ? "" : temp);
						break;
					case "comments":
						temp = lineScan.next();
						comments = (temp.equals("null") ? "" : temp);
						break;
					default:
						Util.debug("Unable to switch value " + temp + " in Time Log List constructor");
					}
				}
				
				timeLogList.addElement(new TimeLog(date, start, end, interrupt, phase, comments));

				lineScan.close();
			}
			
			fileScan.close();
		} catch (FileNotFoundException e) {
			Util.debug("Unable to scan file at path " + timeLogListDoc.getPath());
		}
	}

	public Vector<TimeLog> getList() {
		return timeLogList;
	}

	public void addLog(TimeLog log) {
		timeLogList.addElement(log);
	}

	public TimeLog getLog(int index) {
		return timeLogList.elementAt(index);
	}
	
	public String toString() {
		return timeLogList.toString();
	}
}
