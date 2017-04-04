/**
 * 
 */
package net.sf.memoranda.psp;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

/**
 * @author turnert
 *
 */
@SuppressWarnings("serial")
public class PSPTimeLog implements java.io.Serializable {

	private static int count = 0;
	private List<TimeEntry> Entries;

	/**
	 * @param entries
	 */
	public PSPTimeLog() {
		Entries = new ArrayList<>();
		count = Entries.size();
	}

	/**
	 * @param entries
	 */
	public PSPTimeLog(List<TimeEntry> entries) {
		super();
		Entries = entries;
		count = Entries.size();
	}

	public void addEntry(TimeEntry entry) {
		for (int i = 0; i < Entries.size(); i++) {
			if (Entries.get(i).getID() != i) {
				entry.setID(i);
			}
		}
		Entries.add(entry);
		count += 1;
	}

	public void updateEntry(TimeEntry entry) {
		for (int i = 0; i < Entries.size(); i++) {
			if (Entries.get(i).getID() == entry.getID()) {
				Entries.set(i, entry);
			}
		}
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		PSPTimeLog.count = count;
	}

	/**
	 * @return the entries
	 */
	public List<TimeEntry> getEntries() {
		return Entries;
	}

	/**
	 * @param entries
	 *            the entries to set
	 */
	public void setEntries(List<TimeEntry> entries) {
		Entries = entries;
	}

	// public class TimeEntry implements java.io.Serializable{
	//
	// private int ID;
	// private Date entryDate;
	// private Time StartingTime, stoppingTime, interruptionTime;
	// private PSPPhase Phase;
	// private String comments;
	//
	// public TimeEntry() {
	// ID = 0;
	// entryDate = Calendar.getInstance().getTime();
	// StartingTime = null;
	// stoppingTime = null;
	// interruptionTime = null;
	// Phase = PSPPhase.DESIGN;
	// comments = "";
	//
	// }
	//
	// /**
	// * @param iD
	// * @param entryDate
	// * @param startingTime
	// * @param stoppingTime
	// * @param interruptionTime
	// * @param phase
	// * @param comments
	// */
	// public TimeEntry(int iD, Date entryDate, Time startingTime, Time
	// stoppingTime, Time interruptionTime,
	// PSPPhase phase, String comments) {
	// super();
	// ID = iD;
	// this.entryDate = entryDate;
	// StartingTime = startingTime;
	// this.stoppingTime = stoppingTime;
	// this.interruptionTime = interruptionTime;
	// Phase = phase;
	// this.comments = comments;
	// }
	//
	// /**
	// * @return the iD
	// */
	// public int getID() {
	// return ID;
	// }
	//
	// /**
	// * @param iD
	// * the iD to set
	// */
	// public void setID(int iD) {
	// ID = iD;
	// }
	//
	// /**
	// * @return the entryDate
	// */
	// public Date getEntryDate() {
	// return entryDate;
	// }
	//
	// /**
	// * @param entryDate
	// * the entryDate to set
	// */
	// public void setEntryDate(Date entryDate) {
	// this.entryDate = entryDate;
	// }
	//
	// /**
	// * @return the startingTime
	// */
	// public Time getStartingTime() {
	// return StartingTime;
	// }
	//
	// /**
	// * @param startingTime
	// * the startingTime to set
	// */
	// public void setStartingTime(Time startingTime) {
	// StartingTime = startingTime;
	// }
	//
	// /**
	// * @return the stoppingTime
	// */
	// public Time getStoppingTime() {
	// return stoppingTime;
	// }
	//
	// /**
	// * @param stoppingTime
	// * the stoppingTime to set
	// */
	// public void setStoppingTime(Time stoppingTime) {
	// this.stoppingTime = stoppingTime;
	// }
	//
	// /**
	// * @return the interruptionTime
	// */
	// public Time getInterruptionTime() {
	// return interruptionTime;
	// }
	//
	// /**
	// * @param interruptionTime
	// * the interruptionTime to set
	// */
	// public void setInterruptionTime(Time interruptionTime) {
	// this.interruptionTime = interruptionTime;
	// }
	//
	// /**
	// * @return the phase
	// */
	// public PSPPhase getPhase() {
	// return Phase;
	// }
	//
	// /**
	// * @param phase
	// * the phase to set
	// */
	// public void setPhase(PSPPhase phase) {
	// Phase = phase;
	// }
	//
	// /**
	// * @return the comments
	// */
	// public String getComments() {
	// return comments;
	// }
	//
	// /**
	// * @param comments
	// * the comments to set
	// */
	// public void setComments(String comments) {
	// this.comments = comments;
	// }
	//
	// }

}
